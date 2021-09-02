package com.github.achaaab.utilitaire;

import static java.lang.Character.toUpperCase;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class StringUtilitaire {

	/**
	 * @param chaine chaîne de caracteres contenant au moins 1 caractère
	 * @return chaîne de caractères égale, mais avec le premier caractère en majuscule
	 * @since 0.0.0
	 */
	public static String premiereLettreMajuscule(String chaine) {

		var premiereLettre = chaine.charAt(0);
		var resteChaine = chaine.substring(1);
		var premiereLettreMajuscule = toUpperCase(premiereLettre);

		return premiereLettreMajuscule + resteChaine;
	}
}