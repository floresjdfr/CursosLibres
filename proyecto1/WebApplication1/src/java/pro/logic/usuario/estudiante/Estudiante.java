package pro.logic.usuario.estudiante;
import pro.logic.usuario.Usuario;

public class Estudiante extends Usuario{
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Estudiante(int cedula, String nombre, String apellido1, String apellido2, String correo, String numero, String direccion, String password) {
        super(cedula, nombre, apellido1, apellido2, correo, numero, password);
        this.direccion = direccion;
    }

    public Estudiante() {
        
    }
    
    private String direccion;
    
    
   
    
    

}
