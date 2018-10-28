package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa a un conjunto de figuras geom�tricas.
 * @author Santiago
 *
 */
public class Bloque {
	
	// ------------------------------------------------------------------------------------------
	// Constantes
	// ------------------------------------------------------------------------------------------
	
	
	
	// ------------------------------------------------------------------------------------------
	// Atributos
	// ------------------------------------------------------------------------------------------
	
	/**
	 * Representa el nombre con el cual se identificar� el bloque.
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
	 * M�todo que se encarga de dar el nombre del bloque.
	 * @return cadena que representa nombre del bloque.
	 */
	public String darNombre() {
		return nombre;
	}
	
	/**
	 * M�todo que se encarga de dar la lista de figuras hijas.
	 * @return lista que representa las figuras que hacen parte del bloque
	 */
	public List<Figura> darFigurasHijas() {
		return figurasHijas;
	}
	

}
