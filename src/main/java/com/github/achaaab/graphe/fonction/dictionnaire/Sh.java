package com.github.achaaab.graphe.fonction.dictionnaire;

import com.github.achaaab.graphe.fonction.Fonction;
import com.github.achaaab.graphe.fonction.FonctionParametree;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class Sh extends FonctionParametree {

	/**
	 * 
	 * @param sousFonction
	 */
	public Sh(Fonction sousFonction) {
		super(sousFonction);
	}

	@Override
	public double evaluer() {
		return Math.sinh(parametres[0]);
	}

	@Override
	public String getTexte() {
		return "sh(" + getTexteSousFonctions() + ")";
	}

}