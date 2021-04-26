
package logic.grupo;

import javax.servlet.http.HttpServletRequest;


public class Grupo {
    int codigo;
    int profeid;
    int cursoid;

    public Grupo() {
    }

    public Grupo(int codigo, int profeid, int cursoid) {
        this.codigo = codigo;
        this.profeid = profeid;
        this.cursoid = cursoid;
    }

    public Grupo(int codigo, int cursoid) {
        this.codigo = codigo;
        this.cursoid = cursoid;
    }

    
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setProfeid(int profeid) {
        this.profeid = profeid;
    }

    public void setCursoid(int cursoid) {
        this.cursoid = cursoid;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getProfeid() {
        return profeid;
    }

    public int getCursoid() {
        return cursoid;
    }
    
}
