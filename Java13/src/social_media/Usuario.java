/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_recuperacion_hubert_zambrzycki;

import java.util.ArrayList;

/**
 *
 * @author hz
 */
public class Usuario {

    private int identificador;
    private String nombre;
    private String apellidos;
    private ArrayList<Usuario> listaUsuarios;

    public Usuario(int identificador, String nombre, String apellidos) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.listaUsuarios = new ArrayList<>();
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        
        return "Usuario{" + "identificador=" + identificador + ", nombre=" + nombre + ", apellidos=" + apellidos  + listaUsuarios +'}';
    }

    public boolean agregarSeguido(Usuario usuario) {
        if (usuario == null) {
            return false;
        }
        if (listaUsuarios.contains(usuario)) {
            return false;
        }
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if (listaUsuarios.get(i).getNombre().equals(usuario.getNombre())
          && listaUsuarios.get(i).getApellidos().equals(usuario.getApellidos())
    && listaUsuarios.get(i).getIdentificador() == usuario.getIdentificador()) {
                return false;
            }
        }
        listaUsuarios.add(usuario);
        return true;
    }
    
    public boolean agregarSeguidoOrdenado(Usuario usuario) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            if(listaUsuarios.get(i).getApellidos().
                    compareTo(usuario.getApellidos())>0) {
                listaUsuarios.add(usuario);
                return true;
            }
        }
        return false;
    }
    public boolean eliminarSeguido(Usuario usuario) {
        for (int i = 0; i < listaUsuarios.size(); i++) {
   if(listaUsuarios.get(i).getIdentificador() == usuario.getIdentificador() &&
      listaUsuarios.get(i).getNombre().equals(usuario.getNombre()) &&
      listaUsuarios.get(i).getApellidos().equals(usuario.getApellidos())) {
       listaUsuarios.remove(usuario);
       return true;
   }
        }
        return false;
    }
    public void imprimir() {
        for (int i = 0; i < listaUsuarios.size(); i++) {
            System.out.println(this);
        }
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
}
