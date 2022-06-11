package exceptions;

/**
 * Clase de excepcion Contrase�aIncorrectaException, servira para cuando queramos loguearnos y no exista la contrase�a en la bbdd para el email introducido.
 * @author Rafa
 *
 */
public class Contrase�aIncorrectaException extends Exception{
	
	/**
	 * Constructor Contrase�aIncorrectaException que devolvera un mensaje que se le pase por parametro
	 * @param m de tipo String recibira un texto y lo imprimira cuando se construya 
	 */
	public Contrase�aIncorrectaException(String m) {
		super(m);
	}
}
