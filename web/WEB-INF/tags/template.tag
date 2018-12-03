
<%@tag description="Template principal" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="title"%>
<%@attribute name="estaLogado"%>

<html>
<head>
<title>${title}</title>
<base href="${pageContext.request.contextPath}/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<!-- <meta name="viewport" content="width=device-width, initial-scale=1" /> -->
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<link rel="icon" type="image/png" href="favicon.png" />

<!-- CSS -->
<link type="text/css" rel="stylesheet" href="resources/css/materialize.min.css"  media="screen,projection"/>


<link rel="stylesheet" href="resources/css/cssLayout.css"></link>
<link rel="stylesheet" href="resources/css/materialize.css"></link>
<link rel="stylesheet" href="resources/css/common.css"></link>
<link rel="stylesheet" href="resources/css/template.css"></link>
<link rel="stylesheet" href="resources/lib/font-awesome/css/font-awesome.min.css"></link>


<!--Import Google Icon Font-->
<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet"></link>
<link href='http://fonts.googleapis.com/css?family=Roboto:200,700'
	rel='stylesheet' type='text/css'></link>
	
</head>
<body>
	<header>
		<div class="navbar-fixed" style="z-index: 999">
			<nav>
				<div class="nav-wrapper light-green accent-4">
					<div class="container">
						<a class="brand-logo" href="/matematica"> <img class="utf-logo"
							src="resources/img/logowhite.png"></img>
						</a> <a href="#" data-activates="mobile-demo" class="button-collapse"><i
							class="material-icons">menu</i></a>
						<ul class="right hide-on-med-and-down">
							
							<c:if test="${ isAdministrador }">
								<li><a href="u">Área de Trabalho (Usuário)</a></li>
								<li><a href="a">Área de Trabalho (Admin)</a></li>
								<li><a href="a/lista">Lista de Usuários</a></li>	
								<li><a href="a/deletar">Deletar Usuários</a></li>
							</c:if>
							<c:if test="${ isAdministrador or not isAdministrador and not estaLogado }">
								<li><a href="cadastro">Criar conta</a></li>	
							</c:if>		
							<li><a href="/matematica">Início</a></li>		
							<c:if test="${ estaLogado }">
								<li><a href="logout">Sair</a></li>
							</c:if>							
							
						</ul>
						<ul class="side-nav white" id="mobile-demo">
							<div class="row">
								<div class="col s8 offset-s2">
									<div class="center">
										<img class="responsive-img utf-logo-nav"
											src="resources/img/logo.png" />
									</div>
								</div>
							</div>

							
							<c:if test="${ isAdministrador }">
								<li><a href="u">Área de Trabalho (Usuário)</a></li>
								<li><a href="a">Área de Trabalho (Admin)</a></li>
								<li><a href="a/lista">Lista de Usuários</a></li>	
								<li><a href="a/deletar">Deletar Usuários</a></li>
							</c:if>
							<c:if test="${ isAdministrador or not isAdministrador and not estaLogado }">
								<li><a href="cadastro">Criar conta</a></li>							
							</c:if>
							<li><a href="/matematica">Início</a></li>
							<c:if test="${ estaLogado }">
								<li><a href="logout">Sair</a></li>
							</c:if>
						</ul>
					</div>
				</div>
			</nav>
		</div>
	</header>
	
	<main id="content" class="container">
		<jsp:doBody /> 
	</main>
	<!-- rodape-->
	<footer class="page-footer transparent">
		<div class="footer-copyright center">
			<div class="container font-rodape">
				&#169; Copyright <span id="year"></span> - Todos os direitos reservados
			</div>
		</div>
	</footer>
	
	<!-- <script src="https://code.jquery.com/jquery-2.2.4.js"></script> -->
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	
	<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/js/materialize.min.js"></script> -->
	<script type="text/javascript" src="resources/js/materialize.min.js"></script>
	
	<script src="resources/js/common.js"></script>
	
</body>
</html>
