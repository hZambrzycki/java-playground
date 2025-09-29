
public class Clerigo extends Personaje {

	private String nombreDios;
	private final int I_MENOR = 10;
	private final int I_MAYOR = 20;
	private final int F_MAYOR = 5;

	public Clerigo(String nombre, String raza, int fuerza, int inteligencia, int puntosVidaMax, int puntosVidaActuales,
			String nombreDios) {
		super(nombre, raza, fuerza, inteligencia, puntosVidaMax, puntosVidaActuales);
		
		if(inteligencia< I_MENOR) {
			throw new ClerigoException("La inteligencia de un cl�rigo no puede ser menor que "+I_MENOR, 1);
		}
		if(fuerza>F_MAYOR) {
			throw new ClerigoException("La fuerza de un cl�rigo no puede ser mayor que "+F_MAYOR, 2);
		}
		if(inteligencia> I_MAYOR) {
			throw new ClerigoException("La inteligencia de un cl�rigo no puede ser mayor que "+I_MAYOR, 3);
		}
				
		this.nombreDios = nombreDios;
	}

	public boolean curar(Personaje personaje) {

		if (personaje == null) {
			return false;
		}

		personaje.setPuntosVidaActuales(personaje.getPuntosVidaActuales() + 11);

		return true;
	}
	
	@Override
	public int calcularPoderPersonaje() {
		return super.calcularPoderPersonaje();
	}

	@Override
	public String toString() {
		return super.toString()+ " Cl�rigo [nombreDios=" + nombreDios + "Poder Cl�rigo: " + calcularPoderPersonaje() + "]";
	}

}
