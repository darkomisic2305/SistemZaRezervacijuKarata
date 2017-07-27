<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="">
	<div class="container register-container">
		<form:form name="registerForm" action="${pageContext.request.contextPath}/register"
			method="post" commandName="korisnik">
			<h1>Registracija</h1>
			<hr>
			<div class="form-group">
				<label for="ime">Ime</label> <form:errors path="ime" cssStyle="color: #ff0000" />
				<form:input type="text" path="ime" id="ime" class="form-control"/>
			</div>
			
			<div class="form-group">
				<label for="prezime">Prezime</label> <form:errors path="prezime" cssStyle="color: #ff0000" />
				<form:input path="prezime" id="prezime" class="form-control" />
			</div>
			
			<div class="form-group">
				<label for="datumRodjenja">Datum rodjenja</label> <form:errors path="datumRodjenja" cssStyle="color: #ff0000" />
				<form:input type="date" path="datumRodjenja" id="datumRodjenja" class="form-control" />
			</div>
			
			<div class="form-group">
				<label for="email">Email</label> <span style="color: #ff0000">${emailMsg}</span> <form:errors path="email" cssStyle="color: #ff0000" />
				<form:input type="email" path="email" id="email" class="form-control" />
			</div>
			
			<div class="form-group">
				<label for="username">Username</label> <span style="color: #ff0000">${usernameMsg}</span> <form:errors path="username" cssStyle="color: #ff0000" /> 
				<form:input path="username" id="username" class="form-control" />
			</div>

			<div class="form-group">
				<label for="password">Password</label> <form:errors path="password" cssStyle="color: #ff0000" />
				<form:input type="password" path="password" id="password" class="form-control" />
			</div>

			<br>

			<input type="submit" value="Registruj se" class="btn btn-primary">
			<a href="<c:url value="/"/>"
				class="btn btn-default">Odustani</a>
		</form:form>
	</div>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp"%>