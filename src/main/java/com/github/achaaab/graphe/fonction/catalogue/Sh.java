package com.github.achaaab.graphe.fonction.catalogue;

import com.github.achaaab.graphe.fonction.Fonction;
import com.github.achaaab.graphe.fonction.FonctionParametree;

import static java.lang.Math.sinh;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class Sh extends FonctionParametree {

	/**
	 * @param sousFonction
	 * @since 0.0.0
	 */
	public Sh(Fonction sousFonction) {
		super(sousFonction);
	}

	@Override
	public double evaluer() {
		return sinh(parametres[0]);
	}

	@Override
	public String toString() {
		return "sh(" + getTexteSousFonctions() + ")";
	}
}