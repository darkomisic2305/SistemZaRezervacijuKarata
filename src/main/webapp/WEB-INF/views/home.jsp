<%@include file="/WEB-INF/views/template/header.jsp"%>
<c:if test="${pageContext.request.isUserInRole('ROLE_ADMIN')}">
	<hr>
	<a href="<c:url value="/admin/film/addFilm" />" class="btn btn-primary btn-lg"><spring:message code="dodajNoviFilm"/></a>
	<hr>
</c:if>
<div class="container" >
	
	<c:forEach items="${filmovi}" var="film">
		<div style="display: inline-block; text-align: center;">
			<div style="padding: 10px;">
				<a href="<c:url value="/film/${film.id}" />" style="text-align: center; color: #eeeeee;">
					<img src="<c:url value="/resources/images/${film.id}.png" />" class = "film-img">
					<h4>${film.naslov}</h4>
					<c:if test="${pageContext.request.isUserInRole('ROLE_ADMIN')}">
						<a href="<c:url value="/admin/film/editFilm/${film.id}" />" class="btn btn-default"><spring:message code="izmeni"/></a>
						<a href="<c:url value="/admin/film/deleteFilm/${film.id}" />" class="btn btn-danger"><spring:message code="obrisi"/></a>
					</c:if>
				</a>
				
			</div>		
			
		</div>
	</c:forEach>
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