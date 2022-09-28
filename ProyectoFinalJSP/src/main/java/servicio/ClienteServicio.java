/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicio;

import dominio.AdminBEAN;
import dominio.ClienteBEAN;
import java.util.List;
import javax.ejb.Local;


@Local
public interface ClienteServicio {
    
    public List<ClienteBEAN> buscarClientes();
    
    public ClienteBEAN buscarClientePorId(ClienteBEAN cliente);
    
    public ClienteBEAN insertarCliente(ClienteBEAN cliente);
    
    public ClienteBEAN actualizarCliente(ClienteBEAN cliente);
    
    public void eliminarCliente(ClienteBEAN cliente);
    
    public AdminBEAN buscarAdminPorEmail(AdminBEAN admin);
}
