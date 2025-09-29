/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegorol2;

import java.util.Objects;

/**
 *
 * @author hz
 */
public class Hechizo {
    private  String tipoHechizo;
    private int potencia;

    public Hechizo() {
        tipoHechizo = "FUEGO";
        potencia = 11;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public String getTipoHechizo() {
        return tipoHechizo;
    }

    public void setTipoHechizo(String tipoHechizo) {
        this.tipoHechizo = tipoHechizo;
    }

    @Override
    public String toString() {
        return "Hechizo{" + "tipoHechizo=" + tipoHechizo + ", potencia=" + potencia + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.tipoHechizo);
        hash = 61 * hash + this.potencia;
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
        final Hechizo other = (Hechizo) obj;
        if (this.potencia != other.potencia) {
            return false;
        }
        if (!Objects.equals(this.tipoHechizo, other.tipoHechizo)) {
            return false;
        }
        return true;
    }
    
    
    
}
