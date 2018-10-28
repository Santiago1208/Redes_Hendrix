package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class PanelCanvas extends JPanel implements MouseListener, MouseMotionListener {

	/**
	 * Versión de serialización
	 */
	private static final long serialVersionUID = 3009416156724799831L;
	
	// ------------------------------------------------------------------------------------------
	// Constantes
	// ------------------------------------------------------------------------------------------
	
	/**
	 * Representa el color de fondo del panel.
	 */
	private final static Color COLOR_FONDO = new Color(255, 255, 255);
	
	
	// ------------------------------------------------------------------------------------------
	// Atributos
	// ------------------------------------------------------------------------------------------
	
	/**
	 * Representa la relación con la ventana principal
	 */
	private VentanaPrincipal principal;
	
	/**
	 * Representa el ancho del panel preferido por el usuario.
	 */
	private int ancho;
	
	/**
	 * Representa el alto del panel preferido por el usuario.
	 */
	private int alto;
	
	
	// ------------------------------------------------------------------------------------------
	// Constructor
	// ------------------------------------------------------------------------------------------
	
	/**
	 * Construye el panel donde se dibujará el diagrama.
	 * @param ventana - Representa la ventana propietaria del panel
	 * @param ancho - Representa el ancho del panel, en pixeles.
	 * @param alto - Representa el alto del panel, en pixeles.
	 */
	public PanelCanvas(VentanaPrincipal ventana, int ancho, int alto) {
		principal = ventana;
		
		setBackground(COLOR_FONDO);
		setDoubleBuffered(true);
		this.ancho = ancho;
		this.alto = alto;
		setPreferredSize(new Dimension(this.ancho, this.alto));
		addMouseMotionListener(this);
		addMouseListener(this);
	}
	
	// ------------------------------------------------------------------------------------------
	// Servicios
	// ------------------------------------------------------------------------------------------
	

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		//principal.prueba();			
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
