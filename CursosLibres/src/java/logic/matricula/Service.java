package logic.matricula;

//import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import logic.matricula.Matricula;

public class Service {

    List<Matricula> matriculas;

    public Service() {
        matriculas = new ArrayList();
    }

    public void matriculaAdd(Matricula matricula) {
        matriculas.add(matricula);
    }

    public List<Matricula> matriculasList() {
        return matriculas;
    }

    public void matricular(HttpServletRequest request) throws Exception {
        logic.matricula.MatriculaDAO.obtenerInstancia().matricular(request);
    }

}
