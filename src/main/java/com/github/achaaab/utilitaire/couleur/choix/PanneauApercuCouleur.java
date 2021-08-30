package com.github.achaaab.utilitaire.couleur.choix;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class PanneauApercuCouleur extends JPanel {

	/**
	 * UID genere le 17/06/2010
	 */
	private static final long serialVersionUID = 3359866459613760836L;

	private static final int TAILLE = 128;

	private ChoixCouleur choixCouleur;

	/**
	 * 
	 * @param choixCouleur
	 */
	public PanneauApercuCouleur(ChoixCouleur choixCouleur) {

		this.choixCouleur = choixCouleur;

		setPreferredSize(new Dimension(TAILLE, TAILLE));

	}

	@Override
	public void paint(Graphics graphique) {

		Color couleur = choixCouleur.getCouleur();

		Graphics2D graphique2D = (Graphics2D) graphique;
		graphique2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);

		graphique2D.setColor(getBackground());
		graphique2D.fillRect(0, 0, getWidth(), getHeight());

		graphique2D.setColor(Color.BLACK);
		graphique2D.fillArc(0, 0, TAILLE, TAILLE, 90, 180);

		graphique2D.setColor(Color.WHITE);
		graphique2D.fillArc(0, 0, TAILLE, TAILLE, 270, 180);

		graphique2D.setColor(Color.WHITE);
		graphique2D.fillArc(TAILLE / 4, 0, TAILLE / 2, TAILLE / 2, 90, 180);

		graphique2D.setColor(Color.BLACK);
		graphique2D.fillArc(TAILLE / 4, TAILLE / 2, TAILLE / 2, TAILLE / 2,
				270, 180);

		graphique2D.setColor(couleur);
		graphique2D.fillOval(TAILLE / 4, TAILLE / 4, TAILLE / 2, TAILLE / 2);

	}

}