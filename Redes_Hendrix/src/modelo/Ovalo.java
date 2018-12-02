package modelo;

import java.awt.geom.Ellipse2D;

/**
 * Clase que representan los dominios de la red
 * @author Santiago Restrepo & Andres Zapata
 *
 */
public class Ovalo extends Figura {

	
	// ------------------------------------------------------------------------------------------
	// Constantes
	// ------------------------------------------------------------------------------------------

	/**
	 * Representa la ancho por defecto del óvalo
	 */
	public final static int ANCHO_POR_DEFECTO = 80;
	
	/**
	 * Representa la altura por defecto del óvalo
	 */
	public final static int ALTO_POR_DEFECTO = 60;
	
	// ------------------------------------------------------------------------------------------
	// Atributos
	// ------------------------------------------------------------------------------------------
	
	
	
	// ------------------------------------------------------------------------------------------
	// Constructor
	// ------------------------------------------------------------------------------------------

	public Ovalo(int posicionX, int posicionY, String etiqueta, Long momentoCreacion) {
		super(posicionX, posicionY, etiqueta, momentoCreacion);
		ancho = ANCHO_POR_DEFECTO;
		alto = ALTO_POR_DEFECTO;
		this.posicionX -= ancho / 2;
		this.posicionY -= alto / 2;
		this.etiqueta = etiqueta;
		representacion = new Ellipse2D.Double(this.posicionX, this.posicionY, ANCHO_POR_DEFECTO, ALTO_POR_DEFECTO);
	}
	// ------------------------------------------------------------------------------------------
	// Servicios
	// ------------------------------------------------------------------------------------------

	@Override
	public void modificarPosicionX(int nuevaPosicionX) {
		super.modificarPosicionX(nuevaPosicionX);
		representacion = new Ellipse2D.Double(posicionX, posicionY, ANCHO_POR_DEFECTO, ALTO_POR_DEFECTO);
	}
	
	@Override
	public void modificarPosicionY(int nuevaPosicionY) {
		super.modificarPosicionY(nuevaPosicionY);
		representacion = new Ellipse2D.Double(posicionX, posicionY, ANCHO_POR_DEFECTO, ALTO_POR_DEFECTO);
	}
}
