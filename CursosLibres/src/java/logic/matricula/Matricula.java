
package logic.matricula;


public class Matricula {
    int Codigo_curso;
    int Estudiante_idEstudiante;

    public Matricula() {
    }

    public Matricula(int Codigo_curso, int Estudiante_idEstudiante) {
        this.Codigo_curso = Codigo_curso;
        this.Estudiante_idEstudiante = Estudiante_idEstudiante;
    }

    public int getCodigo_curso() {
        return Codigo_curso;
    }

    public int getEstudiante_idEstudiante() {
        return Estudiante_idEstudiante;
    }

    public void setCodigo_curso(int Codigo_curso) {
        this.Codigo_curso = Codigo_curso;
    }

    public void setEstudiante_idEstudiante(int Estudiante_idEstudiante) {
        this.Estudiante_idEstudiante = Estudiante_idEstudiante;
    }
    
}
