/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author hubert
 */
public class NuestraExcepcion extends Exception {

    /**
     * Creates a new instance of <code>NuestraExcepcion</code> without detail
     * message.
     */
    public NuestraExcepcion() {
    }

    /**
     * Constructs an instance of <code>NuestraExcepcion</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NuestraExcepcion(String msg) {
        super(msg);
    }
}
