/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.usuario;

/**
 *
 * @author josedf
 */
public class Model {

    public Model() {
        tmpUser = new Usuario();
    }

    public Model(Usuario usr) {
        this.tmpUser = usr;
    }

    public Usuario getUsr() {
        return tmpUser;
    }

    public void setUsr(Usuario usr) {
        this.tmpUser = usr;
    }
    
    private Usuario tmpUser;
}
