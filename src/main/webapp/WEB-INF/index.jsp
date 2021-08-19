<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Insert title here</title>
</head>

<body>
	<div class="container">

		<h1>Questions Dashboard</h1>
		<div>
			<table>
				<tr>
					<th>Questions:</th>
					<th>Tags:</th>
				</tr>
				<c:forEach items="${questions }" var="q">
					<tr>
						<td>
						<a href="/questions/${q.id }"><c:out value="${q.question }"></c:out></a>
						</td>
						<td>
						<c:forEach items="${q.tags }" var="tag">
							<c:out value="${tag.subject }"></c:out>
						</c:forEach>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<a href="/questions/new">New Question</a>
	</div>

	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/app.js"></script>
</body>

</html>