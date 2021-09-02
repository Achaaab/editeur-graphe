package com.github.achaaab.utilitaire.couleur;

import java.awt.Color;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public abstract class EspaceColorimetrique {

	private final String chaineLongue;

	private final String nomComposante0;
	private final String nomComposante1;
	private final String nomComposante2;

	/**
	 * @param chaineCourte
	 * @param nomComposante0
	 * @param nomComposante1
	 * @param nomComposante2
	 * @since 0.0.0
	 */
	protected EspaceColorimetrique(String chaineCourte,
			String nomComposante0, String nomComposante1, String nomComposante2) {

		this.nomComposante0 = nomComposante0;
		this.nomComposante1 = nomComposante1;
		this.nomComposante2 = nomComposante2;

		chaineLongue = chaineCourte + " (" + nomComposante0 + ", " + nomComposante1 + ", " + nomComposante2 + ")";
	}

	/**
	 * @param composantes
	 * @return
	 * @since 0.0.0
	 */
	public Color getCouleur(int[] composantes) {

		int composante0 = composantes[0];
		int composante1 = composantes[1];
		int composante2 = composantes[2];

		return getCouleur(composante0, composante1, composante2);
	}

	/**
	 * @param composante0
	 * @param composante1
	 * @param composante2
	 * @return
	 * @since 0.0.0
	 */
	public abstract Color getCouleur(int composante0, int composante1, int composante2);

	/**
	 * @param couleur
	 * @return
	 * @since 0.0.0
	 */
	public abstract int[] getComposantes(Color couleur);

	/**
	 * @return
	 * @since 0.0.0
	 */
	public String getNomComposante0() {
		return nomComposante0;
	}

	/**
	 * @return
	 * @since 0.0.0
	 */
	public String getNomComposante1() {
		return nomComposante1;
	}

	/**
	 * @return
	 * @since 0.0.0
	 */
	public String getNomComposante2() {
		return nomComposante2;
	}

	@Override
	public String toString() {
		return chaineLongue;
	}
}