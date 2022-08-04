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
	// ������ ���̽��� ���� : �����ͺ��̽� �ʱ�ȭ ����
	DataSource dataSource;
		
	// �����ڸ� ���ؼ� �����ͺ��̽� ����̹��� �������ش�
	public PS_Dao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:/comp/env/teamAll");			
			
		}catch(NamingException e) {
			e.getMessage();
		}
		
	}
	
	//	Search���� �Ѹ� ������ �������� : **��ü ����Ʈ**
	public ArrayList<PS_SearchDTO> anSearch(){

		// �����ͺ��̽��� �����Ͽ� ���ϴ� ������� ��´�.
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
				//���⿡�� ���� �浵 ����Լ�(xxx.java or dao ���� �����) ������ �ǳ���
				String address = resultSet.getString("address");
				String location = resultSet.getString("location");
				String imageurl = resultSet.getString("imageurl");
				dtos.add(new PS_SearchDTO(address, location, imageurl));							
			}	
			
			//����Ǿ����� Ȯ�ο� print
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
	
	
	// QRCode : PS_QRCommand���� ���� �Ѱܹ޴´�
			public PS_SearchDTO psQRCode(String name) {
				// �����ͺ��̽��� �����Ͽ� ���ϴ� ������� ��´�.
				PS_SearchDTO ps_searchDTO = null;
				Connection connection = null;
				PreparedStatement prepareStatement = null;
				ResultSet resultSet = null;		
				//name="������";
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