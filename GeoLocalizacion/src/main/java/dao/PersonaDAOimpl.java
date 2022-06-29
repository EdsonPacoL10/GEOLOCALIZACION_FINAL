package dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import modelo.Persona;
import utiles.ConexionDB;

public class PersonaDAOimpl extends ConexionDB implements PersonaDAO{

    @Override
    public void insert(Persona des) throws Exception {
     }

    @Override
    public void update(Persona des) throws Exception {
     }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from foto where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        this.desconectar();
    
    
    }

   
    public List lista()  {
        List<Persona> lista=new ArrayList<>();
        String sql ="select * from foto f,desaparecido d where f.id=d.id";
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Persona p=new Persona();
                p.setId(rs.getInt(1));
                p.setFoto(rs.getBinaryStream(2));
                lista.add(p);
            }
        } catch (Exception e) {
        }
        return lista;
    
    }
    public void listarImg (int id,HttpServletResponse response){
        String sql="select*from foto where id="+id;
        InputStream inputStram =null;
        OutputStream outputStream=null;
        BufferedInputStream bufferedInputStream=null;
        BufferedOutputStream bufferedOutputStream=null;
        response.setContentType("image/*");
        try {
            outputStream=response.getOutputStream();
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                inputStram=rs.getBinaryStream("Foto");
            }
            bufferedInputStream=new BufferedInputStream(inputStram);
            bufferedOutputStream=new BufferedOutputStream(outputStream);
            int i=0;
            while((i=bufferedInputStream.read())!= -1)
            {
                bufferedOutputStream.write(i);
            } 
        } catch (Exception e) {
        }
    }
    public void agregar (Persona p){
        String sql ="INSERT INTO foto(foto) VALUES (?)";
        try {
            this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setBlob(1,p.getFoto());
        ps.executeUpdate();
        } catch (Exception e) {
        }
    }

  
}





























