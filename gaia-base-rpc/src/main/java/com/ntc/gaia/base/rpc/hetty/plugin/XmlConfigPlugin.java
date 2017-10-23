package com.ntc.gaia.base.rpc.hetty.plugin;

import java.util.List;

import com.ntc.gaia.base.rpc.hetty.conf.HettyConfig;
import com.ntc.gaia.base.rpc.hetty.conf.XmlConfigParser;
import com.ntc.gaia.base.rpc.hetty.core.HettySecurity;
import com.ntc.gaia.base.rpc.hetty.core.ServiceHandler;
import com.ntc.gaia.base.rpc.hetty.object.Application;
import com.ntc.gaia.base.rpc.hetty.object.Service;
import com.ntc.gaia.base.rpc.hetty.object.ServiceVersion;

/**
 * XmlConfigPlugin
 * 
 * @author david
 * @date 2017-07-20
 *
 */
public class XmlConfigPlugin implements IPlugin {

	 
	public boolean start() {
		String configFile = HettyConfig.getInstance().getpropertiesFile();
		String[] fileArr = configFile.split(",");

		for (String file : fileArr) {

			XmlConfigParser configParser = new XmlConfigParser(file);

			List<Application> appList = configParser.parseApplication();
			for (Application app : appList) {
				HettySecurity.addToApplicationMap(app);
			}

			List<Service> serviceList = configParser.parseService();
			for (Service service : serviceList) {
				ServiceHandler.addToServiceMap(service);
			}

			List<ServiceVersion> versionList = configParser.parseSecurity();
			if (versionList != null) {
				for (ServiceVersion version : versionList) {
					ServiceHandler.addToVersionMap(version);
				}
			}
		}
		return true;
	}

	 
	public boolean stop() {

		return false;
	}

}
