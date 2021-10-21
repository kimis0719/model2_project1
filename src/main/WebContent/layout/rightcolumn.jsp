<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<%
	if(session.getAttribute("mem_id")==null){
	       %>
	       <div class="rightcolumn">
			<div class="card">
			<a href="Login.member"><button class="btn login">로그인</button></a>

			<a href="Join.member"><button class="btn sing-up">회원가입</button></a>
			</div>
		</div>
<% 		
	}else{
		
	%>
		<%=session.getAttribute("sessionID") %>님 로그인되었습니다.<br>
		<div class="rightcolumn">
			<div class="card">
			<h2><%=session.getAttribute("mem_id") %>님 로그인 되었습니다.</h2>
			<a href="Logout.member"><button class="btn logout">로그아웃</button></a>
			<a href="Update.do"><button class="btn mypage">마이페이지</button></a>
			</div>
		</div>
<% }%>	
	



