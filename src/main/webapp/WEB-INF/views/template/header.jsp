<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="sr">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="<c:url value="/resources/images/favicon.ico" />">

<title><spring:message code="title" /></title>

<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/cover.css" />" rel="stylesheet">
<!-- Style for login page -->
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
	window.jQuery
			|| document
					.write('<script src="<c:url value="/resources/js/jquery-3.2.1.min.js" />"><\/script>')
</script>
<script type="text/javascript"
	src="<c:url value="/resources/js/main.js" />"></script>
</head>

<body>


	<div class="navbar-wrapper">


		<div class="container">


			<div class="container">
				<div class="inner">
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed"
							data-toggle="collapse" data-target="#navbar"
							aria-expanded="false" aria-controls="navbar">
							<span class="sr-only">Toggle navigation</span> <span
								class="icon-bar"></span> <span class="icon-bar"></span> <span
								class="icon-bar"></span>
						</button>
						<a class="navbar-brand" href="<c:url value="/" />"><spring:message code="title" /></a>
					</div>

					<nav class="">
						<!-- navbar -->
						<div id="navbar" class="navbar-collapse collapse">
							<ul class="nav masthead-nav pull-left">
								<c:if test="${pageContext.request.userPrincipal.name != 'admin'}">
									<li><a href="<c:url value="/"/>"><spring:message code="filmovi" /></a></li>
								</c:if>
								
								<c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
									<li><a href="<c:url value="/admin/filmovi" />"><spring:message code="filmovi" /></a></li>
									<li><a href="<c:url value="/admin/sale" />"><spring:message code="sale" /></a></li>
									<li><a href="<c:url value="/admin/projekcije" />"><spring:message code="projekcije" /></a></li>
									<li><a href="<c:url value="/admin/korisnici" />"><spring:message code="korisnici" /></a></li>
								</c:if>
							</ul>
							<ul class="nav masthead-nav">
								<c:if test="${pageContext.request.userPrincipal.name != null}">
									<li><a><spring:message code="dobrodosli" />: ${pageContext.request.userPrincipal.name}</a></li>
									<c:if test="${pageContext.request.userPrincipal.name != 'admin'}">
										<li><a href="<c:url value="/user/profile/${pageContext.request.userPrincipal.name}"/>"><spring:message code="profil" /></a></li>
									</c:if>
									<li><a href="<c:url value="/j_spring_security_logout" />"><spring:message code="logout" /></a></li>

								</c:if>
								<c:if test="${pageContext.request.userPrincipal.name == null}">
									<li><a href="<c:url value="/login" />"><spring:message code="login" /></a></li>
									<li><a href="<c:url value="/register" />"><spring:message code="registracija" /></a></li>
								</c:if>
								<li>
									<div class="dropdown">
										<c:if test="${pageContext.response.locale.language == 'sr'}">
											<button class="dropbtn"><spring:message code="jezik" /> <span class="glyphicon glyphicon-triangle-bottom"></span></button>
										</c:if>
										<c:if test="${pageContext.response.locale.language == 'en'}">
											<button class="dropbtn"><spring:message code="jezik" /> <span class="glyphicon glyphicon-triangle-bottom"></span></button>
										</c:if>
										<div class="dropdown-content">
											<a href="?language=sr">SR <span class="flag"><img
													width="20px" height="15px"
													src="<c:url value="/resources/images/sr_flag.png" />"
													alt="EN"></span></a> 
													
											<a href="?language=en">EN <span
												class="flag"><img width="20px" height="15px"
													src="<c:url value="/resources/images/en_flag.png" />"
													alt="EN"></span></a>

										</div>
									</div> 

								</li>

							</ul>
						</div>
					</nav>
				</div>
			</div>



		</div>



	</div>


	<div class="container">