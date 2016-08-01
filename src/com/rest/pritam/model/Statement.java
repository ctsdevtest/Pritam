package com.rest.pritam.model;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "statement")
public class Statement implements Serializable {
	private static final long serialVersionUID = 4705269836194984397L;
	private int trans_id;
	private int acc_id;
	private Date date;
	private String transaction_type;
	private double amount;

	public Statement() {
		super();
	}
	
	public Date getDate() {
		return date;
	}

	@XmlElement
	public void setDate(Date date) {
		this.date = date;
	}

	public String getTransaction_type() {
		return transaction_type;
	}

	@XmlElement
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}

	public int getAcc_id() {
		return acc_id;
	}

	@XmlElement
	public void setAcc_id(int acc_id) {
		this.acc_id = acc_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getTrans_id() {
		return trans_id;
	}

	public void setTrans_id(int trans_id) {
		this.trans_id = trans_id;
	}

	public Statement(int trans_id, int acc_id, Date date, String transaction_type, double amount) {
		super();
		this.acc_id = acc_id;
		this.trans_id = trans_id;
		this.date = date;
		this.transaction_type = transaction_type;
		this.amount = amount;
	}

}
