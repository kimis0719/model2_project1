<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>공지</th>
			<th>일상 취미</th>
			<th>스포츠</th>
			<th>게임</th>
			<th>연예</th>
		</tr>
		<c:forEach var="c" items="${catelist}">
			<c:set var="num" value="5" />
			<tr>
				<td><a href="./BoardListAction.do?cate=${cate}">
						${c.cate_name} </a></td>
			</tr>
		</c:forEach>

		<tr>
			<c:forEach var="item" items="${catelist}">
     			<td>${item.cate_name}</td>
			</c:forEach>
		</tr>

	</table>

</body>
</html>