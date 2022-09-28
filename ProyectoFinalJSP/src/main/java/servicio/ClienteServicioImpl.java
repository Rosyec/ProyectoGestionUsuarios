/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import datos.ClienteDAO;
import dominio.AdminBEAN;
import dominio.ClienteBEAN;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author chech
 */
public class ClienteServicioImpl implements ClienteServicio{
    
    @Inject
    ClienteDAO clienteDao;

    @Override
    public List<ClienteBEAN> buscarClientes() {
        return clienteDao.findAllClientes();
    }

    @Override
    public ClienteBEAN buscarClientePorId(ClienteBEAN cliente) {
        return clienteDao.findClienteById(cliente);
    }

    @Override
    public ClienteBEAN insertarCliente(ClienteBEAN cliente) {
        return clienteDao.insertCliente(cliente);
    }

    @Override
    public ClienteBEAN actualizarCliente(ClienteBEAN cliente) {
        return clienteDao.updateCliente(cliente);
    }

    @Override
    public void eliminarCliente(ClienteBEAN cliente) {
        clienteDao.deleteCliente(cliente);
    }

    @Override
    public AdminBEAN buscarAdminPorEmail(AdminBEAN admin) {
        return clienteDao.findAdminByEmail(admin);
    }
    
}
