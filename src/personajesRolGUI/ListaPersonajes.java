package personajesRolGUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import personajes.Personaje;
import personajes.PersonajeMuertoException;
import personajes.PersonajeNoExisteException;
import personajes.Taberna;
import utiles.Gestion;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.text.html.StyleSheet.ListPainter;
import javax.swing.JList;
import javax.swing.AbstractListModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * Lista de personajes donde puedes entrar a luchar o eliminarlos, además de moverte entre los distintos personajes.
 * @author Pablo Durán
 *
 */
public class ListaPersonajes extends VentanaPadre {

	private DefaultListModel modelo = new DefaultListModel();
	private String personaje;
	private Taberna taberna;
	private JList listPjs =new JList(); 
	private JLabel lbDanno;
	private JLabel lbArmadura;
	private JLabel lbVida;
	private JLabel lbAtrib;
	private JLabel lbIcono;
	protected JugarPartida jugarPartida;
	private JButton btnJugar;
	private JLabel lbFechaCreacion;
	private int indicePersonajes = 0;
	private JLabel lbEstado;
	private JLabel lbFondoTaberna;

	/**
	 * Create the dialog.
	 * 
	 * @param taberna
	 */
	public ListaPersonajes(final Taberna taberna) {
		super();
		lblDescripcin.setText("Descripci\u00F3n:");
		lbEdad.setText("Edad:");
		lbNombre.setText("Nombre:");
		lbFondoMadera.setText("");
		lbFondoMadera.setVisible(false);
		radioArquero.setForeground(new Color(255, 255, 255));
		radioMago.setForeground(new Color(255, 255, 255));
		radioGuerrero.setForeground(new Color(255, 255, 255));
		radioArquero.setOpaque(false);
		radioMago.setOpaque(false);
		radioGuerrero.setOpaque(false);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Clase", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel.setOpaque(false);
		lblDescripcin.setForeground(new Color(255, 255, 255));
		lbEdad.setForeground(new Color(255, 255, 255));
		lbNombre.setForeground(new Color(255, 255, 255));
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\imagenes\\logoJuego.png"));
		setResizable(false);
		setModal(true);
		setTitle("Taberna");
		tfNombre.setEditable(false);
		this.setSize(780, 460);
		this.taberna = taberna;
		lblDescripcin.setBounds(502, 231, 91, 20);
		spEdad.setBounds(555, 66, 49, 20);
		tADescripcion.setBounds(502, 261, 251, 118);
		panel.setBounds(502, 122, 169, 98);
		lbEdad.setBounds(502, 66, 81, 20);
		lbNombre.setBounds(502, 26, 146, 20);
		tfNombre.setBounds(555, 26, 198, 20);
		lbImagen.setBounds(296, 26, 169, 219);
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarPersonaje(taberna);
				comprobarBtJugar();
			}
			
