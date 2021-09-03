package com.github.achaaab.graphe.fonction.catalogue;

import com.github.achaaab.graphe.fonction.Fonction;
import com.github.achaaab.graphe.fonction.FonctionParametree;

import static java.lang.Math.pow;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class Pow extends FonctionParametree {

	/**
	 * @param sousFonction
	 * @param exposant
	 * @since 0.0.0
	 */
	public Pow(Fonction sousFonction, Fonction exposant) {
		super(sousFonction, exposant);
	}

	@Override
	public double evaluer() {
		return pow(parametres[0], parametres[1]);
	}

	@Override
	public String toString() {
		return "pow(" + getTexteSousFonctions() + ")";
	}
}