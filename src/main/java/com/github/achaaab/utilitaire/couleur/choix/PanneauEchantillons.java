package com.github.achaaab.utilitaire.couleur.choix;

import javax.swing.JPanel;
import java.awt.Dimension;

import static javax.swing.BorderFactory.createTitledBorder;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class PanneauEchantillons extends JPanel {

	/**
	 * @param choixCouleur
	 * @since 0.0.0
	 */
	public PanneauEchantillons(ChoixCouleur choixCouleur) {

		setPreferredSize(new Dimension(192, 112));

		setBorder(createTitledBorder("Échantillons"));

		var echantillons = choixCouleur.getEchantillons();
		var nombreEchantillons = echantillons.size();

		for (var indexEchantillon = 0; indexEchantillon < nombreEchantillons; indexEchantillon++) {
			add(new PresentationEchantillon(choixCouleur, indexEchantillon));
		}
	}
}