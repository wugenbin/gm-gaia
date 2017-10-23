package com.ntc.gaia.base.utils.tools;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

/**
 * XML与Java文件转换类
 * 
 * @author Allen
 * 
 */
public class JAXBUtils {

	public final static Logger log = Logger.getLogger(JAXBUtils.class);

	private JAXBUtils() {

	}

	/**
	 * 将XML 转换为JavaBean
	 * 
	 * @param <T>
	 * 
	 * @param cls
	 *            JavaBean
	 * @param xmlStream
	 * @return
	 * @throws JAXBException
	 */

	public static <T> Object unmarshal(Class<T> cls, InputStream xmlStream) {

		try {

			JAXBContext jabxContext = JAXBContext.newInstance(cls);
			Unmarshaller unmarsheller = jabxContext.createUnmarshaller();

			return unmarsheller.unmarshal(xmlStream);

		} catch (JAXBException ex) {
			log.info("==== JAXBException.unmarshal.EX "
					+ ex.getLinkedException().getMessage());
		}

		return null;
	}

	/**
	 * 将JavaBean转换为XML文档对象
	 * 
	 * @param <T>
	 * 
	 * @param cls
	 *            JavaBean
	 * @param obj
	 *            JavaBean 对象
	 * @param stream
	 *            输出文件流
	 * @throws JAXBException
	 */

	public static <T> void marshal(Class<T> cls, Object obj, OutputStream stream) {

		try {

			JAXBContext jabxContext = JAXBContext.newInstance(cls);
			Marshaller marsheller = jabxContext.createMarshaller();

			marsheller.setProperty(Marshaller.JAXB_FRAGMENT, false);
			marsheller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marsheller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

			marsheller.marshal(obj, stream);

		} catch (JAXBException ex) {
			log.info("==== JAXBException.marshal.EX "
					+ ex.getLinkedException().getMessage());
		}

	}

	/**
	 * 将JavaBean转换为XML文档对象并进行OutPut
	 * 
	 * @param <T>
	 * 
	 * @param cls
	 *            JavaBean
	 * @param obj
	 *            JavaBean 对象
	 * @param stream
	 *            输出文件流
	 * @throws JAXBException
	 */

	public static <T> void marshalForOutput(Class<T> cls, Object obj,
			OutputStream stream) {

		try {
			JAXBContext jabxContext = JAXBContext.newInstance(cls);
			Marshaller marsheller = jabxContext.createMarshaller();

			marsheller.setProperty(Marshaller.JAXB_FRAGMENT, false);
			marsheller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marsheller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

			marsheller.marshal(obj, System.out);

		} catch (JAXBException ex) {
			log.info("==== JAXBException.marshalForOutput.EX "
					+ ex.getLinkedException().getMessage());
		}

	}

	/**
	 * 将对象结果转换为XML
	 * 
	 * @return
	 */
	public static <T> String marshalForXML(T t) {

		try {

			JAXBContext context = JAXBContext.newInstance(t.getClass());
			Marshaller marsheller = context.createMarshaller();

			marsheller.setProperty(Marshaller.JAXB_FRAGMENT, false);
			marsheller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marsheller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

			StringWriter sw = new StringWriter();
			marsheller.marshal(t, sw);

			return sw.toString();

		} catch (JAXBException ex) {
			log.info("==== JAXBException.marshalForXML.EX "
					+ ex.getLinkedException().getMessage());
		}
		return "";

	}

}
