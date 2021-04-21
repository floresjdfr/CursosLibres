/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.curso;

/**
 *
 * @author josedf
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Escinf
 */
public class Service {
    private static Service uniqueInstance;

    public static Service instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Service();
        }
        return uniqueInstance; 
    }

    List<Curso> cursos;

    private Service(){
        cursos = new ArrayList();
    }

    public void cursosAdd (Curso curso){
        cursos.add(curso);
    }

    public List<Curso> cursosList(){
        return cursos;
    }
    
}
