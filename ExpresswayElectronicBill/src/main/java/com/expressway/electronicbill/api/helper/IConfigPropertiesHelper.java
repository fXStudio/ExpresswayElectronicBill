package com.expressway.electronicbill.api.helper;

/**
 * System Config File Helper
 * @author Ajaxfan
 */
public interface IConfigPropertiesHelper {
	public String getProperty(String name);
	public void setProperty(String name, String value);
	public void store();
}
