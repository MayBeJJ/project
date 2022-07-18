package com.hanul.laundry.dto;

public class KangDTO {
	String id, passwd, name, phonenumber, address, filename;

	public KangDTO(String id, String name, String phonenumber, String address, String filename) {
		super();
		this.id = id;
		this.name = name;
		this.phonenumber = phonenumber;
		this.address = address;
		this.filename = filename;
	}
	
	public KangDTO(String id, String passwd, String name, String phonenumber, String address, String filename) {
		super();
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.phonenumber = phonenumber;
		this.address = address;
		this.filename = filename;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
	
}
