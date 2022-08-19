<%@page import="com.hanul.laundry.dto.StoreDTO" %>

<%@page import="com.google.gson.Gson" %>
<%@page import="com.google.gson.JsonObject" %>

<%@page import="org.springframework.ui.Model" %>
<%@page import="java.sql.*,java.sql.Date,javax.sql.*,javax.naming.*,java.util.*,java.io.PrintWriter" %>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%
Gson gson = new Gson();
String json = gson.toJson((ArrayList<StoreDTO>)request.getAttribute("anSearch"));

// 클라이언트에게 응답
out.println(json);	 	
	
	/* 로그인의 경우 : MemberDTO 
		Gson gson = new Gson();
		String json = gson.toJson((MemberDTO)request.getAttribute("anLogin"));
	*/
%>    
    