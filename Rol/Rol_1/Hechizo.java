
public class Hechizo {

	private String tipoHechizo;
	private int potencia;
	
	
	
	public Hechizo(String tipoHechizo, int potencia) {
		super();
		this.tipoHechizo = tipoHechizo;
		this.potencia = potencia;
	}


	@Override
	public String toString() {
		return "Hechizo [tipoHechizo=" + tipoHechizo + ", potencia=" + potencia + "]";
	}



	public String getTipoHechizo() {
		return tipoHechizo;
	}



	public void setTipoHechizo(String tipoHechizo) {
		this.tipoHechizo = tipoHechizo;
	}



	public int getPotencia() {
		return potencia;
	}



	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}



}
