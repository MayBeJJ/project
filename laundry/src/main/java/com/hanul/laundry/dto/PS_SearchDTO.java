package com.hanul.laundry.dto;

import java.io.Serializable;

public class PS_SearchDTO implements Serializable {
	/*
	 * �ʿ��� �������÷���(���̺��̸�)  
	 * 
	 * 1. Search 
	 * 	- �����̸� : storeid(store)
	 * 	- ���� �ּ� : address(store) �� ����ġ ������ �Ÿ� ��� - ���浵�� ����ؼ� java���� ���
	 * 	- ��� ���� ��Ź�� ���� : operating(store?) - 0719 ���� : storestate machineid
	 * 
	 * 2. burger
	 * 	- ����� �̸� : name(userinfo)
	 * 
	 * 3. QR
	 * 	- ����� �̸� : name(userinfo)
	 * 	- �ܿ��ݾ� : point(userinfo)
	 * 
	 * */
	
	/*
	 *	0718~19 �ϴ� Search�� �����̸�, �����ּҸ� �����غ���. �� ���Ŀ� ���ݾ� Ȯ��. 
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

	
	
	
//	String id, passwd, name, phonenumber, address, filename;
//
//	public MemberDTO(String id, String name, String phonenumber, String address, String filename) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.phonenumber = phonenumber;
//		this.address = address;
//		this.filename = filename;
//	}
//	
//	public MemberDTO(String id, String passwd, String name, String phonenumber, String address, String filename) {
//		super();
//		this.id = id;
//		this.passwd = passwd;
//		this.name = name;
//		this.phonenumber = phonenumber;
//		this.address = address;
//		this.filename = filename;
//	}
//
//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
//
//	public String getPasswd() {
//		return passwd;
//	}
//
//	public void setPasswd(String passwd) {
//		this.passwd = passwd;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getPhonenumber() {
//		return phonenumber;
//	}
//
//	public void setPhonenumber(String phonenumber) {
//		this.phonenumber = phonenumber;
//	}
//
//	public String getAddress() {
//		return address;
//	}
//
//	public void setAddress(String address) {
//		this.address = address;
//	}
//
//	public String getFilename() {
//		return filename;
//	}
//
//	public void setFilename(String filename) {
//		this.filename = filename;
//	}
	
	
	
}
