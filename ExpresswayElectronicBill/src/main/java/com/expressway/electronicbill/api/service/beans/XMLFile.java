package com.expressway.electronicbill.api.service.beans;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * XMLFile Object
 * 
 * @author Ajaxfan
 */
public class XMLFile {
	private String name;
	private long size;
	private Date time;
	private String status;
	private String location;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}
}
