<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template>
	<jsp:body>
		<br />
		<div class="row">
			<div class="col s12 texto-form">
				<h5>Cilindro</h5>
				<p>O <b>cilindro</b> ou <b>cilindro circular</b> é um sólido geométrico alongado e arredondado que possui o mesmo diâmetro ao longo de todo o comprimento.</p>
			</div>
		</div>
		
		<div class="row">
			<div class="col s12 center">
				<img class="img-responsive" src="resources/img/cilindro2.png" height="200px">
			</div>
		</div>
		
		<form action="u/cilindro" method="POST">
			<div class="row">
				<div class="input-field col s12 m6">
					<input id="raio" type="text" name="raio"/>
					<label for="raio" class="active">Raio</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s12 m6">
					<input id="altura" type="text" name="altura" />
					<label for="altura" class="active">Altura</label>
				</div>
			</div>
			<div class="row">
				<button type="submit" class="waves-effect waves-light btn blue lighten-2 col s12 m6">
					Calcular
				</button>
			</div>
		</form>
		
		<br/><br/>
      	<div class="row">
	        <div class="col s12 m6">
	          <div class="card pink accent-2">
	            <div class="card-content white-text">
	              <span class="card-title">Fórmulas do Cilindro</span>
	              <p>Área Base = PI x raio x raio</p>
	              <p>Área Lateral = 2 x PI x raio x altura</p>
	              <p>Área Total = (2 x areaBase) + areaLateral</p>
	              <p>Volume = solido.areaBase x altura</p>
	            </div>
	          </div>
	        </div>
      	</div>
      	
	</jsp:body>
</t:template>