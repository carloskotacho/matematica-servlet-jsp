<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template>
	<jsp:body>
		<br/>
		<div class="row">
			<div class="col s6 texto-index-usuario">
				<h5>Portal do Aluno</h5>
				<h6>Bem Vindo, <b>${ cookie.usuarioCorrente.value }!</b></h6>
				<h6>${ dataAtual }</h6>
			</div>
		</div>
      	
      	<div class="row">
	       <div class="col s12 m4">
	          <div class="card">
	            <div class="card-image">
	              <img src="resources/img/geometria.png">
	              <span class="card-title grey darken-2">Geometria</span>
	            </div>
	            <div class="card-content">
	              <p>A Geometria Espacial estuda os objetos que possuem mais de uma dimensão e ocupam lugar no espaço.</p>
	            </div>
	            <div class="card-action">
	              <a href="u/espacial">Geometria espacial</a>
	            </div>
	          </div>
	        </div>
      </div>
      
	</jsp:body>
</t:template>