/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_recuperacion_hubert_zambrzycki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author hz
 */
public class Red_Social {
    private Usuario[] listaUsuarios;

    @Override
    public String toString() {
        return "Red_Social{" + "listaUsuarios=" + Arrays.toString(listaUsuarios) + ", tama\u00f1oMaximo=" + tamañoMaximo + ", nElementos=" + nElementos + '}';
    }
    private int tamañoMaximo;
    private int nElementos;
    
     public Red_Social(int tamañoMaximo) {
        this.tamañoMaximo = tamañoMaximo;
        this.listaUsuarios = new Usuario[tamañoMaximo];
        this.nElementos = 0;
    }

    public Usuario[] getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(Usuario[] listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public int getTamañoMaximo() {
        return tamañoMaximo;
    }

    public void setTamañoMaximo(int tamañoMaximo) {
        this.tamañoMaximo = tamañoMaximo;
    }
    
 
    
    public int agregarUsuario(String nombre, String apellidos) {
        Scanner teclado = new Scanner(System.in);
        
        
        Usuario usuario = new Usuario(nElementos, nombre, apellidos);
        usuario.setApellidos(apellidos);
        usuario.setNombre(nombre);
        usuario.setIdentificador(nElementos);
        if(nElementos < listaUsuarios.length){
            listaUsuarios[nElementos] = usuario;
            nElementos++;
        }
      
       return 0;
    }
    
    public int buscarUsuario(String cadena) {
        for (int i = 0; i < nElementos; i++) {
            if(listaUsuarios[i].getNombre().equals(cadena) ||
            listaUsuarios[i].getApellidos().equals(cadena)) {
                return i;
            }
        }
        return -1;
    }

}
