package com.github.achaaab.graphe.fonction;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class Division extends FonctionParametree {

	/**
	 * 
	 * @param sousFonction0
	 * @param sousFonction1
	 */
	public Division(Fonction sousFonction0, Fonction sousFonction1) {
		super(sousFonction0, sousFonction1);
	}

	@Override
	public double evaluer() {
		return parametres[0] / parametres[1];
	}

	@Override
	public String getTexte() {

		return sousFonctions[0].getTexte() + " / "
				+ sousFonctions[1].getTexte();

	}

}
