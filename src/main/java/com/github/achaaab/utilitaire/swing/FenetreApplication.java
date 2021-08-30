package com.github.achaaab.utilitaire.swing;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;

import javax.swing.JFrame;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class FenetreApplication extends JFrame {

	/**
	 * @param composant
	 */
	public FenetreApplication(Component composant) {
		this(composant, "Fenêtre de test");
	}

	/**
	 * 
	 * @param composant
	 * @param titre
	 */
	public FenetreApplication(Component composant, String titre) {

		super(titre);

		if (composant instanceof Container) {

			setContentPane((Container) composant);

		} else {

			setLayout(new BorderLayout());
			add(composant, BorderLayout.CENTER);

		}

		setDefaultCloseOperation(EXIT_ON_CLOSE);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);

	}

}