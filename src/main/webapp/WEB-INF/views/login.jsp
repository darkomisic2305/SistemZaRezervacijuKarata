<%@include file="/WEB-INF/views/template/header.jsp"%>


<div class="container-wrapper">
	<div class="container login-container">
		<div id="login-box">
			<h2><spring:message code="loginTekst" /></h2>
			<hr>
			<c:if test="${not empty msg}">
				<div class="msg">${msg}</div>
				<br>
			</c:if>
			
			<form name="loginForm" action="<c:url value="/j_spring_security_check" />" method="post">
				<c:if test="${not empty error}">
					<div class="error" style="color: #ff0000;">${error}</div>
				</c:if>
				<div class="form-group">
					<label for="username"><spring:message code="username" />: </label>
					<input type="text" id="username" name="username" class="form-control" />
				</div>
				<div class="form-group">
					<label for="password"><spring:message code="password" />: </label>
					<input type="password" id="password" name="password" class="form-control" />
				</div>
				
				<input type="submit" value="<spring:message code="login" />" class="btn btn-lg btn-primary" />
				
				<br><hr>
				<p><spring:message code="nemateNalog" /><strong> <a class="register-link" href="<c:url value="/register" />"><spring:message code="registrujteSe" />.</a></strong></p>
				
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
		</div>
	</div>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp"%>