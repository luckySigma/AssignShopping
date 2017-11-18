<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Shopping - ${title}</title>
<script>
	window.menu = '${title}';

	window.contextRoot = '${contextRoot}';
</script>

<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap DataTables -->
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">

<%-- <!-- Bootstrap Dark theme  CSS -->
<link href="${css}/bootstrap-yeti-theme.css" rel="stylesheet"> --%>

<!-- Custom styles for this template -->
<link href="${css}/myapp.css" rel="stylesheet">

</head>

<body>
	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>
		<!-- Page Content -->

		<div class="content">

			<div class="container">

				<div class="row">

					<div class="container">


						<div class="jumbotron">

							<h1 align="center">${errorTitle}</h1>
							<hr />


							<blockquote style="word-wrap:break-word">${errorDescription}</blockquote>

						</div>


					</div>

				</div>

			</div>

		</div>

		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>

		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.min.js"></script>
		<script src="${js}/bootstrap.bundle.min.js"></script>
		<!-- Data Table Plugin -->
		<script src="${js}/jquery.dataTables.js"></script>

		<!-- Data Table BoostrapScript -->
		<script src="${js}/dataTables.bootstrap4.js"></script>

		<!-- Self coded java script -->

		<script src="${js}/myapp.js"></script>
	</div>
</body>

</html>
