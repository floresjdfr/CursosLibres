package logic.grupo;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

public class Service {

    List<Grupo> grupos;

    public Service() {
        grupos = new ArrayList();
    }

    public void gruposAdd(Grupo grupo) {
        grupos.add(grupo);
    }

    
    
    public List<Grupo> gruposList() {
        return grupos;
    }

    
    // nosotros sabiamos que esto iba a dar error y se nos olvido donde estaba la vara :v atte: rando y chupepo 

    public void matricular(HttpServletRequest request) throws Exception {
        logic.grupo.GrupoDAO.obtenerInstancia().matricular(request);
    }
}
