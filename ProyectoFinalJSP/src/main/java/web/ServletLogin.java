/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;


import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dominio.AdminBEAN;
import servicio.ClienteServicio;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {

    @Inject
    ClienteServicio clienteServicio;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "login":
                    login(req, resp);
                    break;
                default:
                    System.out.println("No se reconoce la opción recibida!");
                    break;
            }
        }

    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        AdminBEAN admin = clienteServicio.buscarAdminPorEmail(new AdminBEAN(email));
        
        System.out.println(admin);

        if (email.equalsIgnoreCase(admin.getEmail()) && password.equalsIgnoreCase(admin.getPassword())) {
            irPaginaPrincipal(req, resp);
        } else {
            String rutaJSPEditar = "/WEB-INF/paginas/comunes/login.jsp";
            req.setAttribute("error", true);
            req.setAttribute("error_message", "El email o password son incorrectos!");           
            req.getRequestDispatcher(rutaJSPEditar).forward(req, resp);
        }

    }

    public void irPaginaPrincipal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("session", "true");
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/ServletControlador");
        requestDispatcher.forward(request, response);
    }

}
