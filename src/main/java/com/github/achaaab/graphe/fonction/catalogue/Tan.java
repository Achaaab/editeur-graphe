package com.github.achaaab.graphe.fonction.catalogue;

import com.github.achaaab.graphe.fonction.Fonction;
import com.github.achaaab.graphe.fonction.FonctionParametree;

import static java.lang.Math.tan;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class Tan extends FonctionParametree {

	/**
	 * @param sousFonction
	 * @since 0.0.0
	 */
	public Tan(Fonction sousFonction) {
		super(sousFonction);
	}

	@Override
	public double evaluer() {
		return tan(parametres[0]);
	}

	@Override
	public String toString() {
		return "tan(" + getTexteSousFonctions() + ")";
	}
}