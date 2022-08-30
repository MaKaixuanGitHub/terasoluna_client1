package org.terasoluna.tourreservation.domain.model;

import java.io.Serializable;

public class OauthUser implements Serializable{

    private static final long serialVersionUID = 1L;

    private String username;

    private String companyId;

    private String businessId;

    private String clientId;


    public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getCompanyId() {
		return companyId;
	}


	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}


	public String getBusinessId() {
		return businessId;
	}


	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}


	public String getClientId() {
		return clientId;
	}


	public void setClientId(String clientId) {
		this.clientId = clientId;
	}


	public OauthUser(String username, String companyId, String businessId, String clientId){
        this.username = username;
        this.companyId = companyId;
        this.businessId = businessId;
        this.clientId = clientId;
    }


}