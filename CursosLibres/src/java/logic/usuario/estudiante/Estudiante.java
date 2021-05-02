package logic.usuario.estudiante;

import logic.usuario.Usuario;

public class Estudiante extends Usuario{
    

    public Estudiante(int cedula, String nombre, String apellido1, String apellido2, String correo, String numero, String direccion, String password) {
        super(cedula, nombre, apellido1, apellido2, correo, numero, password);
        this.direccion = direccion;
    }
    
    
    
    public Estudiante() {
        
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    
    
    
    private String direccion;
    private int nota;
    
    
}
