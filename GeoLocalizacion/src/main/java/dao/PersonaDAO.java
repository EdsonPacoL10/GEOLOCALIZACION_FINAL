package dao;

import modelo.Persona;

public interface PersonaDAO {
    public void insert(Persona des) throws Exception;
    public void update(Persona des) throws Exception;
    public void delete(int id) throws Exception;
   
}

