package com.github.achaaab.graphe.fonction.catalogue;;

import com.github.achaaab.graphe.fonction.Fonction;
import com.github.achaaab.graphe.fonction.FonctionParametree;

import static java.lang.Math.tanh;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class Tanh extends FonctionParametree {

	/**
	 * @param sousFonction
	 * @since 0.0.0
	 */
	public Tanh(Fonction sousFonction) {
		super(sousFonction);
	}

	@Override
	public double evaluer() {
		return tanh(parametres[0]);
	}

	@Override
	public String toString() {
		return "tanh(" + getTexteSousFonctions() + ")";
	}
}