<div class="modal fade" id="agregarClienteModal">
    <div class="modal-dialog modal-dialog-centered modal-md">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Agregar cliente</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <!-- FORMULARIO -->
                <form action="${pageContext.request.contextPath}/ServletControlador?accion=insertar" method="post" class="was-validated">
                    <div class="row">
                        <div class="col">
                            <div class="form-floating mb-3">                       
                                <input type="text" class="form-control" name="nombre" required>
                                <label for="nombre" class="form-label">Nombre</label>
                            </div>
                        </div>
                        <div class="col">
                            <div class="form-floating mb-3">                       
                                <input type="text" class="form-control" name="apellido" required>
                                <label for="apellido" class="form-label">Apellido</label>
                            </div>
                        </div>
                    </div>

                    <div class="form-floating mb-3">                       
                        <input type="email" class="form-control" name="email" required>
                        <label for="email" class="form-label">Email</label>
                    </div>

                    <div class="form-floating mb-3">                       
                        <input type="tel" class="form-control" name="telefono" required>
                        <label for="telefono" class="form-label">Teléfono</label>
                    </div>

                    <div class="form-floating mb-3">                        
                        <input type="number" class="form-control" name="saldo" required>
                        <label for="saldo" class="form-label">Saldo</label>
                    </div>

                    <div class="modal-footer">                       
                        <button type="submit" class="btn btn-primary col-12">Guardar</button>
                    </div>

                </form>
            </div>




        </div>

    </div>
</div>