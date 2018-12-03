package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class BarraMenu extends JMenuBar implements ActionListener {

	/**
	 * Versión de serialización
	 */
	private static final long serialVersionUID = 1064988928226623879L;
	
	// ------------------------------------------------------------------------------------------
	// Constantes
	// ------------------------------------------------------------------------------------------
	
	private final static String NUEVO = "Nuevo";
	
	private final static String ABRIR = "Abrir";
	
	private final static String GUARDAR = "Guardar";
	
	private final static String EXPORTAR = "Exportar";
	
	private final static String CERRAR = "Cerrar";
	
	// ------------------------------------------------------------------------------------------
	// Atributos
	// ------------------------------------------------------------------------------------------
	
	/**
	 * Representa la relación con la ventana principal
	 */
	private VentanaPrincipal principal;
	
	/**
	 * Representa el menú archivo
	 */
	private JMenu menuArchivo;
	
	/**
	 * Representa el item para hacer un nuevo diagrama.
	 */
	private JMenuItem itemNuevo;
	
	/**
	 * Representa el item para abrir un diagrama existente.
	 */
	private JMenuItem itemAbrir;
	
	/**
	 * Representa el item para guardar el diagrama.
	 */
	private JMenuItem itemGuardar;
	
	/**
	 * Representa el item para exportar el diagrama en formato imagen
	 */
	private JMenuItem itemExportar;
	
	/**
	 * Representa el item para cerrar el diagrama existente.
	 */
	private JMenuItem itemCerrar;

	
	// ------------------------------------------------------------------------------------------
	// Constructor
	// ------------------------------------------------------------------------------------------
	
	/**
	 * @param ventana
	 */
	public BarraMenu(VentanaPrincipal ventana) {
		principal = ventana;
		menuArchivo = new JMenu("Archivo");
		
		itemNuevo = new JMenuItem(NUEVO);
		itemNuevo.setActionCommand(NUEVO);
		itemNuevo.addActionListener(this);
		menuArchivo.add(itemNuevo);
		
		itemAbrir = new JMenuItem(ABRIR);
		itemAbrir.setActionCommand(ABRIR);
		itemAbrir.addActionListener(this);
		menuArchivo.add(itemAbrir);
		
		itemGuardar = new JMenuItem(GUARDAR);
		itemGuardar.setActionCommand(GUARDAR);
		itemGuardar.addActionListener(this);
		menuArchivo.add(itemGuardar);
		
		itemExportar = new JMenuItem(EXPORTAR);
		itemExportar.setActionCommand(EXPORTAR);
		itemExportar.addActionListener(this);
		menuArchivo.add(itemExportar);
		
		menuArchivo.addSeparator();
		
		itemCerrar = new JMenuItem(CERRAR);
		itemCerrar.setActionCommand(CERRAR);
		itemCerrar.addActionListener(this);
		menuArchivo.add(itemCerrar);
		
		add(menuArchivo);
	}
	
	// ------------------------------------------------------------------------------------------
	// Servicios
	// ------------------------------------------------------------------------------------------
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if (comando.equals(NUEVO)) {
			principal.nuevoDiagrama();
		} else if (comando.equals(GUARDAR)) {
			principal.guardarComposicion();
		} else if (comando.equals(ABRIR)) {
			principal.abrirComposicion();
		}
	}

}
