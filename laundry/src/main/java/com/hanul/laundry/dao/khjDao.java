package com.hanul.laundry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


import com.hanul.laundry.dto.khjCleanDTO;
import com.hanul.laundry.dto.khjMemberDTO;
import com.hanul.laundry.dto.khjMoneyDTO;
import com.hanul.laundry.dto.khjRecentDTO;


public class khjDao {
	
	// 데이터 베이스와 연동 : 데이터베이스 초기화 해줌
	DataSource dataSource;
	
	// 생성자를 통해서 데이터베이스 드라이버를 선언해준다
	public khjDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:/comp/env/teamAll");			
			
		}catch(NamingException e) {
			e.getMessage();
		}
		
	}	
	
public ArrayList<khjRecentDTO> anSelectRecent() {
	
	ArrayList<khjRecentDTO> adtos = new ArrayList<khjRecentDTO>();
	Connection connection = null;
	PreparedStatement prepareStatement = null;
	ResultSet resultSet = null;
	
	try {
		connection = dataSource.getConnection();
		String query = "select recent from recentdto";
		prepareStatement = connection.prepareStatement(query);
		resultSet = prepareStatement.executeQuery();
		
		while (resultSet.next()) {
			String recent = resultSet.getString("recent");
			
			khjRecentDTO adto = new khjRecentDTO(recent);
			adtos.add(adto);
		}
	}catch (Exception e) {
		
		System.out.println(e.getMessage());
		} finally {
			try {			
				
				if (resultSet != null) {
					resultSet.close();
				}
				if (prepareStatement != null) {
					prepareStatement.close();
				}
				if (connection != null) {
					connection.close();
				}	

			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}
		}

		return adtos;

		}

public ArrayList<khjMoneyDTO> anSelectMoney() {
	
	ArrayList<khjMoneyDTO> adtos = new ArrayList<khjMoneyDTO>();
	Connection connection = null;
	PreparedStatement prepareStatement = null;
	ResultSet resultSet = null;
	
	try {
		connection = dataSource.getConnection();
		String query = "select id, money "
						+ "from moneydto";
		prepareStatement = connection.prepareStatement(query);
		resultSet = prepareStatement.executeQuery();
		
		while (resultSet.next()) {
			String id = resultSet.getString("id");
			String money = resultSet.getString("money");
			
			khjMoneyDTO adto = new khjMoneyDTO(id, money);
			adtos.add(adto);
		}
	}catch (Exception e) {
		
		System.out.println(e.getMessage());
		} finally {
			try {			
				
				if (resultSet != null) {
					resultSet.close();
				}
				if (prepareStatement != null) {
					prepareStatement.close();
				}
				if (connection != null) {
					connection.close();
				}	

			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}
		}

		return adtos;

		}
	
	
public ArrayList<khjCleanDTO> kimSelectClean() {
	
	ArrayList<khjCleanDTO> adtos = new ArrayList<khjCleanDTO>();
	Connection connection = null;
	PreparedStatement prepareStatement = null;
	ResultSet resultSet = null;
	
	try {
		connection = dataSource.getConnection();
		String query = "select location, latitude, longitude, address, imageurl "
						+ "from store";
		prepareStatement = connection.prepareStatement(query);
		resultSet = prepareStatement.executeQuery();
		
		while (resultSet.next()) {
			String location = resultSet.getString("location");
			String latitude = resultSet.getString("latitude");
			String longitude = resultSet.getString("longitude");
			String address = resultSet.getString("address");
			String imageurl = resultSet.getString("imageurl");
			
			khjCleanDTO adto = new khjCleanDTO(location, latitude, longitude, address, imageurl);
			adtos.add(adto);
		}
	}catch (Exception e) {
		
		System.out.println(e.getMessage());
	} finally {
		try {			
			
			if (resultSet != null) {
				resultSet.close();
			}
			if (prepareStatement != null) {
				prepareStatement.close();
			}
			if (connection != null) {
				connection.close();
			}	

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	return adtos;

	}

	
public ArrayList<khjMemberDTO> anSelectMember() {
	
	ArrayList<khjMemberDTO> adtos = new ArrayList<khjMemberDTO>();
	Connection connection = null;
	PreparedStatement prepareStatement = null;
	ResultSet resultSet = null;
	
	try {
		connection = dataSource.getConnection();
		String query = "select id, name, email, phonenumber, profileimage "
						+"from memberdto";
		prepareStatement = connection.prepareStatement(query);
		resultSet = prepareStatement.executeQuery();
		
		while (resultSet.next()) {
			String id = resultSet.getString("id");
			String name = resultSet.getString("name");
			String email = resultSet.getString("email");
			String phonenumber = resultSet.getString("phonenumber");
			String profileimage = resultSet.getString("profileimage");
			
			khjMemberDTO adto = new khjMemberDTO(id, name, email, phonenumber, profileimage);
			adtos.add(adto);
		}
		
		System.out.println("adtos크기" + adtos.size());
		
	}catch (Exception e) {
		
		System.out.println(e.getMessage());
	} finally {
		try {			
			
			if (resultSet != null) {
				resultSet.close();
			}
			if (prepareStatement != null) {
				prepareStatement.close();
			}
			if (connection != null) {
				connection.close();
			}	

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	return adtos;

	}
}
	
	/*
	 * // 8. 회원가입 : anJionCommand에서 값을 넘겨받는다 public int android(String id, String
	 * money) { // 데이터베이스와 연동하여 원하는 결과물을 얻는다. Connection connection = null;
	 * PreparedStatement preparedStatement = null; int state = -100;
	 * 
	 * try { connection = dataSource.getConnection(); String query = "select * " +
	 * "from android "; preparedStatement = connection.prepareStatement(query);
	 * state = preparedStatement.executeUpdate();
	 * 
	 * 
	 * }catch(Exception e) { System.out.println(e.getMessage()); }finally { try {
	 * if(preparedStatement != null) { preparedStatement.close(); } if(connection !=
	 * null) { connection.close(); }
	 * 
	 * }catch(Exception e) { e.getMessage(); } }
	 * 
	 * // 9. 원하는 값을 넘겨줌 return state;
	 * 
	 * }
	 */
	

		
		













