<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container">
	<hr>
	<a href="<c:url value="/admin/projekcija/addProjekcija" />"
		class="btn btn-primary btn-lg"><spring:message
			code="dodajNovuProjekciju" /></a>
	<hr>
	<table class="table table-striped table-hover">
		<thead>
			<tr class="active" style="color: black;">
				<th><spring:message code="film" /></th>
				<th><spring:message code="sala" /></th>
				<th><spring:message code="datum" /></th>
				<th><spring:message code="vreme" /></th>
				<th><spring:message code="slobodnoSedista" /></th>
				<th></th>
			</tr>
			<c:forEach items="${projekcije}" var="projekcija">
				<tr class="info" style="color: black;">
					<td>${projekcija.film.naslov}</td>
					<td>${projekcija.sala.naziv} - ${projekcija.sala.tehnologija}</td>
					<td>${projekcija.datum}</td>
					<td>${projekcija.vreme}</td>
					<td>${projekcija.slobodnoSedista}</td>
					<td><a style="color: black;"
						href="<c:url value="/admin/projekcija/editProjekcija/${projekcija.id}" />"> <span
							class="glyphicon glyphicon-pencil"></span> <spring:message
								code="izmeni" />
					</a> &nbsp &nbsp <a style="color: red;"
						href="<c:url value="/admin/projekcija/deleteProjekcija/${projekcija.id}" />"> <span
							class="glyphicon glyphicon-remove"></span> <spring:message
								code="obrisi" />
					</a></td>
				</tr>
			</c:forEach>
		</thead>
	</table>
</div>


<%@include file="/WEB-INF/views/template/footer.jsp"%>