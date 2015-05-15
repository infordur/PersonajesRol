package personajes;
/**
 * Interfaz que gestiona la vida, daño y armadura de los personajes, además de aumentarles el nivel o disminuirselo.
 * @author Pablo Durán
 *
 */
public interface Roleable {
	/**
	 * Calcula la vida del personaje
	 */
	void calcularVida();
	/**
	 * Calcula el daño del personaje
	 */
	void calcularDanno();
	/**
	 * Calcula la armadura del personaje
	 */
	void calcularArmadura();
	/**
	 * Sube de nivel al personaje y aumenta sus estadísticas
	 * @throws PersonajeMuertoException Salta al intentar subir de nivel a un personaje muerto
	 */
	void subirNivel() throws PersonajeMuertoException;
	/**
	 * Baja de nivel al personaje y disminuye sus estadísticas
	 */
	void bajarNivel();
}
