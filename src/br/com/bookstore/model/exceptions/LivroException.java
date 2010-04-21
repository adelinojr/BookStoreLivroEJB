package br.com.bookstore.model.exceptions;

import java.io.Serializable;

public class LivroException extends Exception  implements Serializable  {

	private static final long serialVersionUID = 1L;

	public LivroException() {
		super();
	}

	public LivroException(String message, Throwable cause) {
		super(message, cause);
	}

	public LivroException(String message) {
		super(message);
	}

	public LivroException(Throwable cause) {
		super(cause);
	}
}
