package com.github.achaaab.graphe.fonction.catalogue;

import com.github.achaaab.graphe.fonction.Fonction;
import com.github.achaaab.graphe.fonction.FonctionParametree;

import static java.lang.Math.atan;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class Atan extends FonctionParametree {

	/**
	 * @param sousFonction
	 * @since 0.0.0
	 */
	public Atan(Fonction sousFonction) {
		super(sousFonction);
	}

	@Override
	public double evaluer() {
		return atan(parametres[0]);
	}

	@Override
	public String toString() {
		return "atan(" + getTexteSousFonctions() + ")";
	}
}