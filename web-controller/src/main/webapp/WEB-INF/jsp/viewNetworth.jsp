<%@ page language="java" contentType="text/html;  charset=UTF-8"
	import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<link rel="stylesheet" href="style/viewNetworth-style.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<title>View Networth</title>
</head>
<body style="background-image: url('images/bg-01.jpg'); ">
	<nav class="navbar navbar-dark nav_bg">
		<a class="navbar-brand" href="#" style="margin-left: 20px;"> 
		<img src="images/icons/logo.png" width="30" height="30" class="d-inline-block align-top" alt="">
			Portfolio Manager
		</a>
		<form action="/Home">
			<button type="button float-right" style="margin-right: 20px;"
				class="login100-form-btn">Home</button>
		</form>
	</nav>
	<br>
	<div class="container">
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-5">
				<div class="card card-body text-center shadow-lg">
					
					<div class="card-block">
						<h3 class="card-title">Calculated Networth</h3>
						
						<h4 class="card-text">Your Networth is : <span class="text-primary"><strong> ${networth} </strong></span></h4>
						<br> 
						<c:if test="${assetMap != null}" >
						<br>
						<div class="container">
							<table class="table">
								<thead class="thead-dark">
									<tr>
										<th>Asset</th>
										<th>Units Sold</th>
									</tr>
								</thead>
								<tbody>
										<%-- <c:forEach items="${sold}" var="asset">
								</c:forEach>
								<td><c:out value="{}" </td> --%>


										<c:forEach items="${assetMap}" var="temp">
										<tr>
											<td>${temp.key}</td>
											<td>${temp.value}</td>
										</tr>
										</c:forEach>
								</tbody>
							</table>
							
						</div>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>