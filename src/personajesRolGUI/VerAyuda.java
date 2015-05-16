package personajesRolGUI;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.TextArea;

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
		setBounds(100, 100, 754, 462);

		TextArea textArea = new TextArea();
		textArea.setText("\r\nCreaci\u00F3n de personaje:\r\n\r\n-Nombre:\r\n\tS\u00F3lo se admitir\u00E1n nombres que empiezen por may\u00FAscula y no contengan d\u00EDgitos ni espacios, (ej: Manolo).\r\n-Edad:\r\n\tLa edad del personaje ha de estar comprendida entre 18 y 129 a\u00F1os, por lo tanto no se admiten caracteres alfab\u00E9ticos.\r\n-Clase:\r\n\tSe podr\u00E1 optar entre 3 clases diferentes. Guerrero/Mago/Arquero.\r\n-Descripci\u00F3n.\r\n\tSe podr\u00E1 introducir una breve descripci\u00F3n sobre el personaje, o una historia que narre sus haza\u00F1as y/o vivencias.\r\n\r\nMi Taberna:\r\n\r\nEn la taberna aparecer\u00E1n tus personajes, los cuales puedes consultar su informaci\u00F3n mas destacada o eliminarlos.\r\nEn la taberna tambi\u00E9n se encuentra la opci\u00F3n de jugar con la cual podr\u00E1s \r\nllevarte a tu personaje a buscar monstruos para luchar con ellos\r\nSi un personaje ha muerto en combate no se podr\u00E1 seguir jugando con \u00E9l.\r\n\r\nSistema de lucha:\r\n\r\nEl sistema de lucha es simple. Al pulsar el bot\u00F3n \"Buscar Monstruo\" aparecer\u00E1 un monstruo al azar con un nivel aleatorio.\r\n\t-Si tu personaje tiene el mismo nivel que el monstruo, o superior, subes 1 nivel. (Guerrero lvl 5, Monstruo lvl 4).\r\n\t-Si tu personaje tiene un nivel inferior al del monstruo, bajas 1 nivel, \r\n\tindependientemente de si el monstruo tiene mucho o poco nivel m\u00E1s que tu.\r\n\r\nAl subir de nivel tus estad\u00EDsticas aumentar\u00E1n y al bajar de nivel disminuir\u00E1n.\r\n\r\nEl juego finaliza cuando tu personaje muere o alcanzas el nivel m\u00E1ximo. El nivel m\u00E1ximo es  20.\r\n\r\n\r\n\r\n\t\r\n");
		textArea.setEditable(false);
		getContentPane().add(textArea, BorderLayout.CENTER);

	}

}
