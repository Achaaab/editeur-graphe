package com.github.achaaab.graphe.fonction;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public interface Fonction {

	/**
	 * @param x
	 * @return
	 */
	double evaluer(double x);

	/**
	 * @return
	 */
	String getTexte();
}