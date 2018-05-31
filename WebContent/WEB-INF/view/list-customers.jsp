<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
	<head>
		<title>Customers' list</title>
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/assets/bootstrap.css">
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/assets/style.css">
	</head>
	<body>
		<div class="container">
			<h1 id="title">Customers list</h1>
			<input type="button" class="my-3 btn btn-primary d-block" onclick="window.location.href='addCustomer'" value="Add customer"/>
			<table class="table table-striped table-hover">
				<thead class="thead-dark text-center">
					<tr>
						<th>First name</th>
						<th>Last name</th>
						<th>email</th>
						<th>Action</th>
					</tr>
				<thead>
				<tbody class="text-center">
					<c:forEach var="cust" items="${customers}">
						<c:url var="updateLink" value="/customer/update">
							<c:param name="customerId" value="${cust.id}"></c:param>
						</c:url>
						
						<c:url var="deleteLink" value="/customer/delete">
							<c:param name="customerId" value="${cust.id}"></c:param>
						</c:url>
						<tr>
							<td>${cust.firstName}</td>
							<td>${cust.lastName}</td>
							<td>${cust.email}</td>
							<td><a href="${updateLink}">Update</a><span class="mx-2">|</span><a href="${deleteLink}">Delete</a></td>
						</tr>					
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<script src="${pageContext.request.contextPath}/assets/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/tether.min.js"></script>
		<script src="${pageContext.request.contextPath}/assets/bootstrap.min.js"></script>
	</body>
</html>