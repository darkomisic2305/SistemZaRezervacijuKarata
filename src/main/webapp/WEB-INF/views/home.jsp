<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container" >

	<c:forEach items="${filmovi}" var="film">
		<div style="display: inline-block; text-align: center;">
			<div style="padding: 10px;">
				<a href="<c:url value="/film/${film.id}" />" style="text-align: center; color: #eeeeee;">
					<img src="<c:url value="/resources/images/${film.id}.png" />" width="223px" height="324px">
					<h4>${film.naslov}</h4>
				</a>
			</div>			
		</div>
	
	</c:forEach>



	<c:if test="${not empty pageContext.request.userPrincipal}">

		<c:if test="${pageContext.request.isUserInRole('ROLE_ADMIN')}">

        ADMIN ROLA

    </c:if>
		<c:if test="${pageContext.request.isUserInRole('ROLE_USER')}">

        USER ROLA

    </c:if>
	</c:if>
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