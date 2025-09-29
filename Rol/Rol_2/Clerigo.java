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
public class Clerigo extends Personaje {
    private final int F_MENOR_CLERIGO = 10;
    private final int I_MENOR_CLERIGO = 10;
    private final int I_MAYOR_CLERIGO = 20;
    
    private String dios;

    public Clerigo(String dios, String nombre, TipoRaza raza, int fuerza,
            int inteligencia, int puntosVidaMaximo, int puntosVidaActuales) {
        super(nombre, raza, fuerza, inteligencia, puntosVidaMaximo,
                puntosVidaActuales);
        setFuerza(fuerza);
        setInteligencia(fuerza);
        this.dios = dios;
    }

    void curar(Personaje p) {
        p.setPuntosVidaActuales(p.getPuntosVidaActuales() + 11);
    }

    @Override
    public void setFuerza(int fuerza) {

        if (fuerza >= F_MENOR_CLERIGO) {
            super.setFuerza(F_MENOR_CLERIGO);
        } else {
            throw new IllegalArgumentException("Error ....");
        }

    }
    
    

    @Override
    public void setInteligencia(int inteligencia) {

        if (inteligencia <= I_MAYOR_CLERIGO && inteligencia >= I_MENOR_CLERIGO) {
            super.setInteligencia(inteligencia);
        } else {
            throw new IllegalArgumentException("Error ....");
        }

    }

    @Override
    public int calcularPoder() {
        return getFuerza() * getInteligencia()  + getPuntosVidaActuales();
    }

    @Override
    public String toString() {
        return "Clerigo{" + super.toString() + "dios=" + dios + '}';
    }

 
}
