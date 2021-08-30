package com.github.achaaab.utilitaire.couleur.choix;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class PanneauEchantillons extends JPanel {

	/**
	 * UID genere le 22/06/2010
	 */
	private static final long serialVersionUID = -5016390398072922840L;

	/**
	 * 
	 * @param choixCouleur
	 */
	public PanneauEchantillons(ChoixCouleur choixCouleur) {

		setPreferredSize(new Dimension(192, 112));

		setBorder(BorderFactory.createTitledBorder("�chantillons"));

		List<Color> echantillons = choixCouleur.getEchantillons();
		int nombreEchantillons = echantillons.size();

		for (int indexEchantillon = 0; indexEchantillon < nombreEchantillons; indexEchantillon++) {

			add(new PresentationEchantillon(choixCouleur, indexEchantillon));

		}

	}

}