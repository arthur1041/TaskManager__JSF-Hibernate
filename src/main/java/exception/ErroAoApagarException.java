package exception;

public class ErroAoApagarException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public ErroAoApagarException() {
		super("O registro não existe para ser apagado");
	};
}
