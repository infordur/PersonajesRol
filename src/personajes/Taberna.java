package personajes;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.ListIterator;

import utiles.Gestion;
/**
 * ArrayList de personajes en el que se almacenan todos los personajes .
 * @author Pablo Dur�n
 *
 */
public class Taberna implements Serializable {
	/**
	 * ArrayList  parametrizado de personajes
	 */
	ArrayList<Personaje> taberna = new ArrayList<Personaje>();

	/**
	 * A�ade un personaje al ArrayList
	 * @param nombre Nombre del personaje
	 * @param edad Edad del personaje
	 * @param descripcion Descripci�n del personaje
	 * @param atributo Atributo del personaje
	 * @return true si se ha podido a�adir el personaje o false si no
	 * @throws NombreInvalidoException Salta al intentar a�adir un personaje con nombre inv�lido
	 * @throws EdadInvalidaException Salta al intentar a�adir un personaje con edad inv�lida
	 * @throws PersonajeYaExisteException Salta al intentar a�adir un personaje que ya se encuentra en el ArrayList
	 */
	public boolean annadir(String nombre, String edad, String descripcion,
			Atributos atributo) throws NombreInvalidoException,
			EdadInvalidaException, PersonajeYaExisteException {
		Personaje personaje;
		switch (atributo) {
		case FUERZA:
			personaje = new Guerrero(nombre, edad, descripcion);
			break;
		case INTELIGENCIA:
			personaje = new Mago(nombre, edad, descripcion);
			break;
		case DESTREZA:
			personaje = new Arquero(nombre, edad, descripcion);
			break;
		default:
			personaje = null;
		}
		 if (taberna.contains(personaje)) {
		 throw new PersonajeYaExisteException(
		 "El personaje ya se encuentra en la taberna");
		 }
			
		Gestion.setModificado(true);
		return taberna.add(personaje);
	}

	/**
	 * Elimina un personaje por nombre del ArrayList
	 * @param nombre Nombre del personaje a eliminar
	 * @return true si se ha podido eliminar el personaje o false si no se ha podido.
	 * @throws PersonajeNoExisteException Salta al intentar eliminar un personaje que no existe
	 */
	public boolean eliminar(String nombre) throws PersonajeNoExisteException {
		Personaje personaje = get(nombre);
		if (taberna.contains(personaje)) {
			Gestion.setModificado(true);
			return taberna.remove(personaje);
		}
		throw new PersonajeNoExisteException(
				"El personaje ha salido a defender a los aldeanos");
	}

	/**
	 * Devuelve el tama�o del ArrayList
	 * @return tama�o del ArrayList
	 */
	public int size() {
		return taberna.size();
	}

	/**
	 * Devuelve un personaje por nombre
	 * @param nombre Nombre del personaje
	 * @return personaje
	 */
	public Personaje get(String nombre) {
		for (Personaje personaje : taberna) {
			if(personaje.getNombre().equals(nombre)){
				return personaje;
			}
		}
		return null;
	}

	/**
	 * Devuelve un personaje por �ndice
	 * @param i Posici�n del personaje en el ArrayList
	 * @return personaje
	 */
	public Personaje get(int i) {
		if (taberna.isEmpty()) {
			return null;
		} else if (i < 0 || i > taberna.size() - 1) {
			return null;
		} else {
			return taberna.get(i);
		}
	}

}
