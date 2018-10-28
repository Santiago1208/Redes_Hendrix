package excepciones;

/**
 * Clase que representa los errores de sintaxis cuando se construye el diagrama.
 * @author Santiago
 *
 */
public class SintaxisException extends Exception {

	/**
	 * Versión de serialización
	 */
	private static final long serialVersionUID = 6823561595436937680L;
	
	// ------------------------------------------------------------------------------------------
	// Constructor
	// ------------------------------------------------------------------------------------------
	
	/**
	 * Construye la excepción con el mensaje especificado.
	 * @param mensaje - Es aquel que contiene la causa de la excepción.
	 */
	public SintaxisException(String mensaje) {
		super(mensaje);
	}

}
