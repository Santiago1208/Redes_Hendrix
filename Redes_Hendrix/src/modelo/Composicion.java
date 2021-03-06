package modelo;

import java.awt.Shape;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import excepciones.SintaxisException;

/**
 * Clase que representa el diagrama completo que est� construyendo el usuario.
 * @author Santiago Restrepo & Andres Zapata 
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
	 * Representa los bloques creados por el usuario. Un bloque se considera una agrupaci�n de
	 * figuras geom�tricas.
	 */
	private ArrayList<Bloque> bloques;
	
	/**
	 * Representa la lista de figuras geom�tricas que han sido dibujadas por el usuario.
	 */
	private HashMap<Long, Figura> figurasGeometricas;
	
	/**
	 * Representa el archivo en el cual se persiste el programa.
	 */
	private File archivoComposicion;
	
	// ------------------------------------------------------------------------------------------
	// Constructor
	// ------------------------------------------------------------------------------------------
	
	@SuppressWarnings("unchecked")
	public Composicion() throws Exception {
		try {
			archivoComposicion =  new File("./persistencia/composicion.hdr");
			if (archivoComposicion.exists()) {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivoComposicion));
				bloques = (ArrayList<Bloque>) ois.readObject();
				figurasGeometricas = (HashMap<Long, Figura>) ois.readObject();
				ois.close();
			} else {
				figurasGeometricas = new HashMap<>();
				bloques = new ArrayList<>();				
			}
		} catch (Exception e) {
			throw new Exception("Imposible restaurar el estado del programa (" + e.getMessage() + ")");
		}
	}
	
	// ------------------------------------------------------------------------------------------
	// Servicios
	// ------------------------------------------------------------------------------------------
	
	/**
	 * M�todo que se encarga de dar la lista de bloques creadas por el usuario.
	 * @return la lista de bloques que ha creado el usuario.
	 */
	public List<Bloque> darBloques() {
		return bloques;
	}
	
	/**
	 * M�todo que se encarga de dar la lista de figuras geom�tricas dibujadas por el usuario.
	 * @return la lista de figuras que ha dibujado el usuario.
	 */
	public HashMap<Long, Figura> darFigurasGeometricas() {
		return figurasGeometricas;
	}
	
	/**
	 * M�todo que se encarga de registrar un bloque con el nombre especificado y las figuras
	 * hijas seleccionadas.
	 * @param nombre - es el nombre que identificar� al bloque.
	 * @param figuras - es la lista de figuras que ser�n cubiertas por el bloque.
	 */
	public void agregarBloque(String nombre, List<Figura> figuras) throws Exception {
		for (Figura f : figuras) {
			if (f instanceof Ovalo) {
				throw new Exception ("Los dominios no pueden hacer parte del bloque");
			}
		}
		
	}
	
	/**
	 * M�todo que se encarga de agregar una figura a la lista de figuras geom�tricas.
	 * @param f - Es la figura que se quiere agregar a la composici�n.
	 * @throws SintaxisException
	 */
	public void agregarFiguraGeometrica(Figura f) throws SintaxisException {
		figurasGeometricas.put(f.darMomentoCreacion(), f);
	}
	
	/**
	 * M�todo que se encarga de buscar la primera figura que contenga en su interior
	 * al punto (X, Y) pasado por par�metro.
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
	
	public void crearArco(Figura origen, Figura destino, String etiqueta) throws Exception {
		if (origen == null || destino == null) {
			throw new Exception("No se puede crear el arco. La figura origen o la de destino "
					+ "no est�n definidas");
		}
		origen.agregarArco(destino, etiqueta);
	}
	
	public void borrarFigura(Figura f) {
		if(f != null) {
			figurasGeometricas.remove(f.momentoCreacion);
		}
	}
	
	public void salvarComposicion() throws Exception {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoComposicion));
			oos.writeObject(bloques);
			oos.writeObject(figurasGeometricas);
			oos.close();
		} catch (Exception e) {
			throw new Exception ("Error al salvar: " + e.getMessage());
		}
	}
	
	public void salvarComposicion(File archivoPersonalizado) throws Exception {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivoPersonalizado));
			oos.writeObject(bloques);
			oos.writeObject(figurasGeometricas);
			oos.close();
		} catch (Exception e) {
			throw new Exception ("Error al salvar: " + e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public void abrirComposicion(File archivo) throws Exception {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));
			bloques = (ArrayList<Bloque>) ois.readObject();
			figurasGeometricas = (HashMap<Long, Figura>) ois.readObject();
			ois.close();
		} catch (Exception e) {
			throw new Exception("Imposible restaurar el estado del programa (" + e.getMessage() + ")");
		}
	}
	
	public void crearNuevoDiagrama() {
		bloques = new ArrayList<>();
		figurasGeometricas = new HashMap<>();
	}
	
	
}
