package controlador;

import dao.DenunciaDAO;
import dao.DenunciaDAOimpl;
import dao.UsuarioDAO;
import dao.UsuarioDAOimpl;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modelo.Denuncia;
import modelo.usuario;

@WebServlet(name = "DenunciaControlador", urlPatterns = {"/DenunciaControlador"})
public class DenunciaControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  try {
            DenunciaDAO dao = new DenunciaDAOimpl();
            UsuarioDAO daoCliente = new UsuarioDAOimpl();
            int id;
            List<usuario> lista_clientes = null;
            Denuncia informacion = new Denuncia();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    lista_clientes = daoCliente.getAll();
                    request.setAttribute("lista_clientes", lista_clientes);
                    request.setAttribute("informacion", informacion);
                    request.getRequestDispatcher("frmDenuncia.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    informacion = dao.getById(id);
                    lista_clientes = daoCliente.getAll();
                    request.setAttribute("lista_clientes", lista_clientes);
                    request.setAttribute("informacion", informacion);
                    request.getRequestDispatcher("frmDenuncia.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("DenunciaControlador");
                    break;
                case "view":
                    List<Denuncia> lista = dao.getAll();
                    request.setAttribute("lista", lista);
                    request.getRequestDispatcher("Denuncia.jsp").forward(request, response);
                    break;
            }
        } catch (Exception ex) {
            System.out.println("error" + ex.getMessage());
        }
      
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int id = Integer.parseInt(request.getParameter("id"));
        int id_usuario = Integer.parseInt(request.getParameter("usuario_id"));
       String UsuarioDenunciante=request.getParameter("nombre_usuario");
        String DescripcionLugar = request.getParameter("DescripcionLugar");
        String TipoLugar = request.getParameter("TipoLugar");
        String DescripcionDenuncia = request.getParameter("DescripcionDenuncia");
        String DatosImportanteDenuncia = request.getParameter("DatosImportanteDenuncia");
        String localizacion = request.getParameter("localizacion");
        String fecha = request.getParameter("Fecha");
        Denuncia inf = new Denuncia();
        inf.setId(id);
        inf.setUsuario_id(id_usuario);
        inf.setUsuarioDenunciante(UsuarioDenunciante);
        inf.setDescripcionLugar(DescripcionLugar);
        inf.setTipoLugar(TipoLugar);
        inf.setDescripcionDenuncia(DescripcionDenuncia);
        inf.setDatosImportanteDenuncia(DatosImportanteDenuncia);
        inf.setLocalizacion(localizacion);
        inf.setFecha(convierteFecha(fecha));
       
        if (id == 0) {
            DenunciaDAO dao = new DenunciaDAOimpl();
            try {
                // Nuevo
                dao.insert(inf);
                response.sendRedirect("DenunciaControlador");
            } catch (Exception ex) {
                System.out.println("Error al Insertar: " + ex.getMessage());
            }
        } else {
            DenunciaDAO dao = new DenunciaDAOimpl();
            try {
                // Edicion
                response.sendRedirect("DenunciaControlador");
                dao.update(inf);
            } catch (Exception ex) {
                System.out.println("Error al Actualizar: " + ex.getMessage());
            }
        }
    }
    public Date convierteFecha(String fecha) {
        Date fechaBD = null;
        SimpleDateFormat formato;
        formato = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date fechaTMP;
        try {
            fechaTMP = formato.parse(fecha);
            fechaBD = new Date(fechaTMP.getTime());
        } catch (ParseException ex) {
            System.out.println("Error en la conversion de fecha: " + ex.getMessage());
        }

        return fechaBD;
    }

    }
    



