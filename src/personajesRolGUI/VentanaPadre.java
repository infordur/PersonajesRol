package personajesRolGUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.TextArea;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;
import java.awt.Toolkit;
/**
 * Ventana padre que contiene el diseño para la creación de personaje.
 * @author Pablo
 *
 */
public class VentanaPadre extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected final JPanel contentPanel = new JPanel();
	protected JTextField tfNombre;
	protected final ButtonGroup buttonGroup = new ButtonGroup();
	protected JLabel lbImagen;
	protected JLabel lbNombre;
	protected JLabel lbEdad;
	protected JPanel panel;
	protected JRadioButton radioGuerrero;
	protected JRadioButton radioMago;
	protected JRadioButton radioArquero;
	protected TextArea tADescripcion;
	protected JSpinner spEdad;
	protected JLabel lblDescripcin;
	protected JPanel buttonPane;
	protected JButton okButton;
	protected JButton cancelButton;

	/**
	 * Create the dialog.
	 */
	public VentanaPadre() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("src\\imagenes\\logoJuego.png"));
		setBounds(100, 100, 567, 389);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		lbImagen = new JLabel("");
		lbImagen.setBounds(10, 11, 251, 297);
		contentPanel.add(lbImagen);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(348, 11, 146, 20);
		contentPanel.add(tfNombre);
		tfNombre.setColumns(10);
		
		lbNombre = new JLabel("Nombre");
		lbNombre.setBounds(290, 11, 146, 20);
		contentPanel.add(lbNombre);
		
		lbEdad = new JLabel("Edad");
		lbEdad.setBounds(290, 43, 81, 20);
		contentPanel.add(lbEdad);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Clase", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(290, 72, 169, 98);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		radioGuerrero = new JRadioButton("Guerrero");
		radioGuerrero.setBounds(16, 16, 109, 23);
		panel.add(radioGuerrero);
		buttonGroup.add(radioGuerrero);
		
		radioMago = new JRadioButton("Mago");
		radioMago.setBounds(16, 42, 109, 23);
		panel.add(radioMago);
		buttonGroup.add(radioMago);
		
		radioArquero = new JRadioButton("Arquero");
		radioArquero.setBounds(16, 68, 109, 23);
		panel.add(radioArquero);
		buttonGroup.add(radioArquero);
		
		tADescripcion = new TextArea();
		tADescripcion.setBounds(290, 202, 251, 106);
		contentPanel.add(tADescripcion);
		
		spEdad = new JSpinner();
		spEdad.setModel(new SpinnerNumberModel(18, 18, 129, 1));
		spEdad.setBounds(348, 42, 49, 20);
		contentPanel.add(spEdad);
		
		lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setBounds(290, 176, 91, 20);
		contentPanel.add(lblDescripcin);
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
