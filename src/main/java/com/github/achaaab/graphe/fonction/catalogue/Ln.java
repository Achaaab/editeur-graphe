package com.github.achaaab.graphe.fonction.catalogue;

import com.github.achaaab.graphe.fonction.Fonction;
import com.github.achaaab.graphe.fonction.FonctionParametree;

import static java.lang.Math.log;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class Ln extends FonctionParametree {

	/**
	 * @param sousFonction
	 * @since 0.0.0
	 */
	public Ln(Fonction sousFonction) {
		super(sousFonction);
	}

	@Override
	public double evaluer() {
		return log(parametres[0]);
	}

	@Override
	public String toString() {
		return "ln(" + getTexteSousFonctions() + ")";
	}
}