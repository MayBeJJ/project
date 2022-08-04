package com.hanul.laundry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.hanul.laundry.dto.PS_SearchDTO;

public class PS_Dao {
	// 데이터 베이스와 연동 : 데이터베이스 초기화 해줌
	DataSource dataSource;
		
	// 생성자를 통해서 데이터베이스 드라이버를 선언해준다
	public PS_Dao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:/comp/env/teamAll");			
			
		}catch(NamingException e) {
			e.getMessage();
		}
		
	}
	
//	Search에서 뿌릴 데이터 가져오기 : **전체 리스트**
	public ArrayList<PS_SearchDTO> anSearch(){

		// 데이터베이스와 연동하여 원하는 결과물을 얻는다.
		ArrayList<PS_SearchDTO> dtos = new ArrayList<PS_SearchDTO>();
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;		
		
		try {
			connection = dataSource.getConnection();
			String query = "select address, location, imageurl from store" ;
			prepareStatement = connection.prepareStatement(query);
			resultSet = prepareStatement.executeQuery();
			
			while (resultSet.next()) {
				//여기에서 위도 경도 계산함수(xxx.java or dao 에서 만들기) 돌리고 건네줌
				String address = resultSet.getString("address");
				String location = resultSet.getString("location");
				String imageurl = resultSet.getString("imageurl");
				dtos.add(new PS_SearchDTO(address, location, imageurl));							
			}	
			
			//연결되었는지 확인용 print
			System.out.println("dtosSize : " + dtos.size());
			
		} catch (Exception e) {
			
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
		
		
		return dtos;
	}
	
	
	// QRCode : PS_QRCommand에서 값을 넘겨받는다
			public PS_SearchDTO psQRCode(String name) {
				// 데이터베이스와 연동하여 원하는 결과물을 얻는다.
				PS_SearchDTO ps_searchDTO = null;
				Connection connection = null;
				PreparedStatement prepareStatement = null;
				ResultSet resultSet = null;		
				//name="강민재";
				try {
					connection = dataSource.getConnection();
					System.out.println("check1");
					String query = "select name, point "					
									+ " from userinfo" 
									+ " where name = '" + name +"' ";
					System.out.println("check2");
					prepareStatement = connection.prepareStatement(query);
					System.out.println("check3");
					resultSet = prepareStatement.executeQuery();
					System.out.println("check4");
					while (resultSet.next()) {
						int point = resultSet.getInt("point");
						
						System.out.println("check5");

						ps_searchDTO = new PS_SearchDTO(name, point);	
						
					}	
					System.out.println("check6");
					System.out.println("PS_SearchDTO name: " + ps_searchDTO.getName() +" , point : " + ps_searchDTO.getPoint());
					
				} catch (Exception e) {
					
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

				return ps_searchDTO;
				
			}
	
	
	
	
	
}