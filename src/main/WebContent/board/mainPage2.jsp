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
			<c:if test="${c.cate_code == 1}">
				<tr>
					<td><a href=""> ${c.cate_name} ${c.cate_code} </a></td>
				</tr>
			</c:if>
		</c:forEach>

		<c:forEach var="c" items="${catelist}">
			<c:if test="${c.cate_code == 2}">
				<tr>
					<td><a href=""> ${c.cate_name} ${c.cate_code} </a></td>
				</tr>
			</c:if>
		</c:forEach>

		<c:forEach var="c" items="${catelist}">
			<c:if test="${c.cate_code == 3}">
				<tr>
					<td><a href=""> ${c.cate_name} ${c.cate_code} </a></td>
				</tr>
			</c:if>
		</c:forEach>

		<c:forEach var="c" items="${catelist}">
			<c:if test="${c.cate_code == 4}">
				<tr>
					<td><a href=""> ${c.cate_name} ${c.cate_code} </a></td>
				</tr>
			</c:if>
		</c:forEach>

		<c:forEach var="c" items="${catelist}">
			<c:if test="${c.cate_code == 5}">
				<tr>
					<td><a href=""> ${c.cate_name} ${c.cate_code} </a></td>
				</tr>
			</c:if>
		</c:forEach>
	</table>

</body>
</html>