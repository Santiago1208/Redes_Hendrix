package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JPanel;

import modelo.Arco;
import modelo.Circulo;
import modelo.Composicion;
import modelo.Figura;
import modelo.Ovalo;
import modelo.Rectangulo;

public class PanelCanvas extends JPanel implements MouseListener, MouseMotionListener {

	/**
	 * Versi�n de serializaci�n
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
	 * Representa la relaci�n con la ventana principal
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
	 * Representa la composici�n que va a representar en el panel
	 */
	private Composicion composicion;
	
	/**
	 * Representa la figura que est� seleccionada (tiene el foco)
	 */
	private ArrayList<Figura> figurasSeleccionadas;
	
	
	// ------------------------------------------------------------------------------------------
	// Constructor
	// ------------------------------------------------------------------------------------------
	
	/**
	 * Construye el panel donde se dibujar� el diagrama.
	 * @param ventana - Representa la ventana propietaria del panel
	 * @param ancho - Representa el ancho del panel, en pixeles.
	 * @param alto - Representa el alto del panel, en pixeles.
	 * @param c - Es la composici�n que va a dibujar
	 */
	public PanelCanvas(VentanaPrincipal ventana, int ancho, int alto, Composicion c) {
		principal = ventana;
		composicion = c;
		figurasSeleccionadas = new ArrayList<>();
		
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
				if (figurasSeleccionadas.isEmpty()) 
					dibujarEspacio(g2d, f, false); 
				else {
					if (figurasSeleccionadas.contains(f)) {
						dibujarEspacio(g2d, f, true);											
					} else {
						dibujarEspacio(g2d, f, false);
					}
				}
			}
			if (f instanceof Ovalo) {
				if (figurasSeleccionadas.isEmpty()) 
					dibujarDominio(g2d, f, false); 
				else {
					if (figurasSeleccionadas.contains(f)) 
						dibujarDominio(g2d, f, true);					
					 else 	dibujarDominio(g2d, f, false);
				}
			}
			if (f instanceof Circulo) {
				if (figurasSeleccionadas.isEmpty()) 
					dibujarNodo(g2d, f, false); 
				else {
					if (figurasSeleccionadas.contains(f)) 
						dibujarNodo(g2d, f, true);					
					 else 	dibujarNodo(g2d, f, false);
				}
			}
			ArrayList<Arco> arcos = (ArrayList<Arco>) f.darArcos();
			if (!arcos.isEmpty()) {
				for(Arco a : arcos) {
					dibujarArco(g2d, a, false);
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
	
	private void dibujarArco(Graphics2D g2d, Arco arco, boolean focalizado) {
		Point2D start = new Point((int)arco.darPosicionX1(), (int)arco.darPosicionY1());
		Point2D end = new Point((int)arco.darPosicionX2(), (int)arco.darPosicionY2());
		float arrowSize = 20.0f;
		double startx = start.getX();
	    double starty = start.getY();

//	    g2d.setStroke(arrowStroke);
	    double deltax = startx - end.getX();
	    double result;
	    if (deltax == 0.0d) {
	      result = Math.PI / 2;
	    }
	    else {
	      result = Math.atan((starty - end.getY()) / deltax) + (startx < end.getX() ? Math.PI : 0);
	    }

	    double angle = result;

	    double arrowAngle = Math.PI / 12.0d;

	    double x1 = arrowSize * Math.cos(angle - arrowAngle);
	    double y1 = arrowSize * Math.sin(angle - arrowAngle);
	    double x2 = arrowSize * Math.cos(angle + arrowAngle);
	    double y2 = arrowSize * Math.sin(angle + arrowAngle);

	    double cx = (arrowSize / 2.0f) * Math.cos(angle);
	    double cy = (arrowSize / 2.0f) * Math.sin(angle);

	    GeneralPath polygon = new GeneralPath();
	    polygon.moveTo(end.getX(), end.getY());
	    polygon.lineTo(end.getX() + x1, end.getY() + y1);
	    polygon.lineTo(end.getX() + x2, end.getY() + y2);
	    polygon.closePath();
	    g2d.fill(polygon);

//	    g2d.setStroke(lineStroke);
	    g2d.drawLine((int) startx, (int) starty, (int) (end.getX() + cx), (int) (end.getY() + cy));
	    g2d.drawString(arco.darEtiqueta(), (int) (startx * 1.50), (int) (starty / 1.50));
	}
	
	public boolean hayDosFigurasSeleccionadas() {
		return figurasSeleccionadas.size() == 2;
	}
	
	/**
	 * M�todo que actualiza el panel.
	 */
	public void refrescar() {
		repaint();
	}
	
	/**
	 * M�todo que se encarga de retornar la figura seleccionada (que tiene el foco).
	 * @return La figura que ha sido seleccionada con el mouse por el usuario.
	 */
	public ArrayList<Figura> darFigurasSeleccionada() {
		return figurasSeleccionadas;
	}
	
	/**
	 * M�todo que se encarga de agregar a la lista de figuras seleccionadas la figura
	 * especificada. Si la figura ya existe en la lista, no la agrega.
	 * @param f - es la nueva figura que estar� marcada como seleccionada.
	 */
	public void agregarFiguraSeleccionada(Figura f) {
		if (!figurasSeleccionadas.contains(f)) {
			figurasSeleccionadas.add(f);		
		}
		refrescar();
	}
	
	public void quitarFocoFiguras() {
		figurasSeleccionadas = new ArrayList<>();
	}
	
	public Figura darFiguraOrigen() {
		return figurasSeleccionadas.get(0);
	}
	
	public Figura darFiguraDestino() {
		return figurasSeleccionadas.get(1);
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
