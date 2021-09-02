package com.github.achaaab.utilitaire.couleur.choix;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class PresentationEchantillon extends JButton {

	private static final int LARGEUR_ECHANTILLON = 15;
	private static final int HAUTEUR_ECHANTILLON = 15;

	private final ChoixCouleur choixCouleur;
	private final List<Color> echantillons;
	private final int indexEchantillon;

	/**
	 * @param choixCouleur
	 * @param indexEchantillon
	 * @since 0.0.0
	 */
	public PresentationEchantillon(ChoixCouleur choixCouleur, int indexEchantillon) {

		this.choixCouleur = choixCouleur;
		this.indexEchantillon = indexEchantillon;

		echantillons = choixCouleur.getEchantillons();

		setPreferredSize(new Dimension(LARGEUR_ECHANTILLON, HAUTEUR_ECHANTILLON));

		addActionListener(evenement -> appliquerEchantillon());
	}

	/**
	 * @since 0.0.0
	 */
	private void appliquerEchantillon() {

		var echantillon = echantillons.get(indexEchantillon);
		choixCouleur.setCouleur(echantillon);
	}

	@Override
	public void paint(Graphics graphique) {

		var echantillon = echantillons.get(indexEchantillon);

		graphique.setColor(echantillon);
		graphique.fill3DRect(0, 0, LARGEUR_ECHANTILLON, HAUTEUR_ECHANTILLON, true);
	}
}