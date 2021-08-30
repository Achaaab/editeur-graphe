package com.github.achaaab.graphe.fonction;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public abstract class FonctionParametree extends FonctionAbstraite {

	private static final String SEPARATEUR_PARAMETRES = ", ";

	protected final Fonction[] sousFonctions;
	protected final double[] parametres;
	private final int arite;

	/**
	 * @param sousFonctions
	 */
	public FonctionParametree(Fonction... sousFonctions) {

		this.sousFonctions = sousFonctions;

		arite = sousFonctions.length;
		parametres = new double[arite];
	}

	@Override
	public double evaluer(double x) {

		Fonction sousFonction;

		for (int indexSousFonction = 0; indexSousFonction < arite; indexSousFonction++) {

			sousFonction = sousFonctions[indexSousFonction];
			parametres[indexSousFonction] = sousFonction.evaluer(x);
		}

		return evaluer();
	}

	/**
	 * @return
	 */
	public abstract double evaluer();

	/**
	 * @return
	 */
	protected String getTexteSousFonctions() {

		return stream(sousFonctions).
				map(Fonction::getTexte).
				collect(joining(SEPARATEUR_PARAMETRES));
	}
}