package com.github.achaaab.graphe.fonction.catalogue;

import com.github.achaaab.graphe.fonction.Fonction;
import com.github.achaaab.graphe.fonction.FonctionParametree;

import static java.lang.Math.cosh;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class Ch extends FonctionParametree {

	/**
	 * @param sousFonction
	 * @since 0.0.0
	 */
	public Ch(Fonction sousFonction) {
		super(sousFonction);
	}

	@Override
	public double evaluer() {
		return cosh(parametres[0]);
	}

	@Override
	public String toString() {
		return "ch(" + getTexteSousFonctions() + ")";
	}
}