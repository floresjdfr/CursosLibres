package logic.grupo;

import javax.servlet.http.HttpServletRequest;

public class Grupo {

    int codigo;
    int Curso_codigo;
    int profesor_idPreofesor;
    String fecha;

    public Grupo() {
    }

    public Grupo(int codigo, int Curso_codigo, int profesor_idPreofesor, String fecha) {
        this.codigo = codigo;
        this.Curso_codigo = Curso_codigo;
        this.profesor_idPreofesor = profesor_idPreofesor;
        this.fecha = fecha;
    }

    public Grupo(int codigo, int Curso_codigo) {
        this.codigo = codigo;
        this.Curso_codigo = Curso_codigo;
    }

    public Grupo(int codigo, int Curso_codigo,String fecha) {
        this.codigo = codigo;
        this.Curso_codigo = Curso_codigo;
        this.fecha = fecha;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getCurso_codigo() {
        return Curso_codigo;
    }

    public int getProfesor_idPreofesor() {
        return profesor_idPreofesor;
    }

    public String getFecha() {
        return fecha;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setCurso_codigo(int Curso_codigo) {
        this.Curso_codigo = Curso_codigo;
    }

    public void setProfesor_idPreofesor(int profesor_idPreofesor) {
        this.profesor_idPreofesor = profesor_idPreofesor;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
