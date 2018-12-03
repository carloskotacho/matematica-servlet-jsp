<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:template>
    <jsp:body>
        <br />
        <div class="row">
            <div class="col s12 texto-espacial">
                <h5>Geometria Espacial</h5>
                <p>A Geometria Espacial estuda os objetos que possuem mais de uma dimensão e ocupam lugar no espaço.
                    Por sua vez, esses objetos são conhecidos como <b>"sólidos geométricos"</b> ou <b>"figuras geométricas espaciais"</b>.
                    Conheça melhor alguns deles:</p>
            </div>
        </div>

        <div class="row">
            <div class="col s12 m3">
                <div class="card">
                    <div class="card-image">
                        <img src="resources/img/cube.png">
                        <span class="card-title grey darken-2">Cubo</span>
                    </div>

                    <div class="card-action">
                        <a href="u/cubo">Calcular</a>
                    </div>
                </div>
            </div>
            <div class="col s12 m3">
                <div class="card">
                    <div class="card-image">
                        <img src="resources/img/pyramid.png">
                        <span class="card-title grey darken-2">Pirâmide</span>
                    </div>

                    <div class="card-action">
                        <a href="u/piramide">Calcular</a>
                    </div>
                </div>
            </div>
            <div class="col s12 m3">
                <div class="card">
                    <div class="card-image">
                        <img src="resources/img/cylinder.png">
                        <span class="card-title grey darken-2">Cilindro</span>
                    </div>

                    <div class="card-action">
                        <a href="u/cilindro">Calcular</a>
                    </div>
                </div>
            </div>
            <div class="col s12 m3">
                <div class="card">
                    <div class="card-image">
                        <img src="resources/img/cone4.png">
                        <span class="card-title grey darken-2">Cone</span>
                    </div>

                    <div class="card-action">
                        <a href="u/cone">Calcular</a>
                    </div>
                </div>
            </div>
        </div>

    </jsp:body>
</t:template>