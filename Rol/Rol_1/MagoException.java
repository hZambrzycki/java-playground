
public class MagoException extends PersonajeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8816425975308318998L;
	private int tipo;
	public MagoException(String mensajeError, int tipo) {
		super(mensajeError);
		this.tipo = tipo;
	}
	public int getTipo() {
		return tipo;
	}	

}
