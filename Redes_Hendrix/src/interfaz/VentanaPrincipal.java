package interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import modelo.Circulo;
import modelo.Composicion;
import modelo.Figura;
import modelo.Ovalo;
import modelo.Rectangulo;

public class VentanaPrincipal extends JFrame {

	/**
	 * Versi�n de serializaci�n
	 */
	private static final long serialVersionUID = -2573448222477934099L;
	
	// ------------------------------------------------------------------------------------------
	// Constantes
	// ------------------------------------------------------------------------------------------
	
	
	
	// ------------------------------------------------------------------------------------------
	// Atributos
	// ------------------------------------------------------------------------------------------
	
	/**
	 * Representa el panel sobre el cual se dibujar� el diagrama
	 */
	private PanelCanvas panelCanvas;
	
	/**
	 * Representa la barra de herramientas de la aplicaci�n donde estar�n todas las herramientas
	 * de dibujo.
	 */
	private BarraHerramientas barraHerramientas;
	
	/**
	 * Representa la barra de men� de la aplicaci�n donde estar� todos las opciones de gesti�n de
	 * archivos.
	 */
	private BarraMenu barraMenu;
	
	/**
	 * Representa la composici�n que se est� construyendo
	 */
	private Composicion composicion;
	
	// ------------------------------------------------------------------------------------------
	// Constructor
	// ------------------------------------------------------------------------------------------
	
	/**
	 * 
	 */
	public VentanaPrincipal() {
		setTitle("Redes de Hendrix - RDH");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(true);
		setSize(1024, 700);
		setLayout(new BorderLayout());
		
		composicion = new Composicion();
		
		panelCanvas = new PanelCanvas(this, 1024, 768, composicion);
		JScrollPane barraDesplazadora = new JScrollPane(panelCanvas);
		barraDesplazadora.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		barraDesplazadora.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		barraHerramientas = new BarraHerramientas();
		
		barraMenu = new BarraMenu(this);
		
		add(barraDesplazadora, BorderLayout.CENTER);
		add(barraHerramientas, BorderLayout.WEST);
		setJMenuBar(barraMenu);
	}
	
	// ------------------------------------------------------------------------------------------
	// Servicios
	// ------------------------------------------------------------------------------------------
	
	/**
	 * M�todo que gestiona lo que sucede cuando se hace click en una area del canvas.
	 * @param x - es la coordenada en el eje x donde sucede el click.
	 * @param y - es la coordenada en el eje y donde sucede el click.
	 * @param momentoClick - es el momento en el cual sucedi� el click.
	 */
	public void canvasClick(int x, int y, Long momentoClick) {
		try {
			if (barraHerramientas.botonEspaciosSeleccionado()) {
				Figura f = new Rectangulo(x, y, "Esto es una prueba", momentoClick);
				composicion.agregarFiguraGeometrica(f);
			} else if (barraHerramientas.botonDominiosSeleccionado()) {
				Figura f = new Ovalo(x, y, "Esto es una prueba", momentoClick);
				composicion.agregarFiguraGeometrica(f);
				
			} else if (barraHerramientas.botonNodosSeleccionado()) {
				Figura f = new Circulo(x, y, "Esto es una prueba", momentoClick);
				composicion.agregarFiguraGeometrica(f);
			} else if (barraHerramientas.botonRelacionesSeleccionado()) {
				Figura f = composicion.buscarFigura(x, y);
				if (f != null) {
					panelCanvas.agregarFiguraSeleccionada(f);
				} else {
					panelCanvas.quitarFocoFiguras();
				}
				if (panelCanvas.hayDosFigurasSeleccionadas()) {
					String etiqueta = JOptionPane.showInputDialog(this, "Nombre de relaci�n:", "Crear arco", 
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
	
	/**
	 * M�todo que se encarga de gestionar el proceso de creaci�n de nuevo diagrama.
	 * Si no se han guardado los cambios del diagrama en el cual se est� trabajando,
	 * se pregunta si desea conservarlo y luego crea una nueva composici�n.
	 */
	public void nuevoDiagrama() {
		// TODO Crear nuevo Diagrama
	}
	
	/**
	 * M�todo que se encarga de mostrar un mensaje de error al usuario.
	 * @param funcionalidad - Es la funcionalidad en la cual se da el error.
	 * @param mensaje - Es el contenido del error.
	 */
	public void mostrarMensajeError(String funcionalidad, String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, funcionalidad, JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * M�todo con el cual inicia el programa.
	 * @param args - Argumentos recibidos desde una ventana de comandos
	 */
	public static void main(String[] args) {
		VentanaPrincipal ventana = new VentanaPrincipal();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}

}
	
