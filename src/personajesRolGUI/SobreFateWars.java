package personajesRolGUI;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
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
		setResizable(false);
		setTitle("Sobre FateWars");
		setBounds(100, 100, 512, 220);
		getContentPane().setLayout(null);
		
		JLabel lblDesarrolladoPorPablo = new JLabel("<html><body>Desarrollado por: Pablo Dur\u00E1n Camacho.<br/>\r\nVersion: 2.1\r\n</body></html>");
		lblDesarrolladoPorPablo.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesarrolladoPorPablo.setForeground(Color.WHITE);
		lblDesarrolladoPorPablo.setBounds(10, 91, 496, 88);
		getContentPane().add(lblDesarrolladoPorPablo);
		
		JLabel lbFateWars = new JLabel("");
		lbFateWars.setHorizontalAlignment(SwingConstants.CENTER);
		lbFateWars.setIcon(new ImageIcon("src\\imagenes\\FateWars.png"));
		lbFateWars.setBounds(10, 11, 482, 168);
		getContentPane().add(lbFateWars);
		
		JLabel lbFondoMadera = new JLabel("");
		lbFondoMadera.setIcon(new ImageIcon("src\\imagenes\\madera.jpg"));
		lbFondoMadera.setBounds(0, 0, 519, 192);
		getContentPane().add(lbFondoMadera);

	}
}
