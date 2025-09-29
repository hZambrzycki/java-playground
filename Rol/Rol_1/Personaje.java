
public class Personaje implements Rol{

	private String nombre;
	private String raza;
	private int fuerza;
	private int inteligencia;
	private int puntosVidaMax;
	private int puntosVidaActuales;
	
	public Personaje(String nombre, String raza, int fuerza, int inteligencia, int puntosVidaMax,
			int puntosVidaActuales) {
		super();
		this.nombre = nombre;
		this.raza = raza;
		this.fuerza = fuerza;
		this.inteligencia = inteligencia;
		this.puntosVidaMax = puntosVidaMax;
		this.puntosVidaActuales = puntosVidaActuales;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(int inteligencia) {
		this.inteligencia = inteligencia;
	}

	public int getPuntosVidaMax() {
		return puntosVidaMax;
	}

	public void setPuntosVidaMax(int puntosVidaMax) {
		this.puntosVidaMax = puntosVidaMax;
	}

	public int getPuntosVidaActuales() {
		return puntosVidaActuales;
	}

	public void setPuntosVidaActuales(int puntosVidaActuales) {
		this.puntosVidaActuales = puntosVidaActuales;
	}

	
	
	@Override
	public String toString() {
		return "Personaje [nombre=" + nombre + ", raza=" + raza + ", fuerza=" + fuerza + ", inteligencia="
				+ inteligencia + ", puntosVidaMax=" + puntosVidaMax + ", puntosVidaActuales=" + puntosVidaActuales
				+ "]";
	}

	@Override
	public int calcularPoderPersonaje() {
		int fuerza = getFuerza();
		int inteligencia = getInteligencia();
		int puntosVida = getPuntosVidaActuales();

		return ((fuerza * inteligencia) + puntosVida);
	}
	
	
	
}
