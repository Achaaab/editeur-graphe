package com.github.achaaab.graphe.fonction.dictionnaire;;

import com.github.achaaab.graphe.fonction.Fonction;
import com.github.achaaab.graphe.fonction.FonctionParametree;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class Tanh extends FonctionParametree {

	/**
	 * 
	 * @param sousFonction
	 */
	public Tanh(Fonction sousFonction) {
		super(sousFonction);
	}

	@Override
	public double evaluer() {
		return Math.tanh(parametres[0]);
	}

	@Override
	public String getTexte() {
		return "tanh(" + getTexteSousFonctions() + ")";
	}

}