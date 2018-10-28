package modelo;

import java.util.ArrayList;
import java.util.List;

import excepciones.SintaxisException;

/**
 * Clase que representa el diagrama completo que está construyendo el usuario.
 * @author Santiago
 *
 */
public class Composicion {
	
	// ------------------------------------------------------------------------------------------
	// Constantes
	// ------------------------------------------------------------------------------------------
	
	
	
	// ------------------------------------------------------------------------------------------
	// Atributos
	// ------------------------------------------------------------------------------------------
	
	/**
	 * Representa los bloques creados por el usuario. Un bloque se considera una agrupación de
	 * figuras geométricas.
	 */
	private ArrayList<Bloque> bloques;
	
	/**
	 * Representa la lista de figuras geométricas que han sido dibujadas por el usuario.
	 */
	private ArrayList<Figura> figurasGeometricas;
	
	// ------------------------------------------------------------------------------------------
	// Servicios
	// ------------------------------------------------------------------------------------------
	
	/**
	 * Método que se encarga de dar la lista de bloques creadas por el usuario.
	 * @return la lista de bloques que ha creado el usuario.
	 */
	public List<Bloque> darBloques() {
		return bloques;
	}
	
	/**
	 * Método que se encarga de dar la lista de figuras geométricas dibujadas por el usuario.
	 * @return la lista de figuras que ha dibujado el usuario.
	 */
	public List<Figura> darFigurasGeometricas() {
		return figurasGeometricas;
	}
	
	/**
	 * Método que se encarga de registrar un bloque con el nombre especificado y las figuras
	 * hijas seleccionadas.
	 * @param nombre - es el nombre que identificará al bloque.
	 * @param figuras - es la lista de figuras que serán cubiertas por el bloque.
	 */
	public void agregarBloque(String nombre, List<Figura> figuras) throws Exception {
		for (Figura f : figuras) {
			if (f instanceof Ovalo) {
				throw new Exception ("Los dominios no pueden hacer parte del bloque");
			}
		}
		
	}
	
	public void agregarFiguraGeometrica() throws SintaxisException {
		
	}
	
	
}
