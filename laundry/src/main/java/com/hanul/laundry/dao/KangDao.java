package com.hanul.laundry.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.hanul.laundry.dto.UserDTO;

import oracle.jdbc.internal.OracleTypes;


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
	public UserDTO kangJoin(String id, String name, String email, String phone,  String profile) {
		// 데이터베이스와 연동하여 원하는 결과물을 얻는다.
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int state = -100;
		UserDTO dto = null;
		
		try {
			connection = dataSource.getConnection();
			/*
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
			*/
			//2022.08.18 로그인사용자 정보 조회 프로시저호출로 변경 by 조순섭
			String query = "{call pro_userselect(?,?, ?, ?, ?, ?)}";
            CallableStatement statement = connection.prepareCall(query);
            statement.setString(1, id);
            statement.setString(2, name);
            statement.setString(3, email);
            statement.setString(4, phone);
            statement.setString(5, profile);
            statement.registerOutParameter(6, OracleTypes.CURSOR);
            statement.execute();
            ResultSet rs = (ResultSet) statement.getObject(6);
            if( rs.next() ){
            	dto = new UserDTO(rs.getString("userid"), rs.getString("name"), rs.getString("email")
            			,rs.getString("phone"), rs.getString("profile"),  rs.getString("point"));
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
		return dto;
		
	}
	
	public HashMap<String, String> bookmark_store(String userid){
		HashMap<String, String> bookmark = new HashMap<String, String>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs;
		try {
			conn = dataSource.getConnection();
			/*
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
			*/
			//2022.08.18 로그인사용자 정보 조회 프로시저호출로 변경 by 조순섭
			String query = "select storeid from bookmark where userid=?";
			ps = conn.prepareStatement(query);            
			ps.setString(1, userid);
			rs = ps.executeQuery();
            while( rs.next() ){
            	bookmark.put(String.valueOf(rs.getInt("storeid")), String.valueOf(rs.getInt("storeid")) );
            }			
            rs.close();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(conn != null) {
					conn.close();
				}
				
			}catch(Exception e) {
				e.getMessage();
			}
		}
		
		return bookmark;
	}
			

}












