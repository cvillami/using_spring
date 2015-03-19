package com.test.sbb.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the vw_alerts database table.
 * 
 */
@Entity
@Table(name="vw_alerts")
@NamedQuery(name="VwAlert.findAll", query="SELECT v FROM VwAlert v")
public class VwAlert implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String alevel;

	private String application;

	private BigDecimal cutoffreq;

	private String mail;

	private int mxreq;

	private String sms;

	private BigDecimal warningreq;

	public VwAlert() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAlevel() {
		return this.alevel;
	}

	public void setAlevel(String alevel) {
		this.alevel = alevel;
	}

	public String getApplication() {
		return this.application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public BigDecimal getCutoffreq() {
		return this.cutoffreq;
	}

	public void setCutoffreq(BigDecimal cutoffreq) {
		this.cutoffreq = cutoffreq;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getMxreq() {
		return this.mxreq;
	}

	public void setMxreq(int mxreq) {
		this.mxreq = mxreq;
	}

	public String getSms() {
		return this.sms;
	}

	public void setSms(String sms) {
		this.sms = sms;
	}

	public BigDecimal getWarningreq() {
		return this.warningreq;
	}

	public void setWarningreq(BigDecimal warningreq) {
		this.warningreq = warningreq;
	}

	@Override
	public String toString() {
		return "VwAlert [id=" + id + ", alevel=" + alevel + ", application="
				+ application + ", cutoffreq=" + cutoffreq + ", mail=" + mail
				+ ", mxreq=" + mxreq + ", sms=" + sms + ", warningreq="
				+ warningreq + "]";
	}

}