package com.github.achaaab.graphe.fonction.dictionnaire;

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
	 */
	public Atan(Fonction sousFonction) {
		super(sousFonction);
	}

	@Override
	public double evaluer() {
		return atan(parametres[0]);
	}

	@Override
	public String getTexte() {
		return "atan(" + getTexteSousFonctions() + ")";
	}
}