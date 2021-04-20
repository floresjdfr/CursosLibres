package logic.curso;




public class Curso {
    
     int codigo;
     String nombre;
     String tematica;
     Float costo;
     boolean oferta;

    public Curso() {
    }

    public Curso(int codigo, String nombre, String tematica, Float costo, boolean oferta) {
        this.codigo = codigo;
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

    public Float getCosto() {
        return costo;
    }

    public boolean isOferta() {
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

    public void setCosto(Float costo) {
        this.costo = costo;
    }

    public void setOferta(boolean oferta) {
        this.oferta = oferta;
    }
     
}
