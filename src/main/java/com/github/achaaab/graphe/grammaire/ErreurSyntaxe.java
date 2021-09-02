package com.github.achaaab.graphe.grammaire;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.getProperty;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class ErreurSyntaxe extends Exception {

	private static final String SAUT_LIGNE = getProperty("line.separator", "\n");

	/**
	 * @param cause
	 * @since 0.0.0
	 */
	public ErreurSyntaxe(ParseException cause) {
		super(fabriquerMessage(cause));
	}

	/**
	 * @param cause
	 * @return
	 */
	private static String fabriquerMessage(ParseException cause) {

		var message = new StringBuilder();

		var imagesSymboles = CompilateurFonctionConstants.tokenImage;

		var ligne = cause.currentToken.next.beginLine;
		var colonne = cause.currentToken.next.beginColumn;
		var premierSymbole = colonne <= 1;
		var symboleCourant = imagesSymboles[cause.currentToken.kind];
		var symboleSuivant = imagesSymboles[cause.currentToken.next.kind];
		var symbolesAttendus = cause.expectedTokenSequences;
		var listeSymbolesAttendus = new ArrayList<String>();

		StringBuilder sequenceSymbolesString;

		for (var sequenceSymboles : symbolesAttendus) {

			sequenceSymbolesString = new StringBuilder();

			for (var symbole : sequenceSymboles) {
				sequenceSymbolesString.append(imagesSymboles[symbole]);
			}

			listeSymbolesAttendus.add(sequenceSymbolesString.toString());
		}

		message.append("Le symbole ").append(symboleSuivant).append(" était inattendu");

		if (!premierSymbole) {
			message.append(" après le symbole ").append(symboleCourant);
		}

		message.
				append(" (ligne : ").append(ligne).
				append(", colonne : ").append(colonne).append(").").append(SAUT_LIGNE).
				append(SAUT_LIGNE);

		message.append("Un des symboles suivants était attendu : ");

		for (String symboleAttendu : listeSymbolesAttendus) {
			message.append(SAUT_LIGNE).append("-   ").append(symboleAttendu);
		}

		return message.toString();
	}
}