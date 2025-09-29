/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegorol2;

/**
 *
 * @author hz
 */
public abstract class Personaje implements Rol {

    private final int F_MAX = 20;
    private final int F_MIN = 0;
    private final int I_MAX = 25;
    private final int I_MIN = 0;
    private final int P_V_MAX = 500;
    private final int P_V_MIN = 0;
    private final int P_V_ACT_MIN = 0;

    private String nombre;
    private TipoRaza raza;
    private int fuerza;
    private int inteligencia;
    private int puntosVidaMaximo;
    private int puntosVidaActuales;

    public Personaje(String nombre, TipoRaza raza, int fuerza, int inteligencia,
            int puntosVidaMaximo, int puntosVidaActuales) {
        this.nombre = nombre;
        this.raza = raza;
        setFuerza(fuerza);
        setInteligencia(inteligencia);
        setPuntosVidaMaximo(puntosVidaMaximo);
        setPuntosVidaActuales(puntosVidaActuales);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoRaza getRaza() {
        return raza;
    }

    public void setRaza(TipoRaza raza) {
        this.raza = raza;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        if (fuerza <= F_MAX && fuerza >= F_MIN) {
            this.fuerza = fuerza;
        } else {
            throw new IllegalArgumentException("Error. La fuerza tiene que estar ...");
        }
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        if (inteligencia <= I_MAX && inteligencia >= I_MIN) {
            this.inteligencia = inteligencia;
        } else {
            throw new IllegalArgumentException("Error. La inteligencia tiene "
                    + "que estar ...");
        }
    }

    public int getPuntosVidaMaximo() {
        return puntosVidaMaximo;
    }

    public void setPuntosVidaMaximo(int puntosVidaMaximo) {
        if (puntosVidaMaximo <= P_V_MAX && puntosVidaMaximo >= P_V_MIN) {
            this.puntosVidaMaximo = puntosVidaMaximo;
        } else {
            throw new IllegalArgumentException("Error. Los puntosVidaMaximo tiene ");
        }
    }

    public int getPuntosVidaActuales() {
        return puntosVidaActuales;
    }

    public void setPuntosVidaActuales(int puntosVidaActuales) {
        if (puntosVidaActuales <= puntosVidaMaximo
                && puntosVidaActuales >= P_V_ACT_MIN) {
            this.puntosVidaActuales = puntosVidaActuales;
        } else {
            throw new IllegalArgumentException("Error. Los puntosVidaMaximo tiene ");
        }
    }
    
    

    @Override
    public String toString() {
        return "Personaje{" + "nombre=" + nombre + ", raza=" + raza + ", fuerza=" + fuerza + ", inteligencia=" + inteligencia + ", puntosVidaMaximo=" + puntosVidaMaximo + ", puntosVidaActuales=" + puntosVidaActuales + '}';
    }

    @Override
    public abstract int calcularPoder();
}
