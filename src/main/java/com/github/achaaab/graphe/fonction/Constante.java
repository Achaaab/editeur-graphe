package com.github.achaaab.graphe.fonction;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class Constante extends FonctionAbstraite {

	private final double valeur;

	/**
	 * @param valeur
	 * @since 0.0.0
	 */
	public Constante(double valeur) {
		this.valeur = valeur;
	}

	@Override
	public double evaluer(double x) {
		return valeur;
	}

	@Override
	public String toString() {
		return Double.toString(valeur);
	}
}