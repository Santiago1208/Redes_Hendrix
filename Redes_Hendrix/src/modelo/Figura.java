package modelo;

import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase abstracta que representa el conjunto de las figuras geométricas.
 * 
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
	 * Representa la coordenada en el eje x donde está posicionada la figura.
	 */
	protected int posicionX;

	/**
	 * Representa la coordenada en el eje y donde está posicionada la figura.
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
	 * Representa una etiqueta que ofrece contenido semántico a la figura dibujada.
	 */
	protected String etiqueta;

	/**
	 * Representan los arcos que pueden asociarse a la figura.
	 */
	protected ArrayList<Arco> arcos;

	/**
	 * Representa un número único que identifica a la figura
	 */
	protected int identificador;

	/**
	 * Es la representación gráfica de la figura
	 */
	protected Shape representacion;

	/**
	 * Representa el momento en el cual la figura fue creada. Es util para priorizar
	 * cuál figura debe ser seleccionada primero.
	 */
	protected Long momentoCreacion;

	// ------------------------------------------------------------------------------------------
	// Constructor
	// ------------------------------------------------------------------------------------------

	/**
	 * Construye una figura geométrica en la posición especificada y con la etiqueta
	 * especificada.
	 * 
	 * @param posicionX       - Es la coordenada en x donde se ubicará la figura.
	 * @param posicionY       - Es la coordenada en y donde se ubicará la figura.
	 * @param etiqueta        - Es el contenido semántico que tendrá la figura.
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
	 * Retorna la coordenada en el eje x donde está posicionada la figura.
	 * 
	 * @return un entero que representa la coordenada en el eje x.
	 */
	public int darPosicionX() {
		return posicionX;
	}

	/**
	 * Retorna la coordenada en el eje y donde está posicionada la figura.
	 * 
	 * @return un entero que representa la coordenada en el eje y.
	 */
	public int darPosicionY() {
		return posicionY;
	}

	/**
	 * Método que se encarga de dar el ancho de la figura
	 * 
	 * @return el ancho de la figura.
	 */
	public int darAncho() {
		return ancho;
	}

	/**
	 * Método que se encarga de dar el alto de la figura
	 * 
	 * @return el alto de la figura.
	 */
	public int darAlto() {
		return alto;
	}

	/**
	 * Retorna la etiqueta asociada a la figura.
	 * 
	 * @return una cadena que representa la etiqueta asociada a la figura.
	 */
	public String darEtiqueta() {
		return etiqueta;
	}

	/**
	 * Actualiza la etiqueta que tenga actualmente la figura por la que se pasa por
	 * parámetro.
	 * 
	 * @param nuevaEtiqueta - Es la nueva etiqueta que se le asociará a la figura.
	 */
	public void modificarEtiqueta(String nuevaEtiqueta) {
		etiqueta = nuevaEtiqueta;
	}

	/**
	 * Actualiza la posición x de la figura.
	 * 
	 * @param nuevaPosicionX - Es la nueva posición x que ocupará la figura.
	 */
	public void modificarPosicionX(int nuevaPosicionX) {
		posicionX = nuevaPosicionX;
	}

	/**
	 * Actualiza la posicion y de la figura.
	 * 
	 * @param nuevaPosicionY - Es la nueva posición y que ocupará la figura.
	 */
	public void modificarPosicionY(int nuevaPosicionY) {
		posicionY = nuevaPosicionY;
	}

	/**
	 * Retorna los arcos asociados a la figura
	 * 
	 * @return una lista de arcos
	 */
	public List<Arco> darArcos() {
		return arcos;
	}

	/**
	 * Retorna el identificador de la figura.
	 * 
	 * @return el número que identifica a la figura
	 */
	public int darIdentificador() {
		return identificador;
	}

	/**
	 * Método que se encarga de asignar un identificador a la figura
	 * 
	 * @param identificador - Es el número con el cual se identificará
	 */
	public void asignarIdentificador(int identificador) {
		this.identificador = identificador;
	}

	/**
	 * Método que se encarga de dar la representación gráfica de la figura.
	 * 
	 * @return la forma gráfica que representa a la figura.
	 */
	public Shape darRepresentacion() {
		return representacion;
	}

	/**
	 * Método que se encarga de dar el momento de creación de la figura.
	 * 
	 * @return un número que representa el momento de creación de la figura.
	 */
	public Long darMomentoCreacion() {
		return momentoCreacion;
	}

	public void agregarArco(Figura figuraDestino, String etiqueta) throws Exception {
		if (figuraDestino == null) {
			throw new Exception("No se pudo agregar arco. Figura de destino indefinida.");
		}
		double desde = calcularAnguloEntre(this, figuraDestino);
		double hasta = calcularAnguloEntre(figuraDestino, this);
		Point2D pointFrom = darPuntoEnFigura(this, desde);
        Point2D pointTo = darPuntoEnFigura(figuraDestino, hasta);
        Arco nuevoArco = new Arco(etiqueta, pointFrom, pointTo, figuraDestino);
        arcos.add(nuevoArco);
	}
	
	/**
	 * Calcula el centro de la figura geométrica basandose en su contorno.
	 * @param contorno - Es el contorno de la figura
	 * @return Retorna el punto que está en el centro geométrico de la figura.
	 */
	public Point2D calcularCentro(Rectangle2D contorno) {
		return new Point2D.Double(contorno.getCenterX(), contorno.getCenterY());
	}
	
	protected double calcularAnguloEntre(Figura origen, Figura destino) {
		return calcularAnguloEntre(calcularCentro(origen.representacion.getBounds2D()), 
				calcularCentro(destino.representacion.getBounds2D()));
	}
	
	protected Point2D darPuntoEnFigura(Figura figura, double radianes) {
		Rectangle2D contorno = figura.representacion.getBounds();
//      Point2D point = new Point2D.Double(bounds.getX(), bounds.getY());
        Point2D point = calcularCentro(contorno);
        return darPuntoEnFigura(point, radianes, Math.max(contorno.getWidth(), contorno.getHeight()) / 2d);
	}

	private double calcularAnguloEntre(Point2D desde, Point2D hasta) {
		double x = desde.getX();
		double y = desde.getY();

		double deltaX = hasta.getX() - x;
		double deltaY = hasta.getY() - y;

		double rotation = -Math.atan2(deltaX, deltaY);
		rotation = Math.toRadians(Math.toDegrees(rotation) + 180);
		return rotation;
	}

	private Point2D darPuntoEnFigura(Point2D centro, double radians, double radio) {
		double x = centro.getX();
		double y = centro.getY();

		radians = radians - Math.toRadians(90.0); // 0 becomes the top
		// Calculate the outter point of the line
		double xPosy = Math.round((float) (x + Math.cos(radians) * radio));
		double yPosy = Math.round((float) (y + Math.sin(radians) * radio));

		return new Point2D.Double(xPosy, yPosy);
	}

}
