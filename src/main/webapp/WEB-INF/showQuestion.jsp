<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

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

		<h1>Hello Justin!</h1>
		<div>
			<h1>Question</h1>
			<c:out value="${question.question }"></c:out>
		</div>
		<div>
			<h1>Tags</h1>
			<c:forEach items="${question.tags }" var="t">
				<c:out value="${t.subject }"></c:out>
			</c:forEach>
		</div>
		<div>
			<h1>Answers</h1>
			<c:forEach items="${question.answers }" var="a">
				<c:out value="${a.answer }"></c:out>
			</c:forEach>
		</div>
		<div>
			<form:form action="/questions/${question.id }" method="POST"
				modelAttribute="createAnswer">
				<p>
					<form:input type="hidden" path="question" value="${question.id }" />
				</p>
				<p>
					<form:label path="answer">Create Answer: </form:label>
					<form:errors path="answer" />
					<form:input path="answer" />
				</p>
				<button>Submit Answer</button>
			</form:form>
		</div>
	</div>

	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/app.js"></script>
</body>

</html>