<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="">
	<div class="container register-success-container">

		<h1><spring:message code="uspesnaRezervacija" /></h1>
		<p><spring:message code="emailPotvrda" /></p>
		<h1>
			<a class="btn btn-default" href="<c:url value="/" />"><spring:message code="pocetnaStrana" /></a>
		</h1>
	</div>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp"%>