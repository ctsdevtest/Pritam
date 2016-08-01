package com.rest.pritam.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "account")
public class Account implements Serializable{
	
	private static final long serialVersionUID = 6679303781871375506L;
	
	private int id;
	private String name;
	private int balance;
	private String accnt_type;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Account(int id, String name, int balance,String accnt_type) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.accnt_type=accnt_type;
	}
	
	
	public int getId() {
		return id;
	}
	@XmlElement
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	
	
	public int getBalance() {
		return balance;
	}
	@XmlElement
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	
	public String getAccnt_type() {
		return accnt_type;
	}
	
	@XmlElement
	public void setAccnt_type(String accnt_type) {
		this.accnt_type = accnt_type;
	}
	
}
