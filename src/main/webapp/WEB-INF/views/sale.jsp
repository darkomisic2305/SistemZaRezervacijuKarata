<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container">
	<hr>
	<a href="<c:url value="/admin/sala/addSala" />"
		class="btn btn-primary btn-lg"><spring:message
			code="dodajNovuSalu" /></a>
	<hr>
	<table class="table table-striped table-hover">
		<thead>
			<tr class="active" style="color: black;">
				<th><spring:message code="nazivSale" /></th>
				<th><spring:message code="brojSedista" /></th>
				<th><spring:message code="tehnologija" /></th>
				<th></th>
			</tr>
			<c:forEach items="${sale}" var="sala">
				<tr class="info" style="color: black;">
					<td>${sala.naziv}</td>
					<td>${sala.brojSedista}</td>
					<td>${sala.tehnologija}</td>
					<td><a style="color: black;"
						href="<c:url value="/admin/sala/editSala/${sala.id}" />"> <span
							class="glyphicon glyphicon-pencil"></span> <spring:message
								code="izmeni" />
					</a> &nbsp &nbsp <a style="color: red;"
						href="<c:url value="/admin/sala/deleteSala/${sala.id}" />"> <span
							class="glyphicon glyphicon-remove"></span> <spring:message
								code="obrisi" />
					</a></td>
				</tr>
			</c:forEach>
		</thead>
	</table>
</div>


<%@include file="/WEB-INF/views/template/footer.jsp"%>