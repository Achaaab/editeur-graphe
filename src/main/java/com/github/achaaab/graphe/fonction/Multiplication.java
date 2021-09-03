package com.github.achaaab.graphe.fonction;;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class Multiplication extends FonctionParametree {

	/**
	 * @param left
	 * @param right
	 * @since 0.0.0
	 */
	public Multiplication(Fonction left, Fonction right) {
		super(left, right);
	}

	@Override
	public double evaluer() {
		return parametres[0] * parametres[1];
	}

	@Override
	public String toString() {
		return sousFonctions[0] + " * " + sousFonctions[1];
	}
}