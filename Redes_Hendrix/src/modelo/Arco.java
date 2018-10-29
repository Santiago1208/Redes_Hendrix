package modelo;

/**
 * Clase que representa la relación entre dos figuras geométricas.
 * @author Santiago
 *
 */
public class Arco {
	
	// ------------------------------------------------------------------------------------------
	// Constantes
	// ------------------------------------------------------------------------------------------
	
	
	
	// ------------------------------------------------------------------------------------------
	// Atributos
	// ------------------------------------------------------------------------------------------
	
	/**
	 * Representa el contenido semántico del arco.
	 */
	private String etiqueta;
	
	/**
	 * Representa la coordenda x del primer punto por el cual pasa el arco.
	 */
	private Double posicionX1;
	
	/**
	 * Repremodificarna la coordenada y del primer punto por el cual pasa el arco.
	 */
	private Double posicionY1;
	
	/**
	 * Representa la coordenada x del segundo punto por el cual pasa el arco.
	 */
	private Double posicionX2;
	
	/**
	 * Representa la coordenada y del segundo punto por el cual pasa el arco.
	 */
	private Double posicionY2;
	
	/**
	 * Representa la figura a la cual llega el arco.
	 */
	private Figura figuraDestino;

	
	// ------------------------------------------------------------------------------------------
	// Constructor
	// ------------------------------------------------------------------------------------------
	
	/**
	 * Construye un arco que inicia en un punto P1 y termina en otro punto P2 con la etiqueta 
	 * especificada.
	 * @param etiqueta - Es el contenido semántico del arco.
	 * @param x1 - Es la coordenada x de P1.
	 * @param y1 - Es la coordenada y de P1.
	 * @param x2 - Es la coordenada x de P2.
	 * @param y2 - Es la coordenada y de P2.
	 * @param destino - Es la figura a la cual apunta el arco
	 */
	public Arco(String etiqueta, Double x1, Double y1, Double x2, Double y2, Figura destino) {
		this.etiqueta = etiqueta;
		posicionX1 = x1;
		posicionY1 = y1;
		posicionX2 = x2;
		posicionY2 = y2;
		figuraDestino = destino;
	}
	
	// ------------------------------------------------------------------------------------------
	// Servicios
	// ------------------------------------------------------------------------------------------
	
	public String darEtiqueta() {
		return etiqueta;
	}
	
	public void modificarEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}
	
	public Double darPosicionX1() {
		return posicionX1;
	}
	
	public void modificarPosicionX1(Double posicionX1) {
		this.posicionX1 = posicionX1;
	}
	
	public Double darPosicionX2() {
		return posicionX2;
	}
	
	public void modificarPosicionX2(Double posicionX2) {
		this.posicionX2 = posicionX2;
	}
	
	public Double darPosicionY1() {
		return posicionY1;
	}
	
	public void modificarPosicionY1(Double posicionY1) {
		this.posicionY1 = posicionY1;
	}
	
	public Double darPosicionY2() {
		return posicionY2;
	}
	
	public void modificarPosicionY2(Double posicionY2) {
		this.posicionY2 = posicionY2;
	}

	public Figura darFiguraDestino() {
		return figuraDestino;
	}

	public void modificarFiguraDestino(Figura figuraDestino) {
		this.figuraDestino = figuraDestino;
	}
	
	

}
