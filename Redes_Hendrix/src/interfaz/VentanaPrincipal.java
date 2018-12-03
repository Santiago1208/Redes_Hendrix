package interfaz;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

import excepciones.SintaxisException;
import modelo.Circulo;
import modelo.Composicion;
import modelo.Figura;
import modelo.Ovalo;
import modelo.Rectangulo;

public class VentanaPrincipal extends JFrame {

	/**
	 * Versión de serialización
	 */
	private static final long serialVersionUID = -2573448222477934099L;
	
	// ------------------------------------------------------------------------------------------
	// Constantes
	// ------------------------------------------------------------------------------------------
	
	
	
	// ------------------------------------------------------------------------------------------
	// Atributos
	// ------------------------------------------------------------------------------------------
	
	/**
	 * Representa el panel sobre el cual se dibujará el diagrama
	 */
	private PanelCanvas panelCanvas;
	
	/**
	 * Representa la barra de herramientas de la aplicación donde estarán todas las herramientas
	 * de dibujo.
	 */
	private BarraHerramientas barraHerramientas;
	
	/**
	 * Representa la barra de menú de la aplicación donde estará todos las opciones de gestión de
	 * archivos.
	 */
	private BarraMenu barraMenu;
	
	/**
	 * Barra desplazadora para el panel canvas
	 */
	private JScrollPane barraDesplazadora;
	
	/**
	 * Representa la composición que se está construyendo
	 */
	private Composicion composicion;
	
	// ------------------------------------------------------------------------------------------
	// Constructor
	// ------------------------------------------------------------------------------------------
	
	/**
	 * 
	 */
	public VentanaPrincipal() {
		try {
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setResizable(true);
			setSize(1024, 700);
			setLayout(new BorderLayout());
			
			composicion = new Composicion();
			setTitle("Redes de Hendrix - RDH | Backup");
			
			panelCanvas = new PanelCanvas(this, 1024, 768, composicion);
			barraDesplazadora = new JScrollPane(panelCanvas);
			barraDesplazadora.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
			barraDesplazadora.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			barraDesplazadora.getVerticalScrollBar().setUnitIncrement(16);
			barraDesplazadora.getHorizontalScrollBar().setUnitIncrement(16);
			
			barraHerramientas = new BarraHerramientas();
			
			barraMenu = new BarraMenu(this);
			
			add(barraDesplazadora, BorderLayout.CENTER);
			add(barraHerramientas, BorderLayout.WEST);
			setJMenuBar(barraMenu);	
		} catch (Exception e) {
			mostrarMensajeError("Abrir composición", e.getMessage());
		}
	}
	
	// ------------------------------------------------------------------------------------------
	// Servicios
	// ------------------------------------------------------------------------------------------
	
	/**
	 * Método que gestiona lo que sucede cuando se hace click en una area del canvas.
	 * @param x - es la coordenada en el eje x donde sucede el click.
	 * @param y - es la coordenada en el eje y donde sucede el click.
	 * @param momentoClick - es el momento en el cual sucedió el click.
	 */
	public void canvasClick(int x, int y, Long momentoClick) {
		try {
			if (barraHerramientas.botonEspaciosSeleccionado()) {
				Figura f = new Rectangulo(x, y, "", momentoClick);
				composicion.agregarFiguraGeometrica(f);
			} else if (barraHerramientas.botonDominiosSeleccionado()) {
				boolean esCorrecto = esCorrectoAgregarDominio(x, y);
				if (esCorrecto) {
					agregarDominio(x, y, momentoClick);
				}
			} else if (barraHerramientas.botonNodosSeleccionado()) {
				boolean esCorrecto = esCorrectoAgregarNodo(x, y);
				if (esCorrecto) {
					agregarNodo(x, y, momentoClick);
				}
			} else if (barraHerramientas.botonRelacionesSeleccionado()) {
				Figura f = composicion.buscarFigura(x, y);
				if (f != null) {
					panelCanvas.agregarFiguraSeleccionada(f);
				} else {
					panelCanvas.quitarFocoFiguras();
				}
				if (panelCanvas.hayDosFigurasSeleccionadas()) {
					String etiqueta = JOptionPane.showInputDialog(this, "Nombre de relación:", "Crear arco", 
							JOptionPane.INFORMATION_MESSAGE);
					if (etiqueta != null) {
						composicion.crearArco(panelCanvas.darFiguraOrigen(), 
								panelCanvas.darFiguraDestino(), etiqueta);						
					}
					panelCanvas.quitarFocoFiguras();
				}
			} else if (barraHerramientas.botonSeleccionSeleccionado()) {
				Figura seleccionada = composicion.buscarFigura(x, y);
				if (seleccionada == null) {
					panelCanvas.quitarFocoFiguras();
				} else {
					panelCanvas.agregarFiguraSeleccionada(seleccionada);					
				}
			} else if (barraHerramientas.botonBorrarSeleccionado()){
				Figura f = composicion.buscarFigura(x, y);
				composicion.borrarFigura(f);
			}
			panelCanvas.refrescar();
		}catch (Exception e) {
			mostrarMensajeError("Dibujar figura", e.getMessage());
		}
	}
	
