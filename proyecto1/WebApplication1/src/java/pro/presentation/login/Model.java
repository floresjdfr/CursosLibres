/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pro.presentation.login;

import pro.logic.usuario.Usuario;

public class Model {
    
    private Usuario usuario;

    public Model() {
        this.reset();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
  
    public void reset(){
        setUsuario(new Usuario());        
    } 
}
