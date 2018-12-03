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
	 * Versión de serialización
	 */
	private static final long serialVersionUID = 1076767420182914319L;

	/**
	 * Representa la ancho por defecto del óvalo
	 */
	public final static int ANCHO_POR_DEFECTO = 110;
	
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
		actualizarRepresentacion();
	}
	
	@Override
	public void modificarPosicionY(int nuevaPosicionY) {
		super.modificarPosicionY(nuevaPosicionY);
		actualizarRepresentacion();
	}
	
	@Override
	public void aumentarAncho() {
		super.aumentarAncho();
		actualizarRepresentacion();
	}
	
	@Override
	public void disminuirAncho() {
		super.disminuirAncho();
		actualizarRepresentacion();
	}
	
	@Override
	public void modificarAncho(int nuevoAncho) {
		super.modificarAncho(nuevoAncho);
		actualizarRepresentacion();
	}
	
	@Override
	public void aumentarAlto() {
		super.aumentarAlto();
		actualizarRepresentacion();
	}
	
	@Override
	public void disminuirAlto() {
		if ((alto - RAZON_CAMBIO_TAMAÑO) > ALTO_POR_DEFECTO) {
			super.disminuirAlto();
			actualizarRepresentacion();
		}
	}
	
	private void actualizarRepresentacion() {
		representacion = new Ellipse2D.Double(posicionX, posicionY, ancho, alto);
	}

	@Override
	public int compareTo(Figura o) {
		if (momentoCreacion < o.momentoCreacion) {
			return -1;
		} else if (momentoCreacion > o.momentoCreacion) {
			return 1;
		} else {
			return 0;
		}
	}
}
