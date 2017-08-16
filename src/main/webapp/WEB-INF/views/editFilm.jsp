<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="">
	<div class="container add-film-container">
		<form:form name="editFilmForm" action="${pageContext.request.contextPath}/admin/film/editFilm"
			method="post" commandName="film" enctype="multipart/form-data">
			<form:hidden path="id" value="${film.id}"/>
			<h1><spring:message code="izmenaFilma" /></h1>
			<hr>
			<div class="form-group">
				<label for="naslov"><spring:message code="naslov" /></label> <form:errors path="naslov" cssStyle="color: #ff0000" />
				<form:input type="text" path="naslov" id="naslov" class="form-control" autofocus="autofocus"/>
			</div>
			
			<div class="form-group">
				<label for="originalniNaslov"><spring:message code="originalniNaslov" /></label> <form:errors path="originalniNaslov" cssStyle="color: #ff0000" />
				<form:input path="originalniNaslov" id="originalniNaslov" class="form-control" />
			</div>
			
			<div class="form-group">
				<label for="pocetakPrikazivanja"><spring:message code="pocetakPrikazivanja" /></label> <form:errors path="pocetakPrikazivanja" cssStyle="color: #ff0000" />
				<form:input type="date" path="pocetakPrikazivanja" id="pocetakPrikazivanja" class="form-control" />
			</div>


			<div class="form-group">
				<label for="duzinaTrajanja"><spring:message code="duzinaTrajanja" /></label> <span style="color: #ff0000">${duzinaTrajanjaMsg}</span> <form:errors path="duzinaTrajanja" cssStyle="color: #ff0000" /> 
				<form:input type="number" path="duzinaTrajanja" id="duzinaTrajanja" class="form-control" />
			</div>
			
			<div class="form-group">
				<label for="godina"><spring:message code="godina" /></label> <form:errors path="godina" cssStyle="color: #ff0000" />
				<form:input type="number" path="godina" id="godina" class="form-control"/>
			</div>
			
			<div class="form-group">
				<label for="drzava"><spring:message code="drzava" /></label> <form:errors path="drzava" cssStyle="color: #ff0000" />
				<form:input type="text" path="drzava" id="drzava" class="form-control"/>
			</div>

			<div class="form-group">
				<label for="opis"><spring:message code="opis" /></label> <form:errors path="opis" cssStyle="color: #ff0000" />
				<form:textarea type="text" path="opis" id="opis" class="form-control"/>
			</div>
			<div class="form-group">
				<label for="youtubeUrl"><spring:message code="youtubeUrl" /></label> <form:errors path="youtubeUrl" cssStyle="color: #ff0000" />
				<form:input type="text" path="youtubeUrl" id="youtubeUrl" class="form-control"/>
			</div>
			<hr>
			<div class="form-group">
				<label class="control-label" for="slika"><spring:message code="dodajSliku" /></label>
				<form:input id="slika" path="slika" type="file" class="input-large" style="display: center"/>
			</div>
			
			<hr>
			<input type="submit" value="<spring:message code="izmeni" />" class="btn btn-primary">
			<a href="<c:url value="/"/>"
				class="btn btn-default"><spring:message code="odustani" /></a>
		</form:form>
	</div>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp"%>