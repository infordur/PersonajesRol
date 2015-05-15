package personajes;

import java.io.File;

/**
 * Clase  en la que se crean monstruos
 * @author Pablo Durán
 *
 */
public class Monstruo {
	/**
	 * Nombre del monstruo
	 */
	private String nombre;
	/**
	 * Nivel del monstruo
	 */
	private int nivel;
	/**
	 * Imagen del monstruo
	 */
	private String imagen;
	
	/**
	 * Constructor de monstruo
	 * @param nombre Nombre del monstruo
	 * @param nivel Nivel del monstruo
	 * @param string Imagen del monstruo
	 */
	public Monstruo(String nombre, int nivel, String string) {
		setNombre(nombre);
		setNivel(nivel);
		setImagen(string);
	}
	
	
	/**
	 * Getter de imagen
	 * @return the imagen
	 */
	public String getImagen() {
		return imagen;
	}




	/**
	 * Setter de imagen
	 * @param imagen the imagen to set
	 */
	private void setImagen(String imagen) {
		this.imagen = imagen;
	}


	/**
	 * Getter de nombre
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Setter de nombre
	 * @param nombre the nombre to set
	 */
	private void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Getter de nivel
	 * @return the nivel
	 */
	public int getNivel() {
		return nivel;
	}
	
	/**
	 * Setter de nivel
	 * @param nivel the nivel to set
	 */
	private void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	
}
