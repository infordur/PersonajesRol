package personajes;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;
/**
 * Clase padre para la creación de personajes
 * @author Pablo Durán
 *
 */
public abstract class Personaje implements Roleable, Serializable {
	private String nombre;
	private String edad;
	private String descripcion;
	protected int vida = 100;
	protected int danno = 5;
	protected int armadura = 2;
	protected Atributos atributo;
	protected int nivel = 1;
	protected boolean muerto=false;
	private Date fechaCreacion = new Date();

	private static final Pattern PATTERN_NOMBRE = Pattern
			.compile("^[A-Z][a-z]{3,25}$");
	private static final Pattern PATTERN_EDAD = Pattern
			.compile("^[1-9]|[1-9][\\d]|1[0-2][\\d]$");

	
	/**
	 * Getter de vida
	 * @return vida Vida del personaje
	 */
	public int getVida() {
		return vida;
	}

	/**
	 * Getter de vida
	 * @return danno Daño del personaje
	 */
	public int getDanno() {
		return danno;
	}

	/**
	 * Setter de danno
	 * @param danno Daño del personaje
	 */
	 void setDanno(int danno) {
		this.danno = danno;
	}

	 /**
	  * Getter de muerto
	  * @return muerto true si el personaje está muerto y false si no.
	  */
	public boolean isMuerto() {
		return muerto;
	}

	/**
	 * Setter de muerto
	 * @param muerto 
	 */
	private void setMuerto(boolean muerto) {
		this.muerto = muerto;
	}

	/**
	 * Constructor de personaje
	 * @param nombre Nombre del personaje
	 * @param edad Edad del personaje
	 * @param descripcion Descripción del personaje
	 * @throws NombreInvalidoException Salta al introducir un nombre inválido
	 * @throws EdadInvalidaException Salta al introducir una edad inválida
	 */
	public Personaje(String nombre, String edad, String descripcion)
			throws NombreInvalidoException, EdadInvalidaException {
		super();
		setNombre(nombre);
		setEdad(edad);
		setDescripcion(descripcion);
		setVida(vida);
		setArmadura(armadura);
		setFechaCreacion(fechaCreacion);
		setNivel(nivel);
		setAtributo(atributo);
	}
	
	
	/**
	 * Getter de atributo
	 * @return the atributo
	 */
	public Atributos getAtributo() {
		return atributo;
	}

	/**
	 * Setter de atributo
	 * @param atributo
	 *            the atributo to set
	 */
	public void setAtributo(Atributos atributo) {
		this.atributo = atributo;
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
	 * @param nivel
	 *            the nivel to set
	 */
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	/**
	 * Setter de vida
	 * @param valor
	 *            the vida to set
	 */
	public void setVida(int valor) {
		this.vida = valor;
	}

	/**
	 * Getter de armadura
	 * @return the armadura
	 */
	public int getArmadura() {
		return armadura;
	}

	/**
	 * Setter de Armadura
	 * @param armadura
	 *            the armadura to set
	 */
	public void setArmadura(int armadura) {
		this.armadura = armadura;
	}

	/**
	 * Valida el nombre, sólo será válido si empieza por mayúscula y contiene letras de la a-z, de
	 * 3 a 25 letras
	 * 
	 * @param nombre Nombre del personaje
	 * @return true si el nombre es válido y false si no
	 */
	private static boolean nombreEsValido(String nombre) {
		return PATTERN_NOMBRE.matcher(nombre).matches();
	}

	/**
	 * Valida la edad, sólo será válida con valores del 1-120
	 * 
	 * @param edad edad del personaje
	 * @return true si la edad es válida y false si no
	 */
	private static boolean edadEsValida(String edad) {
		return PATTERN_EDAD.matcher(edad).matches();
	}

	/**
	 * Getter de Nombre
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Setter de nombre
	 * @param nombre
	 *            the nombre to set
	 * @throws NombreInvalidoException
	 */
	public void setNombre(String nombre) throws NombreInvalidoException {
		if (nombreEsValido(nombre)) {
			this.nombre = nombre;
		} else {
			throw new NombreInvalidoException("El nombre no es válido");
		}

	}

	/**
	 * Getter de edad
	 * @return the edad
	 */
	public String getEdad() {
		return edad;
	}

	/**
	 * Setter de edad
	 * @param edad
	 *            the edad to set
	 * @throws EdadInvalidaException
	 */
	public void setEdad(String edad) throws EdadInvalidaException {
		if (edadEsValida(edad)) {
			this.edad = edad;
		} else {
			throw new EdadInvalidaException("La edad no es válida");
		}
	}

	/**
	 * Getter de descripción
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Setter de descripción
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Getter de fecha de creación
	 * @return the fechaCreacion
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * Setter de fecha de creación
	 * @param fechaCreacion
	 *            the fechaCreacion to set
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * Hash code para controlar el nombre
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	/**
	 * Equals que controla que solo haya 1 personaje con el mismo nombre
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		Personaje other = (Personaje) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}


}
