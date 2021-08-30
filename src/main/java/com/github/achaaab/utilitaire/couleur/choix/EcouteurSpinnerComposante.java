package com.github.achaaab.utilitaire.couleur.choix;

import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class EcouteurSpinnerComposante implements ChangeListener {

	private ChoixCouleur choixCouleur;

	private JSpinner spinner;
	private JSlider slider;

	private int indexComposante;

	/**
	 * 
	 * @param choixCouleur
	 * @param spinner
	 * @param slider
	 * @param indexComposante
	 */
	public EcouteurSpinnerComposante(ChoixCouleur choixCouleur,
			JSpinner spinner, JSlider slider, int indexComposante) {

		this.choixCouleur = choixCouleur;
		this.spinner = spinner;
		this.slider = slider;
		this.indexComposante = indexComposante;

		spinner.addChangeListener(this);

	}

	@Override
	public void stateChanged(ChangeEvent evenement) {

		int valeurComposante = (Integer) spinner.getValue();

		slider.setValue(valeurComposante);
		choixCouleur.setComposante(indexComposante, valeurComposante);

	}

}