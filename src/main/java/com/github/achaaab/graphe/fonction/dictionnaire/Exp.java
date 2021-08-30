package com.github.achaaab.graphe.fonction.dictionnaire;

import com.github.achaaab.graphe.fonction.Fonction;
import com.github.achaaab.graphe.fonction.FonctionParametree;

import static java.lang.Math.exp;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class Exp extends FonctionParametree {

	/**
	 * 
	 * @param sousFonction
	 */
	public Exp(Fonction sousFonction) {
		super(sousFonction);
	}

	@Override
	public double evaluer() {
		return exp(parametres[0]);
	}

	@Override
	public String getTexte() {
		return "exp(" + getTexteSousFonctions() + ")";
	}
}