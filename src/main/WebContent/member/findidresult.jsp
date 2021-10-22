<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ID찾기 결과창</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap.min.js"></script>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="findinfo.js"></script>
<style>
 .btn-default {
     	 background: #EC5E5E;
     	 color: #fff;
   }
</style>

</head>
<body>
<div class="container" style="padding: 350px;">
<div class="jumbotron">
  <h2>ID 찾기</h2>
  <form action="<%=request.getContextPath()%>/">
    <div class="form-group">
      <label for="email"><h5>회원님의 ID는: ${mem_id} 입니다.</h5></label>
      			
    </div>
  </form>
  <div>
  <input type="button" class="btn btn-default" value="비번찾기" onClick="location.href='searchpw.jsp'">
  </div>
  </div>
</div>

</body>
</html>