package com.expressway.electronicbill.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.expressway.electronicbill.api.helper.IConfigPropertiesHelper;
import com.expressway.electronicbill.api.service.IXMLFileViewerService;
import com.expressway.electronicbill.api.service.beans.XMLFile;

/**
 * Generated XML File Viewer
 * 
 * @author Ajaxfan
 */
@Component
public class XMLFileViewerService implements IXMLFileViewerService {
	/** System Common Property Info Buffer */
	private @Autowired IConfigPropertiesHelper configPropertiesHelper;

	/** Generated Xml File Location Info Key */
	private static final String XML_DIR_KEY = "ftp.localDir";

	/**
	 * List All File
	 */
	@Override
	public List<XMLFile> listAll() {
		// Result List
		List<XMLFile> list = new ArrayList<XMLFile>();

		// Create Directory Object
		File dir = new File(configPropertiesHelper.getProperty(XML_DIR_KEY));

		// Validate Current is Directory
		if (dir.exists()) {
			list.addAll(readFiles(dir));
		}
		return Collections.unmodifiableList(list);
	}

	/**
	 * @param dir
	 * @return
	 */
	private List<XMLFile> readFiles(File dir) {
		List<XMLFile> list = new ArrayList<XMLFile>();

		// Read File From Directory
		for (File file : dir.listFiles()) {
			// Recursion Read Files From SubDirectory
			if (file.isDirectory()) {
				list.addAll(readFiles(file));
				continue;
			}
			// Create XML File Model
			XMLFile xml = new XMLFile();
			xml.setName(file.getName());
			xml.setLocation(file.getAbsolutePath());
			xml.setSize(file.length());
			xml.setStatus(getStatus(file));
			xml.setTime(new Date(file.lastModified()));

			list.add(xml);
		}
		return list;
	}

	/**
	 * Get File Status
	 * 
	 * @param file
	 * @return
	 */
	private String getStatus(File file) {
		if (file.getName().matches(".+\\.bak$")) {
			return "归档";
		}
		return "新建";
	}
}
