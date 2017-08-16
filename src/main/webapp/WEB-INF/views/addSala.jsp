<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="">
	<div class="container login-container">
		<form:form name="addSalaForm" action="${pageContext.request.contextPath}/admin/sala/addSala"
			method="post" commandName="sala">
			<h1><spring:message code="dodavanjeSale" /></h1>
			<hr>
			<div class="form-group">
				<label for="naziv"><spring:message code="nazivSale" /></label> <form:errors path="naziv" cssStyle="color: #ff0000" />
				<form:input type="text" path="naziv" id="naziv" class="form-control" autofocus="autofocus"/>
			</div>
			<div class="form-group">
				<label for="brojSedista"><spring:message code="brojSedista" /></label> <form:errors path="brojSedista" cssStyle="color: #ff0000" /> 
				<form:input type="number" path="brojSedista" id="brojSedista" min="0" class="form-control" />
			</div>			
			<!-- <div class="form-group">
				<label for="tehnologija"><spring:message code="tehnologija" /></label> <form:errors path="tehnologija" cssStyle="color: #ff0000" />
				<form:input type="text" path="tehnologija" id="tehnologija" class="form-control"/>
			</div> -->
			<div class="form-group">
				<label for="tehnologija"><spring:message code="tehnologija" /></label> <form:errors path="tehnologija" cssStyle="color: #ff0000" />
				<br>
				<input type="radio" name="tehnologija" value="2D"> 2D</input><br>
				<input type="radio" name="tehnologija" value="3D"> 3D</input>

			</div>
			
			<hr>
			<input type="submit" value="<spring:message code="dodajSalu" />"  class="btn btn-primary">
			<a href="<c:url value="/admin/sala/sveSale"/>"
				class="btn btn-default"><spring:message code="odustani" /></a>
		</form:form>
	</div>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp"%>