package com.expressway.electronicbill.report.detail;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * 票据明细头信息
 *
 * @author Ajaxfan
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.UNDEFINED)
public class BillDetailHeader {
	private String rgncode;
	private String deptcode;
	private String date;
	private String count;

	public String getRgncode() {
		return rgncode;
	}

	public void setRgncode(String rgncode) {
		this.rgncode = rgncode;
	}

	public String getDeptcode() {
		return deptcode;
	}

	public void setDeptcode(String deptcode) {
		this.deptcode = deptcode;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
