package com.github.achaaab.utilitaire;

import javax.swing.JFrame;

import static com.github.achaaab.utilitaire.ErreurUtilitaire.getErreurInitiale;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class GestionnaireException {

	/**
	 * @param erreur
	 * @since 0.0.0
	 */
	public static void traiter(Throwable erreur) {

		var fenetreErreur = new JFrame();

		var typeErreur = erreur.getClass().getSimpleName();
		var messageErreur = erreur.getLocalizedMessage();

		var message = new StringBuilder();

		message.append(typeErreur);
		message.append("\n\n").append(messageErreur);

		var erreurInitiale = getErreurInitiale(erreur);

		if (erreurInitiale != erreur) {

			var typeErreurInitiale = erreurInitiale.getClass().getSimpleName();
			var messageErreurInitiale = erreurInitiale.getLocalizedMessage();

			message.append("\nCause : ");
			message.append(typeErreurInitiale);
			message.append('(').append(messageErreurInitiale).append(')');
		}

		showMessageDialog(fenetreErreur, message, "Erreur", ERROR_MESSAGE);
	}
}