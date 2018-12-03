package modelo;

import java.awt.geom.Point2D;
import java.io.Serializable;

/**
 * Clase que representa la relación entre dos figuras geométricas.
 * @author Santiago
 *
 */
public class Arco implements Serializable {
	

	// ------------------------------------------------------------------------------------------
	// Constantes
	// ------------------------------------------------------------------------------------------
	
	/**
	 * Versión de serialización
	 */
	private static final long serialVersionUID = 5321107919462437653L;
	
	
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
	private double posicionX1;
	
	/**
	 * Repremodificarna la coordenada y del primer punto por el cual pasa el arco.
	 */
	private double posicionY1;
	
	/**
	 * Representa la coordenada x del segundo punto por el cual pasa el arco.
	 */
	private double posicionX2;
	
	/**
	 * Representa la coordenada y del segundo punto por el cual pasa el arco.
	 */
	private double posicionY2;
	
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
	 * @param relacionada - Es la figura a la cual apunta el arco
	 */
	public Arco(String etiqueta, Point2D inicio, Point2D fin, Figura relacionada) {
		this.etiqueta = etiqueta;
		posicionX1 = inicio.getX();
		posicionY1 = inicio.getY();
		posicionX2 = fin.getX();
		posicionY2 = fin.getY();
		figuraDestino = relacionada;
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
	
	public double darPosicionX1() {
		return posicionX1;
	}
	
	public void modificarPosicionX1(double posicionX1) {
		this.posicionX1 = posicionX1;
	}
	
	public double darPosicionX2() {
		return posicionX2;
	}
	
	public void modificarPosicionX2(double posicionX2) {
		this.posicionX2 = posicionX2;
	}
	
	public double darPosicionY1() {
		return posicionY1;
	}
	
	public void modificarPosicionY1(double posicionY1) {
		this.posicionY1 = posicionY1;
	}
	
	public double darPosicionY2() {
		return posicionY2;
	}
	
	public void modificarPosicionY2(double posicionY2) {
		this.posicionY2 = posicionY2;
	}

	public Figura darFiguraDestino() {
		return figuraDestino;
	}

	public void modificarFiguraDestino(Figura figuraDestino) {
		this.figuraDestino = figuraDestino;
	}
	
	

}
