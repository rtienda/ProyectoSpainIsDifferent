package exceptions;

/**
 * Clase de excepcion EmailYaExisteException, servira para cuando queramos registrarnos y ya exista el email en la bbdd
 * @author Rafa
 *
 */
public class EmailYaExisteException extends Exception{
	
	/**
	 * Constructor EmailYaExisteException que devolvera un mensaje que se le pase por parametro
	 * @param m de tipo String recibira un texto y lo imprimira cuando se construya 
	 */
	public EmailYaExisteException (String m) {
		super(m);
	}
}
