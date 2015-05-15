package personajesRolGUI;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.Label;
import javax.swing.JTextField;
/**
 * Muestra información sobre el programa
 * @author Pablo Durán
 *
 */
public class SobreFateWars extends JDialog {

	/**
	 * Create the dialog.
	 */
	public SobreFateWars() {
		setTitle("Sobre FateWars");
		setBounds(100, 100, 199, 124);
		getContentPane().setLayout(null);
		
		TextArea textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setText("\r\nDesarrollado por: Pablo Dur\u00E1n\r\nVersion 5.0");
		textArea.setBounds(0, 0, 213, 114);
		getContentPane().add(textArea);

	}
}
