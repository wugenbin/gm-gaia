package com.ntc.gaia.base.rpc.hetty.conf;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ntc.gaia.base.rpc.hetty.object.Application;
import com.ntc.gaia.base.rpc.hetty.object.HettyException;
import com.ntc.gaia.base.rpc.hetty.object.Service;
import com.ntc.gaia.base.rpc.hetty.object.ServiceProvider;
import com.ntc.gaia.base.rpc.hetty.object.ServiceVersion;
import com.ntc.gaia.base.rpc.hetty.util.HettyUtil;

/**
 * 
 * @author david
 * @date 2017-07-20
 *
 */
public class XmlConfigParser implements ConfigParser {

	private final static Logger logger = LoggerFactory.getLogger(XmlConfigParser.class);

	private String configFile = null;
	private Document document;
	private Element root = null;

	public XmlConfigParser(String configFile) {
		this.configFile = configFile;
		root = getRoot();
	}

	/**
	 * analyse service configure and return a list,the list is a LocalService
	 * and each localService corresponding a service
	 */
	@SuppressWarnings("unchecked")
	public List<Service> parseService() {
		List<Service> slist = new ArrayList<Service>();

		Node serviceRoot = root.selectSingleNode("//services");

		List<Element> serviceList = serviceRoot.selectNodes("//service");

		int i = 0;
		for (Element serviceNode : serviceList) {
			String name = serviceNode.attributeValue("name");// service name
			String interfaceStr = serviceNode.attributeValue("interface");
			String overloadStr = serviceNode.attributeValue("overload");

			if (HettyUtil.isEmpty(name)) {
				logger.warn("you have a wrong config in " + configFile + ":a service's name is empty.");
				continue;
			}
			if (HettyUtil.isEmpty(interfaceStr)) {
				logger.warn("you have a wrong config in " + configFile + ":service［" + name
						+ "］ has an empty interface configure.");
				continue;
			}
			Class<?> type = null;
			try {
				type = Class.forName(interfaceStr);
			} catch (ClassNotFoundException e) {
				logger.error(e.getMessage());
				throw new RuntimeException("can't find service Interface:" + interfaceStr);
			}
			Service service = new Service("" + i, name);
			service.setTypeClass(type);

			if (HettyUtil.isNotEmpty(overloadStr) && "true".equals(overloadStr.trim())) {
				service.setOverload(true);
			}

			List<Element> versionList = serviceNode.selectNodes("provider");
			for (Element element : versionList) {
				String version = element.attributeValue("version");
				String processor = element.attributeValue("class");
				String isDefault = element.attributeValue("default");
				Class<?> providerClass = null;
				try {
					providerClass = Class.forName(processor);
				} catch (ClassNotFoundException e) {
					logger.error(e.getMessage());
					throw new RuntimeException("can't find service provider Class:" + processor);
				}
				ServiceProvider sv = new ServiceProvider(version, providerClass);
				if (HettyUtil.isNotEmpty(version) && HettyUtil.isNotEmpty(isDefault)
						&& "true".equals(isDefault.trim())) {
					service.setDefaultVersion(version);
				}
				service.addServiceProvider(version, sv);
			}
			slist.add(service);
			i++;
		}
		return slist;
	}

	/**
	 * parse application
	 */
	@SuppressWarnings("unchecked")
	public List<Application> parseApplication() {
		List<Application> appList = new LinkedList<Application>();
		Element aroot = getRoot();
		Node root = aroot.selectSingleNode("//applications");
		List<Element> elementList = root.selectNodes("application");
		for (Element e : elementList) {
			String user = e.attributeValue("user");
			String password = e.attributeValue("password");
			Application app = new Application();
			app.setUser(user);
			app.setPassword(password);
			appList.add(app);
		}
		return appList;
	}

	/**
	 * get the config xml's security info
	 */
	@SuppressWarnings("unchecked")
	public List<ServiceVersion> parseSecurity() {
		List<ServiceVersion> versionList = new LinkedList<ServiceVersion>();
		Element aroot = getRoot();
		Node root = aroot.selectSingleNode("//security-settings");
		if (root == null) {
			return null;
		}
		List<Element> sList = root.selectNodes("security-setting");
		for (Element element : sList) {
			String user = element.attributeValue("user");
			String service = element.attributeValue("service");
			if (HettyUtil.isEmpty(user) || HettyUtil.isEmpty(service)) {
				throw new HettyException("In config file's security-settings,user or service cannot't be empty!");
			}
			String version = element.attributeValue("version");

			ServiceVersion serviceVersion = new ServiceVersion();
			serviceVersion.setUser(user);
			serviceVersion.setService(service);
			serviceVersion.setVersion(version);
			versionList.add(serviceVersion);
		}
		return versionList;
	}

	@SuppressWarnings("unchecked")
	private Element getRoot() {
		try {
			Document doc = getDocument();
			List<Element> list = doc.selectNodes("//deployment");
			if (list.size() > 0) {
				Element aroot = list.get(0);
				return aroot;
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return null;
	}

	private Document getDocument() throws DocumentException, IOException {
		InputStream is = getFileStream();
		try {
			if (document == null) {
				SAXReader reader = new SAXReader();
				reader.setValidation(false);
				if (is == null) {
					throw new RuntimeException("we can not find the service config file:" + configFile);
				}
				document = reader.read(is);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new RuntimeException("get xml Document failed.");
		} finally {
			is.close();
		}
		return document;
	}

	private InputStream getFileStream() {
		return getFileStream(configFile);
	}

	private InputStream getFileStream(String file) {
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(file);
		return is;
	}
}