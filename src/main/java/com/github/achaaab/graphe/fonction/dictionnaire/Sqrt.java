package com.github.achaaab.graphe.fonction.dictionnaire;

import com.github.achaaab.graphe.fonction.Fonction;
import com.github.achaaab.graphe.fonction.FonctionParametree;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class Sqrt extends FonctionParametree {

	/**
	 * 
	 * @param sousFonction
	 */
	public Sqrt(Fonction sousFonction) {
		super(sousFonction);
	}

	@Override
	public double evaluer() {
		return Math.sqrt(parametres[0]);
	}

	@Override
	public String getTexte() {
		return "sqrt(" + getTexteSousFonctions() + ")";
	}

}