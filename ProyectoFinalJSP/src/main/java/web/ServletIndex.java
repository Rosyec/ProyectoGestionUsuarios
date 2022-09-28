/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import java.io.IOException;
import javafx.application.Application;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletIndex")
public class ServletIndex extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        System.out.println("SESION INDEX: " + session.getAttribute("session"));
        if (!session.isNew()) {
            String login = (String) session.getAttribute("session");
            if (login != null && login.equalsIgnoreCase("true")) {
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/ServletControlador");
                requestDispatcher.forward(req, resp);
            } else {
                String rutaJSPLogin = "/WEB-INF/paginas/comunes/login.jsp";
                req.getRequestDispatcher(rutaJSPLogin).forward(req, resp);
            }
        }

    }

}
