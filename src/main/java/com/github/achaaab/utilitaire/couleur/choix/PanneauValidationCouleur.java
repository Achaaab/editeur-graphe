package com.github.achaaab.utilitaire.couleur.choix;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class PanneauValidationCouleur extends JPanel {

	/**
	 * UID genere le 22/06/2010
	 */
	private static final long serialVersionUID = -5334489417480545112L;

	private ChoixCouleur choixCouleur;

	private JButton memoriser;
	private JButton valider;
	private JButton annuler;

	/**
	 * @param choixCouleur
	 */
	public PanneauValidationCouleur(ChoixCouleur choixCouleur) {

		this.choixCouleur = choixCouleur;

		creerComposants();
		ajouterComposants();
		ajouterEcouteur();

	}

	/**
	 * 
	 */
	private final void creerComposants() {

		memoriser = new JButton("M�moriser");
		valider = new JButton("Valider");
		annuler = new JButton("Annuler");

	}

	/**
	 * 
	 */
	private final void ajouterComposants() {

		add(memoriser);
		add(valider);
		add(annuler);

	}

	/**
	 * 
	 */
	private final void ajouterEcouteur() {

		memoriser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evenement) {
				choixCouleur.memoriserEchantillon();
			}

		});

		valider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evenement) {
				choixCouleur.valider();
			}

		});

		annuler.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evenement) {
				choixCouleur.annuler();
			}

		});

	}

}