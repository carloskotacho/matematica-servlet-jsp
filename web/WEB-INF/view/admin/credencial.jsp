<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:template>
    <jsp:body>
        <br/><br/>
        <div class="row">
            <div class="col s12 m6">
                <div class="card blue-grey darken-1">
                    <div class="card-content white-text">
                        <span class="card-title">Minhas credenciais</span>

                        <p>Usuário: ${usuario}</p>
                        <p>Senha:   ${senha}</p>
                        <p>Addr:    ${addr}</p>
                        <p>Host:    ${host}</p>
                        <p>Port:    ${port}</p>
              
                    </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:template>