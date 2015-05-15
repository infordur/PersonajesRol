package personajes;

import java.util.ArrayList;
import java.util.ListIterator;
/**
 * Lista que contiene monstruos
 * @author Pablo Durán
 *
 */
public class CuevaMonstruos {
	
	/**
	 * ArrayList de monstruos
	 */
	ArrayList<Monstruo> cueva= new ArrayList<Monstruo>();
	
	/**
	 * Añade unos cuantos monstruos a la lista
	 * @return lista de monstruos rellena
	 */
	private ArrayList generarMonstruos(){
		cueva.add(new Monstruo("Goblin", (int)(Math.random()*2+1),  "src\\imagenes\\goblin.jpg"));
		cueva.add(new Monstruo("Golem", (int)(Math.random()*4+1),"src\\imagenes\\Golem.jpg"));
		cueva.add(new Monstruo("Ranquirana", 1,"src\\imagenes\\ranquiran.jpg"));
		cueva.add(new Monstruo("Zombie", (int)(Math.random()*2+1),"src\\imagenes\\zombie.jpg"));
		cueva.add(new Monstruo("Raktatof", 20,"src\\imagenes\\Alto_demonio.jpg"));
		cueva.add(new Monstruo("Fetiche", 1,"src\\imagenes\\Fetiche.jpg"));
		cueva.add(new Monstruo("Tarrasque", (int)(Math.random()*10+5),"src\\imagenes\\tarrasque.jpg"));
		cueva.add(new Monstruo("Dragón rojo", (int)(Math.random()*20+15),"src\\imagenes\\Dragon_Rojo.jpg"));
		cueva.add(new Monstruo("Lobo salvaje", 1,"src\\imagenes\\lobo_salvaje.jpg"));
		cueva.add(new Monstruo("Goblin Rey",10,"src\\imagenes\\goblin_rey.jpg"));
		cueva.add(new Monstruo("Troll de Montaña", (int)(Math.random()*16+9),"src\\imagenes\\troll_montaña.jpg"));
		cueva.add(new Monstruo("Ciempiés", 1,"src\\imagenes\\ciempies.jpg"));
		cueva.add(new Monstruo("Esqueleto Arquero", (int)(Math.random()*12+5),"src\\imagenes\\esqueleto_arquero.jpg"));
		cueva.add(new Monstruo("Slime", 1,"src\\imagenes\\slime.jpg"));
		return cueva;
	}
	
	/**
	 * Saca un monstruo aleatorio de la lista de monstruos
	 * @return
	 */
	public Monstruo generarMonstruoAleatorio(){
		cueva=generarMonstruos();
		return cueva.get((int)(Math.random()*cueva.size()));
	}
		
	/**
	 * Devuelve el nivel del monstruo
	 * @param monstruo Monstruo elegido
	 * @return nivel del monstruo
	 */
	public int getNivelMonstruo(Monstruo monstruo){
		return monstruo.getNivel();
	}
	
}
