package com.myapp.core.solr.store;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import javax.jms.IllegalStateException;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.embedded.EmbeddedSolrServer;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.request.CollectionAdminRequest;
import org.apache.solr.client.solrj.request.CollectionAdminRequest.Create;
import org.apache.solr.client.solrj.request.CollectionAdminRequest.CreateAlias;
import org.apache.solr.client.solrj.response.CollectionAdminResponse;
import org.apache.solr.common.cloud.Aliases;
import org.apache.solr.common.cloud.ZkStateReader;
import org.apache.solr.common.util.NamedList;
import org.apache.solr.core.CoreContainer;
import org.broadleafcommerce.core.search.service.solr.SolrConfiguration;
import org.springframework.beans.factory.InitializingBean;
import org.xml.sax.SAXException;

public class StoreSolrConfiguration extends SolrConfiguration implements InitializingBean
{
	private static final Log LOG = LogFactory.getLog(StoreSolrConfiguration.class);

	protected String primaryName = null;
	protected String reindexName = null;

	protected String namespace = "d";

	protected SolrClient adminServer = null;
	protected SolrClient primaryServer = null;
	protected SolrClient reindexServer = null;

	protected String solrCloudConfigName = null;

	protected Integer solrCloudNumShards = null;

	protected String solrHomePath = null;
	
	public String getPrimaryName() {
		return this.primaryName;
	}

	public void setPrimaryName(String primaryName) {
		this.primaryName = primaryName;
	}

	public String getReindexName() {
		return this.reindexName;
	}

	public void setReindexName(String reindex) {
		this.reindexName = reindex;
	}

	public String getSolrCloudConfigName() {
		return this.solrCloudConfigName;
	}

	public void setSolrCloudConfigName(String solrCloudConfigName) {
		this.solrCloudConfigName = solrCloudConfigName;
	}

	public Integer getSolrCloudNumShards() {
		return this.solrCloudNumShards;
	}

	public void setSolrCloudNumShards(Integer solrCloudNumShards) {
		this.solrCloudNumShards = solrCloudNumShards;
	}

	public String getSolrHomePath() {
		return this.solrHomePath;
	}

	public void setSolrHomePath(String solrHomePath) {
		this.solrHomePath = solrHomePath;
	}

	public String getNamespace() {
		return this.namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	
	public void setAdminServer(SolrClient server) {
		this.adminServer = server;
	}

	public SolrClient getAdminServer() {
		if (this.adminServer != null) {
			return this.adminServer;
		}

		return getServer();
	}

	public SolrClient getServer() {
		return this.primaryServer;
	}

	public SolrClient getReindexServer() {
		return ((isSingleCoreMode()) ? this.primaryServer : this.reindexServer);
	}

	public boolean isSingleCoreMode() {
		return (this.reindexServer == null);
	}
	
	
	public StoreSolrConfiguration(String solrServer)
			throws IOException, ParserConfigurationException, SAXException, IllegalStateException {
		super(solrServer);
		setPrimaryName("storeprimary");
		setReindexName("storereindex");

		if (Objects.equals("solrhome", solrServer)) {
			String baseTempPath = System.getProperty("java.io.tmpdir");

			File tempDir = new File(baseTempPath + File.separator + System.getProperty("user.name") + File.separator
					+ "solrstorehome-5.3.1");
			if (System.getProperty("tmpdir.solrhome") != null) {
				tempDir = new File(System.getProperty("tmpdir.solrhome"));
			}
			if (!(tempDir.exists())) {
				tempDir.mkdirs();
			}

			solrServer = tempDir.getAbsolutePath();
		}
		setSolrHomePath(solrServer);

		File solrXml = new File(new File(solrServer), "solr.xml");
		if (!(solrXml.exists())) {
			copyConfigToSolrHome(super.getClass().getResourceAsStream("/solr-default.xml"), solrXml);
		}

		buildSolrCoreDirectories(solrServer);

		LOG.debug(String.format("Using [%s] as solrhome", new Object[] { solrServer }));
		LOG.debug(String.format("Using [%s] as solr.xml", new Object[] { solrXml.getAbsoluteFile() }));

		if (LOG.isTraceEnabled()) {
			LOG.trace("Contents of solr.xml:");
			BufferedReader br = null;
			try {
				br = new BufferedReader(new FileReader(solrXml));
				String line;
				while ((line = br.readLine()) != null) {
					LOG.trace(line);
				}
			} finally {
				if (br != null)
					try {
						br.close();
					} catch (Throwable e) {
					}
			}
			LOG.trace("Done printing solr.xml");
		}

		CoreContainer coreContainer = CoreContainer.createAndLoad(solrServer, solrXml);
		EmbeddedSolrServer primaryServer = new EmbeddedSolrServer(coreContainer, getPrimaryName());
		EmbeddedSolrServer reindexServer = new EmbeddedSolrServer(coreContainer, getReindexName());

		setServer(primaryServer);
		setReindexServer(reindexServer);
	}

	
	
	protected void buildSolrCoreDirectories(String solrServer) throws IOException {
		File cores = new File(new File(solrServer), "cores");
		if ((!(cores.exists())) || (!(cores.isDirectory()))) {
			cores.mkdirs();
		}

		File primaryCoreDir = new File(cores, "storeprimary");
		if ((!(primaryCoreDir.exists())) || (!(primaryCoreDir.isDirectory()))) {
			primaryCoreDir.mkdirs();
		}

		File primaryCoreFile = new File(primaryCoreDir, "core.properties");
		if (!(primaryCoreFile.exists())) {
			FileOutputStream os = new FileOutputStream(primaryCoreFile);
			Properties prop = new Properties();
			prop.put("name", "storeprimary");
			prop.store(os, "Generated Solr core properties file");
			IOUtils.closeQuietly(os);
		}

		File primaryConfDir = new File(primaryCoreDir, "conf");
		if ((!(primaryConfDir.exists())) || (!(primaryConfDir.isDirectory()))) {
			primaryConfDir.mkdirs();
		}

		File reindexCoreDir = new File(cores, "storereindex");
		if ((!(reindexCoreDir.exists())) || (!(reindexCoreDir.isDirectory()))) {
			reindexCoreDir.mkdirs();
		}

		File reindexCoreFile = new File(reindexCoreDir, "core.properties");
		if (!(reindexCoreFile.exists())) {
			FileOutputStream os = new FileOutputStream(reindexCoreFile);
			Properties prop = new Properties();
			prop.put("name", "storereindex");
			prop.store(os, "Generated Solr core properties file");
			IOUtils.closeQuietly(os);
		}

		File reindexConfDir = new File(reindexCoreDir, "conf");
		if ((!(reindexConfDir.exists())) || (!(reindexConfDir.isDirectory())))
			reindexConfDir.mkdirs();
	}
	
	


}
