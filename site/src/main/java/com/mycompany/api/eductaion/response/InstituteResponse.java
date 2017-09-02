package com.mycompany.api.eductaion.response;

import java.util.List;

import com.myapp.core.education.beans.InstituteData;

public class InstituteResponse 
{
	private String errorMessage;
	private InstituteData instituteData;
	private List<InstituteData> institutes;
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public InstituteData getInstituteData() {
		return instituteData;
	}
	public void setInstituteData(InstituteData instituteData) {
		this.instituteData = instituteData;
	}
	public List<InstituteData> getInstitutes() {
		return institutes;
	}
	public void setInstitutes(List<InstituteData> institutes) {
		this.institutes = institutes;
	}
}
