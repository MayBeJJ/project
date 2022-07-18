package com.hanul.laundry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class KangDao {
	
	// ������ ���̽��� ���� : �����ͺ��̽� �ʱ�ȭ ����
	DataSource dataSource;
	
	// �����ڸ� ���ؼ� �����ͺ��̽� ����̹��� �������ش�
	public KangDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:/comp/env/teamAll");			
			
		}catch(NamingException e) {
			e.getMessage();
		}
		
	}	
	// 8. ȸ������ : anJionCommand���� ���� �Ѱܹ޴´�
	public int kangJoin(String name, String email, String phonenumber, String id, String profileimage) {
		// �����ͺ��̽��� �����Ͽ� ���ϴ� ������� ��´�.
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int state = -100;
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into userinfo(userid, name, email, profile, phone) " 
						+ " values('" + id + "', '" + name + "', '" + email  + "', '" 
						+ profileimage + "', '" + phonenumber +"' )";
			preparedStatement = connection.prepareStatement(query);
			state = preparedStatement.executeUpdate();
			
			if(state > 0) {
				System.out.println("ȸ�����Լ���!!!");
			}else {
				System.out.println("ȸ�����Խ��� �̤�");
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
				
			}catch(Exception e) {
				e.getMessage();
			}
		}
		
		// 9. ���ϴ� ���� �Ѱ���
		return state;
		
	}
	

			

}












