package com.myapp.core.solr.store;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.common.SolrInputDocument;
import org.broadleafcommerce.common.exception.ServiceException;
import org.broadleafcommerce.common.locale.domain.Locale;
import org.broadleafcommerce.core.catalog.domain.Indexable;
import org.broadleafcommerce.core.catalog.domain.Sku;
import org.broadleafcommerce.core.search.domain.IndexField;
import org.broadleafcommerce.core.search.service.solr.index.SolrIndexCachedOperation.CacheOperation;
import org.springframework.beans.factory.annotation.Value;
import org.broadleafcommerce.core.search.service.solr.SolrHelperService;
import org.broadleafcommerce.core.search.service.solr.index.SolrIndexOperation;
import org.broadleafcommerce.core.search.service.solr.index.SolrIndexService;

public class StoreSolrIndexServiceImpl implements SolrIndexService
{
	private static final Log LOG = LogFactory.getLog(StoreSolrIndexServiceImpl.class);
	
	private StoreSolrConfiguration solrConfiguration;
	
	@Resource(name = "blSolrHelperService")
	protected SolrHelperService shs;
	
	@Value("${solr.index.product.pageSize}")
	protected int pageSize;
	
	@Override
	public void rebuildIndex() throws ServiceException, IOException 
	{
		
	}

	@Override
	public void preBuildIndex() throws ServiceException 
	{
		deleteAllNamespaceDocuments(this.solrConfiguration.getReindexServer());
	}

	@Override
	public void buildIndex() throws IOException, ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postBuildIndex() throws IOException, ServiceException 
	{
		optimizeIndex(this.solrConfiguration.getReindexServer());

		if (!(this.solrConfiguration.isSingleCoreMode()))
			this.shs.swapActiveCores(this.solrConfiguration);
	}

	@Override
	public SolrIndexOperation getReindexOperation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void executeSolrIndexOperation(SolrIndexOperation paramSolrIndexOperation)
			throws ServiceException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<SolrInputDocument> buildIncrementalIndex(List<? extends Indexable> paramList,
			SolrClient paramSolrClient) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] saveState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void restoreState(Object[] paramArrayOfObject) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void optimizeIndex(SolrClient paramSolrClient) throws ServiceException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void commit(SolrClient paramSolrClient) throws ServiceException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void commit(SolrClient paramSolrClient, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
			throws ServiceException, IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllNamespaceDocuments(SolrClient server) throws ServiceException 
	{
		try {
			String deleteQuery = new StringBuilder().append(this.shs.getNamespaceFieldName()).append(":(\"")
					.append(this.solrConfiguration.getNamespace()).append("\")").toString();
			LOG.debug(new StringBuilder().append("Deleting by query: ").append(deleteQuery).toString());
			server.deleteByQuery(deleteQuery);

			server.commit();
		} catch (Exception e) {
			if (ServiceException.class.isAssignableFrom(e.getClass())) {
				throw ((ServiceException) e);
			}
			throw new ServiceException("Could not delete documents", e);
		}
	}

	@Override
	public void deleteAllDocuments(SolrClient paramSolrClient) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logDocuments(Collection<SolrInputDocument> paramCollection) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Locale> getAllLocales() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SolrInputDocument buildDocument(Indexable paramIndexable, List<IndexField> paramList,
			List<Locale> paramList1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void performCachedOperation(CacheOperation paramCacheOperation) throws ServiceException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Sku> filterIndexableSkus(List<Sku> paramList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void attachIndexableDocumentFields(SolrInputDocument paramSolrInputDocument, Indexable paramIndexable,
			List<IndexField> paramList, List<Locale> paramList1) {
		// TODO Auto-generated method stub
		
	}

}
