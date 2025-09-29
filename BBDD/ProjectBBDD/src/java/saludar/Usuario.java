/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saludar;

/**
 *
 * @author hz
 */
public class Usuario {

    private String n;
    private String p;
    private String e;

    public Usuario(String n, String p, String e) {
        this.n = n;
        this.p = p;
        this.e = e;
    }

    public String getN() {
        return n;
    }

    public String getP() {
        return p;
    }

    public String getE() {
        return e;
    }

}
