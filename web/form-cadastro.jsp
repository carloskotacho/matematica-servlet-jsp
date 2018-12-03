<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template title="OBMEP - Portal Aluno">
	<jsp:body>
		<div class="row">
			<div class="col s12 m6 texto-form">
				<h1>Cadastro</h1>
			</div>
		</div>
		<form action="cadastro" method="POST" onSubmit="Materialize.toast('Cadastrado com sucesso!', 4000)">
			<div class="row">
				<div class="input-field col s12 m6">
					<input id="username" type="text" name="login" data-length="64"/>
					<label for="username" class="active">Usuário</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s12 m6">
					<input id="password" type="password" name="pwd" data-length="64" />
					<label for="password" class="active">Senha</label>
				</div>
			</div>
			
			<c:if test="${ isAdministrador }">
				<div class="row">
					<div class="input-field col s12 m6">
	    				<select class="icons" name="tRole">
			      			<option value="" disabled selected>Escolha o tipo de Usuário</option>
					      	<option value="ADMINISTRADOR" data-icon="resources/img/admin.png">Administrador</option>
					      	<option value="USUARIO" data-icon="resources/img/usuario.png">Usuário</option>
	    				</select>
	    				<label>Tipos de Usuários</label>
	    			</div>
	  			</div>
  			</c:if>
			
			<div class="row">
				<button type="submit" class="waves-effect waves-light btn blue lighten-2 col s12 m6">
					Cadastrar
				</button>
			</div>
		</form>
	</jsp:body>
</t:template>
