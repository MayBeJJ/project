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

public class kkbBookmarkDao {
	// 데이터 베이스와 연동 : 데이터베이스 초기화 해줌
	DataSource dataSource;
		
	// 생성자를 통해서 데이터베이스 드라이버를 선언해준다
	public kkbBookmarkDao() {
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
			String query = "select b.location,b.address,imageurl"
					+ "from bookmark a left join store b"
					+ "on a.storeid = b.storeid"
					+ "where userid='RJtCsewtd3bYaxCr8rgh-EefV4oeUCYxROPX-op91b4'" ;
			prepareStatement = connection.prepareStatement(query);
			resultSet = prepareStatement.executeQuery();
			
			while (resultSet.next()) {
				//여기에서 위도 경도 계산함수(xxx.java or dao 에서 만들기) 돌리고 건네줌
				String address = resultSet.getString("address");
				String location = resultSet.getString("location");
				String imageurl = resultSet.getString("imageurl");
				//String storeid = resultSet.getString("storeid");
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
}

