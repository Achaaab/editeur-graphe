package com.github.achaaab.graphe.fonction;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class Addition extends FonctionParametree {

	/**
	 * @param gauche
	 * @param droite
	 * @since 0.0.0
	 */
	public Addition(Fonction gauche, Fonction droite) {
		super(gauche, droite);
	}

	@Override
	public double evaluer() {
		return parametres[0] + parametres[1];
	}

	@Override
	public String toString() {
		return sousFonctions[0] + " + " + sousFonctions[1];
	}
}