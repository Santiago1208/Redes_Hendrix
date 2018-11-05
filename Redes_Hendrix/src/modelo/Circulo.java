package modelo;

import java.util.ArrayList;
import java.awt.geom.Rectangle2D;

/**
 * Clase que representa las variables y las constantes de la red
 * @author Santiago Restrepo & Andres Zapata
 *
 */
public class Circulo extends Figura {
	
	// ------------------------------------------------------------------------------------------
	// Constantes
	// ------------------------------------------------------------------------------------------
	
	/**
	 * Representa el radio por defecto del círculo
	 */
	public final static int RADIO_POR_DEFECTO = 60;
		
	// ------------------------------------------------------------------------------------------
	// Atributos
	// ------------------------------------------------------------------------------------------
	
	// ------------------------------------------------------------------------------------------
	// Constructor
	// ------------------------------------------------------------------------------------------
	
	/**
	 * Construye un círculo en la posición X y Y especificados y con la etiqueta
	 * especificada.
	 * @param posicionX - Es la coordenada x del punto donde se ubicará el círculo.
	 * @param posicionY - Es la coordenada y del punto donde se ubicará el círculo.
	 * @param etiqueta  - Es el contenido semántico que estará dentro del círculo.
	 */
	public Circulo(int posicionX, int posicionY, String etiqueta, Long momentoCreacion) {
		super(posicionX, posicionY, etiqueta, momentoCreacion);
		ancho = RADIO_POR_DEFECTO;
		alto = RADIO_POR_DEFECTO;
		
		representacion = new Rectangle2D.Double(posicionX, posicionY, RADIO_POR_DEFECTO, RADIO_POR_DEFECTO);

	}
	
	// ------------------------------------------------------------------------------------------
	// Servicios
	// ------------------------------------------------------------------------------------------

}
