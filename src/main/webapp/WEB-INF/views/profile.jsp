<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper cover">
	<div class="container lead" style="text-align: left;">
		<div class="container col-md-12" style="text-align: left;">
			<h1>Profil</h1>

			<h3>Osnovne infromacije:</h3>

		</div>


		<div class="container col-md-4">
			<hr>
			<p>
				<strong>Ime</strong> : ${korisnik.ime}
			</p>
			<p>
				<strong>Prezime</strong> : ${korisnik.prezime}
			</p>
			<p>
				<strong>Datum rodjenja</strong> : ${korisnik.datumRodjenja}
			</p>
			<p>
				<strong>Pol</strong> : ${korisnik.pol}
			</p>
			<p>
				<strong>Email</strong> : ${korisnik.email}
			</p>
			<p>
				<strong>Username</strong> : ${korisnik.username}
			</p>
			<hr>
			
			<a class="btn btn-primary" href="<c:url value="/editProfile/${korisnik.id}" />">Izmeni profil</a>
			
			<a class="btn btn-default" href="<c:url value="/" />">Povratak na pocetnu stranu</a>
		</div>
		<div class="container col-md-8">
			<hr>
			<table class="table table-striped table-hover">
				<thead>
					<tr class="info" style="color: black;">
						<th>Film</th>
						<th>Datum i vreme</th>
						<th>Trajanje</th>
						<th>Tehnologija</th>
						<th>Broj sedista</th>
						<th></th>
					</tr>
					<c:forEach items="${rezervacije}" var="rezervacija">
						<tr class="active" style="color: black;">
							<td>${rezervacija.projekcija.film.naslov}</td>
							<td>${rezervacija.projekcija.datumVreme}</td>
							<td>${rezervacija.projekcija.film.duzinaTrajanja}</td>
							<td>${rezervacija.projekcija.sala.tehnologija}</td>
							<td>${rezervacija.brojKarata}</td>
							<td><a href="<c:url value="/projekcija/${rezervacija.projekcija.id}" />">
									<span class="glyphicon glyphicon-info-sign"></span>
							</a></td>
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