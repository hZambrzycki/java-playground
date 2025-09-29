/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cifradorot13;

/**
 *
 * @author hz
 */
public class Mensaje {

    private String mensaje;

    public Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String cifrar(int nPosiciones) {

        String aux = "";

        for (int i = 0; i < this.mensaje.length(); i++) {
            if (this.mensaje.charAt(i) >= 97 || this.mensaje.charAt(i) >= 122) {
                if (this.mensaje.charAt(i) + nPosiciones > 122) {
                    aux += (char) (this.mensaje.charAt(i) + nPosiciones - 26);
                } else {
                    aux += (char) (this.mensaje.charAt(i) + nPosiciones);
                }
            } else {
                if (this.mensaje.charAt(i) + nPosiciones > 90) {
                    aux += (char) (this.mensaje.charAt(i) + nPosiciones - 26);
                } else {
                    aux += (char) (this.mensaje.charAt(i) + nPosiciones);
                }
            }
        }

        this.mensaje = aux;
        return aux;
    }

    public String desCifrar(int nPosiciones) {
        String aux = "";

        for (int i = 0; i < this.mensaje.length(); i++) {
            if (this.mensaje.charAt(i) >= 97 || this.mensaje.charAt(i) >= 122) {
                if (this.mensaje.charAt(i) - nPosiciones < 97) {
                    aux += (char) (this.mensaje.charAt(i) - nPosiciones + 26);
                } else {
                    aux += (char) (this.mensaje.charAt(i) - nPosiciones);
                }
            } else {
                if (this.mensaje.charAt(i) - nPosiciones < 65) {
                    aux += (char) (this.mensaje.charAt(i) - nPosiciones + 26);
                } else {
                    aux += (char) (this.mensaje.charAt(i) - nPosiciones);
                }
            }
        }
        this.mensaje = aux;
        return aux;
    }
}
