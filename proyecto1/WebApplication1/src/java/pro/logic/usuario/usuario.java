
package pro.logic.usuario;


public class Usuario {
    private String cedula;
    private String nombre;
    private String password;

    public Usuario() {
    }

    public Usuario(String cedula, String nombre, String password) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.password = password;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Usuario{" + "cedula=" + cedula + ", nombre=" + nombre + ", password=" + password + '}';
    }
    
    

 

    
}
