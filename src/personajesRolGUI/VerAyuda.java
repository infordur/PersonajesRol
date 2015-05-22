package personajesRolGUI;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.TextArea;

import javax.swing.JLabel;
import javax.swing.JScrollBar;

import java.awt.Scrollbar;

import javax.swing.JPanel;
import javax.swing.JTextPane;

import java.awt.Point;

/**
 * Muestra información sobre el proyecto
 * @author Pablo Durán
 *
 */
public class VerAyuda extends JDialog {

	/**
	 * Create the dialog.
	 */
	public VerAyuda() {
		setResizable(false);
		setTitle("Ver Ayuda");
		setBounds(100, 100, 617, 493);
		getContentPane().setLayout(null);
		JScrollPane scroll = new JScrollPane();
		scroll.setBounds(0, 0, 611, 465);

		scroll.setPreferredSize(new Dimension(200,300));
		getContentPane().add(scroll);
		
		JTextPane txtpncreacinDePersonaje = new JTextPane();
		txtpncreacinDePersonaje.setEditable(false);
		txtpncreacinDePersonaje.setContentType("text/html");
		txtpncreacinDePersonaje.setText("<html><body>\r\n\r\n<h1>Creaci\u00F3n de personaje:</h1>\r\n<ul>\r\n<li>\r\n<b>Nombre:</b><br/>\r\n\tS\u00F3lo se admitir\u00E1n nombres que empiezen por may\u00FAscula y no contengan d\u00EDgitos ni espacios, (ej: Grithar).<br/><br/>\r\n</li>\r\n<li>\r\n<b>Edad:</b><br/>\r\n\tLa edad del personaje ha de estar comprendida entre 18 y 129 a\u00F1os, por lo tanto no se admiten caracteres alfab\u00E9ticos.<br/><br/>\r\n</li>\r\n<li>\r\n<b>Clase:</b><br/>\r\n\tSe podr\u00E1 optar entre 3 clases diferentes. Guerrero/Mago/Arquero.<br/><br/>\r\n</li>\r\n<li>\r\n<b>Descripci\u00F3n:</b><br/>\r\n\tSe podr\u00E1 introducir una breve descripci\u00F3n sobre el personaje, o una historia que narre sus haza\u00F1as y/o vivencias.<br/><br/>\r\n</li>\r\n</ul>\r\n<h1>Mi Taberna:</h1>\r\n\r\nEn la taberna aparecer\u00E1n tus personajes, los cuales puedes consultar su informaci\u00F3n m\u00E1s destacada o eliminarlos.<br/>\r\nEn la taberna tambi\u00E9n se encuentra la opci\u00F3n de jugar con la cual podr\u00E1s llevarte a tu personaje a buscar monstruos para luchar con ellos.<br/>\r\nSi un personaje ha muerto en combate no se podr\u00E1 seguir jugando con \u00E9l.<br/>\r\n\r\n<h1>Bestiario</h1>\r\nEn el bestiario se podr\u00E1 consultar una lista completa de los monstruos que aparecen en el juego.\r\n\r\n<h1>Sistema de lucha:</h1>\r\n\r\nEl sistema de lucha es simple. Al pulsar el bot\u00F3n \"Buscar Monstruo\" aparecer\u00E1 un monstruo al azar con un nivel aleatorio.<br/>\r\n<ul>\r\n<li>\r\nSi tu personaje tiene el mismo nivel que el monstruo, o superior, subes 1 nivel. (Guerrero lvl 5, Monstruo lvl 4).<br/>\r\n</li>\r\n<li>\r\nSi tu personaje tiene un nivel inferior al del monstruo, bajas 1 nivel, independientemente de si el monstruo tiene mucho o poco nivel m\u00E1s que tu personaje.<br/><br/>\r\n</li>\r\n</ul>\r\nAl subir de nivel tus estad\u00EDsticas aumentar\u00E1n y al bajar de nivel disminuir\u00E1n.<br/>\r\n\r\nEl juego finaliza cuando tu personaje muere o alcanzas el nivel m\u00E1ximo. El nivel m\u00E1ximo es  20.\r\n\r\n</body></html>");
		scroll.setViewportView(txtpncreacinDePersonaje);
		
		
		
		

	}
}
