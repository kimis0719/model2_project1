<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Password찾기 결과창</title>
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
  <h2>Password 찾기</h2>
  <form method="post" action="<%=request.getContextPath()%>/">
    <div class="form-group">
      <h5>회원님의 Password는: ${mem_pass} 입니다.</h5>
    </div>
  </form>
  <div style="text-align:center">
  <input type="button" class="btn btn-default" value="로그인" onClick="location.href='./member/loginForm.jsp'">
  </div>
  </div>
</div>

</body>
</html>