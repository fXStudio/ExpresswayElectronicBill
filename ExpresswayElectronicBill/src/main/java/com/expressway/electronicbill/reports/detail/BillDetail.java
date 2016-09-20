package com.expressway.electronicbill.reports.detail;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 票据明细
 *
 * @author Ajaxfan
 */
@XmlRootElement(name = "pjmx")
@XmlType(name = "", propOrder = { "head", "bill" })
public class BillDetail {
	/** 头信息 */
	private BillDetailHeader head;
	/** 内容 */
	private List<BillDetailBody> bill = new ArrayList<BillDetailBody>();

	public BillDetailHeader getHead() {
		return head;
	}

	@XmlElement
	public void setHead(BillDetailHeader head) {
		this.head = head;
	}

	@XmlElement(name = "bill")
	public List<BillDetailBody> getBill() {
		return bill;
	}

	public void setBill(List<BillDetailBody> body) {
		this.bill = body;
	}
}
