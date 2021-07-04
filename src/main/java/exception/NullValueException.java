package exception;

public class NullValueException extends RuntimeException {
	
	public NullValueException(String msg) {
		super("Atributo " + msg + " não pode ser nulo.");
	}
	
}
