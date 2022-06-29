package modelo;

import java.io.InputStream;

public class Persona {
int id;
InputStream foto;
public Persona(){
    
}

    public Persona(int id, InputStream foto) {
        this.id = id;
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public InputStream getFoto() {
        return foto;
    }

    public void setFoto(InputStream foto) {
        this.foto = foto;
    }

}
