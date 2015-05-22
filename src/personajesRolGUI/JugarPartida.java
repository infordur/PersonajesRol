package personajesRolGUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import personajes.CuevaMonstruos;
import personajes.Monstruo;
import personajes.Personaje;
import personajes.PersonajeMuertoException;
import personajes.Taberna;
import utiles.Gestion;

import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * Ventana en la que se realiza la acción del programa.
 * @author Pablo
 *
 */
public class JugarPartida extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPanel panel;
	private JLabel lbIcono;
	private JLabel lblAtrib;
	private JLabel lblVida;
	private JLabel lbVida;
	private JLabel lbAtrib;
	private JLabel lblDanno;
	private JLabel lbDanno;
	private JLabel lblArmadura;
	private JLabel lbArmadura;
	private JLabel lblNivel;
	private JLabel lbNivel;
	private JLabel lbImagen;
	private Personaje personaje;
	private JTabbedPane tabbedPane;
	private JLabel lblNombre;
	private JLabel lbNombre;
	private TextArea tADescripcion;
	private JLabel lblEdad;
	private JLabel lbEdad;
	private JLabel lbIcon;
	private JLabel lbMonstruo;
	private JLabel lblEstado;
	private JLabel lbEstado;
	private JLabel lbMonstruoImagen;
	private JLabel lbFondo;
	private JLabel lbNombrePj;

	/**
	 * Create the dialog.
	 * 
	 * @param personaje
	 */
	public JugarPartida(final Personaje personaje) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				volverALista();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\imagenes\\logoJuego.png"));
		setTitle("Luchar");
		setAlwaysOnTop(true);
		setResizable(false);
		setBounds(100, 100, 841, 498);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		lbImagen = new JLabel("");
		lbImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lbImagen.setBounds(150, 26, 157, 204);
		contentPanel.add(lbImagen);

		JLabel lbVs = new JLabel("");
		lbVs.setIcon(new ImageIcon("src\\imagenes\\vs.png"));
		lbVs.setHorizontalAlignment(SwingConstants.CENTER);
		lbVs.setBounds(331, 75, 172, 131);
		contentPanel.add(lbVs);

		lbMonstruoImagen = new JLabel("");
		lbMonstruoImagen.setHorizontalAlignment(SwingConstants.CENTER);
		lbMonstruoImagen.setBounds(513, 26, 302, 204);
		contentPanel.add(lbMonstruoImagen);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(28, 236, 654, 180);
		contentPanel.add(tabbedPane);

		panel = new JPanel();
		tabbedPane.addTab("Estadísticas", null, panel, null);
		panel.setLayout(null);

		lbIcono = new JLabel("");
		lbIcono.setBounds(32, 11, 133, 115);
		panel.add(lbIcono);

		lblAtrib = new JLabel("Atrib:");
		lblAtrib.setFont(new Font("AvQest", Font.BOLD, 18));
		lblAtrib.setBounds(175, 45, 68, 25);
		panel.add(lblAtrib);

		lblVida = new JLabel("Vida:");
		lblVida.setFont(new Font("AvQest", Font.BOLD, 18));
		lblVida.setBounds(175, 81, 68, 25);
		panel.add(lblVida);

		lbVida = new JLabel("");
		lbVida.setFont(new Font("AvQest", Font.PLAIN, 18));
		lbVida.setBounds(248, 81, 71, 25);
		panel.add(lbVida);

		lbAtrib = new JLabel("");
		lbAtrib.setFont(new Font("AvQest", Font.PLAIN, 18));
		lbAtrib.setBounds(248, 45, 164, 25);
		panel.add(lbAtrib);

		lblDanno = new JLabel("Da\u00F1o:");
		lblDanno.setFont(new Font("AvQest", Font.BOLD, 18));
		lblDanno.setBounds(432, 45, 78, 25);
		panel.add(lblDanno);

		lbDanno = new JLabel("");
		lbDanno.setFont(new Font("AvQest", Font.PLAIN, 18));
		lbDanno.setBounds(510, 45, 121, 25);
		panel.add(lbDanno);

		lblArmadura = new JLabel("Armadura:");
		lblArmadura.setFont(new Font("AvQest", Font.BOLD, 18));
		lblArmadura.setBounds(401, 81, 109, 25);
		panel.add(lblArmadura);

		lbArmadura = new JLabel("");
		lbArmadura.setFont(new Font("AvQest", Font.PLAIN, 18));
		lbArmadura.setBounds(510, 81, 78, 25);
		panel.add(lbArmadura);

		lblNivel = new JLabel("Nivel:");
		lblNivel.setFont(new Font("AvQest", Font.BOLD, 18));
		lblNivel.setBounds(175, 11, 78, 23);
		panel.add(lblNivel);

		lbNivel = new JLabel("");
		lbNivel.setFont(new Font("AvQest", Font.PLAIN, 18));
		lbNivel.setBounds(248, 11, 109, 23);
		panel.add(lbNivel);
		
		lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("AvQest", Font.BOLD, 18));
		lblEstado.setBounds(423, 11, 87, 14);
		panel.add(lblEstado);
		
		lbEstado = new JLabel("");
		lbEstado.setFont(new Font("AvQest", Font.PLAIN, 18));
		lbEstado.setBounds(510, 11, 106, 14);
		panel.add(lbEstado);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Personaje", null, panel_1, null);
		panel_1.setLayout(null);

		lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("AvQest", Font.BOLD, 18));
		lblNombre.setBounds(183, 11, 90, 14);
		panel_1.add(lblNombre);

		lbNombre = new JLabel("");
		lbNombre.setFont(new Font("AvQest", Font.PLAIN, 18));
		lbNombre.setBounds(259, 11, 154, 14);
		panel_1.add(lbNombre);

		tADescripcion = new TextArea();
		tADescripcion.setEditable(false);
		tADescripcion.setBounds(419, 11, 220, 131);
		panel_1.add(tADescripcion);

		lblEdad = new JLabel("Edad:");
		lblEdad.setFont(new Font("AvQest", Font.BOLD, 18));
		lblEdad.setBounds(183, 50, 66, 14);
		panel_1.add(lblEdad);

		lbEdad = new JLabel("");
		lbEdad.setFont(new Font("AvQest", Font.PLAIN, 18));
		lbEdad.setBounds(259, 50, 154, 14);
		panel_1.add(lbEdad);

		lbIcon = new JLabel("");
		lbIcon.setBounds(31, 11, 133, 115);
		panel_1.add(lbIcon);

		JButton okButton = new JButton("<html><body><center>Buscar</center>\r\nMonstruos</body></html>");
		okButton.setFont(new Font("AvQest", Font.PLAIN, 18));
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					buscarMonstruo(personaje);
				} catch (LosMuertosNoLuchanException e1) {
					JOptionPane.showMessageDialog(contentPanel, e1.getMessage(), "Personaje muerto", JOptionPane.INFORMATION_MESSAGE);
				}
			}

			/**
			 * Busca un monstruo aleatorio, le asigna una imagen y le hace pelear contra el jugador
			 * @param personaje Personaje elegido para luchar
			 * @throws LosMuertosNoLuchanException Salta al intentar buscar monstruos cuando tu personaje está muerto
			 */
			private void buscarMonstruo(final Personaje personaje)
					throws LosMuertosNoLuchanException {
				if (personaje.isMuerto() != true) {
					Monstruo monstruo = Gestion.cueva.generarMonstruoAleatorio();
					lbMonstruoImagen.setIcon(new ImageIcon(monstruo.getImagen()));
					pelea(personaje, monstruo);
				}
				else{
					throw new LosMuertosNoLuchanException("Los muertos no luchan.");
				}
			}
		});
		okButton.setBounds(692, 258, 123, 61);
		contentPanel.add(okButton);
		okButton.setActionCommand("OK");
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("Salir");
		cancelButton.setFont(new Font("AvQest", Font.PLAIN, 18));
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				volverALista();
			}
		});
		cancelButton.setBounds(692, 378, 123, 38);
		contentPanel.add(cancelButton);
		cancelButton.setActionCommand("Cancel");
		
		lbNombrePj = new JLabel("");
		lbNombrePj.setHorizontalAlignment(SwingConstants.CENTER);
		lbNombrePj.setForeground(new Color(255, 255, 255));
		lbNombrePj.setFont(new Font("AvQest", Font.BOLD, 18));
		lbNombrePj.setBounds(60, 11, 338, 14);
		contentPanel.add(lbNombrePj);

		lbMonstruo = new JLabel("");
		lbMonstruo.setHorizontalAlignment(SwingConstants.CENTER);
		lbMonstruo.setForeground(new Color(255, 255, 255));
		lbMonstruo.setFont(new Font("AvQest", Font.BOLD, 18));
		lbMonstruo.setBounds(513, 11, 302, 14);
		contentPanel.add(lbMonstruo);
		
		lbFondo = new JLabel("");
		lbFondo.setIcon(new ImageIcon("src\\imagenes\\bosque.jpg"));
		lbFondo.setBounds(0, 0, 835, 470);
		contentPanel.add(lbFondo);

		datosPersonaje(personaje);
	}
	/**
	 * Crea la ventana listaPersonajes y cierra JugarPartida
	 */
	private void volverALista() {
		ListaPersonajes listapersonajes=new ListaPersonajes(Gestion.taberna);
		dispose();
		listapersonajes.setVisible(true);
	}
	
	/**
	 * Comprueba los datos necesarios para hacer subir de nivel al personaje o bajarselo. Si consigues llegar a nivel máximo te felicita.
	 * @param personaje Personaje con el que juegas
	 * @param monstruo Monstruo contra el que luchas
	 */
	protected void pelea(Personaje personaje, Monstruo monstruo) {
		lbMonstruo.setText(monstruo.getNombre() + " - Nivel: "
				+ monstruo.getNivel());
		if (personaje.getNivel() < monstruo.getNivel()
				&& personaje.isMuerto() != true) {
			personaje.bajarNivel();
			datosPersonaje(personaje);
		} else if (personaje.getNivel() >= Gestion.cueva.getNivelMonstruo(monstruo)
				&& personaje.isMuerto() != true && personaje.getNivel()<20) {
			try {
				personaje.subirNivel();
				datosPersonaje(personaje);
			} catch (PersonajeMuertoException e) {
				JOptionPane.showMessageDialog(contentPanel, e.getMessage(),
						"Error", JOptionPane.ERROR_MESSAGE);
			}
			if(personaje.getNivel()==20){
				JOptionPane.showMessageDialog(contentPanel, "Felicidades. Has llegado a nivel máximo",
						"Felicidades", JOptionPane.INFORMATION_MESSAGE);
				ListaPersonajes listapersonajes=new ListaPersonajes(Gestion.taberna);
				dispose();
				listapersonajes.setVisible(true);
			}
		}
	}

	/**
	 * Rellena los datos del personaje
	 * @param personaje Personaje con el que juegas
	 */
	private void datosPersonaje(Personaje personaje) {
		lbAtrib.setText(String.valueOf(personaje.getAtributo()));
		lbNivel.setText(String.valueOf(personaje.getNivel()));
		lbNombre.setText(personaje.getNombre());
		lbNombrePj.setText(personaje.getNombre());
		lbVida.setText(String.valueOf(personaje.getVida()));
		lbArmadura.setText(String.valueOf(personaje.getArmadura()));
		lbDanno.setText(String.valueOf(personaje.getDanno()));
		if(personaje.isMuerto()==true){
			lbEstado.setText("Muerto");
			lbEstado.setForeground(Color.RED);
		}
		else{
			lbEstado.setText("Vivo");
			lbEstado.setForeground(Color.BLACK);
		}
		asignarImagenPersonaje(personaje);

		lbEdad.setText(personaje.getEdad());
		tADescripcion.setText(personaje.getDescripcion());
	}
	
	/**
	 * Asigna una imagen y un icono al personaje en función de tu atributo
	 * @param personaje Personaje con el que juegas
	 */
	private void asignarImagenPersonaje(Personaje personaje) {
		switch (personaje.getAtributo()) {
		case FUERZA:
			lbImagen.setIcon(new ImageIcon("src\\imagenes\\guerrero2.jpg"));
			lbIcono.setIcon(new ImageIcon("src\\imagenes\\guerreroLogo.png"));
			lbIcon.setIcon(new ImageIcon("src\\imagenes\\guerreroLogo.png"));
			break;
		case INTELIGENCIA:
			lbImagen.setIcon(new ImageIcon("src\\imagenes\\mago2.jpg"));
			lbIcono.setIcon(new ImageIcon("src\\imagenes\\magoLogo.png"));
			lbIcon.setIcon(new ImageIcon("src\\imagenes\\magoLogo.png"));
			break;
		case DESTREZA:
			lbImagen.setIcon(new ImageIcon("src\\imagenes\\arquera2.jpg"));
			lbIcono.setIcon(new ImageIcon("src\\imagenes\\arqueroLogo.png"));
			lbIcon.setIcon(new ImageIcon("src\\imagenes\\arqueroLogo.png"));
			break;
		}
	}
}
