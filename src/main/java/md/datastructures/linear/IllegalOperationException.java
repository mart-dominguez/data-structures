package md.datastructures.linear;

public class IllegalOperationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IllegalOperationException() {
		super("The operation is not valid");
	}
	
	public IllegalOperationException(String msg) {
		super(msg);
	}

}