	public void agregarNodo(int x, int y, long momentoClick) throws SintaxisException {
		String msg = JOptionPane.showInputDialog("Ingrese el nombre del elemento:");
		if (msg!=null) {
			Rectangulo padre = (Rectangulo) composicion.buscarFigura(x, y);
			Figura f = new Circulo(x, y, msg, momentoClick, padre);
			padre.agregarHija(f);
			composicion.agregarFiguraGeometrica(f);
		}
	}
	
	private boolean esCorrectoAgregarNodo(int x, int y) {
		boolean correcto = false;
		Figura f = composicion.buscarFigura(x, y);
		if (f != null) {
			if (f instanceof Rectangulo) {
				correcto = true;
			}
		}
		return correcto;
	}
	
	public void agregarDominio(int x, int y, long momentoClick) throws SintaxisException {
		String msg = JOptionPane.showInputDialog("Ingrese el nombre del elemento:");
		if (msg!=null) {
			Figura f = new Ovalo(x, y, msg, momentoClick);
			composicion.agregarFiguraGeometrica(f);
		}
	}
	
	private boolean esCorrectoAgregarDominio(int x, int y) {
		boolean correcto = true;
		Figura f = composicion.buscarFigura(x, y);
		if (f != null) {
			if (f instanceof Circulo || f instanceof Rectangulo) {
				correcto = false;
			}
		}
		return correcto;
	}
	
	public void moverFigura(int x, int y) {
		Figura f = composicion.buscarFigura(x, y);
		if (barraHerramientas.botonSeleccionSeleccionado()) {
			if (f != null) {
				f.modificarPosicionX(x);
				f.modificarPosicionY(y);
				panelCanvas.refrescar();
			}			
		}
	}
	
	public void aumentarAnchoFigura(Point coordenada) {
		Figura f = composicion.buscarFigura(coordenada.x, coordenada.y);
		if (f != null) {
			if (barraHerramientas.botonSeleccionSeleccionado()) {
				f.aumentarAncho();
				panelCanvas.refrescar();				
			}
		}
	}
	
	public void disminuirAnchoFigura(Point coordenada) {
		Figura f = composicion.buscarFigura(coordenada.x, coordenada.y);
		if (f != null) {
			if (barraHerramientas.botonSeleccionSeleccionado()) {
				f.disminuirAncho();
				panelCanvas.refrescar();				
			}
		}
	}
	
	public void aumentarAltoFigura(Point coordenada) {
		Figura f = composicion.buscarFigura(coordenada.x, coordenada.y);
		if (f != null) {
			if (barraHerramientas.botonSeleccionSeleccionado()) {
				f.aumentarAlto();
				panelCanvas.refrescar();				
			}
		}
	}
	
	public void disminuirAltoFigura(Point coordenada) {
		Figura f = composicion.buscarFigura(coordenada.x, coordenada.y);
		if (f != null) {
			if (barraHerramientas.botonSeleccionSeleccionado()) {
				f.disminuirAlto();
				panelCanvas.refrescar();				
			}
		}
	}
	
	public void scroll(Component escucha, MouseWheelEvent e) {
		MouseEvent event = SwingUtilities.convertMouseEvent(escucha, e, barraDesplazadora);
		barraDesplazadora.dispatchEvent(event);
	}
	
