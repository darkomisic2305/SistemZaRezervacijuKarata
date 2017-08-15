<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>
<div class="col-md-12">
	<h1>${film.naslov}</h1>
	<iframe width="65%" height="400" src="${film.youtubeUrl}" frameborder="1" allowfullscreen></iframe>
	<br>
	<br>
</div>
<br><br>
<div class="row">
	<div class="col-md-2">
	</div>
	<div class="col-md-3">
		<img src="<c:url value="/resources/images/${film.id}.png" />" width="223px" height="324px">
	</div>
	<div class="col-md-5">
		<div class="row">
			
			<div class="col-md-11">
				<p align="justify">${film.opis}</p>
				<hr>
			</div>
			
		</div>
		<div class="row">
			<div class="col-md-3">
				<p align="right"><strong>Originalni naslov:</strong>
			</div>
			<div class="col-md-7">
				<p align="justify">${film.originalniNaslov}</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<p align="right"><strong>Pocetak prikazivanja:</strong>
			</div>
			<div class="col-md-7">
				<p align="justify">${film.pocetakPrikazivanja}</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<p align="right"><strong>Trajanje:</strong>
			</div>
			<div class="col-md-7">
				<p align="left">${film.duzinaTrajanja} min.</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<p align="right"><strong>Drzava/Godina:</strong></p>
			</div>
			<div class="col-md-7">
				<p align="left">${film.drzava}/${film.godina}.</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3">
				<p align="right"><strong>Zanr:</strong></p>
			</div>
			<div class="col-md-7">
				<p align="left">${film.zanr}</p>
			</div>
		</div>
	</div>

</div>
<div class="row">
	<div class="col-md-2">
	</div>
	<div class="col-md-8">
	<hr>
		<h3>Dostupne projekcije:</h3>
		<p>(Kliknite na projekciju za rezervaciju sedista)</p>
	
		<div style="margin-left: 50px; margin-right: 50px;">
			<c:forEach items="${projekcije}" var="projekcija">
				<a href="<c:url value="/" />" class="btn btn-primary" style="margin: 10px;">
					<p>${projekcija.datumVreme}, ${projekcija.sala.naziv}</p>
				</a>
			</c:forEach>
		</div>
	</div>
</div>
<%@include file="/WEB-INF/views/template/footer.jsp"%>

	<!-- {% for projekcija in projekcije %}
		<a href="{% url 'rezervacije:projekcija' projekcija.id %}" class="btn btn-primary" >
			<p>${projekcija.datum}, ${projekcija.vreme}, ${projekcija.tip}</p>
		</a>
	{% endfor %}
	<br><br><br>
	<a href="{% url 'rezervacije:filmovi'%}" class="btn btn-default">Povratak na spisak filmova</button> -->

