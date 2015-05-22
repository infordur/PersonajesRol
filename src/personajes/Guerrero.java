package personajes;

import java.io.Serializable;
import java.util.Calendar;
/**
 * Clase Guerrero
 * @author Pablo Dur�n
 *
 */
public class Guerrero extends Personaje implements Serializable{

	/**
	 * Construnstor de la clase Guerrero
	 * @param nombre Nombre del personaje
	 * @param edad Edad del personaje
	 * @param descripcion Breve descripci�n del personaje
	 * @throws NombreInvalidoException Excepci�n que salta si introduces un nombre Inv�lido
	 * @throws EdadInvalidaException Excepci�n que salta si introduces una Edad inv�lida
	 */
	public Guerrero(String nombre, String edad, String descripcion)
			throws NombreInvalidoException, EdadInvalidaException {
		super(nombre, edad, descripcion);
		setAtributo(Atributos.FUERZA);
		incVida=200;
		incDanno=10;
		incArmadura=10;
		snVida=1.35f;
		snArmadura=1.35f;
		snDanno=1.3f;
		calcularVida(incVida);
		calcularDanno(incDanno);
		calcularArmadura(incArmadura);
	}
}
