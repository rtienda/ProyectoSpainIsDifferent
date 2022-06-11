package exceptions;

/**
 * Clase de excepcion ContraseñaIncorrectaException, servira para cuando queramos loguearnos y no exista la contraseña en la bbdd para el email introducido.
 * @author Rafa
 *
 */
public class ContraseñaIncorrectaException extends Exception{
	
	/**
	 * Constructor ContraseñaIncorrectaException que devolvera un mensaje que se le pase por parametro
	 * @param m de tipo String recibira un texto y lo imprimira cuando se construya 
	 */
	public ContraseñaIncorrectaException(String m) {
		super(m);
	}
}
