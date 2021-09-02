package com.github.achaaab.utilitaire.couleur.choix;

import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public record EcouteurSpinnerComposante(
		ChoixCouleur choixCouleur,
		JSpinner spinner, JSlider slider,
		int indexComposante)
		implements ChangeListener {

	/**
	 * @param choixCouleur
	 * @param spinner
	 * @param slider
	 * @param indexComposante
	 * @since 0.0.0
	 */
	public EcouteurSpinnerComposante(ChoixCouleur choixCouleur, JSpinner spinner, JSlider slider,
			int indexComposante) {

		this.choixCouleur = choixCouleur;
		this.spinner = spinner;
		this.slider = slider;
		this.indexComposante = indexComposante;

		spinner.addChangeListener(this);
	}

	@Override
	public void stateChanged(ChangeEvent evenement) {

		var valeurComposante = (Integer) spinner.getValue();

		slider.setValue(valeurComposante);
		choixCouleur.setComposante(indexComposante, valeurComposante);
	}
}