package com.github.achaaab.graphe.fonction.dictionnaire;

import com.github.achaaab.graphe.fonction.Fonction;
import com.github.achaaab.graphe.fonction.FonctionParametree;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class Sin extends FonctionParametree {

	/**
	 * 
	 * @param sousFonction
	 */
	public Sin(Fonction sousFonction) {
		super(sousFonction);
	}

	@Override
	public double evaluer() {
		return Math.sin(parametres[0]);
	}

	@Override
	public String getTexte() {
		return "sin(" + getTexteSousFonctions() + ")";
	}

}