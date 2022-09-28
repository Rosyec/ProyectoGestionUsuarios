<div class="modal fade" id="confirmar">
    <div class="modal-dialog modal-dialog-centered modal-md">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Eliminar cliente</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                Estas seguro de eliminar a ${cliente.nombre} ${cliente.apellido} ?
            </div>
            <div class="modal-footer">
                <a class="btn btn-danger btn-block" href="${pageContext.request.contextPath}/ServletControlador?accion=eliminar&idcliente=${cliente.idcliente}">Eliminar</a>               
            </div>
        </div>

    </div>
</div>