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

    
    
}
