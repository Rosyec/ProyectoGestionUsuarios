/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;


import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import dominio.ClienteBEAN;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import servicio.ClienteServicio;

/**
 *
 * @author chech
 */
@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {
    static Logger log = LogManager.getRootLogger();
    
    @Inject
    ClienteServicio clienteServicio;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {       
        String accion = req.getParameter("accion");       
        System.out.println("ACCION GET: "+ accion);
        if (accion != null && !"".equalsIgnoreCase(accion)) {
            switch (accion) {
                case "encontrar":               
                    encontrarCliente(req, resp);
                    break;
                case "eliminar":
                    eliminarCliente(req, resp);
                    break;
                default:
                    porDefecto(req, resp);
            }
        } else {
            porDefecto(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        System.out.println("ACCION POST: "+ accion);
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    insertarCliente(req, resp);
                    break;
                    
                case "editar":
                    editarCliente(req, resp);
                    break;
                    
                default:
                    porDefecto(req, resp);
            }
        } else {
            porDefecto(req, resp);
        }
    }

    public double calcularSaldo(List<ClienteBEAN> clientes) {
        double total = 0;
        for (ClienteBEAN c : clientes) {
            total += c.getSaldo();
        }
        return total;
    }
    
    public void editarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ClienteBEAN cliente = new ClienteBEAN();
        cliente.setIdcliente(Integer.parseInt(request.getParameter("idcliente")));
        cliente.setNombre(request.getParameter("nombre"));
        cliente.setApellido(request.getParameter("apellido"));
        cliente.setEmail(request.getParameter("email"));
        cliente.setTelefono(request.getParameter("telefono"));
        double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if (saldoString != null && !("".equalsIgnoreCase(saldoString))) {
            saldo = Double.parseDouble(saldoString);
            cliente.setSaldo(saldo);
        }

        ClienteBEAN clienteModificado = clienteServicio.actualizarCliente(cliente);
        log.debug("Registros (EDITAR): " + clienteModificado);

        porDefecto(request, response);
    }

    public void insertarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClienteBEAN cliente = new ClienteBEAN();
        cliente.setNombre(request.getParameter("nombre"));
        cliente.setApellido(request.getParameter("apellido"));
        cliente.setEmail(request.getParameter("email"));
        cliente.setTelefono(request.getParameter("telefono"));
        double saldo = 0;
        String saldoString = request.getParameter("saldo");
        if (saldoString != null && !("".equalsIgnoreCase(saldoString))) {
            saldo = Double.parseDouble(saldoString);
            cliente.setSaldo(saldo);
        }

        ClienteBEAN clienteModificado = clienteServicio.insertarCliente(cliente);
        log.debug("Registros (INSERTAR): " + clienteModificado);

        porDefecto(request, response);

    }
    
    public void encontrarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int idcliente = Integer.parseInt(request.getParameter("idcliente"));        
        ClienteBEAN cliente = clienteServicio.buscarClientePorId(new ClienteBEAN(idcliente));
        request.setAttribute("cliente", cliente);
        String rutaJSPEditar = "/WEB-INF/paginas/clientes/editarCliente.jsp";
        request.setAttribute("cliente", cliente);
        request.getRequestDispatcher(rutaJSPEditar).forward(request, response);
    }

    public void porDefecto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ClienteBEAN> clientes = clienteServicio.buscarClientes();
//        request.setAttribute("clientes", clientes);
//        request.setAttribute("totalSaldo", calcularSaldo(clientes));
//        request.setAttribute("totalUsuarios", clientes.size());
//        request.getRequestDispatcher("clientes.jsp").forward(request, response);

//Ya no vamos a pasar los datos por el alcance de REQUEST sino que esta vez lo haremos con un alcance mayor, el de SESSION.
        HttpSession session = request.getSession();
        session.setAttribute("clientes", clientes);
        session.setAttribute("totalSaldo", calcularSaldo(clientes));
        session.setAttribute("totalUsuarios", clientes.size());
        response.sendRedirect("clientes.jsp");
    }

    public void eliminarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClienteBEAN cliente = new ClienteBEAN();
        cliente.setIdcliente(Integer.parseInt(request.getParameter("idcliente")));       
        clienteServicio.eliminarCliente(cliente);
        log.debug("Registro Eliminado (ELIMINAR) ");
        

        porDefecto(request, response);
    }

}
