package personajesRolGUI;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import personajes.CuevaMonstruos;
import personajes.Monstruo;
import personajes.Taberna;
import utiles.Gestion;
import utiles.Filtro;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Toolkit;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
/**
 * Ventana principal que ejecuta el programa
 * @author Pablo Durán
 *
 */
public class Principal {

	private JFrame frmSintitulo;
	private CrearPersonaje nuevoPj;
	private listaPersonajes miTaberna;
	private JFileChooser guardarComoFile;
	private Filtro filtro = new Filtro(".rol", "Archivo de rol");
	private VerAyuda verAyuda= new VerAyuda();
	private Instrucciones instrucciones =  new Instrucciones();
	private SobreFateWars sobreFateWars = new SobreFateWars();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmSintitulo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSintitulo = new JFrame();
		frmSintitulo.setResizable(false);
		frmSintitulo.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\imagenes\\logoJuego.png"));
		frmSintitulo.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				cerrarVentana();
			}



		});
		frmSintitulo.setTitle("FateWars - Sin_titulo");
		frmSintitulo.setBounds(100, 100, 554, 396);
		frmSintitulo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frmSintitulo.setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.setMnemonic('a');
		menuBar.add(mnArchivo);

		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevoArchivo();
			}
		});
		mnArchivo.add(mntmNuevo);

		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirFichero();
			}
		});
		mnArchivo.add(mntmAbrir);

		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		mnArchivo.addSeparator();
		mnArchivo.add(mntmGuardar);

		JMenuItem mntmGuardarComo = new JMenuItem("Guardar Como");
		mntmGuardarComo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarComo();
			}
		});
		mnArchivo.add(mntmGuardarComo);

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cerrarVentana();
			}
		});
		mnArchivo.addSeparator();
		mnArchivo.add(mntmSalir);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setMnemonic('y');
		menuBar.add(mnAyuda);
		
		JMenuItem mntmVerAyuda = new JMenuItem("ver Ayuda");
		mntmVerAyuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mntmVerAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				verAyuda();
			}
		});
		mnAyuda.add(mntmVerAyuda);
		
		JMenuItem mntmInstrucciones = new JMenuItem("Instrucciones");
		mntmInstrucciones.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK));
		mntmInstrucciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				instrucciones();
			}
		});
		mnAyuda.add(mntmInstrucciones);
		
		JMenuItem mntmSobre = new JMenuItem("sobre FateWars");
		mntmSobre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sobreFateWars();
			}
		});
		mnAyuda.add(mntmSobre);
		frmSintitulo.getContentPane().setLayout(null);

		JButton btnCrearPersonaje = new JButton("Crear Personaje");
		btnCrearPersonaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nuevoPj();
			}
		});
		btnCrearPersonaje.setBounds(204, 205, 139, 23);
		frmSintitulo.getContentPane().add(btnCrearPersonaje);

		JButton btnListaPersonajes = new JButton("Mi Taberna");
		btnListaPersonajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					miTaberna();
				} catch (TabernaVaciaException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),
							"Taberna Vacía", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnListaPersonajes.setBounds(204, 239, 139, 23);
		frmSintitulo.getContentPane().add(btnListaPersonajes);
				
				JButton btnBestiario = new JButton("Bestiario");
				btnBestiario.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						bestiario();
					}
				});
				btnBestiario.setBounds(204, 271, 139, 23);
				frmSintitulo.getContentPane().add(btnBestiario);
				
				JLabel lblNewLabel_1 = new JLabel("");
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setIcon(new ImageIcon("src\\imagenes\\FateWars.png"));
				lblNewLabel_1.setBounds(10, 11, 542, 251);
				frmSintitulo.getContentPane().add(lblNewLabel_1);
		
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setBounds(0, -11, 552, 367);
				lblNewLabel.setIcon(new ImageIcon("src\\imagenes\\portada"));
				frmSintitulo.getContentPane().add(lblNewLabel);
	}

	/**
	 * En caso de que se hayan hecho cambios pregunta al usuario si desea guardar los cambios
	 */
	protected void cerrarVentana() {
		if (Gestion.isModificado() == true) {
			int opcion = JOptionPane.showOptionDialog(null,
					"No has guardado, ¿Desea Guardar?",
					"¿Desea Guardar?",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, null, null);
			switch (opcion) {
			case JOptionPane.YES_OPTION:
				guardar();
				System.exit(0);
				break;
			case JOptionPane.NO_OPTION:
				System.exit(0);
				break;
			case JOptionPane.CANCEL_OPTION:
				frmSintitulo.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				break;
			}
		}
	}

	/**
	 * Crea la ventana ListaPersonajes
	 * @throws TabernaVaciaException
	 */
	protected void miTaberna() throws TabernaVaciaException {
		if (Gestion.taberna.size() != 0) {
			miTaberna = new listaPersonajes(Gestion.taberna);
			miTaberna.setVisible(true);
		} else {
			throw new TabernaVaciaException("No hay personajes en la Taberna");
		}
	}

	/**
	 * Crea la ventana CrearPersonaje
	 */
	protected void nuevoPj() {
		nuevoPj = new CrearPersonaje(Gestion.taberna);
		nuevoPj.setVisible(true);
	}

	/**
	 * Crea la ventana VerAyuda
	 */
	private void verAyuda(){
		verAyuda.setVisible(true);
		verAyuda.toFront();
	}
	
	/**
	 * Crea la ventana instrucciones
	 */
	private void instrucciones() {
		instrucciones.setVisible(true);
		instrucciones.toFront();
	}
	
	/**
	 * Crea la ventana SobreFateWars
	 */
	private void sobreFateWars() {
		sobreFateWars.setVisible(true);
		sobreFateWars.toFront();
	}
	
	/**
	 * Crea la ventana Bestiario
	 */
	private void bestiario(){
		Bestiario bestiario= new Bestiario(Gestion.cueva);
		bestiario.setVisible(true);
	}
	/**
	 * Implementa la función de abrir un archivo
	 */
	private void abrirFichero() {
		if (Gestion.isModificado()) {
			int opcion = JOptionPane.showConfirmDialog(null,
					"No has guardado. ¿Desea guardar?", "Salir",
					JOptionPane.YES_NO_CANCEL_OPTION);
			switch (opcion) {
			case JOptionPane.YES_OPTION:
				guardar();
				abrir();
				return;
			case JOptionPane.NO_OPTION:
				abrir();
				return;
			case JOptionPane.CANCEL_OPTION:
				return;
			}
		}
		abrir();
	}

	/**
	 * Abre un archivo abriendo una ventana de explorador (JFileChooser)
	 */
	protected void abrir() {
		JFileChooser abrir = new JFileChooser();
		abrir.setAcceptAllFileFilterUsed(false);
		abrir.addChoosableFileFilter(filtro);
		if (abrir.showDialog(abrir, "Abrir Archivo") == abrir.APPROVE_OPTION) {
			try {
				Gestion.archivo = abrir.getSelectedFile();
				Gestion.validarArchivo(abrir.getSelectedFile());
				Gestion.taberna = (Taberna) Gestion.abrirArchivo();
				Gestion.setModificado(false);
				frmSintitulo.setTitle("FateWars - "+Gestion.archivo.getName());
			} catch (ClassNotFoundException | IOException ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
				Gestion.setArchivo("FateWars - Sin_titulo");
			}
		}
	}


	/**
	 * Guarda un archivo abriendo una ventana de explorador (JFileChooser)
	 */
	private void guardarComo() {
		guardarComoFile = new JFileChooser();
		guardarComoFile.setAcceptAllFileFilterUsed(false);
		guardarComoFile.addChoosableFileFilter(filtro);
		if (guardarComoFile.APPROVE_OPTION == guardarComoFile.showDialog(
				guardarComoFile, "Guardar Archivo")) {
			try {
				guardarComoFile.setAcceptAllFileFilterUsed(false);
				Gestion.validarArchivo(guardarComoFile.getSelectedFile());
				if (Gestion.archivo.exists()) {
					int opcion = JOptionPane
							.showOptionDialog(
									null,
									"¿Esta seguro de que desea sobreescribir el archivo?",
									"Verificar",
									JOptionPane.YES_NO_CANCEL_OPTION,
									JOptionPane.QUESTION_MESSAGE, null, null,
									null);
					switch (opcion) {
					case JOptionPane.YES_OPTION:
						Gestion.guardarComo(Gestion.taberna, Gestion.archivo);
						break;
					case JOptionPane.NO_OPTION:
						break;
					}
				} else {
					Gestion.guardarComo(Gestion.taberna, Gestion.archivo);
				}
			} catch (IOException ex) {
			}
		}
		frmSintitulo.setTitle("FateWars - "+Gestion.archivo.getName());
	}

	/**
	 * Implementa la función Guardar
	 */
	private void guardar() {
		if (Gestion.archivo.getName().equalsIgnoreCase("FateWars - Sin_titulo")) {
			guardarComo();
		} else {
			try {
				Gestion.guardar(Gestion.taberna);
				frmSintitulo.setTitle("FateWars - "+Gestion.archivo.getName());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Crea una nueva Taberna, en caso de que la taberna haya sido
	 * modificado sin guardarse anteriormente muestra una ventana que pregunta
	 * si deseas guardar. Si la respuesta es si, invoca a guardarComo() que pide
	 * un nombre y crea un archivo con la información. En caso de que la
	 * respuesta sea no mantiene los cambios hechos
	 * 
	 */
	public void nuevoArchivo() {
		if (Gestion.isModificado()) {
			int opcion = JOptionPane.showOptionDialog(null,
					"No has guardado, ¿Desea Guardar?", "¿Desea Guardar?",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, null, null);
			switch (opcion) {
			case JOptionPane.YES_OPTION:
				guardar();
				Gestion.taberna = new Taberna();
				Gestion.setModificado(false);
				frmSintitulo.setTitle("FateWars - Sin_titulo");
				break;
			case JOptionPane.NO_OPTION:
				Gestion.setArchivo("FateWars - Sin_titulo");
				frmSintitulo.setTitle(Gestion.archivo.getName());
				Gestion.taberna = new Taberna();
				Gestion.setModificado(false);
				break;
			}
		} else {
			Gestion.setArchivo("FateWars - Sin_titulo");
			Gestion.taberna = new Taberna();
			frmSintitulo.setTitle(Gestion.archivo.getName());
			Gestion.setModificado(false);
		}

	}
}
