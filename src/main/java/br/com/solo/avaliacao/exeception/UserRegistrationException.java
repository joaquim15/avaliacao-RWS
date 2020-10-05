package br.com.solo.avaliacao.exeception;

public class UserRegistrationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserRegistrationException(String message) {
		super(message);
	}

	public UserRegistrationException(String message, Throwable cause) {
		super(message, cause);
	}
}
