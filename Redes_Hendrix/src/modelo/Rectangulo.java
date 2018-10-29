package modelo;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa a los espacios de la red
 * @author Santiago
 *
 */
public class Rectangulo extends Figura {

	
	// ------------------------------------------------------------------------------------------
	// Constantes
	// ------------------------------------------------------------------------------------------
	
	/**
	 * Representa la anchura por defecto del rect�ngulo
	 */
	public final static int ANCHO_POR_DEFECTO = 80;
	
	/**
	 * Representa la altura por defecto del rect�ngulo
	 */
	public final static int ALTO_POR_DEFECTO = 60;
	
	// ------------------------------------------------------------------------------------------
	// Atributos
	// ------------------------------------------------------------------------------------------
	
	/**
	 * Representan las figuras que pueden estar dentro del rect�ngulo.
	 */
	private ArrayList<Figura> figurasHijas;
	
	// ------------------------------------------------------------------------------------------
	// Constructor
	// ------------------------------------------------------------------------------------------
	
	/**
	 * Construye un rect�ngulo en la posici�n X y Y especificados y con la etiqueta
	 * especificada.
	 * @param posicionX - Es la coordenada x del punto donde se ubicar� el rect�ngulo.
	 * @param posicionY - Es la coordenada y del punto donde se ubicar� el rect�ngulo.
	 * @param etiqueta - Es el contenido sem�ntico que estar� dentro del rect�ngulo.
	 */
	public Rectangulo(int posicionX, int posicionY, String etiqueta, Long creacion) {
		super(posicionX, posicionY, etiqueta, creacion);
		ancho = ANCHO_POR_DEFECTO;
		alto = ALTO_POR_DEFECTO;
		figurasHijas = new ArrayList<>();
		representacion = new Rectangle2D.Double(posicionX, posicionY, ANCHO_POR_DEFECTO, ALTO_POR_DEFECTO);
	}
	
	// ------------------------------------------------------------------------------------------
	// Servicios
	// ------------------------------------------------------------------------------------------
	
	/**
	 * Retorna las figuras hijas del rect�ngulo.
	 * @return la lista de figuras hijas del rect�ngulo.
	 */
	public List<Figura> darFigurasHijas() {
		return figurasHijas;
	}

}
