package com.github.achaaab.utilitaire.couleur.choix;

import com.github.achaaab.utilitaire.swing.PanneauTampon;

import java.awt.Dimension;
import java.awt.image.BufferedImage;

import static com.github.achaaab.utilitaire.couleur.CouleurUtilitaire.getNiveauGris;
import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import static java.awt.image.BufferedImage.TYPE_INT_RGB;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class PanneauChoixCouleur2 extends PanneauTampon {

	private static final int LARGEUR = 256;
	private static final int HAUTEUR = 256;
	private static final int TAILLE_CURSEUR = 8;

	private final ChoixCouleur choixCouleur;
	private final BufferedImage palette;

	/**
	 * @param choixCouleur
	 * @param panneauComposantes
	 * @since 0.0.0
	 */
	public PanneauChoixCouleur2(ChoixCouleur choixCouleur, PanneauComposantes panneauComposantes) {

		super(false);

		this.choixCouleur = choixCouleur;

		setPreferredSize(new Dimension(LARGEUR, HAUTEUR));

		palette = new BufferedImage(LARGEUR, HAUTEUR, TYPE_INT_RGB);

		creerImage(LARGEUR, HAUTEUR);

		var ecouteur = new EcouteurChoixCouleur2(choixCouleur, panneauComposantes);

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
	 * @since 0.0.0
	 */
	private void calculerPalette() {

		for (var x = 0; x < largeur; x++) {

			for (var y = 0; y < hauteur; y++) {

				var couleur = choixCouleur.getCouleur(x, y);
				palette.setRGB(x, y, couleur.getRGB());
			}
		}
	}

	/**
	 * @since 0.0.0
	 */
	private void dessinerPalette() {
		graphique.drawImage(palette, 0, 0, null);
	}

	/**
	 * @since 0.0.0
	 */
	private void dessinerCurseur() {

		var x = choixCouleur.getComposante0();
		var y = choixCouleur.getComposante1();

		var couleur = choixCouleur.getCouleur();
		var rgb = couleur.getRGB();
		var niveauGris = getNiveauGris(rgb);

		graphique.setColor(niveauGris < 128 ? WHITE : BLACK);

		graphique.drawLine(x, y - 1, x, y - TAILLE_CURSEUR);
		graphique.drawLine(x + 1, y, x + TAILLE_CURSEUR, y);
		graphique.drawLine(x, y + 1, x, y + TAILLE_CURSEUR);
		graphique.drawLine(x - 1, y, x - TAILLE_CURSEUR, y);
	}

	@Override
	public void dessiner() {

		calculerPalette();
		dessinerPalette();
		dessinerCurseur();
	}
}