package utiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.regex.Pattern;

import personajes.Taberna;

public class Gestion {

	/**
	 * Creación de la taberna
	 */
	public static Taberna taberna= new Taberna();
	static boolean modificado = false;
	/**
	 * Patrón para validar la extensión de un archivo
	 */
	private static final Pattern PATTERN_EXTENSION = Pattern
			.compile("^((\\w)+(\\.rol))$");
	/**
	 * Archivo con nombre por defecto (Sin_titulo)
	 */
	public static File archivo=new File("FateWars - Sin_titulo");

	/**
	 * Getter de archivo
	 * @return the archivo
	 */
	private static File getArchivo() {
		return archivo;
	}

	/**
	 * Setter de archivo
	 * @param archivo
	 *            the archivo to set
	 */
	public static void setArchivo(String archivo) {
		Gestion.archivo = new File(archivo);
	}

	
	
	/**
	 * Abre un archivo
	 * 
	 * @return Objeto con la información del objeto abierto
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Object abrirArchivo() throws IOException,
			ClassNotFoundException {
		Object aux;
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				Gestion.archivo))) {
			aux = in.readObject();
			return aux;
		}
	}
	
	/**
	 * Valida el nombre del archivo dependiendo de un patrón
	 * @param archivo Archivo que deseas validar
	 * @return Archivo con la extensión (.obj)
	 */
	public static File validarArchivo(File archivo) {
		if (PATTERN_EXTENSION.matcher(archivo.getName()).matches()) {
			return archivo;
		} else {
			setArchivo(archivo.getAbsolutePath() + ".rol");
			return archivo;
		}
	}

	/**
	 * Guarda la información en un archivo al cual se le define el nombre
	 * @param objeto Objeto que deseas guardar
	 * @param nombre Nombre del archivo
	 * @throws IOException
	 */
	public static void guardarComo(Object objeto, File nombre)
			throws IOException {
		archivo = nombre;
		try (ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream(archivo))) {
			setModificado(false);
			out.writeObject(objeto);
		}
	}

	/**
	 * Guarda la información del parámetro en un archivo
	 * @param objeto Objeto que desees guardar
	 * @throws IOException
	 */
	public static void guardar(Object objeto) throws IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream(archivo))) {
			setModificado(false);
			out.writeObject(objeto);
		}
	}

	/**
	 * @return the modificado
	 */
	public static boolean isModificado() {
		return modificado;
	}

	/**
	 * @param modificado the modificado to set
	 */
	public static void setModificado(boolean modificado) {
		Gestion.modificado = modificado;
	}

}
