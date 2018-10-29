package modelo;

import java.awt.Shape;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import excepciones.SintaxisException;

/**
 * Clase que representa el diagrama completo que está construyendo el usuario.
 * @author Santiago
 *
 */
public class Composicion {
	
	// ------------------------------------------------------------------------------------------
	// Constantes
	// ------------------------------------------------------------------------------------------
	
	
	
	// ------------------------------------------------------------------------------------------
	// Atributos
	// ------------------------------------------------------------------------------------------
	
	/**
	 * Representa los bloques creados por el usuario. Un bloque se considera una agrupación de
	 * figuras geométricas.
	 */
	private ArrayList<Bloque> bloques;
	
	/**
	 * Representa la lista de figuras geométricas que han sido dibujadas por el usuario.
	 */
	private HashMap<Integer, Figura> figurasGeometricas;
	
	/**
	 * Representa un número que se asigna a cada figura para identificarlas
	 */
	private Integer secuencia;
	
	// ------------------------------------------------------------------------------------------
	// Constructor
	// ------------------------------------------------------------------------------------------
	
	public Composicion() {
		secuencia = 0;
		figurasGeometricas = new HashMap<>();
		bloques = new ArrayList<>();
	}
	
	// ------------------------------------------------------------------------------------------
	// Servicios
	// ------------------------------------------------------------------------------------------
	
	/**
	 * Método que se encarga de dar la lista de bloques creadas por el usuario.
	 * @return la lista de bloques que ha creado el usuario.
	 */
	public List<Bloque> darBloques() {
		return bloques;
	}
	
	/**
	 * Método que se encarga de dar la lista de figuras geométricas dibujadas por el usuario.
	 * @return la lista de figuras que ha dibujado el usuario.
	 */
	public HashMap<Integer, Figura> darFigurasGeometricas() {
		return figurasGeometricas;
	}
	
	/**
	 * Método que se encarga de registrar un bloque con el nombre especificado y las figuras
	 * hijas seleccionadas.
	 * @param nombre - es el nombre que identificará al bloque.
	 * @param figuras - es la lista de figuras que serán cubiertas por el bloque.
	 */
	public void agregarBloque(String nombre, List<Figura> figuras) throws Exception {
		for (Figura f : figuras) {
			if (f instanceof Ovalo) {
				throw new Exception ("Los dominios no pueden hacer parte del bloque");
			}
		}
		
	}
	
	/**
	 * Método que se encarga de agregar una figura a la lista de figuras geométricas.
	 * @param f - Es la figura que se quiere agregar a la composición.
	 * @throws SintaxisException
	 */
	public void agregarFiguraGeometrica(Figura f) throws SintaxisException {
		f.asignarIdentificador(secuencia);
		figurasGeometricas.put(secuencia, f);
		secuencia++;
	}
	
	/**
	 * Método que se encarga de buscar la primera figura que contenga en su interior
	 * al punto (X, Y) pasado por parámetro.
	 * @param x - Es la coordenada del eje x contenido en la figura a buscar.
	 * @param y - Es la coordenada del eje y contenido en la figura a buscar.
	 * @return La figura que contiene el punto (X, Y) especificado o null si la figura
	 * no existe.
	 */
	public Figura buscarFigura(int x, int y) {
		Figura buscada = null;
		for(Figura f : figurasGeometricas.values()) {
			Shape representacion = f.darRepresentacion();
			Point2D.Double p = new Point2D.Double(x, y);
			if (representacion.contains(p)) {
				if (buscada == null) {
					buscada = f;					
				} else {
					if (f.darMomentoCreacion() > buscada.darMomentoCreacion()) {
						buscada = f;
					}
				}
			}
		}
		return buscada;
	}
	
	
}
