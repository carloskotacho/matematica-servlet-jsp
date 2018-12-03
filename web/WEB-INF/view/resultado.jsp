<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:template>
	<jsp:body>
		<br />
		<div class="row">
			<div class="col s12 texto-form">
				<h5>Resultado</h5>
				<p><strong>Sólido: </strong>${ bean.nome } </p>
			</div>
		</div>
		
		<div class="row">
	      <div class="col s12 m3">
	        <div class="card-panel blue lighten-2 white-text">
				<c:forEach items="${ parameterMap }" var="entry">
					<p><strong>${ entry.key }:
					<c:forEach items="${ entry.value }" var="item" varStatus="loop">
					 	${ item }</strong></p>
					 </c:forEach>
				</c:forEach>
	        </div>
	      </div>
	    </div>
		
		<div class="row">
			<table class="responsive-table striped texto-form">
				<thead>
					<tr>
						<th>Área Base</th>
						<th>Área Lateral</th>
						<th>Área Total</th>
						<th>Volume</th>
					</tr>
				</thead>
				
				<tbody>
					<tr>
						<td>${ bean.areaBase }</td>
						<td>${ bean.areaLateral }</td>
						<td>${ bean.areaTotal }</td>
						<td>${ bean.volume }</td>
					</tr>
				</tbody>
			</table>
		</div>
		
	</jsp:body>
</t:template>