package examen_hubert_zambrzycki;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dawmi
 */
public class Emisora implements Emitible{
    private int identificador;
    private String nombre;
    private int añoCreacion;
    private boolean emitiendo;
    private int nEmisora = 0;
   

    public Emisora(int identificador, int añoCreacion, String nombre, int nEmisora) {
        this.emitiendo = false;
        System.out.println("Se ha creado la emisora numero:" + nEmisora);
        this.identificador = identificador;
        this.añoCreacion = añoCreacion;
        this.nombre = nombre;
        
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

    public int getAñoCreacion() {
        return añoCreacion;
    }

    public void setAñoCreacion(int añoCreacion) {
        this.añoCreacion = añoCreacion;
    }

    public boolean isEmitiendo() {
        return emitiendo;
    }

    public void setEmitiendo(boolean emitiendo) {
        this.emitiendo = emitiendo;
    }

    public int getnEmisoras() {
        return nEmisora;
    }

    public void setnEmisoras(int nEmisoras) {
        this.nEmisora = nEmisoras;
    }
        @Override
    public String toString() {
        return "Emisora{" + "identificador=" + identificador + ", nombre=" 
                + nombre + ", a\u00f1oCreacion=" + añoCreacion + ", emitiendo=" 
                + emitiendo +  '}';
    }

    @Override
    public void iniciarEmision() {
        System.out.println("Iniciando la emision : " + this.nombre + "");
        this.emitiendo = true;
    }

    @Override
    public void finalizarEmision() {
        System.out.println("Finalizando la transmision : " + this.nombre + "");
        this.emitiendo = false;
    }

    @Override
    public boolean estaEmitiendo() {
        
       if(this.emitiendo == true) {
           return true;
       } 
      
       return false;
    }
}
