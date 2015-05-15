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
		calcularVida();
		calcularDanno();
		calcularArmadura();
		setAtributo(Atributos.INTELIGENCIA);
	}

	/**
	 * Define la vida inicial del mago
	 */
	@Override
	public void calcularVida() {
		vida = vida + 20;
	}

	/**
	 * Define el da�o inicial del mago
	 */
	@Override
	public void calcularDanno() {
		danno = danno + 20;
	}

	/**
	 * Define la armadura inicial del mago
	 */
	@Override
	public void calcularArmadura() {
		armadura = armadura + 2;
	}

	/**
	 * Incrementa el nivel del mago y modifica sus estad�sticas al alza
	 */
	@Override
	public void subirNivel() throws PersonajeMuertoException {
		if (muerto == false) {
			nivel=++nivel;
			if (atributo == Atributos.INTELIGENCIA && nivel!=20) {
				vida = (int) (vida * 1.3);
				danno = (int) (danno * 1.35);
				armadura = (int) (armadura * 1.3);
			}
		}

	}

	/**
	 * Decrementa el nivel del mago y modifica sus estad�sticas a la baja
	 */
	@Override
	public void bajarNivel(){
		if(nivel-1<=0){
			muerto=true;
		}
		else{
			nivel=--nivel;
			if (atributo == Atributos.INTELIGENCIA) {
				vida = (int) (vida/1.3);
				danno = (int) (danno/1.35);
				armadura = (int) (armadura/1.3);
			}
		}
	}

}
