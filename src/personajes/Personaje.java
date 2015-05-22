package personajes;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Pattern;
/**
 * Clase padre para la creaci�n de personajes
 * @author Pablo Dur�n
 *
 */
public class Personaje implements Roleable, Serializable {
	/**
	 * Nombre del personaje
	 */
	private String nombre;
	/**
	 * Edad del personaje
	 */
	private String edad;
	/**
	 * Descripci�n sobre el personaje
	 */
	private String descripcion;
	/**
	 * Vida del personaje
	 */
	protected int vida = 100;
	/**
	 * Da�o del personaje
	 */
	protected int danno = 5;
	/**
	 * Armadura del personaje
	 */
	protected int armadura = 2;
	/**
	 * Atributo del personaje
	 */
	protected Atributos atributo;
	/**
	 * Nivel del personaje
	 */
	protected int nivel = 1;
	/**
	 * Estado del personaje
	 */
	protected boolean muerto=false;
	/**
	 * Fecha de creaci�n del personaje
	 */
	private Date fechaCreacion = new Date();
	/**
	 * Incremento de da�o del personaje
	 */
	protected int incDanno;
	/**
	 * Incremento de armadura del personaje
	 */
	protected int incArmadura;
	/**
	 * Incremento de vida del personaje
	 */
	protected int incVida;
	/**
	 * Incremento de da�o al subir de nivel el personaje
	 */
	protected float snDanno;
	/**
	 * Incremento de armadura al subir de nivel el personaje
	 */
	protected float snArmadura;
	/**
	 * Incremento de vida al subir de nivel el personaje
	 */
	protected float snVida;

	/**
	 * Patr�n para el nombre
	 */
	private static final Pattern PATTERN_NOMBRE = Pattern
			.compile("^[A-Z][a-z]{3,25}$");
	/**
	 * Patr�n para la edad
	 */
	private static final Pattern PATTERN_EDAD = Pattern
			.compile("^[1-9]|[1-9][\\d]|1[0-2][\\d]$");


	/**
	 * Constructor de personaje
	 * @param nombre Nombre del personaje
	 * @param edad Edad del personaje
	 * @param descripcion Descripci�n del personaje
	 * @throws NombreInvalidoException Salta al introducir un nombre inv�lido
	 * @throws EdadInvalidaException Salta al introducir una edad inv�lida
	 */
	public Personaje(String nombre, String edad, String descripcion)
			throws NombreInvalidoException, EdadInvalidaException {
		super();
		setNombre(nombre);
		setEdad(edad);
		setDescripcion(descripcion);
		calcularVida(incVida);
		setNivel(nivel);
		setAtributo(atributo);
	}
	
	
	/**
	 * Define la vida inicial del arquero
	 */
	@Override
	public void calcularVida(int incVida) {
		vida = vida + incVida;
	}

	/**
	 * Define el danno inicial del arquero
	 */
	@Override
	public void calcularDanno(int incDanno) {
		danno = danno + incDanno;

	}

	/**
	 * Define la armadura inicial del arquero
	 */
	@Override
	public void calcularArmadura(int incArmadura) {
		armadura = armadura + incArmadura;

	}
	
	/**
	 * Incrementa el nivel del arquero y modifica sus estad�sticas al alza
	 */
	@Override
	public void subirNivel() throws PersonajeMuertoException {
		if (muerto == false) {
			++nivel;
				vida = (int) (vida * snVida);
				danno = (int) (danno * snDanno);
				armadura = (int) (armadura * snArmadura);
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
			--nivel;
			if (atributo == Atributos.DESTREZA) {
				vida = (int) (vida /snVida);
				danno = (int) (danno/snDanno);
				armadura = (int) (armadura/snArmadura);
			}
		}
	}
	
	
	/**
	 * Getter de vida
	 * @return vida Vida del personaje
	 */
	public int getVida() {
		return vida;
	}

	/**
	 * Getter de vida
	 * @return danno Da�o del personaje
	 */
	public int getDanno() {
		return danno;
	}

	/**
	 * Setter de danno
	 * @param danno Da�o del personaje
	 */
	 void setDanno(int danno) {
		this.danno = danno;
	}

	 /**
	  * Getter de muerto
	  * @return muerto true si el personaje est� muerto y false si no.
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
	 * Valida el nombre, s�lo ser� v�lido si empieza por may�scula y contiene letras de la a-z, de
	 * 3 a 25 letras
	 * 
	 * @param nombre Nombre del personaje
	 * @return true si el nombre es v�lido y false si no
	 */
	private static boolean nombreEsValido(String nombre) {
		return PATTERN_NOMBRE.matcher(nombre).matches();
	}

	/**
	 * Valida la edad, s�lo ser� v�lida con valores del 1-120
	 * 
	 * @param edad edad del personaje
	 * @return true si la edad es v�lida y false si no
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
			throw new NombreInvalidoException("El nombre no es v�lido");
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
			throw new EdadInvalidaException("La edad no es v�lida");
		}
	}

	/**
	 * Getter de descripci�n
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Setter de descripci�n
	 * @param descripcion
	 *            the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Getter de fecha de creaci�n
	 * @return the fechaCreacion
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * Setter de fecha de creaci�n
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
