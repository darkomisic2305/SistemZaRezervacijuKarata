<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container">
	<hr>
	<h1>Projekcija filma: <a href="<c:url value="/film/${projekcija.film.id}" />">${projekcija.film.naslov}</a></h1>
	<h3>Datum: ${projekcija.datum}</h3>
	<h3>Vreme: ${projekcija.vreme}</h3>
	<h3>Sala: ${projekcija.sala.naziv} - ${projekcija.sala.tehnologija}</h3>
	<hr>
	<table class="table table-striped table-hover">
		<thead>
			<tr class="active" style="color: black;">
				<th><spring:message code="imeIPrezime" /></th>
				<th><spring:message code="username" /></th>
				<th><spring:message code="email" /></th>
				<th><spring:message code="brojKarata" /></th>
				<th></th>
			</tr>
			<c:forEach items="${rezervacije}" var="rezervacija">
				<tr class="info" style="color: black;">
					<td>${rezervacija.korisnik.ime} ${rezervacija.korisnik.prezime}</td>
					<td>${rezervacija.korisnik.username}</td>
					<td>${rezervacija.korisnik.email}</td>
					<td>${rezervacija.brojKarata}</td>
					<td><a style="color: red;"
						href="<c:url value="/admin/rezervacija/deleteRezervacija/${rezervacija.id}" />"> <span
							class="glyphicon glyphicon-remove"></span> <spring:message
								code="obrisiRezervaciju" />
					</a></td>
				</tr>
			</c:forEach>
		</thead>
	</table>
</div>


<%@include file="/WEB-INF/views/template/footer.jsp"%>