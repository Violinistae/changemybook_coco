/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import db.models.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import rmiserverbook.ForoInterface;
import rmiserverbook.Res_ForoInterface;
import rmiserverbook.UsuarioInterface;

/**
 *
 * @author Wero
 */
public class AddMessage extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
            HttpSession sesion = request.getSession();
            
            UsuarioInterface user;
            user = (UsuarioInterface)Naming.lookup("rmi://localhost/Usuario");
            Usuario res = user.readUsuarioByUsername((String)sesion.getAttribute("username"));
            
            if(res != null) {                
                
                Res_ForoInterface foro;
                foro = (Res_ForoInterface)Naming.lookup("rmi://localhost/ResForo");
                int rp = foro.createRes_ForoSms((String)request.getParameter("mensaje"), res.getId_U(), new Date(), Integer.parseInt((String)request.getParameter("id_foro")));
                
                if(rp == 1) {
                    response.sendRedirect("ResForo.jsp?id="+(String)request.getParameter("id_foro"));
                } else {
                    response.sendRedirect("Foro.jsp");
                }
            }
            else {
                response.sendRedirect("addPublication.jsp");
            }
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            System.out.println(ex.getMessage());
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
