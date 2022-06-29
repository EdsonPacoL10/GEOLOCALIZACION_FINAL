/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.PersonaDAO;
import dao.PersonaDAOimpl;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modelo.Persona;

/**
 *
 * @author Apple
 */
@WebServlet(name = "PersonaControlador", urlPatterns = {"/PersonaControlador"})
@MultipartConfig
public class PersonaControlador extends HttpServlet {
PersonaDAOimpl dao=new PersonaDAOimpl();
Persona p=new Persona();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String accion = (request.getParameter("accion") != null) ? request.getParameter("accion") : "listar";    
        
            switch(accion){
                case "listar":
                    List<Persona>lista=dao.lista();
                    request.setAttribute("lista",lista);
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
                case "nuevo":
                    request.getRequestDispatcher("agregar.jsp").forward(request, response);
                    break;
                case "delete":
                    int id = Integer.parseInt(request.getParameter("id"));
             {
                 try {
                     dao.delete(id);
                 } catch (Exception ex) {
                     Logger.getLogger(PersonaControlador.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
                    response.sendRedirect("InformacionControlador");
                    break;

                case "guardar":
                    Part part=request.getPart("fileFoto");
                    InputStream inputStream=part.getInputStream();
                    p.setFoto(inputStream);
                    dao.agregar(p);
                    request.getRequestDispatcher("PersonaControlador?accion=listar").forward(request,response);
                    break;
                }
    }

}













