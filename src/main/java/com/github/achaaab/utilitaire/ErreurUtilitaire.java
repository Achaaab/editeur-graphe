package com.github.achaaab.utilitaire;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class ErreurUtilitaire {

	/**
	 * @param erreur
	 * @return
	 * @since 0.0.0
	 */
	public static Throwable getErreurInitiale(Throwable erreur) {

		var cause = erreur.getCause();
		Throwable erreurInitiale;

		if (cause != null && cause != erreur) {
			erreurInitiale = getErreurInitiale(cause);
		} else {
			erreurInitiale = erreur;
		}

		return erreurInitiale;
	}
}