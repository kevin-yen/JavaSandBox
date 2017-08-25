package me.khyen.test.exception;

/**
 * @author Kevin Yen
 */
public class JavaSandBoxException extends Exception {

	public JavaSandBoxException() {
		super();
	}

	public JavaSandBoxException(String msg) {
		super(msg);
	}

	public JavaSandBoxException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public JavaSandBoxException(Throwable cause) {
		super(cause);
	}

}