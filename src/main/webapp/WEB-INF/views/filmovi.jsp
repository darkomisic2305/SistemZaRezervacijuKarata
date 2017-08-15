<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container">

	<table class="table table-striped table-hover">
		<thead>
			<tr class="info" style="color: black;">
				<th>Naslov</th>
				<th>Pocetak prikazivanja</th>
				<th>Trajanje</th>
				<th>Zanr</th>
				<th></th>
			</tr>
			<c:forEach items="${filmovi}" var="film">
				<tr class="active" style="color: black;">
					<td>${film.naslov}</td>
					<td>${film.pocetakPrikazivanja}</td>
					<td>${film.duzinaTrajanja}</td>
					<td>${film.zanr}</td>
					<td><a
						href="<c:url value="/film/${film.id}" />">
							<span class="glyphicon glyphicon-info-sign"></span>
					</a></td>
				</tr>
			</c:forEach>
		</thead>
	</table>


<!-- 
	<c:if test="${not empty pageContext.request.userPrincipal}">

		<c:if test="${pageContext.request.isUserInRole('ROLE_ADMIN')}">

        ADMIN ROLA

    </c:if>
		<c:if test="${pageContext.request.isUserInRole('ROLE_USER')}">

        USER ROLA

    </c:if>
	</c:if>
 -->
</div>


<%@include file="/WEB-INF/views/template/footer.jsp"%>


<!-- 
<div class="inner cover">
	<h1 class="cover-heading">Cover your page.</h1>
	<p class="lead">Cover is a one-page template for building simple
		and beautiful home pages. Download, edit the text, and add your own
		fullscreen background photo to make it your own.</p>
	<p class="lead">
		<a href="#" class="btn btn-lg btn-default">Learn more</a>
	</p>
</div>
 -->