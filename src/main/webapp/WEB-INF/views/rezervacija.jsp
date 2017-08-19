<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="">
	<div class="container register-container">
		<form:form name="rezervacijaForm" action="${pageContext.request.contextPath}/rezervacija/${rezervacija.projekcija.id}"
			method="post" commandName="rezervacija">
			<h1><spring:message code="rezervacijaKarata" /></h1>
			<h2>Film: <a href="<c:url value="/film/${rezervacija.projekcija.film.id}" />">${rezervacija.projekcija.film.naslov}</a></h2>
			<h3>Datum projekcije: ${rezervacija.projekcija.datum}</h3>
			<h3>Vreme: ${rezervacija.projekcija.vreme}</h3>
			<h3>Sala: ${rezervacija.projekcija.sala.naziv} - ${rezervacija.projekcija.sala.tehnologija}</h3>
			<hr>
			
			<div class="form-group">
				<label for="brojKarata"><spring:message code="brojKarata" /></label> <span style="color: #ff0000">${nemaMestaMsg}</span> <form:errors path="brojKarata" cssStyle="color: #ff0000" /> 
				<form:input type="number" path="brojKarata" id="brojKarata" min="0" max="5" class="form-control" />
			</div>			
			
			
			<hr>
			<input type="submit" value="<spring:message code="izvrsiRezervaciju" />"  class="btn btn-primary">
			<a href="<c:url value="/film/${rezervacija.projekcija.film.id}"/>"
				class="btn btn-default"><spring:message code="odustani" /></a>
		</form:form>
	</div>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp"%>