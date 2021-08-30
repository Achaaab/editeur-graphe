package com.github.achaaab.utilitaire;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class ErreurUtilitaire {

	/**
	 * 
	 * @param erreur
	 * @return
	 */
	public static Throwable getErreurInitiale(Throwable erreur) {

		Throwable cause = erreur.getCause();
		Throwable erreurInitiale;

		if (cause != null && cause != erreur) {
			erreurInitiale = getErreurInitiale(cause);
		} else {
			erreurInitiale = erreur;
		}

		return erreurInitiale;

	}

}