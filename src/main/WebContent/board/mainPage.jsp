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
		<%-- <c:if test="${Integer.parseInt(catelist.cate_code) == 1 }"> --%>
		<c:forEach var="c" items="${catelist}">
			<tr>
				<td><a href="">
						${c.cate_name} </a>
						${c.cate_code} </a></td>
			</tr>
		</c:forEach>
		<%-- </c:if> --%>
	</table>

</body>
</html>