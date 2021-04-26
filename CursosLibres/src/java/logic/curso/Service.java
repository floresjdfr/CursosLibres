/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.curso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Service {

    

    List<Curso> cursos;

    public Service(){
        cursos = new ArrayList();
    }

    public void cursosAdd (Curso curso){
        cursos.add(curso);
    }

    public List<Curso> cursosList(){
        return cursos;
    }
    
}
