import java.util.Scanner;

/**
 *
 * @author hz
 */
public class Exercise144 {

    /**
     * @param args the command line arguments
     */
    static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) {
        
        while(teclado.hasNext()) {
            tratarCaso();
        }
    }
    private static void tratarCaso() {
        
        String [] notaciones = {"","UpperCase" , "SnakeCase" , "KebabCase"};
        
        int tipoNotacionInicial = 0; // 1-Uppercase , 2 Snakecase, 3 KebabCase
        
        String variable = teclado.nextLine();
        String notacion = teclado.nextLine();
        
        int tipoNotacionResultado = 0;
        System.out.println(variable + " " + notacion);
       
        Character car = variable.charAt(0);
        Character.isUpperCase(variable.charAt(0));
        
        boolean mayuscula = Character.isUpperCase(variable.charAt(0));
        
        if(variable.charAt(0) > 'A' && variable.charAt(0) <='Z') {
             tipoNotacionInicial = 1;
        } 
        else if(variable.indexOf("_") != -1) { ///////Cambiar indexOf por .contains
                tipoNotacionInicial = 2;
            }
        else if(variable.indexOf("-") != -1) { ////Cambiar indexOf por .contains
            tipoNotacionInicial = 3;
        
        }
        // else { tipo notaion 3 } y consideramos kebab para J que tiene un hueco y fini
        
        System.out.println(notaciones[tipoNotacionInicial]);
        
        if ((tipoNotacionInicial == 2) && notacion.equals("Kebab-case")) {
            String resultado = variable.replaceAll("_", "-");
            System.out.println(resultado);
        }
        else if (tipoNotacionInicial == 3 && notacion.equals("snake_case")) {
            String resultado = variable.replaceAll("-", "_");
            System.out.println(resultado);
        }
        else if ((tipoNotacionInicial==1) && notacion.equals("snake_case")) {
            
            String resultado="";
            for (int i = 0; i < variable.length(); i++) {
                if(variable.charAt(i)< 'A' &&  variable.charAt(i)>='Z') {
                    resultado+="_" + variable.charAt(i) +32; /// +('a'-'A')
                }
                else {
                    resultado+= variable.charAt(i);
                }
            }
            System.out.println(resultado);
        }
    }
    
}
