package com.hanul.laundry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class KangDao {
	
	// 데이터 베이스와 연동 : 데이터베이스 초기화 해줌
	DataSource dataSource;
	
	// 생성자를 통해서 데이터베이스 드라이버를 선언해준다
	public KangDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:/comp/env/teamAll");			
			
		}catch(NamingException e) {
			e.getMessage();
		}
		
	}	
	// 8. 회원가입 : anJionCommand에서 값을 넘겨받는다
	public int kangJoin(String name, String email, String phonenumber, String id, String profileimage) {
		// 데이터베이스와 연동하여 원하는 결과물을 얻는다.
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
				System.out.println("회원가입성공!!!");
			}else {
				System.out.println("회원가입실패 ㅜㅜ");
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
		
		// 9. 원하는 값을 넘겨줌
		return state;
		
	}
	

			

}












