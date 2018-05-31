<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Add customer</title>
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/assets/bootstrap.css">
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/assets/style.css">
	</head>
	<body>
	<h1 class="my-3 text-center">Add/Update Customer</h1>
		<form:form class="col-md-4 text-center offset-md-4" action="handleCustomer" modelAttribute="customer" method="POST">
			<form:hidden path="id"/>
			<form:input class="form-control my-2" path="firstName" placeholder="First name"/>
			<form:input class="form-control my-2" path="lastName" placeholder="Last name"/>
			<form:input class="form-control my-2" path="email" placeholder="email"/>
			<input class="btn btn-success my-2  d-inline-block" type="submit" value="Submit"/>
		</form:form> 
		
		<script src="${pageContext.request.contextPath}/assets/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/tether.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/bootstrap.min.js"></script>
	</body>
</html>