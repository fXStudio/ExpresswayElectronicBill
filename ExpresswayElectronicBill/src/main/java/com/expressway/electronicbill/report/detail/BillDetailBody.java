package com.expressway.electronicbill.report.detail;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 票据明细头信息
 *
 * @author Ajaxfan
 */
@XmlRootElement(name = "bill")
@XmlType(name = "", propOrder = { "head", "body"})
public class BillDetailBody {
	/** 头信息 */
	private BillHeader head;
	/** 内容 */
	private BillBody body = new BillBody();

	public BillHeader getHead() {
		return head;
	}

	@XmlElement
	public void setHead(BillHeader head) {
		this.head = head;
	}

	@XmlElement(name = "body")
	public BillBody getBody() {
		return body;
	}

	public void setBody(BillBody body) {
		this.body = body;
	}
}
