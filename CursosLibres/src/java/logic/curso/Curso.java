package logic.curso;




public class Curso {
    
     int codigo;
     String nombre;
     String tematica;
     String costo;
     int oferta;

    public Curso() {
    }

    public Curso(int codigo, String nombre, String tematica, String costo, int oferta) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tematica = tematica;
        this.costo = costo;
        this.oferta = oferta;
    }

    public Curso(int codigo, String nombre, String tematica, String costo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tematica = tematica;
        this.costo = costo;
    }

    public Curso(String nombre, String tematica, String costo, int oferta) {
        this.nombre = nombre;
        this.tematica = tematica;
        this.costo = costo;
        this.oferta = oferta;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTematica() {
        return tematica;
    }

    public String getCosto() {
        return costo;
    }

    public int getOferta() {
        return oferta;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public void setOferta(int oferta) {
        this.oferta = oferta;
    }
     
}
