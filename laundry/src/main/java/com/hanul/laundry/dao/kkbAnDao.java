package com.hanul.laundry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import com.hanul.laundry.dto.*;

public class kkbAnDao {
	DataSource dataSource;

	// 생성자 : 데이터베이스 드라이버를 셋팅한다
	public kkbAnDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:/comp/env/teamAll");
			/* dataSource = (DataSource) context.lookup("java:/comp/env/CSS"); */
		} catch (NamingException e) {
			e.getMessage();
		}

	}

	//즐겨찾기 별 버튼을 누를때마다 실행. 무조건 변화가 있는 함수
	public  int anlocation(String userid, String storeid , String lc) {
		int state = -100;
		/*
		 * userid = "1"; storeid= "2";
		 */
// 데이터베이스와 연결하여 원하는 결과물을 얻는다
		Connection connection = null;
		PreparedStatement ps = null;
		String query = "";
		try {
			
			connection = dataSource.getConnection();
			/* lc을 기준으로 if, update 
			 * 
			 * */
			
			  if(lc.equals("1") ) { 
					  query = "insert into BOOKMARK(userid,storeid) " +
								 "values ('"+userid+"','"+storeid+"') "; }
			  else if(lc.equals("0")){ 
				  System.out.println("delete> ");
				  query = "delete from bookmark "
			  + " where userid= '"+ userid + "' "
			  + " and storeid= '"+ storeid + "' " ; }
			 
		
			//String query = "insert into BOOKMARK(userid, storeid) " + "values(  '" + userid + "','" + storeid + "')";
			//query = "insert into BOOKMARK(userid,storeid) " +
					 //"values ("+userid+","+storeid+") ";
			  System.out.println("check2");
			ps = connection.prepareStatement(query);
			
			System.out.println("check3");
			state = ps.executeUpdate();
			System.out.println("check4");
			
			if (state > 0) {
				System.out.println(state + "삽입성공");
			} else {
				System.out.println(state + "삽입실패");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (connection != null) {
					connection.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {

			}
		}

//8. 원하는 값을 리턴시킨다
		return state;

	}
	
	public ArrayList<PS_SearchDTO> anSearch2(){

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
	

	/*
	 * public LocationDTO anLogin(String idin, String pwin) { LocationDTO adto =
	 * null; Connection connection = null; PreparedStatement prepareStatement =
	 * null; ResultSet resultSet = null;
	 * 
	 * try { connection = dataSource.getConnection(); String query = "select * " +
	 * " from memberdto" + " where id = '" + idin + "' and pw = '" + pwin + "' ";
	 * prepareStatement = connection.prepareStatement(query); resultSet =
	 * prepareStatement.executeQuery();
	 * 
	 * while (resultSet.next()) { String id = resultSet.getString("id"); String name
	 * = resultSet.getString("name"); String location =
	 * resultSet.getString("location");
	 * 
	 * 
	 * adto = new LocationDTO(id, name, location); }
	 * 
	 * System.out.println("MemberDTO id : " + adto.getId());
	 * 
	 * } catch (Exception e) { System.out.println(e.getMessage()); } finally { try {
	 * if (resultSet != null) { resultSet.close(); } if (prepareStatement != null) {
	 * prepareStatement.close(); } if (connection != null) { connection.close(); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } finally {
	 * 
	 * } }
	 * 
	 * return adto;
	 * 
	 * }
	 */
	/*
	 * // 데이터베이스에 있는 멤버를 모두 가져와서 ArrayList에 넣기 public ArrayList<LocationDTO>
	 * anMemberSelect() {
	 * 
	 * ArrayList<LocationDTO> adtos = new ArrayList<LocationDTO>(); Connection
	 * connection = null; PreparedStatement prepareStatement = null; ResultSet
	 * resultSet = null;
	 * 
	 * try { connection = dataSource.getConnection(); String query =
	 * "select id, name, location " + " from bookmark" + " order by id desc";
	 * prepareStatement = connection.prepareStatement(query); resultSet =
	 * prepareStatement.executeQuery();
	 * 
	 * while (resultSet.next()) { String userid = resultSet.getString("userid");
	 * String storeid = resultSet.getString("storeid");
	 * 
	 * 
	 * 
	 * 
	 * LocationDTO ldto = new LocationDTO(like , name, location); adtos.add(dto);
	 * 
	 * }
	 * 
	 * System.out.println("adtos크기" + adtos.size());
	 * 
	 * } catch (Exception e) {
	 * 
	 * System.out.println(e.getMessage()); } finally { try {
	 * 
	 * if (resultSet != null) { resultSet.close(); } if (prepareStatement != null) {
	 * prepareStatement.close(); } if (connection != null) { connection.close(); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } finally {
	 * 
	 * } }
	 * 
	 * return adtos;
	 * 
	 * }
	 * 
	 */

}
