<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container">

	<table class="table table-striped table-hover">
		<thead>
			<tr class="active" style="color: black;">
				<th><spring:message code="ime" /></th>
				<th><spring:message code="prezime" /></th>
				<th><spring:message code="username" /></th>
				<th><spring:message code="email" /></th>
				<th><spring:message code="pol" /></th>
				<th><spring:message code="datumRodjenja" /></th>
				<th></th>
			</tr>
			<c:forEach items="${korisnici}" var="korisnik">
				<tr class="info" style="color: black;">
					<td>${korisnik.ime}</td>
					<td>${korisnik.prezime}</td>
					<td>${korisnik.username}</td>
					<td>${korisnik.email}</td>
					<td>${korisnik.pol}</td>
					<td>${korisnik.datumRodjenja}</td>
					<td><a style="color: red;"
						href="<c:url value="/admin/korisnik/deleteKorisnik/${korisnik.username}" />"> <span
							class="glyphicon glyphicon-remove"></span> <spring:message code="obrisi" />
					</a></td>
				</tr>
			</c:forEach>
		</thead>
	</table>
</div>


<%@include file="/WEB-INF/views/template/footer.jsp"%>