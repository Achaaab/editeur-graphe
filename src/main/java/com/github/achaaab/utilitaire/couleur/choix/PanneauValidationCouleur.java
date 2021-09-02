package com.github.achaaab.utilitaire.couleur.choix;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class PanneauValidationCouleur extends JPanel {

	private final ChoixCouleur choixCouleur;

	private JButton memoriser;
	private JButton valider;
	private JButton annuler;

	/**
	 * @param choixCouleur
	 * @since 0.0.0
	 */
	public PanneauValidationCouleur(ChoixCouleur choixCouleur) {

		this.choixCouleur = choixCouleur;

		creerComposants();
		ajouterComposants();
		ajouterEcouteur();
	}

	/**
	 * @since 0.0.0
	 */
	private void creerComposants() {

		memoriser = new JButton("Mémoriser");
		valider = new JButton("Valider");
		annuler = new JButton("Annuler");
	}

	/**
	 * @since 0.0.0
	 */
	private void ajouterComposants() {

		add(memoriser);
		add(valider);
		add(annuler);
	}

	/**
	 * @since 0.0.0
	 */
	private void ajouterEcouteur() {

		memoriser.addActionListener(evenement -> choixCouleur.memoriserEchantillon());
		valider.addActionListener(evenement -> choixCouleur.valider());
		annuler.addActionListener(evenement -> choixCouleur.annuler());
	}
}