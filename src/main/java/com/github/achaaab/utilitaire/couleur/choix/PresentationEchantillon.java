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

	/**
	 * UID genere le 22/06/2010
	 */
	private static final long serialVersionUID = -9158547950323175912L;

	private static final int LARGEUR_ECHANTILLON = 15;
	private static final int HAUTEUR_ECHANTILLON = 15;

	private ChoixCouleur choixCouleur;
	private List<Color> echantillons;
	private int indexEchantillon;

	/**
	 * 
	 * @param choixCouleur
	 * @param indexEchantillon
	 */
	public PresentationEchantillon(ChoixCouleur choixCouleur,
			int indexEchantillon) {

		this.choixCouleur = choixCouleur;
		this.indexEchantillon = indexEchantillon;

		echantillons = choixCouleur.getEchantillons();

		setPreferredSize(new Dimension(LARGEUR_ECHANTILLON, HAUTEUR_ECHANTILLON));

		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evenement) {
				appliquerEchantillon();
			}

		});

	}

	/**
	 * 
	 */
	private final void appliquerEchantillon() {

		Color echantillon = echantillons.get(indexEchantillon);
		choixCouleur.setCouleur(echantillon);

	}

	@Override
	public final void paint(Graphics graphique) {

		Color echantillon = echantillons.get(indexEchantillon);

		graphique.setColor(echantillon);

		graphique.fill3DRect(0, 0, LARGEUR_ECHANTILLON, HAUTEUR_ECHANTILLON,
				true);

	}

}