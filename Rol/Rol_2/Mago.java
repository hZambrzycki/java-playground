/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegorol2;

import java.util.ArrayList;

/**
 *
 * @author hz
 */
public class Mago extends Personaje implements Rol {

    private final int F_MAYOR_MAGO = 12;
    private final int I_MENOR_MAGO = 15;
    private final int N_HECHIZOS = 3;

    private ArrayList<Hechizo> listaHechizos;

    public Mago(String nombre, TipoRaza raza, int fuerza, int inteligencia,
            int puntosVidaMaximo, int puntosVidaActuales) {
        super(nombre, raza, fuerza, inteligencia, puntosVidaMaximo,
                puntosVidaActuales);
        setFuerzaMago(fuerza);
        setInteligenciaMago(inteligencia);

        listaHechizos = new ArrayList<>();
    }


    public final void setFuerzaMago(int fuerza) {
        if (fuerza <= F_MAYOR_MAGO) {
            super.setFuerza(fuerza);
        }
        else {
            throw new IllegalArgumentException("Error .....");
        }
    }
    
    public final void setInteligenciaMago(int inteligencia) {
        if (inteligencia >= I_MENOR_MAGO) {
            super.setInteligencia(inteligencia);
        }
        else {
            throw new IllegalArgumentException("Error .....");
        }
    }

    public boolean aprendeHechizo(Hechizo h) {
        
        if (h==null) {
            return false;
        }
        if (listaHechizos.contains(h)) {
            return false;
        }
        if (listaHechizos.size() >= N_HECHIZOS) {
            return false;
        }
        return listaHechizos.add(h);
        
    }
    
    
    
    @Override
    public int calcularPoder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
