package com.ntc.gaia.base.model.base;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 统一定义id的BaseEntity基类.
 * 
 * 基类统一定义id的属性名称、数据类型、列名映射及生成策略.
 * 
 */
public abstract class BaseEntity implements Serializable {

	protected Integer id ;// ID自增列

//	protected String createuser = "";// 创建人

	protected String createtime = "";// 创建时间

//	protected String lastupdateuser = "";// 最后修改人

//	protected String lastupdatetime = "";// 最后修改时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

/*	public String getCreateuser() {
		return createuser;
	}

	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}*/

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

/*	public String getLastupdateuser() {
		return lastupdateuser;
	}

	public void setLastupdateuser(String lastupdateuser) {
		this.lastupdateuser = lastupdateuser;
	}

	public String getLastupdatetime() {
		return lastupdatetime;
	}

	public void setLastupdatetime(String lastupdatetime) {
		this.lastupdatetime = lastupdatetime;
	}*/

	//hashcode就是对象签名，当两个对象的hashcode一样时，两个对象就有可能一样。如果不一样的话两个对象就肯定不一样。
	//一般用hashcode来进行比较两个东西是不是一样的，可以很容易的排除许多不一样的东西。
	@Override
	public int hashCode() {
		return id == null ? 0 : id.hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}

		if (this.id == null || obj == null || !(this.getClass().equals(obj.getClass()))) {
			return false;
		}

		BaseEntity that = (BaseEntity) obj;
		return this.id.equals(that.getId());
	}

	@Override
	public String toString() {
		StringBuffer strBuf = new StringBuffer();

		// 得到类中的成员变量
		Field[] fields = this.getClass().getDeclaredFields();

		for (int i = 0; i < fields.length; i++) {
			// 成员变量名称
			String fieldName = fields[i].getName();

			// 过滤 序列化属性 serialVersionUID
			if (fieldName.equalsIgnoreCase("serialVersionUID")) {
				continue;
			}
			// 拼接出方法名：getXxx()
			String methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
			try {
				// 得到方法
				Method method = this.getClass().getMethod(methodName, new Class[] {});
				// 调用方法
				Object value = method.invoke(this, new Object[] {});
				strBuf.append(fieldName + ":");
				strBuf.append(value + " ");
			} catch (SecurityException e) {

				e.printStackTrace();
			} catch (NoSuchMethodException e) {

				e.printStackTrace();
			} catch (IllegalArgumentException e) {

				e.printStackTrace();
			} catch (IllegalAccessException e) {

				e.printStackTrace();
			} catch (InvocationTargetException e) {

				e.printStackTrace();
			}
		}

		return strBuf.toString();
	}
}