	/**
	 * Método que se encarga de gestionar el proceso de creación de nuevo diagrama.
	 * Si no se han guardado los cambios del diagrama en el cual se está trabajando,
	 * se pregunta si desea conservarlo y luego crea una nueva composición.
	 */
	public void nuevoDiagrama() {
		int respuesta = mostrarConfirmacion("Nuevo diagrama", 
				"Los cambios que no haya guardado se perderán.\n¿Desea continuar creando el nuevo diagrama?", 
				JOptionPane.YES_NO_OPTION);
		if (respuesta == JOptionPane.YES_OPTION) {
			composicion.crearNuevoDiagrama();
			panelCanvas.refrescar();
		}
	}
	
	/**
	 * Método que se encarga de guardar una composición en un archivo que el usuario
	 * nombrará. La ubicación del archivo también la dará el usuario.
	 */
	public void guardarComposicion() {
		try {
			if (getTitle().contains("Backup")) {
				guardarConDialogo();
			} else {
				guardarSinDialogo();
			}
		} catch (Exception e) {
			mostrarMensajeError("Guardar composición", "Error guardando la composición.\n" + e.getMessage());
		}
	}
	
	private void guardarConDialogo() throws Exception {
		JFileChooser fc = new JFileChooser("./composiciones");
		fc.setDialogTitle("Guardar composición en archivo");
		fc.setFileFilter(new FileNameExtensionFilter("Archivos RDH", "rdh"));
		int resultado = fc.showSaveDialog(this);
		if (resultado == JFileChooser.APPROVE_OPTION) {
			File archivo = new File(fc.getSelectedFile() + ".rdh");
			composicion.salvarComposicion(archivo);
			mostrarInformacion("Guardar composición", "Composición guardada correctamente!");
		}
	}
	
	private void guardarSinDialogo() throws Exception {
		String tituloVentana = getTitle();
		String[] split = tituloVentana.split("\\|");
		String rutaArchivo = split[1].trim();
		File archivo = new File(rutaArchivo);
		composicion.salvarComposicion(archivo);
		mostrarInformacion("Guardar composición", "Composición guardada correctamente!");
	}
	
	public void abrirComposicion() {
		try {
			JFileChooser fc = new JFileChooser("./composiciones");
			fc.setDialogTitle("Abrir composición");
			fc.setFileFilter(new FileNameExtensionFilter("Archivos RDH", "rdh"));
			int resultado = fc.showOpenDialog(this);
			if (resultado == JFileChooser.APPROVE_OPTION) {
				File archivo = fc.getSelectedFile();
				composicion.abrirComposicion(archivo);
				setTitle("Redes de Hendrix - RDH | " + archivo.getPath());
			}
			panelCanvas.refrescar();
		} catch (Exception e) {
			mostrarMensajeError("Abrir composición", "Error abriendo la composición.\n" + e.getMessage());
		}
	}
	
	@Override
	public void dispose() {
		try {
			composicion.salvarComposicion();
			super.dispose();
		} catch (Exception e) {
			setVisible(true);
			int respuesta = mostrarConfirmacion("Error", "Problemas salvando la información:\n"
					+ e.getMessage() + "\n¿Quiere cerrar el programa sin salvar?", 
					JOptionPane.YES_NO_OPTION);
			if (respuesta == JOptionPane.YES_OPTION) {
				super.dispose();
			}
		}
	}
	
	/**
	 * Método que se encarga de mostrar un mensaje de error al usuario.
	 * @param funcionalidad - Es la funcionalidad en la cual se da el error.
	 * @param mensaje - Es el contenido del error.
	 */
	public void mostrarMensajeError(String funcionalidad, String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, funcionalidad, JOptionPane.ERROR_MESSAGE);
	}
	
	public int mostrarConfirmacion(String titulo, String mensaje, int tipoConfirmacion) {
		return JOptionPane.showConfirmDialog(this, mensaje, titulo, tipoConfirmacion);
	}
	
	public void mostrarInformacion(String titulo, String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Método con el cual inicia el programa.
	 * @param args - Argumentos recibidos desde una ventana de comandos
	 */
	public static void main(String[] args) {
		VentanaPrincipal ventana = new VentanaPrincipal();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}

}
	
