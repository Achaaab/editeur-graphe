package com.github.achaaab.graphe.fonction.dictionnaire;

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
	 */
	public Ch(Fonction sousFonction) {
		super(sousFonction);
	}

	@Override
	public double evaluer() {
		return cosh(parametres[0]);
	}

	@Override
	public String getTexte() {
		return "ch(" + getTexteSousFonctions() + ")";
	}
}