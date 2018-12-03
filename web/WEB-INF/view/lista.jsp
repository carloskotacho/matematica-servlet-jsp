<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:template>
	<jsp:body>
		<br />
		<div class="row">
			<div class="col s12 texto-form">
				<h4>Lista</h4>
      			<h5>Usuários</h5>
      		
      			<c:if test="${ empty listaUsuarios }">
      				<p class="texto-form">Não há usuários cadastrados!</p>
      			</c:if>
      	
		      	<c:if test="${ not empty listaUsuarios }">
		      		<div class="row">
		      			<div class="col s12">
					    	<table class="responsive-table texto-form">
					        	<thead>
					          		<tr>
					              		<th>Login</th>
					              		<th>Senha</th>
					          		</tr>
					        	</thead>
							
					        	<tbody>
					        		<c:forEach var="bean" items="${ listaUsuarios }" varStatus="status">
				        				<tr>
				        					<td> ${ bean.login } </td>
				        					<td> ${ bean.pwd   } </td>
				        				</tr>
				        			</c:forEach>
					        	</tbody>
					      	</table>
						</div>
			      	</div>
		      	</c:if>
      		</div>
      	</div>
      	
      	<div class="row">
      		<div class="col s12 texto-form">
	      	<h5>Roles</h5>
		      	<c:if test="${ empty listaRoles }">
		      		<p>Não há Roles cadastrados!</p>
		      	</c:if>
		      
		      	<c:if test="${ not empty listaRoles }">
			    	<table class="responsive-table texto-form">
			        	<thead>
			          		<tr>
			            		<th>Login</th>
			              		<th>Role</th>
			          		</tr>
			        	</thead>
					
			        	<tbody>
			        		<c:forEach var="bean" items="${ listaRoles }" varStatus="status">
		        				<tr>
		        					<td> ${ bean.login } </td>
		        					<td> ${ bean.role  } </td>
		        				</tr>
		        			</c:forEach>
			        	</tbody>
			      	</table>
		      	</c:if>
	      	</div>
		</div>
	</jsp:body>
</t:template>