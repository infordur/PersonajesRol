package utiles;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 * Clase que controla Filtros de extensiones
 * @author Pablo
 *
 */
public class Filtro extends FileFilter {
	private String extension;
	private String description;

	/**
	 * Constructor de la clase filtro
	 * @param extension
	 * @param description
	 */
	public Filtro(String extension, String description) {
		this.extension = extension;
		this.description = description;
	}

	/**
	 * Controla que el fichero acabe con la extensión indicada
	 */
	public boolean accept(File file) {
		if (file.isDirectory()) {
			return true;
		}
		return file.getName().endsWith(extension);
	}

	/**
	 * Devuelve la descripción con un formato específico
	 */
	public String getDescription() {
		return description + String.format(" (*%s)", extension);
	}
}
