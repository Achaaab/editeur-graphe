package com.github.achaaab.utilitaire.couleur.choix;

import com.github.achaaab.utilitaire.swing.PanneauTampon;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import static com.github.achaaab.utilitaire.couleur.CouleurUtilitaire.getNiveauGris;
import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class PanneauChoixCouleur1 extends PanneauTampon {

	private static final int LARGEUR = 32;
	private static final int HAUTEUR = 256;

	private final ChoixCouleur choixCouleur;
	private final BufferedImage palette;
	private final Graphics2D graphiquePalette;

	/**
	 * @param choixCouleur
	 * @param panneauComposantes
	 * @since 0.0.0
	 */
	public PanneauChoixCouleur1(ChoixCouleur choixCouleur, PanneauComposantes panneauComposantes) {

		super(false);

		this.choixCouleur = choixCouleur;

		setPreferredSize(new Dimension(LARGEUR, HAUTEUR));

		palette = new BufferedImage(LARGEUR, HAUTEUR, BufferedImage.TYPE_INT_RGB);
		graphiquePalette = palette.createGraphics();

		creerImage(LARGEUR, HAUTEUR);

		var ecouteur = new EcouteurChoixCouleur1(choixCouleur, panneauComposantes);

		addMouseListener(ecouteur);
		addMouseMotionListener(ecouteur);
	}

	/**
	 * @since 0.0.0
	 */
	public void redessinerCurseur() {

		dessinerPalette();
		dessinerCurseur();
		repaint();
	}

	/**
	 * recalcule la palette de couleurs
	 *
	 * @since 0.0.0
	 */
	private void calculerPalette() {

		for (var y = 0; y < hauteur; y++) {

			var couleur = choixCouleur.getCouleur(y);
			graphiquePalette.setColor(couleur);
			graphiquePalette.drawLine(0, y, LARGEUR, y);
		}
	}

	/**
	 * colle la palette dans le panneau sans la recalculer
	 *
	 * @since 0.0.0
	 */
	private void dessinerPalette() {
		graphique.drawImage(palette, 0, 0, null);
	}

	/**
	 * @since 0.0.0
	 */
	private void dessinerCurseur() {

		var y = choixCouleur.getComposante2();

		var couleur = choixCouleur.getCouleur();
		var rgb = couleur.getRGB();
		var niveauGris = getNiveauGris(rgb);
		graphique.setColor(niveauGris < 128 ? WHITE : BLACK);
		graphique.drawLine(0, y, largeur, y);
	}

	@Override
	public void dessiner() {

		calculerPalette();
		dessinerPalette();
		dessinerCurseur();
	}
}