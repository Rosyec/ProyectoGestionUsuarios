<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/0819a8150e.js" crossorigin="anonymous"></script>
        <title>Editar clientes</title>
    </head>

    <body>
        <!-- CABECERO -->
        <jsp:include page="/WEB-INF/paginas/comunes/cabecero.jsp"/>
        <!-- BOTONES EDICION -->
        <jsp:include page="/WEB-INF/paginas/comunes/botonesEdicionCliente.jsp"/>

        <form action="${pageContext.request.contextPath}/ServletControlador?accion=editar&idcliente=${cliente.idcliente}" method="post" class="was-validated">      

            <section id="detalles">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Eliminar / Editar cliente</h4>
                                </div>
                                <div class="card-body">
                                    <div class="row">
                                        <div class="col">
                                            <div class="form-floating mb-3">                       
                                                <input type="text" class="form-control" name="nombre" required value="${cliente.nombre}">
                                                <label for="nombre" class="form-label">Nombre</label>
                                            </div>
                                        </div>
                                        <div class="col">
                                            <div class="form-floating mb-3">                       
                                                <input type="text" class="form-control" name="apellido" required value="${cliente.apellido}">
                                                <label for="apellido" class="form-label">Apellido</label>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-floating mb-3">                       
                                        <input type="email" class="form-control" name="email" required value="${cliente.email}">
                                        <label for="email" class="form-label">Email</label>
                                    </div>

                                    <div class="form-floating mb-3">                       
                                        <input type="tel" class="form-control" name="telefono" required value="${cliente.telefono}">
                                        <label for="telefono" class="form-label">Teléfono</label>
                                    </div>

                                    <div class="form-floating mb-3">                        
                                        <input type="number" class="form-control" name="saldo" required value="${cliente.saldo}">
                                        <label for="saldo" class="form-label">Saldo</label>
                                    </div>

                                    <div class="modal-footer">
                                        <div class="container">
                                            <div class="row">
                                                <div class="col">
                                                    <a href="#" class="btn btn-danger col-12" data-bs-toggle="modal" data-bs-target="#confirmar"><i class="bi bi-trash"></i> Eliminar</a>
                                                </div>
                                                <div class="col">
                                                    <button type="submit" class="btn btn-success col-12">  <i class="bi bi-pencil-square"></i> Editar</button>
                                                </div>
                                                                                                                                      
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

        </form>
        <!-- PIE DE PAGINA -->
        <jsp:include page="/WEB-INF/paginas/comunes/piePagina.jsp"/>
        <jsp:include page="/WEB-INF/paginas/clientes/confirmarEliminacion.jsp"/>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>
