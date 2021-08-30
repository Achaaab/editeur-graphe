package com.github.achaaab.utilitaire.couleur.choix;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.border.Border;

import com.github.achaaab.utilitaire.couleur.EspaceColorimetrique;
import com.github.achaaab.utilitaire.mathematiques.MathematiquesUtilitaire;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class PanneauComposantes extends JPanel {

	/**
	 * UID genere le 21/06/2010
	 */
	private static final long serialVersionUID = 9145802906004340625L;

	private static final String TITRE = "Composantes";

	private ChoixCouleur choixCouleur;

	private JLabel labelComposante0;
	private JSlider sliderComposante0;
	private JSpinner spinnerComposante0;

	private JLabel labelComposante1;
	private JSlider sliderComposante1;
	private JSpinner spinnerComposante1;

	private JLabel labelComposante2;
	private JSlider sliderComposante2;
	private JSpinner spinnerComposante2;

	/**
	 * @param choixCouleur
	 */
	public PanneauComposantes(ChoixCouleur choixCouleur) {

		this.choixCouleur = choixCouleur;

		Border bordureInterne = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		Border bordureExterne = BorderFactory.createTitledBorder(TITRE);

		Border bordure = BorderFactory.createCompoundBorder(bordureExterne,
				bordureInterne);

		setBorder(bordure);

		setLayout(new GridBagLayout());

		creerComposants();
		ajouterComposants();
		ajouterEcouteurs();

	}

	/**
	 * 
	 * @param espaceColorimetrique
	 */
	public final void actualiserEspaceColorimetrique(
			EspaceColorimetrique espaceColorimetrique) {

		String nomComposante0 = espaceColorimetrique.getNomComposante0();
		String nomComposante1 = espaceColorimetrique.getNomComposante1();
		String nomComposante2 = espaceColorimetrique.getNomComposante2();

		labelComposante0.setText(nomComposante0);
		labelComposante1.setText(nomComposante1);
		labelComposante2.setText(nomComposante2);

	}

	/**
	 * 
	 */
	private final void creerComposants() {

		EspaceColorimetrique espaceColorimetrique = choixCouleur
				.getEspaceColorimetrique();

		String nomComposante0 = espaceColorimetrique.getNomComposante0();
		String nomComposante1 = espaceColorimetrique.getNomComposante1();
		String nomComposante2 = espaceColorimetrique.getNomComposante2();

		int composante0 = choixCouleur.getComposante0();
		int composante1 = choixCouleur.getComposante1();
		int composante2 = choixCouleur.getComposante2();

		labelComposante0 = new JLabel(nomComposante0);
		labelComposante1 = new JLabel(nomComposante1);
		labelComposante2 = new JLabel(nomComposante2);

		sliderComposante0 = new JSlider(JSlider.HORIZONTAL, 0, 255, composante0);
		sliderComposante1 = new JSlider(JSlider.HORIZONTAL, 0, 255, composante1);
		sliderComposante2 = new JSlider(JSlider.HORIZONTAL, 0, 255, composante2);

		SpinnerModel modele0 = new ModeleSpinnerComposante(composante0);
		SpinnerModel modele1 = new ModeleSpinnerComposante(composante1);
		SpinnerModel modele2 = new ModeleSpinnerComposante(composante2);

		spinnerComposante0 = new JSpinner(modele0);
		spinnerComposante1 = new JSpinner(modele1);
		spinnerComposante2 = new JSpinner(modele2);

	}

	/**
	 * 
	 */
	private final void ajouterComposants() {

		GridBagConstraints contraintes = new GridBagConstraints();

		contraintes.anchor = GridBagConstraints.LINE_START;

		Insets margeDefaut = contraintes.insets;
		Insets margeSliders = new Insets(5, 10, 5, 10);

		/*
		 * la colonne des labels
		 */

		contraintes.gridx = 0;

		contraintes.gridy = 0;
		add(labelComposante0, contraintes);
		contraintes.gridy = 1;
		add(labelComposante1, contraintes);
		contraintes.gridy = 2;
		add(labelComposante2, contraintes);

		/*
		 * la colonne des sliders
		 */

		contraintes.gridx = 1;
		contraintes.insets = margeSliders;

		contraintes.gridy = 0;
		add(sliderComposante0, contraintes);
		contraintes.gridy = 1;
		add(sliderComposante1, contraintes);
		contraintes.gridy = 2;
		add(sliderComposante2, contraintes);

		contraintes.insets = margeDefaut;

		/*
		 * la colonne des spinners
		 */

		contraintes.gridx = 2;

		contraintes.gridy = 0;
		add(spinnerComposante0, contraintes);
		contraintes.gridy = 1;
		add(spinnerComposante1, contraintes);
		contraintes.gridy = 2;
		add(spinnerComposante2, contraintes);

	}

	/**
	 * 
	 * @param composante0
	 * @param composante1
	 */
	public final void setComposantes01(int composante0, int composante1) {

		composante0 = MathematiquesUtilitaire.borner(composante0, 0, 255);
		composante1 = MathematiquesUtilitaire.borner(composante1, 0, 255);

		sliderComposante0.setValue(composante0);
		spinnerComposante0.setValue(composante0);

		sliderComposante1.setValue(composante1);
		spinnerComposante1.setValue(composante1);

	}

	/**
	 * 
	 * @param composante2
	 */
	public final void setComposante2(int composante2) {

		composante2 = MathematiquesUtilitaire.borner(composante2, 0, 255);

		sliderComposante2.setValue(composante2);
		spinnerComposante2.setValue(composante2);

	}

	/**
	 * 
	 */
	public final void actualiserComposantes() {

		int composante0 = choixCouleur.getComposante0();
		int composante1 = choixCouleur.getComposante1();
		int composante2 = choixCouleur.getComposante2();

		sliderComposante0.setValue(composante0);
		spinnerComposante0.setValue(composante0);

		sliderComposante1.setValue(composante1);
		spinnerComposante1.setValue(composante1);

		sliderComposante2.setValue(composante2);
		spinnerComposante2.setValue(composante2);

	}

	/**
	 * 
	 */
	private final void ajouterEcouteurs() {

		new EcouteurSliderComposante(choixCouleur, sliderComposante0,
				spinnerComposante0, 0);
		new EcouteurSliderComposante(choixCouleur, sliderComposante1,
				spinnerComposante1, 1);
		new EcouteurSliderComposante(choixCouleur, sliderComposante2,
				spinnerComposante2, 2);

		new EcouteurSpinnerComposante(choixCouleur, spinnerComposante0,
				sliderComposante0, 0);
		new EcouteurSpinnerComposante(choixCouleur, spinnerComposante1,
				sliderComposante1, 1);
		new EcouteurSpinnerComposante(choixCouleur, spinnerComposante2,
				sliderComposante2, 2);

	}

}