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

	// ������ : �����ͺ��̽� ����̹��� �����Ѵ�
	public kkbAnDao() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:/comp/env/teamAll");
			/* dataSource = (DataSource) context.lookup("java:/comp/env/CSS"); */
		} catch (NamingException e) {
			e.getMessage();
		}

	}

	//���ã�� �� ��ư�� ���������� ����. ������ ��ȭ�� �ִ� �Լ�
	public int anlocation(String userid, String storeid , String lc) {
		int state = -100;
		userid = "1";
		storeid= "2";
// �����ͺ��̽��� �����Ͽ� ���ϴ� ������� ��´�
		Connection connection = null;
		PreparedStatement ps = null;
		String query = "";
		try {
			
			connection = dataSource.getConnection();
			/* lc�� �������� if, update 
			 * 
			 * */
			
			  if(lc.equals("1") ) { 
					  query = "insert into BOOKMARK(userid,storeid) " +
								 "values ("+userid+","+storeid+") "; }
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
				System.out.println(state + "���Լ���");
			} else {
				System.out.println(state + "���Խ���");
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

//8. ���ϴ� ���� ���Ͻ�Ų��
		return state;

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
	 * // �����ͺ��̽��� �ִ� ����� ��� �����ͼ� ArrayList�� �ֱ� public ArrayList<LocationDTO>
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
	 * System.out.println("adtosũ��" + adtos.size());
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
