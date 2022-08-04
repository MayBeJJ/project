package com.hanul.laundry.dto;

import java.io.Serializable;

public class PS_SearchDTO implements Serializable {
	/*
	 * 필요한 데이터컬럼명(테이블이름)  
	 * 
	 * 1. Search 
	 * 	- 가게이름 : storeid(store)
	 * 	- 가게 주소 : address(store) 와 현위치 사이의 거리 계산 - 위경도를 사용해서 java에서 계산
	 * 	- 사용 가능 세탁기 개수 : operating(store?) - 0719 질문 : storestate machineid
	 * 
	 * 2. burger
	 * 	- 사용자 이름 : name(userinfo)
	 * 
	 * 3. QR
	 * 	- 사용자 이름 : name(userinfo)
	 * 	- 잔여금액 : point(userinfo)
	 * 
	 * */
	
	/*
	 *	0718~19 일단 Search의 가게이름, 가게주소만 연결해보자. 그 이후에 조금씩 확장. 
	 * 
	 * */
	private String name, email, phonenumber, id, profileimage;
	private String address, location, imageurl;
	private String userid;
	private int point;
	

	public PS_SearchDTO(String address, String location, String imageurl) {
		super();
		this.address = address;
		this.location = location;
		this.imageurl = imageurl;
	}

	
	public PS_SearchDTO(String name, int point) {
		this.name = name;
		this.point = point;
	}

	
	public PS_SearchDTO(String name, String email, String phonenumber, String id, String profileimage) {
        this.name = name;
        this.email = email;
        this.phonenumber = phonenumber;
        this.id = id;
        this.profileimage = profileimage;
    }
	
	
	
	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getImageurl() {
		return imageurl;
	}

	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	   

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public String getPhonenumber() {
	        return phonenumber;
	    }

	    public void setPhonenumber(String phonenumber) {
	        this.phonenumber = phonenumber;
	    }

	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	    public String getProfileimage() {
	        return profileimage;
	    }

	    public int getPoint() {
			return point;
		}

		public void setPoint(int point) {
			this.point = point;
		}

		public void setProfileimage(String profileimage) {
	        this.profileimage = profileimage;
	    }

	
	
	
	
	
}
