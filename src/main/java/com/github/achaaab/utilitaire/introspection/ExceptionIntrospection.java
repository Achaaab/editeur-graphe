package com.github.achaaab.utilitaire.introspection;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class ExceptionIntrospection extends Exception {

	/**
	 * @param message
	 * @param cause
	 * @since 0.0.0
	 */
	public ExceptionIntrospection(String message, Throwable cause) {
		super(message, cause);
	}
}