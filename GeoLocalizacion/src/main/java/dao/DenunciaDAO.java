package dao;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import modelo.Denuncia;

public interface DenunciaDAO {
public void insert(Denuncia denun) throws Exception;
    public void update(Denuncia denun) throws Exception;
    public void delete(int id) throws Exception;
    public Denuncia getById(int id) throws Exception;
    public List<Denuncia> getAll() throws Exception;
   
}
