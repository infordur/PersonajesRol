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
		calcularVida();
		calcularDanno();
		calcularArmadura();
		setAtributo(Atributos.DESTREZA);
	}

	/**
	 * Define la vida inicial del arquero
	 */
	@Override
	public void calcularVida() {
		vida = vida + 100;

	}

	/**
	 * Define el danno inicial del arquero
	 */
	@Override
	public void calcularDanno() {
		danno = danno + 15;

	}

	/**
	 * Define la armadura inicial del arquero
	 */
	@Override
	public void calcularArmadura() {
		armadura = armadura + 5;

	}

	/**
	 * Incrementa el nivel del arquero y modifica sus estad�sticas al alza
	 */
	@Override
	public void subirNivel() throws PersonajeMuertoException {
		if (muerto == false) {
			nivel = ++nivel;
			if (atributo == Atributos.DESTREZA) {
				vida = (int) (vida * 1.3);
				danno = (int) (danno * 1.3);
				armadura = (int) (armadura * 1.3);
			}
		}
	}

	/**
	 * Decrementa el nivel del arquero y modifica sus estad�sticas a la baja
	 */
	@Override
	public void bajarNivel(){
		if(nivel-1<=0){
			muerto=true;
		}
		else{
			nivel=--nivel;
			if (atributo == Atributos.DESTREZA) {
				vida = (int) (vida /1.3);
				danno = (int) (danno/1.3);
				armadura = (int) (armadura/1.3);
			}
		}
	}

}
