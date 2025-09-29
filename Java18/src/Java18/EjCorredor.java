package ejcorredor;

/**
 *
 * @author hz
 */
public class EjCorredor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Corredor X = new Corredor(90);
     
        System.out.println("Introduzca la energia del deportista");
        System.out.println(X.getEnergia());
        System.out.println("Verificamos la energia");
        System.out.println(X.verificarEnergia(90));
        System.out.println("Corremos");
        X.correr();
        System.out.println("Al correr, hemos gastado energia, la energia actual es: ");
        System.out.println(X.getEnergia());
        System.out.println("Entrenamos para recargar la energia");
        X.entrenar();
        System.out.println("Despues de entrenar, hemos restablecido la energia y actualmente es: ");
        System.out.println(X.getEnergia());
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }
    
}
