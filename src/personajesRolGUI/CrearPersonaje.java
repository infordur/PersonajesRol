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
/**
 * Ventana para la creaci�n de un personaje
 * @author Pablo Dur�n
 *
 */
public class CrearPersonaje extends VentanaPadre {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public CrearPersonaje(final Taberna taberna) {
		super();
		setResizable(false);
		setTitle("Crear Personaje");
		radioGuerrero.setSelected(true);
		lbImagen.setIcon(new ImageIcon("src\\imagenes\\guerrero.jpg"));
		tfNombre.setColumns(25);
		setModal(true);
		radioArquero.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lbImagen.setIcon(new ImageIcon("src\\imagenes\\arquera.jpg"));
			}
		});
		radioMago.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lbImagen.setIcon(new ImageIcon("src\\imagenes\\mago.jpg"));
			}
		});
		radioGuerrero.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				lbImagen.setIcon(new ImageIcon("src\\imagenes\\guerrero.jpg"));
			}
		});
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					taberna.annadir(tfNombre.getText(),spEdad.getValue().toString() , tADescripcion.getText() , getAtributo());
					JOptionPane.showMessageDialog(contentPanel,"Tu personaje est� esperando en la taberna", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				} catch (NombreInvalidoException | EdadInvalidaException | PersonajeYaExisteException e1) {
					JOptionPane.showMessageDialog(contentPanel, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		cancelButton.setText("Cancelar");
		okButton.setText("Crear");
	}
	
	/**
	 * Devuelve un atributo en funci�n del radioButton seleccionado
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
	 * Asigna una imagen en funci�n del radioButton seleccionado
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