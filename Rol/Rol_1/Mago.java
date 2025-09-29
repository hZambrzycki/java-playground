import java.util.Arrays;

public class Mago extends Personaje {

	private int numeroMaxHechizos;
	private int numeroHechizosConocidos;
	private final int I_MENOR = 10;
	private final int F_MAYOR = 5;
	private Hechizo[] hechizos;

	public Mago(String nombre, String raza, int fuerza, int inteligencia, int puntosVidaMax, int puntosVidaActuales,
			int numeroMaxHechizos, Hechizo[] hechizos) {		
		super(nombre, raza, fuerza, inteligencia, puntosVidaMax, puntosVidaActuales);
		if(inteligencia< I_MENOR) {
			throw new MagoException("La inteligencia de un mago no puede ser menor que "+I_MENOR, 1);
		}
		if(fuerza>F_MAYOR) {
			throw new MagoException("La fuerza de un mago no puede ser mayor que "+F_MAYOR, 2);
		}
		this.numeroMaxHechizos = numeroMaxHechizos;
		
		if(hechizos!=null && hechizos.length == numeroMaxHechizos) {
		this.hechizos = hechizos;
		}else {
			this.hechizos = new Hechizo[numeroMaxHechizos];
		}
	}

	public boolean aprendeHechizo(Hechizo nuevoHechizo) {
		if (numeroHechizosConocidos < numeroMaxHechizos) {
			hechizos[numeroHechizosConocidos] = nuevoHechizo;
			numeroHechizosConocidos++;
			return true;
		} else {
			return false;
		}
	}

	public void lanzaHechizo(Personaje personajeObjetivo) throws HechizoException{
		if (personajeObjetivo == null) {
			throw new HechizoException("No existe el objetivo");
		}
		
		if(numeroHechizosConocidos == 0) {
			throw new HechizoException("No quedan hechizos");
		}

		int vidaActualPersonaje = personajeObjetivo.getPuntosVidaActuales();
		int potenciaHechizoUsado = hechizos[0].getPotencia();

		personajeObjetivo.setPuntosVidaActuales(vidaActualPersonaje - potenciaHechizoUsado);

		hechizos[0] = null;
		numeroHechizosConocidos--;
		reordenarHechizos();		
	}

	public void lanzaHechizo(Personaje personajeObjetivo, Hechizo hechizoLanzado) throws HechizoException{
		if (personajeObjetivo == null) {
			throw new HechizoException("No existe el objetivo");
		}
		if (hechizoLanzado == null) {
			throw new HechizoException("No existe el hechizo");
		}

		if(numeroHechizosConocidos == 0) {
			throw new HechizoException("No quedan hechizos");
		}
		
		int posicionHechizo = buscarHechizo(hechizoLanzado);
		if (posicionHechizo == -1) {
			throw new HechizoException("El mago no tiene ese hechizo");
		}
		int vidaActualPersonaje = personajeObjetivo.getPuntosVidaActuales();
		int potenciaHechizoUsado = hechizos[posicionHechizo].getPotencia();

		personajeObjetivo.setPuntosVidaActuales(vidaActualPersonaje - potenciaHechizoUsado);

		hechizos[posicionHechizo] = null;
		numeroHechizosConocidos--;
		reordenarHechizos();		
	}

	private void reordenarHechizos() {
		for (int i = 0; i < hechizos.length; i++) {
			if (hechizos[i] != null) {
				if (i > 0 && hechizos[i - 1] == null) {
					hechizos[i - 1] = hechizos[i];
					hechizos[i]=null;					
				}
			}
		}
	}

	private int buscarHechizo(Hechizo hechizo) {
		for (int i = 0; i < hechizos.length; i++) {
			if (hechizos[i] == hechizo) {
				return i;
			}
		}
		return -1;
	}

	private int calcularPotenciaAcumuladaHechizos() {
		int potenciaAcumulada = 0;
		for (int i = 0; i < hechizos.length; i++) {
			if (hechizos[i] != null) {
				potenciaAcumulada += hechizos[i].getPotencia();
			}
		}
		return potenciaAcumulada;
	}


	@Override
	public int calcularPoderPersonaje() {	
		int potenciaAcumuladaDeHechizosConocidos = calcularPotenciaAcumuladaHechizos();
		return super.calcularPoderPersonaje()+ potenciaAcumuladaDeHechizosConocidos;
	}
	

	@Override
	public String toString() {
		return super.toString()+" Mago [numeroMaxHechizos=" + numeroMaxHechizos + ", numeroHechizosConocidos=" + numeroHechizosConocidos
				+ ", hechizos=" + Arrays.toString(hechizos) + "Poder Mago: " + calcularPoderPersonaje() + "]";
	}

}
