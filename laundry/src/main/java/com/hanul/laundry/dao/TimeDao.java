package com.hanul.laundry.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class TimeDao {
	
	// 데이터 베이스와 연동 : 데이터베이스 초기화 해줌
	DataSource dataSource;
	
	// 생성자를 통해서 데이터베이스 드라이버를 선언해준다
	public TimeDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:/comp/env/teamAll");			
			
		}catch(NamingException e) {
			e.getMessage();
		}
		
	}	
	// 8. iot 정보를 받아 데이터베이스 갱신
	public int kangTime(String userid, String machineseq, String resttime) {
		// 데이터베이스와 연동하여 원하는 결과물을 얻는다.
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int state = -100;
		
		try {
			connection = dataSource.getConnection();
			
			String query = "{call pro_storestate(?,?, ?)}";
            CallableStatement statement = connection.prepareCall(query);
            statement.setString(1, userid);
            statement.setInt(2, Integer.parseInt(machineseq));
            statement.setInt(3, Integer.parseInt(resttime));
            statement.execute();
	
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