			/**
			 * Elimina un personaje de la lista, para ello primero pregunta si realmente deseas eliminarlo.
			 * @param taberna ArrayList de personajes
			 */
			private void eliminarPersonaje(final Taberna taberna) {
				try {
					personaje = taberna.get(listPjs.getSelectedIndex())
							.getNombre();
					int opcion = JOptionPane
							.showConfirmDialog(contentPanel,
									"Vas a eliminar a " + personaje
											+ " ¿Estás seguro?", "Eliminar",
									JOptionPane.YES_NO_OPTION);
					switch (opcion) {
					case JOptionPane.YES_OPTION:
						taberna.eliminar(personaje);
						modelo.clear();
						indicePersonajes = 0;
						rellenarLista();
						resetearDatos();
						comprobarBoton();
						break;
					case JOptionPane.NO_OPTION:
						break;
					}

					listPjs.setSelectedIndex(0);
				} catch (PersonajeNoExisteException e1) {
					JOptionPane.showMessageDialog(contentPanel,
							e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		cancelButton.setText("Cancelar");
		okButton.setText("Eliminar");
		tADescripcion.setEditable(false);
		spEdad.setEnabled(false);
		radioArquero.setEnabled(false);
		radioMago.setEnabled(false);
		radioGuerrero.setEnabled(false);
		contentPanel.setLayout(null);
		rellenarLista();

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Estadisticas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel.setBounds(35, 252, 444, 131);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblAtrib = new JLabel("Atrib:");
		lblAtrib.setForeground(new Color(255, 255, 255));
		lblAtrib.setBounds(180, 48, 46, 14);
		panel.add(lblAtrib);

		lbAtrib = new JLabel("");
		lbAtrib.setForeground(new Color(255, 255, 255));
		lbAtrib.setBounds(215, 48, 98, 14);
		panel.add(lbAtrib);

		JLabel lblVida = new JLabel("Vida:");
		lblVida.setForeground(new Color(255, 255, 255));
		lblVida.setBounds(180, 73, 46, 14);
		panel.add(lblVida);

		lbVida = new JLabel("");
		lbVida.setForeground(new Color(255, 255, 255));
		lbVida.setBounds(215, 73, 46, 14);
		panel.add(lbVida);

		JLabel lblDao = new JLabel("Da\u00F1o:");
		lblDao.setForeground(new Color(255, 255, 255));
		lblDao.setBounds(323, 48, 46, 14);
		panel.add(lblDao);

		JLabel lblArmadura = new JLabel("Armadura:");
		lblArmadura.setForeground(new Color(255, 255, 255));
		lblArmadura.setBounds(323, 73, 68, 14);
		panel.add(lblArmadura);

		lbDanno = new JLabel("");
		lbDanno.setForeground(new Color(255, 255, 255));
		lbDanno.setBounds(360, 48, 46, 14);
		panel.add(lbDanno);

		lbArmadura = new JLabel("");
		lbArmadura.setForeground(new Color(255, 255, 255));
		lbArmadura.setBounds(390, 73, 54, 14);
		panel.add(lbArmadura);

		lbIcono = new JLabel("");
		lbIcono.setBounds(21, 11, 133, 115);
		panel.add(lbIcono);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setForeground(new Color(255, 255, 255));
		lblEstado.setBounds(180, 23, 54, 14);
		panel.add(lblEstado);
		
		lbEstado = new JLabel("");
		lbEstado.setForeground(new Color(255, 255, 255));
		lbEstado.setBounds(228, 23, 98, 14);
		panel.add(lbEstado);

		btnJugar = new JButton("JUGAR");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					jugar();
				} catch (LosMuertosNoLuchanException e1) {
					JOptionPane.showMessageDialog(contentPanel,
							e1.getMessage(), "Personaje muerto",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
				listPjs.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null,
						null, null));
				listPjs.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						if (taberna.size() > 0) {
							personaje = taberna.get(listPjs.getSelectedIndex())
									.getNombre();
							datosPersonaje(taberna.get(listPjs.getSelectedIndex()));
							indicePersonajes = listPjs.getSelectedIndex();
							comprobarBoton();
						}
					}
				});
				listPjs.setBounds(43, 26, 198, 149);
				listPjs.setModel(modelo);
				JScrollPane scroll = new JScrollPane(listPjs);
				scroll.setLocation(43, 11);
				scroll.setSize(198, 198);
				scroll.setPreferredSize(new Dimension(200,300));
				contentPanel.add(scroll, BorderLayout.CENTER);
		btnJugar.setBounds(43, 210, 198, 35);
		contentPanel.add(btnJugar);

		comprobarBtJugar(); // comprueba que haya personajes en la
									// taberna para poder jugar.

		JLabel lblFechaCreacion = new JLabel("Fecha Creaci\u00F3n:");
		lblFechaCreacion.setForeground(new Color(255, 255, 255));
		lblFechaCreacion.setBounds(502, 97, 102, 14);
		contentPanel.add(lblFechaCreacion);

		lbFechaCreacion = new JLabel("");
		lbFechaCreacion.setForeground(new Color(255, 255, 255));
		lbFechaCreacion.setBounds(600, 97, 153, 14);
		contentPanel.add(lbFechaCreacion);
		
		lbFondoTaberna = new JLabel("");
		lbFondoTaberna.setIcon(new ImageIcon("src\\imagenes\\madera2.jpg"));
		lbFondoTaberna.setBounds(0, 1, 774, 432);
		contentPanel.add(lbFondoTaberna);

		cargarPrimerPersonaje(taberna);
		
	}

	/**
	 * Comprueba los botones en caso de que no haya personajes. Si hay algún personaje selecciona el primer personaje
	 * @param taberna ArrayList de personajes
	 */
	private void cargarPrimerPersonaje(final Taberna taberna) {
		comprobarBoton();
		if (taberna.size() != 0) {
			datosPersonaje(taberna.get(indicePersonajes));
			listPjs.setSelectedIndex(0);
			comprobarBoton();
		}
	}

	/**
	 * Resetea todos los datos del personaje al eliminarlo y selecciona otro personaje si lo hay.
	 */
	protected void resetearDatos() {
		if (taberna.size() == 0) {
			tfNombre.setText(null);
			radioArquero.setSelected(false);
			radioGuerrero.setSelected(false);
			radioMago.setSelected(false);
			tADescripcion.setText(null);
			lbArmadura.setText(null);
			lbDanno.setText(null);
			lbVida.setText(null);
			lbFechaCreacion.setText(null);
			lbImagen.setIcon(null);
			lbIcono.setIcon(null);
			spEdad.setValue(18);
		} else {
			listPjs.setSelectedIndex(indicePersonajes);
			datosPersonaje(taberna.get(listPjs.getSelectedIndex()));
		}
	}

	/**
	 * Desactiva el botón jugar si no hay personajes
	 */
	private void comprobarBtJugar() {
		if(Gestion.taberna.size()==0)
			btnJugar.setEnabled(false);
		else{
			btnJugar.setEnabled(true);
		}
	}

	/**
	 * Rellena la lista con los personajes existentes en el ArrayList
	 */
	private void rellenarLista() {
		for (int i = 0; i < taberna.size(); i++) {
			modelo.addElement(taberna.get(i).getNombre()+ "- Nivel: "
					+ taberna.get(i).getNivel());
		}
	}

	/**
	 * Rellena los datos del personaje seleccionado.
	 * @param personaje Personaje seleccionado
	 */
	private void datosPersonaje(Personaje personaje) {
		lbAtrib.setText(String.valueOf(personaje.getAtributo()));
		tfNombre.setText(personaje.getNombre());
		lbVida.setText(String.valueOf(personaje.getVida()));
		lbArmadura.setText(String.valueOf(personaje.getArmadura()));
		lbDanno.setText(String.valueOf(personaje.getDanno()));
		lbFechaCreacion.setText(String.valueOf(new SimpleDateFormat(
				"dd-MM-yyyy").format(personaje.getFechaCreacion())));

		if(personaje.isMuerto()==true){
			lbEstado.setText("Muerto");
			lbEstado.setForeground(Color.RED);
		}
		else{
			lbEstado.setText("Vivo");
			lbEstado.setForeground(Color.WHITE);
		}
		switch (personaje.getAtributo()) {
		case FUERZA:
			radioGuerrero.setSelected(true);
			lbImagen.setIcon(new ImageIcon("src\\imagenes\\guerrero2.jpg"));
			lbIcono.setIcon(new ImageIcon("src\\imagenes\\guerreroLogo.png"));
			break;
		case INTELIGENCIA:
			radioMago.setSelected(true);
			lbImagen.setIcon(new ImageIcon("src\\imagenes\\mago2.jpg"));
			lbIcono.setIcon(new ImageIcon("src\\imagenes\\magoLogo.png"));
			break;
		case DESTREZA:
			radioArquero.setSelected(true);
			lbImagen.setIcon(new ImageIcon("src\\imagenes\\arquera2.jpg"));
			lbIcono.setIcon(new ImageIcon("src\\imagenes\\arqueroLogo.png"));
			break;
		}

		spEdad.setValue(Integer.parseInt(personaje.getEdad()));
		tADescripcion.setText(personaje.getDescripcion());
	}

	/**
	 * Instancia la ventana JugarPartida con el personaje seleccionado
	 * @throws LosMuertosNoLuchanException
	 */
	private void jugar() throws LosMuertosNoLuchanException {
		
		if(taberna.get(listPjs.getSelectedIndex()).getNivel()==20){
			JOptionPane.showMessageDialog(contentPanel, "Tu personaje ya está a nivel máximo");
			return;
		}
		if (taberna.get(listPjs.getSelectedIndex()).isMuerto() == false) {
			jugarPartida = new JugarPartida(taberna.get(listPjs
					.getSelectedIndex()));
			jugarPartida.setVisible(true);
			dispose();
		} else {
			throw new LosMuertosNoLuchanException("Los muertos no luchan.");
		}
	}

	/**
	 * Comprueba el botón eliminar.
	 * Los desactiva si no hay más personajes y los activa en caso contrario.
	 */
	private void comprobarBoton() {
		if (taberna.get(indicePersonajes) == null) {
			okButton.setEnabled(false);
		} else {
			okButton.setEnabled(true);
		}
	}
}
