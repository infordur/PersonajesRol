package personajes;

import java.io.Serializable;

public class Mago extends Personaje implements Serializable{
	
	
	/**
	 * Constructor de la clase Mago
	 * @param nombre Nombre del personaje
	 * @param edad Edad del personaje
	 * @param descripcion Breve descripci�n del personaje
	 * @throws NombreInvalidoException Excepci�n que salta si introduces un nombre Inv�lido
	 * @throws EdadInvalidaException Excepci�n que salta si introduces una Edad inv�lidaption
	 */
	public Mago(String nombre, String edad, String descripcion)
			throws NombreInvalidoException, EdadInvalidaException {
		super(nombre, edad, descripcion);
		incVida=20;
		incDanno=20;
		incArmadura=2;
		snVida=1.3f;
		snArmadura=1.3f;
		snDanno=1.35f;
		calcularVida(incVida);
		calcularDanno(incDanno);
		calcularArmadura(incArmadura);
		setAtributo(Atributos.INTELIGENCIA);

	}

}
