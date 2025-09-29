/**
 *
 * @author hz
 */
public class ProyClinicaDental {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Paciente p1 = new Paciente("Federico", "G�mez");
        Paciente p2 = new Paciente("Pepa", "Flores");
        Paciente p3 = new Paciente("Juan", "Bravo");
        Paciente p4 = new Paciente("Carlos", "G�mez");
        Paciente p5 = new Paciente("Ana", "Mart�nez");
        
        ClinicaDental cl = new ClinicaDental();
        
        cl.agregarPaciente(p1);
        cl.agregarPaciente(p2);
        cl.agregarPaciente(p3);
        cl.agregarPaciente(p4);
        
        cl.imprimirClinicaDental();
        
        cl.ordenarListaPacientes();
        
        cl.imprimirClinicaDental();
        
        
        
    }
    
}
