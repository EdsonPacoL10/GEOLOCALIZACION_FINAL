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
import modelo.Denuncia;
import utiles.ConexionDB;

public class DenunciaDAOimpl extends ConexionDB implements DenunciaDAO {

    @Override
    public void insert(Denuncia denun) throws Exception {
        String sql = "insert into denuncia (usuario_id,DescripcionLugar,TipoLugar,DescripcionDenuncia,DatosImportanteDenuncia,localizacion,Fecha)values (?,?,?,?,?,?,?);";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, denun.getUsuario_id());
        ps.setString(2, denun.getDescripcionLugar());
        ps.setString(3, denun.getTipoLugar());
        ps.setString(4, denun.getDescripcionDenuncia());
        ps.setString(5, denun.getDatosImportanteDenuncia());
        ps.setString(6, denun.getLocalizacion());
        ps.setDate(7, denun.getFecha());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Denuncia denun) throws Exception {
        String sql;
        sql = "update denuncia set usuario_id=?,DescripcionLugar=?,TipoLugar=?,DescripcionDenuncia=?,DatosImportanteDenuncia=?,localizacion=?,Fecha=? where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, denun.getUsuario_id());
        ps.setString(2, denun.getDescripcionLugar());
        ps.setString(3, denun.getTipoLugar());
        ps.setString(4, denun.getDescripcionDenuncia());
        ps.setString(5, denun.getDatosImportanteDenuncia());
        ps.setString(6, denun.getLocalizacion());
        ps.setDate(7, denun.getFecha());
        ps.setInt(8, denun.getId());
        ps.executeUpdate();
        this.desconectar();

    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from denuncia where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        this.desconectar();

    }

    @Override
    public Denuncia getById(int id) throws Exception {
        Denuncia des = new Denuncia();
        String sql = "select * from denuncia where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            des.setId(rs.getInt("id"));
            des.setUsuario_id(rs.getInt("usuario_id"));
            des.setDescripcionLugar(rs.getString("DescripcionLugar"));
            des.setTipoLugar(rs.getString("TipoLugar"));
            des.setDescripcionDenuncia(rs.getString("DescripcionDenuncia"));
            des.setDatosImportanteDenuncia(rs.getString("DatosImportanteDenuncia"));
            des.setLocalizacion(rs.getString("localizacion"));
            des.setFecha(rs.getDate("Fecha"));
        }
        this.desconectar();
        return des;

    }

    @Override
    public List<Denuncia> getAll() throws Exception {
        List<Denuncia> lista = null;
        String sql = "SELECT d.id as id,d.usuario_id as usuario_id,u.nombres as nombre_usuario,d.DescripcionLugar as DescripcionLugar,d.TipoLugar as TipoLugar,d.DescripcionDenuncia as DescripcionDenuncia,d.DatosImportanteDenuncia as DatosImportanteDenuncia,d.localizacion as localizacion,d.Fecha as Fecha FROM denuncia d,usuario u where d.id=u.id";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        lista = new ArrayList<Denuncia>();
        while (rs.next()) {
            Denuncia p = new Denuncia();
            p.setId(rs.getInt("id"));
            p.setUsuario_id(rs.getInt("usuario_id"));
            p.setUsuarioDenunciante(rs.getString("nombre_usuario"));
            p.setDescripcionLugar(rs.getString("DescripcionLugar"));
            p.setTipoLugar(rs.getString("TipoLugar"));
            p.setDescripcionDenuncia(rs.getString("DescripcionDenuncia"));
            p.setDatosImportanteDenuncia(rs.getString("DatosImportanteDenuncia"));
            p.setLocalizacion(rs.getString("localizacion"));
            p.setFecha(rs.getDate("Fecha"));
            lista.add(p);

        }
        this.desconectar();
        return lista;
    }
}
