package personajesRolGUI;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.TextArea;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class Instrucciones extends JDialog {

	/**
	 * Create the dialog.
	 */
	public Instrucciones() {
		setResizable(false);
		setTitle("Instrucciones");
		setBounds(100, 100, 386, 313);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<html><title><h1>Sistema de lucha</h1></title>\r\n<body>\r\nSi tienes nivel superior o el mismo nivel que el mosntruo subes 1 nivel.<br/><br/>\r\n\tGuerrero nivel 1 vs Monstruo nivel 1 ------>Guerrero nivel 2.<br/><br/>\r\nSi tienes nivel inferior al del monstruo bajas 1 nivel.<br/>\r\n\tGuerrero nivel 3 vs Monstruo nivel 15 ------> Guerrero nivel 2.<br/><br/>\r\nSi tu nivel es 1 y aparece un monstruo con m\u00E1s nivel que tu mueres.<br/>\r\n\tGuerrero nivel 1 vs Monstruo nivel 20 ------> Guerrero muerto.<br/><br/>\r\n\r\nSi un personaje ha muerto no podr\u00E1s seguir jugando con el.\r\n</body></html>");
		lblNewLabel.setBounds(10, 0, 358, 264);
		getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 380, 285);
		getContentPane().add(panel);

	}
}
