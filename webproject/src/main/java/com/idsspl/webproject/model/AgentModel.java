package com.idsspl.webproject.model;

public class AgentModel {
	
	private String accountCode;

	private String name;

	private Double ledgerbalance;

	private String customerId;
	
	private String accountType;

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getLedgerbalance() {
		return ledgerbalance;
	}

	public void setLedgerbalance(Double ledgerbalance) {
		this.ledgerbalance = ledgerbalance;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	
	
	
}
