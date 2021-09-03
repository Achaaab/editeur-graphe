package com.github.achaaab.graphe.fonction.catalogue;

import com.github.achaaab.graphe.fonction.Fonction;
import com.github.achaaab.graphe.fonction.FonctionParametree;

import static java.lang.Math.sqrt;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class Sqrt extends FonctionParametree {

	/**
	 * @param sousFonction
	 * @since 0.0.0
	 */
	public Sqrt(Fonction sousFonction) {
		super(sousFonction);
	}

	@Override
	public double evaluer() {
		return sqrt(parametres[0]);
	}

	@Override
	public String toString() {
		return "sqrt(" + getTexteSousFonctions() + ")";
	}
}