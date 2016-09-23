package com.expressway.electronicbill.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import org.springframework.stereotype.Component;

import com.expressway.electronicbill.Application;
import com.expressway.electronicbill.api.helper.IConfigPropertiesHelper;

/**
 * @author Ajaxfan
 */
@Component
final class ConfigPropertiesHelper implements IConfigPropertiesHelper {
	/** 用户目录 */
	private static final String USER_HOME = "user.home";
	/** 应用程序目录 */
	private static final String APP_HOME = ".bill";
	/** 配置文件名称 */
	private static final String CONFIG_FILE_NAME = "config.properties";
	/** 配置文件路径 */
	private static final String CONFIG_FILE_PATH = "/com/expressway/electronicbill/configs/";

	/** System Config Properties */
	private Properties _pro = new Properties();

	/**
	 * Default Constructor
	 */
	ConfigPropertiesHelper() {
		loadProperties();
	}

	/**
	 * Load Properties File
	 */
	private void loadProperties() {
		// 应用程序目录
		File directory = new File(System.getProperty(USER_HOME) + File.separator + APP_HOME);

		// 如果应用程序目录不存在，则创建目录并拷贝配置文件到该目录中
		File file = checkPropertieFiles(directory);

		// 加载资源文件
		loadPropertie(file);
	}

	/**
	 * 拷贝配置文件到磁盘目录
	 * 
	 * @param directory
	 */
	private File checkPropertieFiles(File directory) {
		File file = new File(directory + File.separator + CONFIG_FILE_NAME);

		if (!file.exists()) {
			writeFileToUserHome(directory, file);
		}
		return file;
	}

	/**
	 * @param directory
	 * @param file
	 */
	private void writeFileToUserHome(File directory, File file) {
		InputStream in = null;
		OutputStream out = null;

		try {
			if (!directory.exists()) {
				directory.mkdir();
			}
			in = Application.class.getResourceAsStream(CONFIG_FILE_PATH + CONFIG_FILE_NAME);
			out = new FileOutputStream(file);

			byte[] buffer = new byte[2048];

			for (int n = in.read(buffer); n != -1; n = in.read(buffer)) {
				out.write(buffer, 0, n);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					out = null;
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					in = null;
				}
			}
		}
	}

	/**
	 * 从磁盘目录加载配置信息
	 */
	private void loadPropertie(File file) {
		InputStream in = null;

		try {
			_pro.load(in = new FileInputStream(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				in = null;
			}
		}
	}

	/**
	 * @param name
	 * @return
	 */
	public String getProperty(String name) {
		return _pro.getProperty(name);
	}

	/**
	 * @param name
	 * @param value
	 * @return
	 */
	public void setProperty(String name, String value) {
		_pro.setProperty(name, value);
	}

	/**
	 * 
	 */
	public void store() {
		OutputStream out = null;

		try {
			_pro.store(out = new FileOutputStream(
					System.getProperty(USER_HOME) + File.separator + APP_HOME + File.separator + CONFIG_FILE_NAME),
					"System Config Info");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				out = null;
			}
		}
	}
}
