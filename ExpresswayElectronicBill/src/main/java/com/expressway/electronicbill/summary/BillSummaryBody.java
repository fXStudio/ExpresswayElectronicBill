package com.expressway.electronicbill.summary;

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
public class BillSummaryBody {
	private String billtype;
	private String billreg;
	private String amt;
	private String bgnno;
	private String endno;
	private String copynum;
	private String invldnospan;
	private String blnknospan;
	private String blnkcnt;

	public String getBilltype() {
		return billtype;
	}

	public void setBilltype(String billtype) {
		this.billtype = billtype;
	}

	public String getBillreg() {
		return billreg;
	}

	public void setBillreg(String billreg) {
		this.billreg = billreg;
	}

	public String getAmt() {
		return amt;
	}

	public void setAmt(String amt) {
		this.amt = amt;
	}

	public String getBgnno() {
		return bgnno;
	}

	public void setBgnno(String bgnno) {
		this.bgnno = bgnno;
	}

	public String getEndno() {
		return endno;
	}

	public void setEndno(String endno) {
		this.endno = endno;
	}

	public String getCopynum() {
		return copynum;
	}

	public void setCopynum(String copynum) {
		this.copynum = copynum;
	}

	public String getInvldnospan() {
		return invldnospan;
	}

	public void setInvldnospan(String invldnospan) {
		this.invldnospan = invldnospan;
	}

	public String getBlnknospan() {
		return blnknospan;
	}

	public void setBlnknospan(String blnknospan) {
		this.blnknospan = blnknospan;
	}

	public String getBlnkcnt() {
		return blnkcnt;
	}

	public void setBlnkcnt(String blnkcnt) {
		this.blnkcnt = blnkcnt;
	}
}
