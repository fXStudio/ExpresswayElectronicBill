package com.expressway.electronicbill.detail;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class BillBody {
	private String payername;
	private List<BillChargeItem> chargeitems = new ArrayList<BillChargeItem>();

	@XmlElementWrapper(name = "chargeitems")
	@XmlElement(name = "charge")
	public List<BillChargeItem> getBody() {
		return chargeitems;
	}

	@XmlElement(name = "payername")
	public String getPayername() {
		return payername;
	}

	public void setPayername(String payername) {
		this.payername = payername;
	}

	public void setBody(List<BillChargeItem> chargeitems) {
		this.chargeitems = chargeitems;
	}
}
