package com.github.achaaab.utilitaire;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class GestionnaireException {

	/**
	 * 
	 * @param erreur
	 */
	public static void traiter(Throwable erreur) {

		JFrame fenetreErreur = new JFrame();

		String typeErreur = erreur.getClass().getSimpleName();
		String messageErreur = erreur.getLocalizedMessage();

		StringBuilder message = new StringBuilder();

		message.append(typeErreur);
		message.append("\n\n" + messageErreur);

		Throwable erreurInitiale = ErreurUtilitaire.getErreurInitiale(erreur);

		if (erreurInitiale != erreur) {

			String typeErreurInitiale = erreurInitiale.getClass()
					.getSimpleName();

			String messageErreurInitiale = erreurInitiale.getLocalizedMessage();

			message.append("\nCause : ");
			message.append(typeErreurInitiale);
			message.append('(' + messageErreurInitiale + ')');

		}

		JOptionPane.showMessageDialog(fenetreErreur, message, "Erreur",
				JOptionPane.ERROR_MESSAGE);

	}

}