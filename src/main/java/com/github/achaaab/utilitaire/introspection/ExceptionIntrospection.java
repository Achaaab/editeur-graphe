package com.github.achaaab.utilitaire.introspection;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class ExceptionIntrospection extends Exception {

	/**
	 * UID genere le 01/06/2010
	 */
	private static final long serialVersionUID = 5579415226063891959L;

	/**
	 * @param message
	 * @param cause
	 */
	public ExceptionIntrospection(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param cause
	 */
	public ExceptionIntrospection(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 */
	public ExceptionIntrospection(String message) {
		super(message);
	}

}