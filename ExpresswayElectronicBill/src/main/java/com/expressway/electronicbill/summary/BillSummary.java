package com.expressway.electronicbill.summary;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 票据汇总
 *
 * @author Ajaxfan
 */
@XmlRootElement(name = "pjhz")
@XmlType(name = "", propOrder = { "head", "body" })
public class BillSummary {
	/** 头信息 */
	private BillSummaryHeader head;
	/** 内容 */
	private List<BillSummaryBody> body = new ArrayList<BillSummaryBody>();

	public BillSummaryHeader getHead() {
		return head;
	}

	@XmlElement
	public void setHead(BillSummaryHeader head) {
		this.head = head;
	}

	@XmlElementWrapper(name = "body")
	@XmlElement(name = "item")
	public List<BillSummaryBody> getBody() {
		return body;
	}

	public void setBody(List<BillSummaryBody> body) {
		this.body = body;
	}
}
