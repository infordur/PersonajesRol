package personajes;

import java.io.Serializable;
/**
 * Clase Arquero
 * @author Pablo Dur�n
 *
 */
public class Arquero extends Personaje implements Serializable{

	
	/**
	 * Contructor de la clase Arquero
	 * @param nombre Nombre del personaje
	 * @param edad Edad del personaje
	 * @param descripcion Breve descipci�n del personaje
	 * @throws NombreInvalidoException Excepci�n que salta si introduces un nombre Inv�lido
	 * @throws EdadInvalidaException Excepci�n que salta si introduces una Edad inv�lida
	 */
	public Arquero(String nombre, String edad, String descripcion)
			throws NombreInvalidoException, EdadInvalidaException {
		super(nombre, edad, descripcion);
		setAtributo(Atributos.DESTREZA);
		incDanno=15;
		incVida=100;
		incArmadura=5;
		snVida=1.3f;
		snArmadura=1.3f;
		snDanno=1.3f;
		calcularVida(incVida);
		calcularDanno(incDanno);
		calcularArmadura(incArmadura);
	}

}
