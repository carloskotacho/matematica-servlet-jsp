<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template>
	<jsp:body>
		<br />
		<div class="row">
			<div class="col s12 texto-form">
				<h5>Pirâmide</h5>
				<p>Em outros termos, a pirâmide é um <b>sólido geométrico</b> de <b>base poligonal</b> que possui todos os vértices num plano (plano da base).
				Sua altura corresponde a distância entre o vértice e sua base.</p>
			</div>
		</div>
		
		<div class="row">
			<div class="col s12 center">
				<img class="img-responsive" src="resources/img/piramide2.png" height="180px">
			</div>
		</div>
		
		<form action="u/piramide" method="POST">
			<div class="row">
				<div class="input-field col s12 m6">
					<input id="altura" type="text" name="altura"/>
					<label for="altura" class="active">Altura</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s12 m6">
					<input id="ladoBase" type="text" name="ladoBase" />
					<label for="ladoBase" class="active">Lado da Base</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s12 m6">
					<input id="apotemaBase" type="text" name="apotemaBase" />
					<label for="apotemaBase" class="active">Apótema da Base</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s12 m6">
					<input id="apotemaPiramide" type="text" name="apotemaPiramide" />
					<label for="apotemaPiramide" class="active">Apótema da Pirâmide</label>
				</div>
			</div>
			
			<div class="row">
				<div class="input-field col s12 m6">
    				<select class="icons" name="tipo-piramide">
		      			<option value="" disabled selected>Escolha a sua opção</option>
				      	<option value="1" data-icon="resources/img/pTriangular.png">Triangular</option>
				      	<option value="2" data-icon="resources/img/pQuadrangular.png">Quadrangular</option>
				      	<option value="3" data-icon="resources/img/pPentagonal.png">Pentagonal</option>
				      	<option value="4" data-icon="resources/img/pHexagonal.png">Hexagonal</option>
    				</select>
    				<label>Tipos de Pirâmide</label>
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
	              <span class="card-title">Fórmulas da Pirâmide</span>
	              <p>Área Base = (Triangular, Quadrangular, Pentagonal, Hexagonal)</p>
	              <p>Área Lateral = nFaces x ((ladoBase x apotemaPiramide) / 2)</p>
	              <p>Área Total = areaLateral + areaBase</p>
	              <p>Volume = (areaBase x altura) / 3</p>
	            </div>
	          </div>
	        </div>
      	</div>
      	
	</jsp:body>
</t:template>