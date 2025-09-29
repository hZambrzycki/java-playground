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
public class Emisora_Online extends Emisora{
    
    private String url;

    @Override
    public String toString() {
        return "Emisora_Online{" + "url=" + url + 
                super.toString()+'}';
    }

    public Emisora_Online(int identificador, int añoCreacion, String nombre, String url, int nEmisora) {
        super(identificador, añoCreacion, nombre, nEmisora);
        this.url = url;
       
    }
       @Override
    public void iniciarEmision() {
        super.iniciarEmision();
        System.out.println("En : "+getUrl() );
    }

    @Override
    public void finalizarEmision() {
        super.finalizarEmision();
        System.out.println("En : " +getUrl());
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
