package com.github.achaaab.utilitaire.couleur.choix;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.github.achaaab.utilitaire.couleur.CouleurUtilitaire;
import com.github.achaaab.utilitaire.swing.PanneauTampon;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class PanneauChoixCouleur1 extends PanneauTampon {

	/**
	 * UID genere le 17/06/2010
	 */
	private static final long serialVersionUID = -809159999299787860L;

	private static final int LARGEUR = 32;
	private static final int HAUTEUR = 256;
	
	private ChoixCouleur choixCouleur;

	private BufferedImage palette;
	private Graphics2D graphiquePalette;

	/**
	 * 
	 * @param choixCouleur
	 * @param panneauComposantes
	 */
	public PanneauChoixCouleur1(ChoixCouleur choixCouleur,
			PanneauComposantes panneauComposantes) {

		super(false);

		this.choixCouleur = choixCouleur;

		setPreferredSize(new Dimension(LARGEUR, HAUTEUR));

		palette = new BufferedImage(LARGEUR, HAUTEUR, BufferedImage.TYPE_INT_RGB);
		graphiquePalette = palette.createGraphics();

		creerImage(LARGEUR, HAUTEUR);

		EcouteurChoixCouleur1 ecouteur = new EcouteurChoixCouleur1(
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
	 * recalcule la palette de couleurs
	 */
	private final void calculerPalette() {

		Color couleur;

		int y;

		for (y = 0; y < hauteur; y++) {

			couleur = choixCouleur.getCouleur(y);
			graphiquePalette.setColor(couleur);
			graphiquePalette.drawLine(0, y, LARGEUR, y);

		}

	}

	/**
	 * colle la palette dans le panneau sans la recalculer
	 */
	private final void dessinerPalette() {
		graphique.drawImage(palette, 0, 0, null);
	}

	/**
	 * 
	 */
	private final void dessinerCurseur() {

		int y = choixCouleur.getComposante2();

		Color couleur = choixCouleur.getCouleur();
		int rgb = couleur.getRGB();
		int niveauGris = CouleurUtilitaire.getNiveauGris(rgb);
		graphique.setColor(niveauGris < 128 ? Color.WHITE : Color.BLACK);

		graphique.drawLine(0, y, largeur, y);

	}

	@Override
	public final void dessiner() {

		calculerPalette();
		dessinerPalette();
		dessinerCurseur();

	}

}