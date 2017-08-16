<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="">
	<div class="container register-container">
		<form:form name="registerForm" action="${pageContext.request.contextPath}/register"
			method="post" commandName="korisnik">
			<h1><spring:message code="registracija" /></h1>
			<hr>
			<div class="form-group">
				<label for="ime"><spring:message code="ime" /></label> <form:errors path="ime" cssStyle="color: #ff0000" />
				<form:input type="text" path="ime" id="ime" class="form-control" autofocus="autofocus"/>
			</div>
			
			<div class="form-group">
				<label for="prezime"><spring:message code="prezime" /></label> <form:errors path="prezime" cssStyle="color: #ff0000" />
				<form:input path="prezime" id="prezime" class="form-control" />
			</div>
			
			<div class="form-group">
				<label for="datumRodjenja"><spring:message code="datumRodjenja" /></label> <form:errors path="datumRodjenja" cssStyle="color: #ff0000" />
				<form:input type="date" path="datumRodjenja" id="datumRodjenja" class="form-control" />
			</div>
			
			<!-- <div class="form-group">
				<label for="pol"><spring:message code="pol" /></label> <form:errors path="pol" cssStyle="color: #ff0000" />
				<form:select path="pol" id="pol" class="form-control">
					<form:option value="" />
					<form:options items="${polovi}"/>
				</form:select>
			</div> -->
			<div class="form-group">
				<label for="pol"><spring:message code="pol" /></label> <form:errors path="pol" cssStyle="color: #ff0000" />
				<br>
				<input type="radio" name="pol" value="<spring:message code="muski" />"> <spring:message code="muski" /></input>&nbsp&nbsp
				<input type="radio" name="pol" value="<spring:message code="zenski" />"><spring:message code="zenski" /></input>
			</div>
			<div class="form-group">
				<label for="email"><spring:message code="email" /></label> <span style="color: #ff0000">${emailMsg}</span> <form:errors path="email" cssStyle="color: #ff0000" />
				<form:input type="email" path="email" id="email" class="form-control" />
			</div>
			
			<div class="form-group">
				<label for="username"><spring:message code="username" /></label> <span style="color: #ff0000">${usernameMsg}</span> <form:errors path="username" cssStyle="color: #ff0000" /> 
				<form:input path="username" id="username" class="form-control" />
			</div>

			<div class="form-group">
				<label for="password"><spring:message code="password" /></label> <form:errors path="password" cssStyle="color: #ff0000" />
				<form:input type="password" path="password" id="password" class="form-control" />
			</div>

			<input type="submit" value="<spring:message code="registrujSe" />" class="btn btn-primary">
			<a href="<c:url value="/"/>"
				class="btn btn-default"><spring:message code="odustani" /></a>
		</form:form>
	</div>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp"%>