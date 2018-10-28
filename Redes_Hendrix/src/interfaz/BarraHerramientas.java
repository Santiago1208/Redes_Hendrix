package interfaz;

import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

public class BarraHerramientas extends JToolBar {

	/**
	 * Versión de serialización
	 */
	private static final long serialVersionUID = 7892377757408399408L;
	
	// ------------------------------------------------------------------------------------------
	// Constantes
	// ------------------------------------------------------------------------------------------
	
	
	
	// ------------------------------------------------------------------------------------------
	// Atributos
	// ------------------------------------------------------------------------------------------
	
	/**
	 * Representa el concepto que permite seleccionar solo uno de los botones que estén incluidos
	 * en él.
	 */
	private ButtonGroup grupoBotones;
	
	/**
	 * Representa el botón que permite dibujar espacios.
	 */
	private JToggleButton botonEspacios;
	
	/**
	 * Representa el botón que permite dibujar nodos.
	 */
	private JToggleButton botonNodos;
	
	/**
	 * Representa el botón que permite dibujar dominios.
	 */
	private JToggleButton botonDominios;
	
	/**
	 * Representa el botón que permite dibujar relaciones.
	 */
	private JToggleButton botonRelaciones;
	
	/**
	 * Representa el botón que permite seleccionar figuras
	 */
	private JToggleButton botonSeleccion;
	
	/**
	 * Representa el botón que permite borrar figuras
	 */
	private JToggleButton botonBorrar;
	
	// ------------------------------------------------------------------------------------------
	// Constructor
	// ------------------------------------------------------------------------------------------
	
	/**
	 * Construye la barra de herramientas con todos sus botones.
	 */
	public BarraHerramientas() {
		setFloatable(false);
		setLayout(new GridLayout(6, 1, 10, 10));
		grupoBotones = new ButtonGroup();
		
		botonEspacios = new JToggleButton("Espacios");
		botonNodos = new JToggleButton("Nodos");
		botonDominios = new JToggleButton("Dominios");
		botonRelaciones = new JToggleButton("Relaciones");
		botonSeleccion = new JToggleButton("Seleccionar...");
		botonBorrar = new JToggleButton("Borrar");
		
		grupoBotones.add(botonEspacios);
		grupoBotones.add(botonNodos);
		grupoBotones.add(botonDominios);
		grupoBotones.add(botonRelaciones);
		grupoBotones.add(botonSeleccion);
		grupoBotones.add(botonBorrar);
		
		add(botonEspacios);
		add(botonNodos);
		add(botonDominios);
		add(botonRelaciones);
		add(botonSeleccion);
		add(botonBorrar);
		
		botonSeleccion.setSelected(true);
	}
	
	// ------------------------------------------------------------------------------------------
	// Servicios
	// ------------------------------------------------------------------------------------------
	
	/**
	 * Retorna si el botón de creación de espacios está seleccionado o no.
	 * @return Verdadero si está seleccionado o falso de lo contrario.
	 */
	public boolean botonEspaciosSeleccionado() {
		return botonEspacios.isSelected();
	}
	
	/**
	 * Retorna si el botón de creación de nodos está seleccionado o no.
	 * @return Verdadero si está seleccionado o falso de lo contrario.
	 */
	public boolean botonNodosSeleccionado() {
		return botonNodos.isSelected();
	}
	
	/**
	 * Retorna si el botón de creación de dominios está seleccionado o no.
	 * @return Verdadero si está seleccionado o falso de lo contrario.
	 */
	public boolean botonDominiosSeleccionado() {
		return botonDominios.isSelected();
	}
	
	/**
	 * Retorna si el botón de creación de relaciones está seleccionado o no.
	 * @return Verdadero si está seleccionado o falso de lo contrario.
	 */
	public boolean botonRelacionesSeleccionado() {
		return botonRelaciones.isSelected();
	}
	
	/**
	 * Retorna si el botón de creación de selección está seleccionado o no.
	 * @return Verdadero si está seleccionado o falso de lo contrario.
	 */
	public boolean botonSeleccionSeleccionado() {
		return botonSeleccion.isSelected();
	}
	
	/**
	 * Retorna si el botón de creación de borrar está seleccionado o no.
	 * @return Verdadero si está seleccionado o falso de lo contrario.
	 */
	public boolean botonBorrarSeleccionado() {
		return botonBorrar.isSelected();
	}

}
