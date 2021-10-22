<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ID찾기</title>
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
<div class="container" style="padding: 230px;">
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