package com.github.achaaab.graphe.fonction.dictionnaire;

import com.github.achaaab.graphe.fonction.Fonction;
import com.github.achaaab.graphe.fonction.FonctionParametree;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class Tan extends FonctionParametree {

	/**
	 * 
	 * @param sousFonction
	 */
	public Tan(Fonction sousFonction) {
		super(sousFonction);
	}

	@Override
	public double evaluer() {
		return Math.tan(parametres[0]);
	}

	@Override
	public String getTexte() {
		return "tan(" + getTexteSousFonctions() + ")";
	}

}