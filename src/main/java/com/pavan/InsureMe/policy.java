package com.pavan.InsureMe;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class policy {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String policyName;
	private long policyNumber;
	private String companyName;
	private long sumAssured;
	private long premiumAmount;
	private long tenure;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public long getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(long policyNumber) {
		this.policyNumber = policyNumber;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public long getSumAssured() {
		return sumAssured;
	}
	public void setSumAssured(long sumAssured) {
		this.sumAssured = sumAssured;
	}
	public long getPremiumAmount() {
		return premiumAmount;
	}
	public void setPremiumAmount(long premiumAmount) {
		this.premiumAmount = premiumAmount;
	}
	public long getTenure() {
		return tenure;
	}
	public void setTenure(long tenure) {
		this.tenure = tenure;
	}
	public policy(long id, String policyName, long policyNumber, String companyName, long sumAssured,
			long premiumAmount, long tenure) {
		super();
		this.id = id;
		this.policyName = policyName;
		this.policyNumber = policyNumber;
		this.companyName = companyName;
		this.sumAssured = sumAssured;
		this.premiumAmount = premiumAmount;
		this.tenure = tenure;
	}
	public policy() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
