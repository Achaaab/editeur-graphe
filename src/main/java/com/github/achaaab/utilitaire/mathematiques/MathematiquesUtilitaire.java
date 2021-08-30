package com.github.achaaab.utilitaire.mathematiques;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class MathematiquesUtilitaire {

	/**
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return
	 */
	public static final int getDistanceCarree(int x1, int y1, int x2, int y2) {
		return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
	}

	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static final long pgcd(long a, long b) {

		long r = a % b;

		while (r != 0) {

			a = b;
			b = r;
			r = a % b;

		}

		return b;

	}

	/**
	 * 
	 * @param entier
	 * @param minimum
	 * @param maximum
	 * @return
	 */
	public static final int borner(int entier, int minimum, int maximum) {

		int entierBorne;

		if (entier > maximum) {
			entierBorne = maximum;
		} else if (entier < minimum) {
			entierBorne = minimum;
		} else {
			entierBorne = entier;
		}

		return entierBorne;

	}

}