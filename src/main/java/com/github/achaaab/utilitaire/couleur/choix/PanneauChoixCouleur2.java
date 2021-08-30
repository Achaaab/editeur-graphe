package com.github.achaaab.utilitaire.couleur.choix;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

import com.github.achaaab.utilitaire.couleur.CouleurUtilitaire;
import com.github.achaaab.utilitaire.swing.PanneauTampon;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class PanneauChoixCouleur2 extends PanneauTampon {

	/**
	 * UID genere le 17/06/2010
	 */
	private static final long serialVersionUID = -1788983648421272377L;

	private static final int LARGEUR = 256;
	private static final int HAUTEUR = 256;

	private static final int TAILLE_CURSEUR = 8;

	private ChoixCouleur choixCouleur;

	private BufferedImage palette;

	/**
	 * 
	 * @param choixCouleur
	 * @param panneauComposantes
	 */
	public PanneauChoixCouleur2(ChoixCouleur choixCouleur,
			PanneauComposantes panneauComposantes) {

		super(false);

		this.choixCouleur = choixCouleur;

		setPreferredSize(new Dimension(LARGEUR, HAUTEUR));

		palette = new BufferedImage(LARGEUR, HAUTEUR,
				BufferedImage.TYPE_INT_RGB);

		creerImage(LARGEUR, HAUTEUR);

		EcouteurChoixCouleur2 ecouteur = new EcouteurChoixCouleur2(
				choixCouleur, panneauComposantes);

		addMouseListener(ecouteur);
		addMouseMotionListener(ecouteur);

	}

	/**
	 * 
	 */
	public final void redessinerCurseur() {

		dessinerPalette();
		dessinerCurseur();
		repaint();

	}

	/**
	 * 
	 */
	private final void calculerPalette() {

		Color couleur;

		int x, y;

		for (x = 0; x < largeur; x++) {

			for (y = 0; y < hauteur; y++) {

				couleur = choixCouleur.getCouleur(x, y);
				palette.setRGB(x, y, couleur.getRGB());

			}

		}

	}

	/**
	 * 
	 */
	private final void dessinerPalette() {
		graphique.drawImage(palette, 0, 0, null);
	}

	/**
	 * 
	 */
	private final void dessinerCurseur() {

		int x = choixCouleur.getComposante0();
		int y = choixCouleur.getComposante1();

		Color couleur = choixCouleur.getCouleur();
		int rgb = couleur.getRGB();
		int niveauGris = CouleurUtilitaire.getNiveauGris(rgb);
		graphique.setColor(niveauGris < 128 ? Color.WHITE : Color.BLACK);

		graphique.drawLine(x, y - 1, x, y - TAILLE_CURSEUR);
		graphique.drawLine(x + 1, y, x + TAILLE_CURSEUR, y);
		graphique.drawLine(x, y + 1, x, y + TAILLE_CURSEUR);
		graphique.drawLine(x - 1, y, x - TAILLE_CURSEUR, y);

	}

	@Override
	public final void dessiner() {

		calculerPalette();
		dessinerPalette();
		dessinerCurseur();

	}

}