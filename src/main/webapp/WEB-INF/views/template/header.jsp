<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="<c:url value="/resources/images/favicon.ico" />">

<title>Rezervacija bioskopskih karata</title>

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
	<script type="text/javascript" src="<c:url value="/resources/js/main.js" />"></script>
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
						<a class="navbar-brand" href="#">Cinema Reservation System</a>
					</div>
					
					<nav class=""> <!-- navbar -->
						<div id="navbar" class="navbar-collapse collapse">
							<ul class="nav masthead-nav pull-left">
								<li class="active"><a href="<c:url value="/"/>">Home</a></li>
								<li><a href="<c:url value="/login"/>">Movies</a></li>

							</ul>
							<ul class="nav masthead-nav">
								<c:if test="${pageContext.request.userPrincipal.name != null}">
									<li><a>Welcome:
											${pageContext.request.userPrincipal.name}</a></li>
									<c:if
										test="${pageContext.request.userPrincipal.name != 'admin'}">

									</c:if>
									<c:if
										test="${pageContext.request.userPrincipal.name == 'admin'}">
										<li><a href="<c:url value="/admin" />">Admin</a></li>
									</c:if>
									<li><a href="<c:url value="/j_spring_security_logout" />">Logout</a></li>
								</c:if>
								<c:if test="${pageContext.request.userPrincipal.name == null}">
									<li><a href="<c:url value="/login" />">Login</a></li>
									<li><a href="<c:url value="/register" />">Register</a></li>
								</c:if>
							</ul>
						</div>
					</nav>
				</div>
			</div>



		</div>



	</div>


	<div class="cover-container">