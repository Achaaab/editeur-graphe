package com.github.achaaab.utilitaire.mathematiques;

import static java.lang.Math.max;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class MathematiquesUtilitaire {

	/**
	 * @param entier
	 * @param minimum
	 * @param maximum
	 * @return
	 * @since 0.0.0
	 */
	public static int borner(int entier, int minimum, int maximum) {

		int entierBorne;

		if (entier > maximum) {
			entierBorne = maximum;
		} else {
			entierBorne = max(entier, minimum);
		}

		return entierBorne;
	}
}