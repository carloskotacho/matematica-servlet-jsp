<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template title="OBMEP - Portal Aluno">
	<jsp:body>
		<div class="row">
			<div class="col s12 m6 texto-form">
				<h1>Login</h1>
			</div>
		</div>
		<form class="" action="login" method="POST">
			<div class="row">
				<div class="input-field col s12 m6">
					<input id="username" type="text" name="login" value="${ cookie.login.value }"/>
					<label for="username" class="active">Usuário</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s12 m6">
					<input id="password" type="password" name="pwd" value=""/>
					<label for="password" class="active">Senha</label>
				</div>
			</div>
			<div class="row">
				<button type="submit" class="waves-effect waves-light btn blue lighten-2 col s12 m6">
					Entrar
				</button>
			</div>
		</form>
		
	</jsp:body>
</t:template>
