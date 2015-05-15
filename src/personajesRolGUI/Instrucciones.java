package personajesRolGUI;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.TextArea;

public class Instrucciones extends JDialog {

	/**
	 * Create the dialog.
	 */
	public Instrucciones() {
		setTitle("Instrucciones");
		setBounds(100, 100, 450, 300);
		
		TextArea textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setText("\r\nSistema de lucha:\r\n\r\nSi tienes nivel superior o el mismo nivel que el mosntruo subes 1 nivel. \r\n\tGuerrero nivel 1 vs Monstruo nivel 1 ------>Guerrero nivel 2.\r\nSi tienes nivel inferior al del monstruo bajas 1 nivel.\r\n\tGuerrero nivel 3 vs Monstruo nivel 15 ------> Guerrero nivel 2.\r\nSi tu nivel es 1 y aparece un monstruo con m\u00E1s nivel que tu mueres.\r\n\tGuerrero nivel 1 vs Monstruo nivel 20 ------> Guerrero muerto.\r\n\r\nSi un personaje ha muerto no podr\u00E1s seguir jugando con el.");
		getContentPane().add(textArea, BorderLayout.CENTER);

	}

}
