<%@page import="com.hanul.laundry.dto.KangDTO" %>

<%@page import="com.google.gson.Gson" %>
<%@page import="com.google.gson.JsonObject" %>

<%@page import="org.springframework.ui.Model" %>
<%@page import="java.sql.* , javax.sql.*, javax.naming.*, java.util.*, java.io.PrintWriter" %>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%
	String state = (String)request.getAttribute("kangTime");
	out.println(state);
	
	/* 로그인의 경우 : MemberDTO 
		Gson gson = new Gson();
		String json = gson.toJson((MemberDTO)request.getAttribute("anLogin"));
	*/
	
	

%>    
    