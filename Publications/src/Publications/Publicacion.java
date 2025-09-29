/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proypublicaciones;

import java.util.Objects;

/**
 *
 * @author ANA
 */
public class Publicacion {

    private String codigo;
    private String titulo;
    private int a�o;

    public Publicacion(String codigo, String titulo, int a�o) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.a�o = a�o;
    }

    public int getA�o() {
        return a�o;
    }


    public String getCodigo() {
        return codigo;
    }


    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "Publicacion{" + "codigo=" + codigo + ", titulo=" + titulo + ", a\u00f1o=" + a�o + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.codigo);
        hash = 31 * hash + Objects.hashCode(this.titulo);
        hash = 31 * hash + this.a�o;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Publicacion other = (Publicacion) obj;
        if (this.a�o != other.a�o) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        return true;
    }
    
    

}
