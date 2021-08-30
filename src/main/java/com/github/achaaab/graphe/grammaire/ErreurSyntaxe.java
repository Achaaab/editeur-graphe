package com.github.achaaab.graphe.grammaire;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author guehenneux
 * 
 */
public class ErreurSyntaxe extends Exception {

	/**
	 * UID genere le 16/06/2010
	 */
	private static final long serialVersionUID = -926772550077253865L;

	private static final String SAUT_LIGNE = System.getProperty(
			"line.separator", "\n");

	/**
	 * 
	 * @param cause
	 */
	public ErreurSyntaxe(ParseException cause) {
		super(fabriquerMessage(cause));
	}

	/**
	 * 
	 * @param cause
	 * @return
	 */
	private static final String fabriquerMessage(ParseException cause) {

		StringBuilder fabriqueMessage = new StringBuilder();

		String[] imagesSymboles = CompilateurFonctionConstants.tokenImage;
		imagesSymboles[0] = "<FIN_DE_TEXTE>";

		int ligne = cause.currentToken.next.beginLine;
		int colonne = cause.currentToken.next.beginColumn;

		boolean premierSymbole = colonne <= 1;

		String symboleCourant = imagesSymboles[cause.currentToken.kind];
		String symboleSuivant = imagesSymboles[cause.currentToken.next.kind];

		int[][] symbolesAttendus = cause.expectedTokenSequences;

		List<String> listeSymbolesAttendus = new ArrayList<String>();

		String sequenceSymbolesString;

		for (int[] sequenceSymboles : symbolesAttendus) {

			sequenceSymbolesString = "";

			for (int symbole : sequenceSymboles) {
				sequenceSymbolesString += imagesSymboles[symbole];
			}

			listeSymbolesAttendus.add(sequenceSymbolesString);

		}

		fabriqueMessage.append("Le symbole " + symboleSuivant
				+ " �tait inattendu");

		if (!premierSymbole) {
			fabriqueMessage.append(" apr�s le symbole " + symboleCourant);
		}

		fabriqueMessage.append(" (ligne : " + ligne + ", colonne : " + colonne
				+ ")." + SAUT_LIGNE + SAUT_LIGNE);

		fabriqueMessage.append("Un des symboles suivants �tait attendu : ");

		for (String symboleAttendu : listeSymbolesAttendus) {
			fabriqueMessage.append(SAUT_LIGNE + "-   " + symboleAttendu);
		}

		return fabriqueMessage.toString();

	}

}