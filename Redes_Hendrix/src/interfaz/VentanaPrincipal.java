package interfaz;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

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
		
		panelCanvas = new PanelCanvas(this, 1024, 768);
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
	
	public void canvasClick() {
		if (barraHerramientas.botonEspaciosSeleccionado()) {
			
		} else if (barraHerramientas.botonNodosSeleccionado()) {
			
		} else if (barraHerramientas.botonDominiosSeleccionado()) {
			
		} else if (barraHerramientas.botonRelacionesSeleccionado()) {
			
		} else if (barraHerramientas.botonSeleccionSeleccionado()) {
			
		} else {
			
		}
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
