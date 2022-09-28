<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="format" uri="http://java.sun.com/jsp/jstl/fmt" %>
<format:setLocale value="es_CO"/>

<section id="clientes">
    <div class="container">
        <div class="row">
            <!-- LISTA CLIENTES -->
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Lista de clientes</h4>
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>ID</th>
                                <th>Nombre</th>
                                <th>Saldo</th>
                                <th></th>
                            </tr>             
                        </thead>

                        <tbody>
                            <c:forEach var="cliente" items="${clientes}" varStatus="status">                                
                                <tr>
                                    <td>${status.count}</td>
                                    <td>${cliente.nombre} ${cliente.apellido}</td>
                                    <td><format:formatNumber value="${cliente.saldo}" type="currency" /></td>
                                    <td><a href="${pageContext.request.contextPath}/ServletControlador?accion=encontrar&idcliente=${cliente.idcliente}" class="btn btn-dark col-12">
                                            <i class="bi bi-trash"></i> / <i class="bi bi-pencil-square"></i>                                           
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>

                    </table>
                </div>
            </div>
            <!-- TARJETAS -->
            <div class="col-md-3">
                <div class="card text-center bg-light mb-3">
                    <div class="card-body">
                        <h3>Saldo total</h3>
                        <h4 class="display-6"><format:formatNumber value="${totalSaldo}" type="currency"/></h4>
                    </div>
                </div>
                <div class="card text-center bg-light mb-3">
                    <div class="card-body">
                        <h3>Total usuarios</h3>
                        <h4 class="display-4">
                            <i class="bi bi-people-fill"></i> ${totalUsuarios}
                        </h4>
                    </div>
                </div>                
            </div>            
            
        </div>
    </div>
</section>
<!-- MODAL AGREGAR CLIENTE -->
<jsp:include page="/WEB-INF/paginas/clientes/agregarCliente.jsp"/>