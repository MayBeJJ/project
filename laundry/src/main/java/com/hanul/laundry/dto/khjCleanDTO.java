package com.hanul.laundry.dto;

public class khjCleanDTO {
	String location, latitude, longitude, address;
	
	

	public khjCleanDTO(String location, String latitude, String longitude, String address) {
		super();
		this.location = location;
		this.latitude = latitude;
		this.longitude = longitude;
		this.address = address;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
