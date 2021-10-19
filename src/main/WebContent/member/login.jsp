<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.css">
<title>로그인 페이지</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>

<script src="<%=request.getContextPath() %>/member/login.js"></script>
<style>
	.btn-default {
     	 background: #EC5E5E;
     	 color: #fff;
   }
</style>
</head>
<body>

	<div class="container" style="padding: 230px;">
		<div class="jumbotron">
  <div align="center"><h2>로그인</h2></div>
  <form method="post" action="<%=request.getContextPath()%>/Login.do">
   <table class="table table-bordered table-hover" align="center" >
    <div class="form-group">
      <label for="mem_id">ID:</label>
      <input type="text" class="form-control" id="mem_id" placeholder="아이디" maxlength="20">
    </div>
    <div class="form-group">
      <label for="mem_pass">Password:</label>
      <input type="password" class="form-control" id="mem_pass" placeholder="비밀번호" maxlength="20">
    </div>
    	<div class="checkbox">
      	<label><input type="checkbox"> 아이디 저장</label>
    	</div>
      <div style="text-align:left">ID/PW찾기</div>
      <div style="text-align:right">
    <button type="submit" class="btn btn-default">로그인</button>
     </div>
 	</table>
  </form>
  </div>
</div>

</body>
</html>