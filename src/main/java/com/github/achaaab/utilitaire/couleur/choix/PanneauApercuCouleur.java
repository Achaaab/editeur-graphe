package com.github.achaaab.utilitaire.couleur.choix;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import static java.awt.RenderingHints.KEY_ANTIALIASING;
import static java.awt.RenderingHints.VALUE_ANTIALIAS_ON;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class PanneauApercuCouleur extends JPanel {

	private static final int TAILLE = 128;

	private final ChoixCouleur choixCouleur;

	/**
	 * @param choixCouleur
	 * @since 0.0.0
	 */
	public PanneauApercuCouleur(ChoixCouleur choixCouleur) {

		this.choixCouleur = choixCouleur;

		setPreferredSize(new Dimension(TAILLE, TAILLE));
	}

	@Override
	public void paint(Graphics graphique) {

		var couleur = choixCouleur.getCouleur();

		var graphique2D = (Graphics2D) graphique;
		graphique2D.setRenderingHint(KEY_ANTIALIASING, VALUE_ANTIALIAS_ON);

		graphique2D.setColor(getBackground());
		graphique2D.fillRect(0, 0, getWidth(), getHeight());

		graphique2D.setColor(BLACK);
		graphique2D.fillArc(0, 0, TAILLE, TAILLE, 90, 180);

		graphique2D.setColor(WHITE);
		graphique2D.fillArc(0, 0, TAILLE, TAILLE, 270, 180);

		graphique2D.setColor(WHITE);
		graphique2D.fillArc(TAILLE / 4, 0, TAILLE / 2, TAILLE / 2, 90, 180);

		graphique2D.setColor(BLACK);
		graphique2D.fillArc(TAILLE / 4, TAILLE / 2, TAILLE / 2, TAILLE / 2, 270, 180);

		graphique2D.setColor(couleur);
		graphique2D.fillOval(TAILLE / 4, TAILLE / 4, TAILLE / 2, TAILLE / 2);
	}
}