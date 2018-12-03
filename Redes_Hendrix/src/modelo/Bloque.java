package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa a un conjunto de figuras geométricas.
 * @author Santiago
 *
 */
public class Bloque implements Serializable {
	
	// ------------------------------------------------------------------------------------------
	// Constantes
	// ------------------------------------------------------------------------------------------
	
	/**
	 * Versión de serialización
	 */
	private static final long serialVersionUID = -7066661952090117912L;
	
	
	// ------------------------------------------------------------------------------------------
	// Atributos
	// ------------------------------------------------------------------------------------------
	

	/**
	 * Representa el nombre con el cual se identificará el bloque.
	 */
	private String nombre;
	
	/**
	 * Representa las figuras que hacen parte del bloque.
	 */
	private ArrayList<Figura> figurasHijas;
	
	// ------------------------------------------------------------------------------------------
	// Servicios
	// ------------------------------------------------------------------------------------------
	
	/**
	 * Método que se encarga de dar el nombre del bloque.
	 * @return cadena que representa nombre del bloque.
	 */
	public String darNombre() {
		return nombre;
	}
	
	/**
	 * Método que se encarga de dar la lista de figuras hijas.
	 * @return lista que representa las figuras que hacen parte del bloque
	 */
	public List<Figura> darFigurasHijas() {
		return figurasHijas;
	}
	

}
