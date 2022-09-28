package datos;


import dominio.AdminBEAN;
import dominio.ClienteBEAN;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@Stateless
public class ClienteDAOImple implements ClienteDAO {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProyectoPU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction transaction = em.getTransaction();
    List<ClienteBEAN> clientes = null;
    ClienteBEAN cliente = null;
    AdminBEAN myAdmin = null;

    @Override
    public List<ClienteBEAN> findAllClientes() {
        transaction.begin();
        
        clientes = em.createNamedQuery("ClienteBEAN.findAll").getResultList();
        transaction.commit();

        
        return clientes;
    }

    @Override
    public ClienteBEAN findClienteById(ClienteBEAN cliente) {
        transaction.begin();
        
        cliente = em.find(ClienteBEAN.class, cliente.getIdcliente());
        
        transaction.commit();

        
        return cliente;
    }

    @Override
    public ClienteBEAN insertCliente(ClienteBEAN cliente) {
        transaction.begin();
        
        em.persist(cliente);
        
        transaction.commit();

                
        return cliente;
    }

    @Override
    public ClienteBEAN updateCliente(ClienteBEAN cliente) {
        transaction.begin();
        
        em.merge(cliente);
        
        transaction.commit();

        
        return cliente;
    }

    @Override
    public void deleteCliente(ClienteBEAN cliente) {
        transaction.begin();
        
        em.remove(em.merge(cliente));
        
        transaction.commit();

        
    }

    @Override
    public AdminBEAN findAdminByEmail(AdminBEAN admin) {
        transaction.begin();

        myAdmin = (AdminBEAN) em.createNamedQuery("AdminBEAN.findByEmail").setParameter("email", admin.getEmail()).getSingleResult();
        
        transaction.commit();

        
        return myAdmin;
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    

//    private static final String SQL_SELECT = "SELECT idcliente, nombre, apellido, email, telefono, saldo FROM control_clientes.cliente";
//    private static final String SQL_SELECT_BY_ID = "SELECT * FROM control_clientes.cliente WHERE idcliente = ?";
//    private static final String SQL_INSERT = "INSERT INTO control_clientes.cliente(nombre, apellido, email, telefono, saldo) VALUES(?, ?, ?, ?, ?)";
//    private static final String SQL_UPDATE = "UPDATE control_clientes.cliente SET nombre=?, apellido=?, email=?, telefono=?, saldo=? WHERE idcliente=?";
//    private static final String SQL_DELETE = "DELETE FROM control_clientes.cliente WHERE idcliente=?";
//    private static final String SQL_SELECT_ADMIN = "SELECT email, password FROM control_clientes.admin WHERE email=?";
//
//    @Override
//    public List<Cliente> listar() {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//        Cliente cliente = null;
//        List<Cliente> clientes = new ArrayList<>();
//
//        try {
//            connection = Conexion.getConnection();
//            preparedStatement = connection.prepareStatement(SQL_SELECT);
//            resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                int idcliente = resultSet.getInt("idcliente");
//                String nombre = resultSet.getString("nombre");
//                String apellido = resultSet.getString("apellido");
//                String email = resultSet.getString("email");
//                String telefono = resultSet.getString("telefono");
//                double saldo = resultSet.getDouble("saldo");
//                cliente = new Cliente(idcliente, nombre, apellido, email, telefono, saldo);
//
//                clientes.add(cliente);
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {
//            Conexion.close(resultSet);
//            Conexion.close(preparedStatement);
//            Conexion.close(connection);
//        }
//        return clientes;
//    }
//
//    @Override
//    public Cliente encontrar(Cliente cliente) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//
//        try {
//
//            connection = Conexion.getConnection();
//            preparedStatement = connection.prepareStatement(SQL_SELECT_BY_ID);
//            preparedStatement.setInt(1, cliente.getIdcliente());
//            resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                cliente.setNombre(resultSet.getString("nombre"));
//                cliente.setApellido(resultSet.getString("apellido"));
//                cliente.setEmail(resultSet.getString("email"));
//                cliente.setTelefono(resultSet.getString("telefono"));
//                cliente.setSaldo(resultSet.getDouble("saldo"));
//            }
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {
//            Conexion.close(resultSet);
//            Conexion.close(preparedStatement);
//            Conexion.close(connection);
//        }
//        return cliente;
//    }
//
//    @Override
//    public int insertar(Cliente cliente) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        int result = 0;
//
//        try {
//            connection = Conexion.getConnection();
//            preparedStatement = connection.prepareStatement(SQL_INSERT);
//            preparedStatement.setString(1, cliente.getNombre());
//            preparedStatement.setString(2, cliente.getApellido());
//            preparedStatement.setString(3, cliente.getEmail());
//            preparedStatement.setString(4, cliente.getTelefono());
//            preparedStatement.setDouble(5, cliente.getSaldo());
//            result = preparedStatement.executeUpdate();
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {
//            Conexion.close(preparedStatement);
//            Conexion.close(connection);
//        }
//
//        return result;
//    }
//
//    @Override
//    public int actualizar(Cliente cliente) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        int result = 0;
//
//        try {
//            connection = Conexion.getConnection();
//            preparedStatement = connection.prepareStatement(SQL_UPDATE);
//            preparedStatement.setString(1, cliente.getNombre());
//            preparedStatement.setString(2, cliente.getApellido());
//            preparedStatement.setString(3, cliente.getEmail());
//            preparedStatement.setString(4, cliente.getTelefono());
//            preparedStatement.setDouble(5, cliente.getSaldo());
//            preparedStatement.setInt(6, cliente.getIdcliente());
//            result = preparedStatement.executeUpdate();
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {
//            Conexion.close(preparedStatement);
//            Conexion.close(connection);
//        }
//
//        return result;
//    }
//
//    @Override
//    public int eliminar(Cliente cliente) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        int result = 0;
//
//        try {
//            connection = Conexion.getConnection();
//            preparedStatement = connection.prepareStatement(SQL_DELETE);
//            preparedStatement.setInt(1, cliente.getIdcliente());
//            result = preparedStatement.executeUpdate();
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {
//            Conexion.close(preparedStatement);
//            Conexion.close(connection);
//        }
//
//        return result;
//    }
//
//    @Override
//    public AdminCOPIA encontrarAdmin(AdminCOPIA admin) {
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//
//        try {
//            connection = Conexion.getConnection();
//            preparedStatement = connection.prepareStatement(SQL_SELECT_ADMIN);
//            preparedStatement.setString(1, admin.getEmail());
//            resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {                
//                admin.setEmail(resultSet.getString("email"));
//                admin.setPassword(resultSet.getString("password"));
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {
//            Conexion.close(preparedStatement);
//            Conexion.close(connection);
//        }
//        
//        return admin;
//    }

}
