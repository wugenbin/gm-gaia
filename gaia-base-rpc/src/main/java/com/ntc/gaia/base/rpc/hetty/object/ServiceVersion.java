package com.ntc.gaia.base.rpc.hetty.object;

/**
 * 
 * 
 * @author david
 * @date 2017-07-20
 *
 */
public class ServiceVersion {

	private String user;
	private String service;
	private String version;

	public StringBuffer getUser() {
		return new StringBuffer(user);
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
