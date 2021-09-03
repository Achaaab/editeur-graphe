package com.github.achaaab.graphe.fonction.catalogue;

import com.github.achaaab.graphe.fonction.Fonction;
import com.github.achaaab.graphe.fonction.FonctionParametree;

import static java.lang.Math.sin;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class Sin extends FonctionParametree {

	/**
	 * @param sousFonction
	 * @since 0.0.0
	 */
	public Sin(Fonction sousFonction) {
		super(sousFonction);
	}

	@Override
	public double evaluer() {
		return sin(parametres[0]);
	}

	@Override
	public String toString() {
		return "sin(" + getTexteSousFonctions() + ")";
	}
}