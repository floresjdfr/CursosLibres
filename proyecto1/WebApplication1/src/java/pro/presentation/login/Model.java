/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro.presentation.login;

import pro.logic.usuario;

public class Model {
    
    private usuario usuario;

    public Model() {
        this.reset();
    }

    public usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(usuario usuario) {
        this.usuario = usuario;
    }
  
    public void reset(){
        setUsuario(new usuario());        
    } 
}
