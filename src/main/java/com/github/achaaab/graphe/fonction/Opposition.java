package com.github.achaaab.graphe.fonction;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class Opposition extends FonctionParametree {

	/**
	 * 
	 * @param sousFonction
	 */
	public Opposition(Fonction sousFonction) {
		super(sousFonction);
	}

	@Override
	public double evaluer() {
		return -parametres[0];
	}

	@Override
	public String getTexte() {
		return "-" + sousFonctions[0].getTexte();
	}

}