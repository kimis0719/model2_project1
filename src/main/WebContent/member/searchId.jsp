<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="kr">

<head>
<title>ID찾기 페이지</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script src="http://code.jquery.com/jquery-latest.js"></script>

<script src="<%=request.getContextPath() %>/member/findinfo.js"></script>

<style>
 .btn-default {
     	 background: #EC5E5E;
     	 color: #fff;
   }
</style>

</head>
<body>
<div class="container" style="padding: 270px;">
<div class="jumbotron">
  <h2>ID 찾기</h2>
  <form method="post" action="<%=request.getContextPath()%>/FindId.member">
    <div class="form-group">
      <label for="nick">닉네임:</label>
      <input type="text" class="form-control" id="mem_nick" name="mem_nick" placeholder="Enter ncikname" >
    </div>
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="mem_email" name="mem_email" placeholder="Enter email" >
    </div>
    <button type="submit" class="btn btn-default">찾기</button>
  </form>
  <div style="text-align:right">
  <input type="button" class="btn btn-default" value="비번찾기" onClick="location.href='searchpw.jsp'">
  </div>
  </div>
</div>

</body>
</html> 