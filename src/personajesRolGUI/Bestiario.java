package personajesRolGUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import personajes.CuevaMonstruos;
import personajes.Monstruo;
import personajes.Taberna;
import utiles.Gestion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Bestiario extends VentanaPadre {

	private final JPanel contentPanel = new JPanel();
	private JLabel lbNombreMonstruo;
	private JLabel lbImgMonstruo;
	private int indiceMonstruos=0;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JLabel lbFondoMadera;
	
	/**
	 * Create the dialog.
	 */
	public Bestiario(CuevaMonstruos cueva) {
		super();
		setModal(true);
		setResizable(false);
		setTitle("Bestiario");
		setBounds(100, 100, 479, 330);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lbImgMonstruo = new JLabel("");
		lbImgMonstruo.setHorizontalAlignment(SwingConstants.CENTER);
		lbImgMonstruo.setBounds(10, 36, 273, 204);
		contentPanel.add(lbImgMonstruo);
		
		lbNombreMonstruo = new JLabel("");
		lbNombreMonstruo.setHorizontalAlignment(SwingConstants.CENTER);
		lbNombreMonstruo.setForeground(Color.WHITE);
		lbNombreMonstruo.setFont(new Font("AvQest", Font.PLAIN, 20));
		lbNombreMonstruo.setBounds(10, 11, 258, 14);
		contentPanel.add(lbNombreMonstruo);
		
		btnAnterior = new JButton("<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comprobarBoton();
				datosMonstruo(Gestion.cueva.get(--indiceMonstruos));
				comprobarBoton();
			}
		});
		btnAnterior.setBounds(293, 108, 75, 55);
		contentPanel.add(btnAnterior);
		
		btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comprobarBoton();
				datosMonstruo(Gestion.cueva.get(++indiceMonstruos));
				comprobarBoton();
			}
		});
		btnSiguiente.setBounds(378, 108, 75, 55);
		contentPanel.add(btnSiguiente);
		
		lbFondoMadera = new JLabel("");
		lbFondoMadera.setIcon(new ImageIcon("src\\imagenes\\madera.jpg"));
		lbFondoMadera.setBounds(0, 0, 489, 316);
		contentPanel.add(lbFondoMadera);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.DARK_GRAY);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		cargarPrimerMonstruo();
	}

	private void datosMonstruo(Monstruo monstruo) {
		lbNombreMonstruo.setText(monstruo.getNombre());
		lbImgMonstruo.setIcon(new ImageIcon(monstruo.getImagen()));
		
	}
	
	private void comprobarBoton() {
		if (Gestion.cueva.get(indiceMonstruos - 1) == null) {
			btnAnterior.setEnabled(false);
		} else {
			btnAnterior.setEnabled(true);
		}
		if (Gestion.cueva.get(indiceMonstruos + 1) == null) {
			btnSiguiente.setEnabled(false);
		} else {
			btnSiguiente.setEnabled(true);
		}
	}
	
	/**
	 * Comprueba los botones en caso de que no haya personajes. Si hay algún personaje selecciona el primer personaje
	 */
	private void cargarPrimerMonstruo() {
		comprobarBoton();
		if (Gestion.cueva.size() != 0) {
			datosMonstruo(Gestion.cueva.get(indiceMonstruos));
			comprobarBoton();
		}
	}
}
