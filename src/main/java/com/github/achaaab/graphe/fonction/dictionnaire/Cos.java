package com.github.achaaab.graphe.fonction.dictionnaire;

import com.github.achaaab.graphe.fonction.Fonction;
import com.github.achaaab.graphe.fonction.FonctionParametree;

import static java.lang.Math.cos;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class Cos extends FonctionParametree {

	/**
	 * @param sousFonction
	 */
	public Cos(Fonction sousFonction) {
		super(sousFonction);
	}

	@Override
	public double evaluer() {
		return cos(parametres[0]);
	}

	@Override
	public String getTexte() {
		return "cos(" + getTexteSousFonctions() + ")";
	}
}