package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Collection;

import javax.swing.JPanel;

import modelo.Circulo;
import modelo.Composicion;
import modelo.Figura;
import modelo.Ovalo;
import modelo.Rectangulo;

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
	
	/**
	 * Representa la composición que va a representar en el panel
	 */
	private Composicion composicion;
	
	/**
	 * Representa la figura que está seleccionada (tiene el foco)
	 */
	private Figura figuraSeleccionada;
	
	
	// ------------------------------------------------------------------------------------------
	// Constructor
	// ------------------------------------------------------------------------------------------
	
	/**
	 * Construye el panel donde se dibujará el diagrama.
	 * @param ventana - Representa la ventana propietaria del panel
	 * @param ancho - Representa el ancho del panel, en pixeles.
	 * @param alto - Representa el alto del panel, en pixeles.
	 * @param c - Es la composición que va a dibujar
	 */
	public PanelCanvas(VentanaPrincipal ventana, int ancho, int alto, Composicion c) {
		principal = ventana;
		composicion = c;
		figuraSeleccionada = null;
		
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
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		Collection<Figura> listaFiguras = composicion.darFigurasGeometricas().values();
		for(Figura f: listaFiguras) {
			if (f instanceof Rectangulo) {
				if (figuraSeleccionada == null) 
					dibujarEspacio(g2d, f, false); 
				else {
					if (f.darIdentificador() == figuraSeleccionada.darIdentificador()) 
						dibujarEspacio(g2d, f, true);					
					 else 	dibujarEspacio(g2d, f, false);
				}
			}
			if (f instanceof Ovalo) {
				if (figuraSeleccionada == null) 
					dibujarDominio(g2d, f, false); 
				else {
					if (f.darIdentificador() == figuraSeleccionada.darIdentificador()) 
						dibujarDominio(g2d, f, true);					
					 else 	dibujarDominio(g2d, f, false);
				}
			}
			if (f instanceof Circulo) {
				if (figuraSeleccionada == null) 
					dibujarNodo(g2d, f, false); 
				else {
					if (f.darIdentificador() == figuraSeleccionada.darIdentificador()) 
						dibujarNodo(g2d, f, true);					
					 else 	dibujarNodo(g2d, f, false);
				}
			}
		}
	}
	
	private void dibujarEspacio(Graphics2D g2d, Figura f, boolean focalizado) {
		Rectangle2D.Double representacion = (Rectangle2D.Double) f.darRepresentacion();
		if (!focalizado) {
			g2d.setColor(new Color(200, 108, 55));
		} else {
			g2d.setColor(Color.YELLOW);
		}
		g2d.fill(representacion);
		g2d.setColor(Color.BLACK);			
		g2d.draw(representacion);
	}
	
	private void dibujarDominio(Graphics2D g2d, Figura f, boolean focalizado) {
		Ellipse2D.Double representacion = (Ellipse2D.Double) f.darRepresentacion();
		if (!focalizado) {
			g2d.setColor(new Color(100, 64, 32));
		} else {
			g2d.setColor(Color.RED);
		}
		g2d.fill(representacion);
		g2d.setColor(Color.DARK_GRAY);			
		g2d.draw(representacion);
	}
	
	private void dibujarNodo(Graphics2D g2d, Figura f, boolean focalizado) {
		Ellipse2D.Double representacion = (Ellipse2D.Double) f.darRepresentacion();
		if (!focalizado) {
			g2d.setColor(new Color(88, 154, 232));
		} else {
			g2d.setColor(Color.ORANGE);
		}
		g2d.fill(representacion);
		g2d.setColor(Color.GRAY);			
		g2d.draw(representacion);
	}
	
	/**
	 * Método que actualiza el panel.
	 */
	public void refrescar() {
		repaint();
	}
	
	/**
	 * Método que se encarga de retornar la figura seleccionada (que tiene el foco).
	 * @return La figura que ha sido seleccionada con el mouse por el usuario.
	 */
	public Figura darFiguraSeleccionada() {
		return figuraSeleccionada;
	}
	
	/**
	 * Método que se encarga de actualizar la figura seleccionada
	 * @param f - es la nueva figura que estará marcada como seleccionada.
	 */
	public void actualizarFiguraSeleccionada(Figura f) {
		figuraSeleccionada = f;
		refrescar();
	}
	
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
		if (e.getButton() == MouseEvent.BUTTON1) {
			principal.canvasClick(e.getX(), e.getY(), e.getWhen());
			
		}
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
