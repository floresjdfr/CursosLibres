
package pro.logic;


public class profesor {
    String cedula;
    String nombre;
    String apellido1;
    String apellido2;
    String correo;
    String numero;
    String direccion;
    String especialidad;
    String password;

    public profesor() {
    }

    public profesor(String cedula, String nombre, String apellido1, String apellido2, String correo, String numero, String direccion, String especialidad, String password) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.correo = correo;
        this.numero = numero;
        this.direccion = direccion;
        this.especialidad = especialidad;
        this.password = password;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNumero() {
        return numero;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "profesor{" + "cedula=" + cedula + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", correo=" + correo + ", numero=" + numero + ", direccion=" + direccion + ", especialidad=" + especialidad + ", password=" + password + '}';
    }
}
