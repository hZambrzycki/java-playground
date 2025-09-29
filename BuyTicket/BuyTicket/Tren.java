/**
 *
 * @author hz
 */
public class Tren {
     private int capacidad;
    private String[] listaAsientos;

    public Tren(int capacidad) {
        this.capacidad = capacidad;
        listaAsientos = new String[this.capacidad];
        for (int i = 0; i < listaAsientos.length; i++) {
            listaAsientos[i] = "vacio";
        }
    }
     public int reservarAsiento(String dni, int asiento) {
         if(asiento >= capacidad) {
             return -1;
         } else {
             for (int i = 0; i < listaAsientos.length; i++) {
                 if(dni.compareTo(listaAsientos[i]) == 0) {
                     return 3;
                 }
             }
            if(listaAsientos[asiento].compareTo("vacio") == 0) {
                listaAsientos[asiento] = dni;
                return 1;
            } else {
                return 2;
            }
         }
     }
     
     public boolean anularReserva(String dni) {
         boolean Reserva = false;
         
         for (int i = 0; i < listaAsientos.length; i++) {
             if(dni.compareTo(listaAsientos[i]) == 0) {
                 listaAsientos[i] = "vacio";
                 Reserva = true;
             }
         }
         return Reserva;
     }
}
