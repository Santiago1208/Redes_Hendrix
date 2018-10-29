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
	 * Representa la anchura por defecto del rectángulo
	 */
	public final static int ANCHO_POR_DEFECTO = 80;
	
	/**
	 * Representa la altura por defecto del rectángulo
	 */
	public final static int ALTO_POR_DEFECTO = 60;
	
	// ------------------------------------------------------------------------------------------
	// Atributos
	// ------------------------------------------------------------------------------------------
	
	/**
	 * Representan las figuras que pueden estar dentro del rectángulo.
	 */
	private ArrayList<Figura> figurasHijas;
	
	// ------------------------------------------------------------------------------------------
	// Constructor
	// ------------------------------------------------------------------------------------------
	
	/**
	 * Construye un rectángulo en la posición X y Y especificados y con la etiqueta
	 * especificada.
	 * @param posicionX - Es la coordenada x del punto donde se ubicará el rectángulo.
	 * @param posicionY - Es la coordenada y del punto donde se ubicará el rectángulo.
	 * @param etiqueta - Es el contenido semántico que estará dentro del rectángulo.
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
	 * Retorna las figuras hijas del rectángulo.
	 * @return la lista de figuras hijas del rectángulo.
	 */
	public List<Figura> darFigurasHijas() {
		return figurasHijas;
	}

}
