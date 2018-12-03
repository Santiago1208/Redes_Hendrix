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
	 * Versión de serialización
	 */
	private static final long serialVersionUID = -2188907686501112302L;
	
	/**
	 * Representa el radio por defecto del círculo
	 */
	public final static int RADIO_POR_DEFECTO = 60;
		
	// ------------------------------------------------------------------------------------------
	// Atributos
	// ------------------------------------------------------------------------------------------
	
	private Rectangulo padre;
	
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
	public Circulo(int posicionX, int posicionY, String etiqueta, Long momentoCreacion, Rectangulo padre) {
		super(posicionX, posicionY, etiqueta, momentoCreacion);
		ancho = RADIO_POR_DEFECTO;
		alto = RADIO_POR_DEFECTO;
		this.etiqueta = etiqueta;
		this.posicionX += ancho / 2;
		this.posicionY += alto / 2;
		representacion = new Ellipse2D.Double(this.posicionX, this.posicionY, RADIO_POR_DEFECTO, RADIO_POR_DEFECTO);
		this.modificarPadre(padre);
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
	
	public Rectangulo darPadre() {
		return padre;
	}

	public void modificarPadre(Rectangulo padre) {
		this.padre = padre;
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
	public void modificarAlto(int nuevoAlto) {
		super.modificarAlto(nuevoAlto);
		actualizarRepresentacion();
	}
	
	@Override
	public void aumentarAlto() {
		super.aumentarAlto();
		actualizarRepresentacion();
	}
	
	@Override
	public void disminuirAlto() {
		if ((alto - RAZON_CAMBIO_TAMAÑO) > RADIO_POR_DEFECTO) {
			super.disminuirAlto();
			actualizarRepresentacion();			
		}
	}
	
	
	private void actualizarRepresentacion() {
		representacion = new Ellipse2D.Double(posicionX, posicionY, ancho, alto);
	}
}
