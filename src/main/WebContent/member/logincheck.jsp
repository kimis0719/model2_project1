<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.memberDTO" %>

<%
	// 세션 저장되어있는 로그인 회원정보를 받아 저장
	memberDTO loginMember = (memberDTO)session.getAttribute("loginMember");
	
	if(loginMember == null){	// 비로그인상태 일시
		out.println("<script>");
		out.println("alert('로그인이 필요합니다');");
		out.println("history.go(-1)");
		out.println("</script>");
	}

%>