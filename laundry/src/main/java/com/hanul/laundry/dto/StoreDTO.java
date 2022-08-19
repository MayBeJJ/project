package com.hanul.laundry.dto;

public class StoreDTO {
	
	String storeid, location, imageurl, address, operating, f_cctv, f_game, f_toilet, f_concent, f_wifi, f_coin, ownerid, latitude, longitude;
	int cost;

	public StoreDTO(String storeid, String location, String imageurl, String address, String operating, String f_cctv,
			String f_game, String f_toilet, String f_concent, String f_wifi, String f_coin, String ownerid, String latitude,
			String longitude, int cost) {
		super();
		this.storeid = storeid;
		this.location = location;
		this.imageurl = imageurl;
		this.address = address;
		this.operating = operating;
		this.f_cctv = f_cctv;
		this.f_game = f_game;
		this.f_toilet = f_toilet;
		this.f_concent = f_concent;
		this.f_wifi = f_wifi;
		this.f_coin = f_coin;
		this.ownerid = ownerid;
		this.latitude = latitude;
		this.longitude = longitude;
		this.cost = cost;
	}

	public String getStoreid() {
		return storeid;
	}

	public void setStoreid(String storeid) {
		this.storeid = storeid;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOperating() {
		return operating;
	}

	public void setOperating(String operating) {
		this.operating = operating;
	}

	public String getF_cctv() {
		return f_cctv;
	}

	public void setF_cctv(String f_cctv) {
		this.f_cctv = f_cctv;
	}

	public String getF_game() {
		return f_game;
	}

	public void setF_game(String f_game) {
		this.f_game = f_game;
	}

	public String getF_toilet() {
		return f_toilet;
	}

	public void setF_toilet(String f_toilet) {
		this.f_toilet = f_toilet;
	}

	public String getF_concent() {
		return f_concent;
	}

	public void setF_concent(String f_concent) {
		this.f_concent = f_concent;
	}

	public String getF_wifi() {
		return f_wifi;
	}

	public void setF_wifi(String f_wifi) {
		this.f_wifi = f_wifi;
	}

	public String getF_coin() {
		return f_coin;
	}

	public void setF_coin(String f_coin) {
		this.f_coin = f_coin;
	}

	public String getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(String ownerid) {
		this.ownerid = ownerid;
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

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}


}
