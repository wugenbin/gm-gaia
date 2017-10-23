package com.ntc.gaia.base.rpc.hetty.conf;

import java.util.List;

import com.ntc.gaia.base.rpc.hetty.object.Application;
import com.ntc.gaia.base.rpc.hetty.object.Service;
import com.ntc.gaia.base.rpc.hetty.object.ServiceVersion;

/**
 * 
 * @author david
 * @date 2017-07-20
 *
 */
public interface ConfigParser {

	List<Service> parseService();

	List<Application> parseApplication();

	List<ServiceVersion> parseSecurity();
}