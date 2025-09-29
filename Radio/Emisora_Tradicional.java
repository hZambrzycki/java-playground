/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen_hubert_zambrzycki;

/**
 *
 * @author dawmi
 */
public class Emisora_Tradicional extends Emisora {

    
    private double frecuencia;

    public Emisora_Tradicional(int identificador, int añoCreacion,
            String nombre, double frecuencia, int nEmisora) {
        super(identificador, añoCreacion, nombre, nEmisora);
        this.frecuencia = frecuencia;
       
        
    }

    public double getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(double frecuencia) {
        this.frecuencia = frecuencia;
    }

    @Override
    public String toString() {
        return "Emisora_Tradicional{" + "frecuencia=" + 
                + frecuencia + super.toString()+ '}';
    }

    @Override
    public void iniciarEmision() {
        super.iniciarEmision();
        System.out.println("En : "  +  frecuencia);
    }

    @Override
    public void finalizarEmision() {
        super.finalizarEmision();
        System.out.println("En :"  +  frecuencia);
    }

}
