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
	 * Versi�n de serializaci�n
	 */
	private static final long serialVersionUID = 6097697081296558258L;

	/**
	 * Representa la anchura por defecto del rect�ngulo
	 */
	public final static int ANCHO_POR_DEFECTO = 130;
	
	/**
	 * Representa la altura por defecto del rect�ngulo
	 */
	public final static int ALTO_POR_DEFECTO = 130;
	
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
		this.posicionX -= ancho / 2;
		this.posicionY -= alto / 2;
		figurasHijas = new ArrayList<>();
		representacion = new Rectangle2D.Double(this.posicionX, this.posicionY, ANCHO_POR_DEFECTO, ALTO_POR_DEFECTO);
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
		if ((ancho - RAZON_CAMBIO_TAMA�O) > ANCHO_POR_DEFECTO) {
			super.disminuirAncho();
			actualizarRepresentacion();
		}
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
		if ((alto - RAZON_CAMBIO_TAMA�O) > ALTO_POR_DEFECTO) {
			super.disminuirAlto();
			actualizarRepresentacion();			
		}
	}
	
	private void actualizarRepresentacion() {
		representacion = new Rectangle2D.Double(posicionX, posicionY, ancho, alto);
	}
	
	public void agregarHija(Figura f) {
		if (!figurasHijas.contains(f)) {
			figurasHijas.add(f);
		}
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
