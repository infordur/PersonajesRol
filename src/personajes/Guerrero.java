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
		calcularVida();
		calcularArmadura();
		calcularDanno();
		setAtributo(Atributos.FUERZA);
	}

	/**
	 * Define la vida inicial del Guerrero
	 */
	@Override
	public void calcularVida() {
		vida = vida + 200;
	}

	/**
	 * Define el da�o inicial del Guerrero
	 */
	@Override
	public void calcularDanno() {
		danno = danno + 10;
	}

	/**
	 * Define la armadura inicial del Guerrero
	 */
	@Override
	public void calcularArmadura() {
		armadura = armadura + 10;
	}

	/**
	 * Incrementa el nivel del guerrero y modifica sus estad�sticas al alza
	 */
	@Override
	public void subirNivel() throws PersonajeMuertoException {
		if (muerto == false) {
			nivel = ++nivel;
			if(atributo==Atributos.FUERZA){
				danno=(int) (danno*1.3);
				vida=(int) (vida*1.35);
				armadura=(int) (armadura*1.35);
			}
		}
		else{
			throw new PersonajeMuertoException("Tu personaje est� descansando en los cielos");
		}
	}

	/**
	 * Decrementa el nivel del guerrero y modifica sus estad�sticas a la baja
	 */
	@Override
	public void bajarNivel(){
		if(nivel-1<=0){
			muerto=true;
		}
		else{
			nivel=--nivel;
			if(atributo==Atributos.FUERZA){
				danno=(int) (danno/1.3);
				vida=(int) (vida/1.4);
				armadura=(int) (armadura/1.4);
			}
		}
	}


}
