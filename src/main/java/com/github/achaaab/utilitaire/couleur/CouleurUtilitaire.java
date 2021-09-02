package com.github.achaaab.utilitaire.couleur;

import static java.lang.Math.round;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class CouleurUtilitaire {

	/**
	 * @param rgb
	 * @return
	 * @since 0.0.0
	 */
	public static int getNiveauGris(int rgb) {

		var r = rgb >> 16 & 0xff;
		var g = rgb >> 8 & 0xff;
		var b = rgb & 0xff;

		return round(r * 0.299f + g * 0.587f + b * 0.114f);
	}
}