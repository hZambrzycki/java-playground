
public class ClerigoException extends PersonajeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3429629664968309618L;
	private int tipo;

	public ClerigoException(String mensajeError, int tipo) {
		super(mensajeError);
		this.tipo = tipo;
	}

	public int getTipo() {
		return tipo;
	}

}
