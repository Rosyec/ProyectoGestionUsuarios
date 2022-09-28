/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import dominio.AdminBEAN;
import dominio.ClienteBEAN;
import java.util.List;


public interface ClienteDAO {
    
    public List<ClienteBEAN> findAllClientes();
    
    public ClienteBEAN findClienteById(ClienteBEAN cliente);
    
    public ClienteBEAN insertCliente(ClienteBEAN cliente);
    
    public ClienteBEAN updateCliente(ClienteBEAN cliente);
    
    public void deleteCliente(ClienteBEAN cliente);
    
    public AdminBEAN findAdminByEmail(AdminBEAN admin);
    
//    public List<Cliente> listar();
//    public Cliente encontrar(Cliente cliente);
//    public int insertar(Cliente cliente);
//    public int actualizar(Cliente cliente);
//    public int eliminar(Cliente cliente);
//    public Admin encontrarAdmin(Admin admin);
}
