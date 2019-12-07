package exceptions;

public class InadequateControllerConstructorException extends RuntimeException {

	public InadequateControllerConstructorException(ReflectiveOperationException e) {
		super(e);
	}

}
