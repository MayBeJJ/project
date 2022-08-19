package com.hanul.laundry.dto;


public class TimeDTO  {
	String storeid, machineid, cost;

	public TimeDTO(String storeid, String machineid, String cost) {
		super();
		this.storeid = storeid;
		this.machineid = machineid;
		this.cost = cost;
	}

	public String getStoreid() {
		return storeid;
	}

	public void setStoreid(String storeid) {
		this.storeid = storeid;
	}

	public String getMachineid() {
		return machineid;
	}

	public void setMachineid(String machineid) {
		this.machineid = machineid;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}
}
