<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:template>
	<jsp:body>
		<br />
		<div class="row">
			<div class="col s12 texto-form">
				<h5>Administração</h5>
				<p>Bem Vindo, ${ cookie.usuarioCorrente.value }!</p>
				<p>${ dataAtual }</p>
			</div>
		</div>
		
		<div class="row">
            <div class="col s12 texto-espacial">
                <a class="waves-effect waves-light btn blue lighten-2" href="a/aux">Minhas credenciais</a>
            </div>
        </div>
		
		<div class="row">
			<div class="col s12 center">
				<img class="img-responsive" src="resources/img/admin2.png" height="250px">
			</div>
		</div>

	</jsp:body>
</t:template>