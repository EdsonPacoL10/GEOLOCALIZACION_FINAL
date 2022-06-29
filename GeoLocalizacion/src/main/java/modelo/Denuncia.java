package modelo;

import java.io.InputStream;
import java.sql.Date;

public class Denuncia {
    private int  id;
    private String UsuarioDenunciante;
    private int usuario_id;
    private String DescripcionLugar;
    private String TipoLugar;
    private String DescripcionDenuncia;
    private String DatosImportanteDenuncia;
     private String localizacion;
    private Date Fecha;

    public Denuncia(int id, String UsuarioDenunciante, int usuario_id, String DescripcionLugar, String TipoLugar, String DescripcionDenuncia, String DatosImportanteDenuncia, String localizacion, Date Fecha) {
        this.id = id;
        this.UsuarioDenunciante = UsuarioDenunciante;
        this.usuario_id = usuario_id;
        this.DescripcionLugar = DescripcionLugar;
        this.TipoLugar = TipoLugar;
        this.DescripcionDenuncia = DescripcionDenuncia;
        this.DatosImportanteDenuncia = DatosImportanteDenuncia;
        this.localizacion = localizacion;
        this.Fecha = Fecha;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public Denuncia() {
    }

    public int getId() {
        return id;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuarioDenunciante() {
        return UsuarioDenunciante;
    }

    public void setUsuarioDenunciante(String UsuarioDenunciante) {
        this.UsuarioDenunciante = UsuarioDenunciante;
    }

    public String getDescripcionLugar() {
        return DescripcionLugar;
    }

    public void setDescripcionLugar(String DescripcionLugar) {
        this.DescripcionLugar = DescripcionLugar;
    }

    public String getTipoLugar() {
        return TipoLugar;
    }

    public void setTipoLugar(String TipoLugar) {
        this.TipoLugar = TipoLugar;
    }

    public String getDescripcionDenuncia() {
        return DescripcionDenuncia;
    }

    public void setDescripcionDenuncia(String DescripcionDenuncia) {
        this.DescripcionDenuncia = DescripcionDenuncia;
    }

    public String getDatosImportanteDenuncia() {
        return DatosImportanteDenuncia;
    }

    public void setDatosImportanteDenuncia(String DatosImportanteDenuncia) {
        this.DatosImportanteDenuncia = DatosImportanteDenuncia;
    }


    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

}               