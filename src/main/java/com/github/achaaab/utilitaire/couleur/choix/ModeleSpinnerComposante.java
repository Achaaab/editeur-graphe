package com.github.achaaab.utilitaire.couleur.choix;

import javax.swing.SpinnerNumberModel;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class ModeleSpinnerComposante extends SpinnerNumberModel {

	/**
	 * @param composante
	 * @øince 0.0.0
	 */
	public ModeleSpinnerComposante(int composante) {
		super(composante, 0, 255, 1);
	}
}