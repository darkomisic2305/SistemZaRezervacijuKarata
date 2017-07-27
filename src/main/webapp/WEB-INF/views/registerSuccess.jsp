<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="">
	<div class="container register-success-container">

		<h1>Cestitamo! Uspesno ste izvrsili registraciju.</h1>
		<h1>
			<a class="btn btn-primary" href="<c:url value="/login" />">Login</a>
		</h1>
		<h1>
			<a class="btn btn-default" href="<c:url value="/" />">Vrati se na
				pocetnu stranu</a>
		</h1>
	</div>
</div>

<%@include file="/WEB-INF/views/template/footer.jsp"%>