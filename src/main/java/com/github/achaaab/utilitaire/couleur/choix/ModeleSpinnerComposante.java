package com.github.achaaab.utilitaire.couleur.choix;

import javax.swing.SpinnerNumberModel;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class ModeleSpinnerComposante extends SpinnerNumberModel {

	/**
	 * UID genere le 21/06/2010
	 */
	private static final long serialVersionUID = 5559329146908740329L;

	/**
	 * 
	 * @param composante
	 */
	public ModeleSpinnerComposante(int composante) {
		super(composante, 0, 255, 1);
	}

}