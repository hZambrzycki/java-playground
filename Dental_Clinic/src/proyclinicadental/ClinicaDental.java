/**
 *
 * @author hz
 */
public class ClinicaDental {

    private final int MAX_ELEMENTOS = 4;
    private Paciente[] listaPacientes;
    private int indice;

    public ClinicaDental() {

        listaPacientes = new Paciente[MAX_ELEMENTOS];
        indice = 0;
    }

    public ClinicaDental(int maxElementos) {
        listaPacientes = new Paciente[maxElementos];
        indice = 0;
    }

    public boolean agregarPaciente(Paciente p) {
        //Comprobar nulos
        if (p==null) {
            return false;
        }
        
        //COmprobar que el paciente no est� en la lista
        if (consultarPaciente(p)!=-1) {
            return false;
        }
     
        if (indice < listaPacientes.length) {
            listaPacientes[indice] = p;
            indice++;
            return true;
        }
        return false;
    }

    public int consultarPaciente(Paciente p) {
        //Comprobar nulos
        if (p==null) {
            return -1;
        }
        for (int i = 0; i < indice; i++) {
            if (p.getNombre().equals(listaPacientes[i].getNombre())
                && p.getApellido().equals(listaPacientes[i].getApellido())) {
                return i;
            }
        }
        return -1;
    }

    public void ordenarListaPacientes() {

        for (int i = 1; i < listaPacientes.length; i++) {
            boolean ordenado = true;
            for (int j = 0; j < listaPacientes.length - i; j++) {
                if (listaPacientes[j + 1].getApellido().
                        compareTo(listaPacientes[j].getApellido()) < 0) {
                    // Intercambio (swapping)
                    Paciente aux = listaPacientes[j + 1];
                    listaPacientes[j + 1] = listaPacientes[j];
                    listaPacientes[j] = aux;
                    ordenado = false;
                }
            }
            if (ordenado) {
                return;
            }
        }
    }
    
    public void imprimirClinicaDental(){
        for (int i=0; i<listaPacientes.length-1; i++) {
            System.out.print(listaPacientes[i]+ "-");
        }
        System.out.println(listaPacientes[listaPacientes.length-1]);
    }
}
