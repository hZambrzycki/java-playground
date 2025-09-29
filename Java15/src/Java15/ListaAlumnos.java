/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyalumnosprofe;

import java.util.ArrayList;

/**
 *
 * @author hz
 */
public class ListaAlumnos {
    private ArrayList<Alumno> lista;

    public ListaAlumnos() {
        lista = new ArrayList<>();
    }
    public boolean agregarAlumno(Alumno a) {
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getApellidos().compareTo(a.getApellidos())>0) {
              lista.add(i, a);
              return true;
            }
          
        }
        return lista.add(a);
    }
    public int consultarAlumno(String apellido) {
        for (int i = 0; i < lista.size(); i++) {
            if(lista.get(i).getApellidos().equals(apellido)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "ListaAlumnos{" + "lista=" + lista + '}';
    }
}
