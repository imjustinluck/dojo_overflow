<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
			
			<h1>What is your question?</h1>
			<div>
			
				<form:form action="/questions/new" method="POST" modelAttribute="createQuestion">
				<p>
					<form:label path="question">Question: </form:label>
					<form:errors path="question" />
					<form:input path="question" />
				</p>
				<p>
					<label for="subject">Tag: </label>
					<input type="text" name="subject" id="subject"/>
				</p>
				<button>Submit Question</button>
				</form:form>
			
			</div>
		</div>
	
		<script src="/webjars/jquery/jquery.min.js"></script>
		<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="js/app.js"></script>
	</body>
	
</html>