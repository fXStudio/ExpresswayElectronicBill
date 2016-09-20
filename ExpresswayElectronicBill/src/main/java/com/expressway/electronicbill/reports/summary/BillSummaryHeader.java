package com.expressway.electronicbill.reports.summary;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * 票据汇总头信息
 *
 * @author Ajaxfan
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.UNDEFINED)
public class BillSummaryHeader {
	private String datefrom;
	private String dateto;
	private String rgncode;
	private String deptcode;
	private String totamt;
	private String count;

	public String getDatefrom() {
		return datefrom;
	}

	public void setDatefrom(String datefrom) {
		this.datefrom = datefrom;
	}

	public String getDateto() {
		return dateto;
	}

	public void setDateto(String dateto) {
		this.dateto = dateto;
	}

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

	public String getTotamt() {
		return totamt;
	}

	public void setTotamt(String totamt) {
		this.totamt = totamt;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}
}
