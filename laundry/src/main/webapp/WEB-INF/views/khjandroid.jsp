<%@ page import="com.hanul.laundry.dto.khjMemberDTO" %>
<%@ page import="com.hanul.laundry.dto.khjRecentDTO" %>
<%@ page import="com.hanul.laundry.dto.khjMoneyDTO" %>


<%@page import="com.google.gson.Gson" %>
<%@page import="com.google.gson.JsonObject" %>

<%@page import="org.springframework.ui.Model" %>
<%@page import="java.sql.* , javax.sql.*, javax.naming.*, java.util.*, java.io.PrintWriter" %>

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%
	Gson gson = new Gson();
	String state = gson.toJson((ArrayList<khjMemberDTO>)request.getAttribute("anMemberSelect"));
	out.println(state);
	Gson gson2 = new Gson();
	String statString = gson.toJson((ArrayList<khjMoneyDTO>)request.getAttribute("anMoneySelect"));
	out.println(state);
	Gson gson3 = new Gson();
	String staString = gson.toJson((ArrayList<khjRecentDTO>)request.getAttribute("anRecentSelect"));
	out.println(state);
	
	
	/* 로그인의 경우 : MemberDTO 
		Gson gson = new Gson();
		String json = gson.toJson((MemberDTO)request.getAttribute("anLogin"));
	*/
	
	

%>    