package com.github.achaaab.utilitaire.couleur;

import java.awt.Color;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public abstract class EspaceColorimetrique {

	private String chaineLongue;

	private String nomComposante0;
	private String nomComposante1;
	private String nomComposante2;

	/**
	 * @param chaineCourte
	 * @param nomComposante0
	 * @param nomComposante1
	 * @param nomComposante2
	 */
	protected EspaceColorimetrique(String chaineCourte, String nomComposante0,
			String nomComposante1, String nomComposante2) {

		this.nomComposante0 = nomComposante0;
		this.nomComposante1 = nomComposante1;
		this.nomComposante2 = nomComposante2;

		chaineLongue = chaineCourte + " (" + nomComposante0 + ", "
				+ nomComposante1 + ", " + nomComposante2 + ")";

	}

	/**
	 * 
	 * @param composantes
	 * @return
	 */
	public final Color getCouleur(int[] composantes) {

		int composante0 = composantes[0];
		int composante1 = composantes[1];
		int composante2 = composantes[2];

		return getCouleur(composante0, composante1, composante2);

	}

	/**
	 * 
	 * @param composante0
	 * @param composante1
	 * @param composante2
	 * @return
	 */
	public abstract Color getCouleur(int composante0, int composante1,
			int composante2);

	/**
	 * 
	 * @param couleur
	 * @return
	 */
	public abstract int[] getComposantes(Color couleur);

	/**
	 * @return the nomComposante0
	 */
	public String getNomComposante0() {
		return nomComposante0;
	}

	/**
	 * @return the nomComposante1
	 */
	public String getNomComposante1() {
		return nomComposante1;
	}

	/**
	 * @return the nomComposante2
	 */
	public String getNomComposante2() {
		return nomComposante2;
	}

	@Override
	public String toString() {
		return chaineLongue;
	}

}