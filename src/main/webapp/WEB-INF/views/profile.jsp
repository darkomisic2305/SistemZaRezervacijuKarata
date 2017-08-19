<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper cover">
	<div class="container lead" style="text-align: left;">
		<div class="container col-md-12" style="text-align: left;">
			<h1><spring:message code="profil" /></h1>

			<h3><spring:message code="osnovneInformacije" />:</h3>

		</div>


		<div class="container col-md-4">
			<hr>
			<p>
				<strong><spring:message code="ime" /></strong> : ${korisnik.ime}
			</p>
			<p>
				<strong><spring:message code="prezime" /></strong> : ${korisnik.prezime}
			</p>
			<p>
				<strong><spring:message code="datumRodjenja" /></strong> : ${korisnik.datumRodjenja}
			</p>
			<p>
				<strong><spring:message code="pol" /></strong> : ${korisnik.pol}
			</p>
			<p>
				<strong><spring:message code="email" /></strong> : ${korisnik.email}
			</p>
			<p>
				<strong><spring:message code="username" /></strong> : ${korisnik.username}
			</p>
			<hr>
			
			<!-- <a class="btn btn-primary" href="<c:url value="/editProfile/${korisnik.id}" />">Izmeni profil</a> -->
			
			<a class="btn btn-default" href="<c:url value="/" />"><spring:message code="povratakNaPocetnuStranu" /></a>
		</div>
		<div class="container col-md-8">
			<hr>
			<table class="table table-striped table-hover">
				<thead>
					<tr class="info" style="color: black;">
						<th><spring:message code="film" /></th>
						<th><spring:message code="datum" /></th>
						<th><spring:message code="vreme" /></th>
						<th><spring:message code="duzinaTrajanja" /></th>
						<th><spring:message code="tehnologija" /></th>
						<th><spring:message code="brojSedista" /></th>
					</tr>
					<c:forEach items="${rezervacije}" var="rezervacija">
						<tr class="active" style="color: black;">
							<td>${rezervacija.projekcija.film.naslov}</td>
							<td>${rezervacija.projekcija.datum}</td>
							<td>${rezervacija.projekcija.vreme}</td>
							<td>${rezervacija.projekcija.film.duzinaTrajanja}</td>
							<td>${rezervacija.projekcija.sala.tehnologija}</td>
							<td>${rezervacija.brojKarata}</td>
						</tr>
					</c:forEach>
				</thead>
			</table>
			<hr>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp"%>


<!-- 

 -->