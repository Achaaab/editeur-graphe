package com.github.achaaab.utilitaire.couleur.choix;

import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class EcouteurSliderComposante implements ChangeListener {

	private ChoixCouleur choixCouleur;

	private JSlider slider;
	private JSpinner spinner;

	private int indexComposante;

	/**
	 * 
	 * @param choixCouleur
	 * @param slider
	 * @param spinner
	 * @param indexComposante
	 */
	public EcouteurSliderComposante(ChoixCouleur choixCouleur, JSlider slider,
			JSpinner spinner, int indexComposante) {

		this.choixCouleur = choixCouleur;
		this.slider = slider;
		this.spinner = spinner;
		this.indexComposante = indexComposante;

		slider.addChangeListener(this);

	}

	@Override
	public void stateChanged(ChangeEvent evenement) {

		int valeurComposante = slider.getValue();

		spinner.setValue(valeurComposante);
		choixCouleur.setComposante(indexComposante, valeurComposante);

	}

}