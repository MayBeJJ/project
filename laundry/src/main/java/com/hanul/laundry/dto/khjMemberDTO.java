package com.hanul.laundry.dto;

public class khjMemberDTO {
	String id, email, name, phonenumber, profileimage;

	public khjMemberDTO(String id, String email, String name, String phonenumber, String profileimage) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.phonenumber = phonenumber;
		this.profileimage = profileimage;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getProfileimage() {
		return profileimage;
	}

	public void setProfileimage(String profileimage) {
		this.profileimage = profileimage;
	}

	
}