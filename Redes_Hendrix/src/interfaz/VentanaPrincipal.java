package interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import excepciones.SintaxisException;
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
		setSize(1024, 768);
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
			} else if (barraHerramientas.botonNodosSeleccionado()) {
				
			}
				if (barraHerramientas.botonDominiosSeleccionado()) {
					Figura f = new Ovalo(x, y, "Esto es una prueba", momentoClick);
					composicion.agregarFiguraGeometrica(f);
			} else if (barraHerramientas.botonDominiosSeleccionado()) {
				if (barraHerramientas.botonEspaciosSeleccionado()) {
					Figura f = new Circulo(x, y, "Esto es una prueba", momentoClick);
					composicion.agregarFiguraGeometrica(f);
			} else if (barraHerramientas.botonRelacionesSeleccionado()) {

			} else if (barraHerramientas.botonSeleccionSeleccionado()) {
				Figura seleccionada = composicion.buscarFigura(x, y);
				panelCanvas.actualizarFiguraSeleccionada(seleccionada);
			} else if (barraHerramientas.botonBorrarSeleccionado()){

			}
			panelCanvas.refrescar();
		} }catch (SintaxisException e) {
			mostrarMensajeError("Dibujar figura", e.getMessage());
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
	
