package com.github.achaaab.graphe.fonction;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class Identite extends FonctionAbstraite {

	private String nomVariable;

	/**
	 * @param nomVariable
	 */
	public Identite(String nomVariable) {
		this.nomVariable = nomVariable;
	}

	@Override
	public double evaluer(double x) {
		return x;
	}

	@Override
	public String getTexte() {
		return nomVariable;
	}

}