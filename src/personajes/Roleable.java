package personajes;
/**
 * Interfaz que gestiona la vida, da�o y armadura de los personajes, adem�s de aumentarles el nivel o disminuirselo.
 * @author Pablo Dur�n
 *
 */
public interface Roleable {
	/**
	 * Calcula la vida del personaje
	 */
	void calcularVida();
	/**
	 * Calcula el da�o del personaje
	 */
	void calcularDanno();
	/**
	 * Calcula la armadura del personaje
	 */
	void calcularArmadura();
	/**
	 * Sube de nivel al personaje y aumenta sus estad�sticas
	 * @throws PersonajeMuertoException Salta al intentar subir de nivel a un personaje muerto
	 */
	void subirNivel() throws PersonajeMuertoException;
	/**
	 * Baja de nivel al personaje y disminuye sus estad�sticas
	 */
	void bajarNivel();
}
