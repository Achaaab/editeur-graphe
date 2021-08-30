package com.github.achaaab.graphe.fonction.dictionnaire;

import com.github.achaaab.graphe.fonction.Fonction;
import com.github.achaaab.graphe.fonction.FonctionParametree;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class Pow extends FonctionParametree {

	/**
	 * 
	 * @param sousFonction
	 * @param exposant
	 */
	public Pow(Fonction sousFonction, Fonction exposant) {
		super(sousFonction, exposant);
	}

	@Override
	public double evaluer() {
		return Math.pow(parametres[0], parametres[1]);
	}

	@Override
	public String getTexte() {
		return "pow(" + getTexteSousFonctions() + ")";
	}

}