package logic.usuario.profesor;

import logic.usuario.Usuario;

public class Profesor extends Usuario {

    private String especialidad;

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Profesor() {
    }

    public Profesor(String especialidad) {
        this.especialidad = especialidad;
    }

    public Profesor(String especialidad, String nombre, String apellido1, String apellido2, String correo, String numero, String password) {
        super(nombre, apellido1, apellido2, correo, numero, password);
        this.especialidad = especialidad;
    }
    
    

    public Profesor(int cedula, String nombre, String apellido1, String apellido2, String correo, String numero, String especialidad, String password) {
        super(cedula, nombre, apellido1, apellido2, correo, numero, password);
        this.especialidad = especialidad;
    }

    

}
