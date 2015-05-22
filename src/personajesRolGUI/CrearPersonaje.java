package personajesRolGUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import personajes.Atributos;
import personajes.EdadInvalidaException;
import personajes.NombreInvalidoException;
import personajes.PersonajeYaExisteException;
import personajes.Taberna;
import utiles.Gestion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * Ventana para la creación de un personaje
 * @author Pablo Durán
 *
 */
public class CrearPersonaje extends VentanaPadre {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public CrearPersonaje(final Taberna taberna) {
		super();
		radioArquero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbImagen.setIcon(new ImageIcon("src\\imagenes\\arquera.jpg"));
			}
		});
		radioMago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbImagen.setIcon(new ImageIcon("src\\imagenes\\mago.jpg"));
			}
		});
		radioGuerrero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lbImagen.setIcon(new ImageIcon("src\\imagenes\\guerrero.jpg"));
			}
		});
		spEdad.setLocation(348, 42);
		lblDescripcin.setLocation(290, 176);
		tADescripcion.setLocation(290, 202);
		panel.setLocation(290, 72);
		lbEdad.setLocation(290, 43);
		lbImagen.setBounds(33, 11, 228, 297);
		lbFondoMadera.setText("");
		tfNombre.setBounds(348, 11, 193, 20);
		setResizable(false);
		setTitle("Crear Personaje");
		radioGuerrero.setSelected(true);
		lbImagen.setIcon(new ImageIcon("src\\imagenes\\guerrero.jpg"));
		tfNombre.setColumns(25);
		
		JLabel lbletras = new JLabel("New label");
		lbletras.setBounds(495, 14, 46, 14);
		contentPanel.add(lbletras);
		
		JLabel label = new JLabel("New label");
		label.setBounds(504, 14, 46, 14);
		contentPanel.add(label);
					
		
		setModal(true);
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					taberna.annadir(tfNombre.getText(),spEdad.getValue().toString() , tADescripcion.getText() , getAtributo());
					resetearDatos();
					JOptionPane.showMessageDialog(contentPanel,"Tu personaje está esperando en la taberna", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				} catch (NombreInvalidoException | EdadInvalidaException | PersonajeYaExisteException e1) {
					JOptionPane.showMessageDialog(contentPanel, e1.getMessage()+". \n4-25 letras y empezar por mayúscula.\nejemplo: Grazler", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		cancelButton.setText("Cancelar");
		okButton.setText("Crear");
	}
	
	
	private void resetearDatos(){
		tfNombre.setText(null);
		spEdad.setValue(18);
		tADescripcion.setText(null);
		radioArquero.setSelected(false);
		radioGuerrero.setSelected(false);
		radioMago.setSelected(false);
	}
	
	/**
	 * Devuelve un atributo en función del radioButton seleccionado
	 * @return Atributo del personaje elegido
	 */
	private Atributos getAtributo(){
		if(radioGuerrero.isSelected()){
			return Atributos.FUERZA;
		}
		else if(radioMago.isSelected()){
			return Atributos.INTELIGENCIA;
		}
		else if(radioArquero.isSelected()){
			return Atributos.DESTREZA;
		}
		else{
			return null;
		}
	}
	
	/**
	 * Asigna una imagen en función del radioButton seleccionado
	 */
	private void getClaseImagen(){
		if(radioGuerrero.isSelected()){
			lbImagen.setIcon(new ImageIcon("src\\imagenes\\guerrero.jpg"));
		}
		else if(radioMago.isSelected()){
			lbImagen.setIcon(new ImageIcon("src\\imagenes\\mago.jpg"));
		}
		else if(radioArquero.isSelected()){
			lbImagen.setIcon(new ImageIcon("src\\imagenes\\arquero.png"));
		}
	}
}
