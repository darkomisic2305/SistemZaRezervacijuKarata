<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="">
	<div class="container login-container">
		<form:form name="editProjekcijaForm" action="${pageContext.request.contextPath}/admin/projekcija/editProjekcija"
			method="post" commandName="projekcija">
			<form:hidden path="id" value="${projekcija.id}"/>
			<h1><spring:message code="izmenaProjekcije" /></h1>
			<hr>
			<div class="form-group">
				<label for="film"><spring:message code="film" /></label> <form:errors path="film" cssStyle="color: #ff0000" />
				<form:select path="film" id="filmSlc" class="form-control">
					<form:option value="" label="${projekcija.film.naslov}"></form:option>
					<form:options items="${filmovi}" itemValue="id" itemLabel="naslov" />
				</form:select>
			</div>
			<div class="form-group">
				<label for="sala"><spring:message code="sala" /></label> <form:errors path="sala" cssStyle="color: #ff0000" />
				<form:select path="sala" id="salaSlc" class="form-control">
					<form:option value=""><spring:message code="izaberiSalu" /></form:option>
					<form:options items="${sale}" itemLabel="naziv" itemValue="id" />
				</form:select>
			</div>
			<div class="form-group">
				<label for="datum"><spring:message code="datum" /></label> <form:errors path="datum" cssStyle="color: #ff0000" />
				<form:input type="date" pattern="dd.MM.yyyy." path="datum" id="datum" class="form-control" />
			</div>		
			<div class="form-group">
				<label for="vreme"><spring:message code="vreme" /></label> <form:errors path="vreme" cssStyle="color: #ff0000" />
				<form:input type="text" path="vreme" id="vreme" class="form-control" />
			</div>	
			<hr>
			<input type="submit" value="<spring:message code="izmeniProjekciju" />"  class="btn btn-primary">
			<a href="<c:url value="/admin/projekcija/sveProjekcije"/>"
				class="btn btn-default"><spring:message code="odustani" /></a>
		</form:form>
	</div>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp"%>