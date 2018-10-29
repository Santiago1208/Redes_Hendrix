package modelo;

import java.awt.Shape;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase abstracta que representa el conjunto de las figuras geom�tricas.
 * @author Santiago
 *
 */
public abstract class Figura {
	
	// ------------------------------------------------------------------------------------------
	// Constantes
	// ------------------------------------------------------------------------------------------
	
	
	// ------------------------------------------------------------------------------------------
	// Atributos
	// ------------------------------------------------------------------------------------------
	
	/**
	 * Representa la coordenada en el eje x donde est� posicionada la figura.
	 */
	protected int posicionX;
	
	/**
	 * Representa la coordenada en el eje y donde est� posicionada la figura.
	 */
	protected int posicionY;
	
	/**
	 * Representa el ancho de la figura.
	 */
	protected int ancho;
	
	/**
	 * Representa el alto de la figura.
	 */
	protected int alto;
	
	/**
	 * Representa una etiqueta que ofrece contenido sem�ntico a la figura dibujada.
	 */
	protected String etiqueta;
	
	/**
	 * Representan los arcos que pueden asociarse a la figura.
	 */
	protected ArrayList<Arco> arcos;
	
	/**
	 * Representa un n�mero �nico que identifica a la figura
	 */
	protected int identificador;
	
	/**
	 * Es la representaci�n gr�fica de la figura
	 */
	protected Shape representacion;
	
	/**
	 * Representa el momento en el cual la figura fue creada. Es util para priorizar
	 * cu�l figura debe ser seleccionada primero.
	 */
	protected Long momentoCreacion;
	
	// ------------------------------------------------------------------------------------------
	// Constructor
	// ------------------------------------------------------------------------------------------
	
	/**
	 * Construye una figura geom�trica en la posici�n especificada y con la etiqueta especificada.
	 * @param posicionX - Es la coordenada en x donde se ubicar� la figura.
	 * @param posicionY - Es la coordenada en y donde se ubicar� la figura.
	 * @param etiqueta - Es el contenido sem�ntico que tendr� la figura.
	 * @param momentoCreacion - Es el momento en el cual la figura fue creada.
	 */
	public Figura(int posicionX, int posicionY, String etiqueta, Long momentoCreacion) {
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.etiqueta = etiqueta;
		arcos = new ArrayList<>();
		this.momentoCreacion = momentoCreacion;
	}
	
	// ------------------------------------------------------------------------------------------
	// Servicios
	// ------------------------------------------------------------------------------------------
	
	/**
	 * Retorna la coordenada en el eje x donde est� posicionada la figura.
	 * @return un entero que representa la coordenada en el eje x.
	 */
	public int darPosicionX() {
		return posicionX;
	}
	
	/**
	 * Retorna la coordenada en el eje y donde est� posicionada la figura.
	 * @return un entero que representa la coordenada en el eje y.
	 */
	public int darPosicionY() {
		return posicionY;
	}
	
	/**
	 * M�todo que se encarga de dar el ancho de la figura
	 * @return el ancho de la figura.
	 */
	public int darAncho() {
		return ancho;
	}
	
	/**
	 * M�todo que se encarga de dar el alto de la figura
	 * @return el alto de la figura.
	 */
	public int darAlto() {
		return alto;
	}
	
	/**
	 * Retorna la etiqueta asociada a la figura.
	 * @return una cadena que representa la etiqueta asociada a la figura.
	 */
	public String darEtiqueta() {
		return etiqueta;
	}
	
	/**
	 * Actualiza la etiqueta que tenga actualmente la figura por la que se
	 * pasa por par�metro.
	 * @param nuevaEtiqueta - Es la nueva etiqueta que se le asociar� a la figura.
	 */
	public void modificarEtiqueta(String nuevaEtiqueta) {
		etiqueta = nuevaEtiqueta;
	}
	
	/**
	 * Actualiza la posici�n x de la figura.
	 * @param nuevaPosicionX - Es la nueva posici�n x que ocupar� la figura.
	 */
	public void modificarPosicionX(int nuevaPosicionX) {
		posicionX = nuevaPosicionX;
	}
	
	/**
	 * Actualiza la posicion y de la figura.
	 * @param nuevaPosicionY - Es la nueva posici�n y que ocupar� la figura.
	 */
	public void modificarPosicionY(int nuevaPosicionY) {
		posicionY = nuevaPosicionY;
	}
	
	/**
	 * Retorna los arcos asociados a la figura
	 * @return una lista de arcos
	 */
	public List<Arco> darArcos() {
		return arcos;
	}
	
	/**
	 * Retorna el identificador de la figura.
	 * @return el n�mero que identifica a la figura
	 */
	public int darIdentificador() {
		return identificador;
	}
	
	/**
	 * M�todo que se encarga de asignar un identificador a la figura
	 * @param identificador - Es el n�mero con el cual se identificar�
	 */
	public void asignarIdentificador(int identificador) {
		this.identificador = identificador;
	}
	
	/**
	 * M�todo que se encarga de dar la representaci�n gr�fica de la figura.
	 * @return la forma gr�fica que representa a la figura.
	 */
	public Shape darRepresentacion() {
		return representacion;
	}
	
	/**
	 * M�todo que se encarga de dar el momento de creaci�n de la figura.
	 * @return un n�mero que representa el momento de creaci�n de la figura.
	 */
	public Long darMomentoCreacion() {
		return momentoCreacion;
	}
	

}
