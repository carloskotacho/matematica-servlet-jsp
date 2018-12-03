<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template title="OBMEP - Portal Aluno">
	<jsp:body>
		<div class="row">
			<div class="col s12 m6 texto-form">
				<h1>Deletar</h1>
			</div>
		</div>
		<form action="a/deletar" method="POST" onSubmit="Materialize.toast('Deletado com Sucesso!', 4000)">
			<div class="row">
				<div class="input-field col s12 m6">
					<input id="login" type="text" name="login" data-length="64"/>
					<label for="login" class="active">Login do Usuário</label>
				</div>
			</div>
			
			<div class="row">
				<button type="submit" class="waves-effect waves-light btn blue lighten-2 col s12 m6">
					Deletar
				</button>
			</div>
		</form>
	</jsp:body>
</t:template>
