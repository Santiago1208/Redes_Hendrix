package modelo;

import java.awt.geom.Ellipse2D;

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
	 * Representa el radio por defecto del c�rculo
	 */
	public final static int RADIO_POR_DEFECTO = 60;
		
	// ------------------------------------------------------------------------------------------
	// Atributos
	// ------------------------------------------------------------------------------------------
	
	// ------------------------------------------------------------------------------------------
	// Constructor
	// ------------------------------------------------------------------------------------------
	
	/**
	 * Construye un c�rculo en la posici�n X y Y especificados y con la etiqueta
	 * especificada.
	 * @param posicionX - Es la coordenada x del punto donde se ubicar� el c�rculo.
	 * @param posicionY - Es la coordenada y del punto donde se ubicar� el c�rculo.
	 * @param etiqueta  - Es el contenido sem�ntico que estar� dentro del c�rculo.
	 */
	public Circulo(int posicionX, int posicionY, String etiqueta, Long momentoCreacion) {
		super(posicionX, posicionY, etiqueta, momentoCreacion);
		ancho = RADIO_POR_DEFECTO;
		alto = RADIO_POR_DEFECTO;
		this.etiqueta = etiqueta;
		this.posicionX -= ancho / 2;
		this.posicionY -= alto / 2;
		representacion = new Ellipse2D.Double(this.posicionX, this.posicionY, RADIO_POR_DEFECTO, RADIO_POR_DEFECTO);
	}
	
	// ------------------------------------------------------------------------------------------
	// Servicios
	// ------------------------------------------------------------------------------------------
	
	
	@Override
	public void modificarPosicionX(int nuevaPosicionX) {
		super.modificarPosicionX(nuevaPosicionX);
		representacion = new Ellipse2D.Double(posicionX, posicionY, RADIO_POR_DEFECTO, RADIO_POR_DEFECTO);
	}
	
	@Override
	public void modificarPosicionY(int nuevaPosicionY) {
		super.modificarPosicionY(nuevaPosicionY);
		representacion = new Ellipse2D.Double(posicionX, posicionY, RADIO_POR_DEFECTO, RADIO_POR_DEFECTO);
	}
}
