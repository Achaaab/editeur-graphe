package com.github.achaaab.utilitaire.swing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.Timer;

import javax.swing.JPanel;

import com.github.achaaab.utilitaire.Chronometre;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public abstract class PanneauTampon extends JPanel {

	private static final Timer TIMER_RAFRAICHISSEMENT = new Timer();

	protected int xImage;
	protected int yImage;
	protected boolean imageAJour;

	protected BufferedImage image;
	protected Graphics2D graphique;

	protected int largeur;
	protected int hauteur;

	private Rafrachissement rafraichissement;
	private int rps;

	private boolean anticrenelage;

	/**
	 * 
	 */
	public PanneauTampon() {
		this(true);
	}

	/**
	 * 
	 * @param anticrenelage
	 */
	public PanneauTampon(boolean anticrenelage) {

		this.anticrenelage = anticrenelage;

		xImage = 0;
		yImage = 0;

		imageAJour = false;

	}

	@Override
	public final void paint(Graphics g) {

		int largeurPanneau = getWidth();
		int hauteurPanneau = getHeight();

		if (image == null || largeurPanneau != largeur
				|| hauteurPanneau != hauteur) {

			creerImage(largeurPanneau, hauteurPanneau);
			imageAJour = false;

		}

		if (imageAJour) {

			g.setColor(getBackground());
			g.fillRect(0, 0, largeurPanneau, hauteurPanneau);

		} else {

			graphique.setColor(getBackground());
			graphique.fillRect(0, 0, largeurPanneau, hauteurPanneau);

			dessiner();

			imageAJour = true;

		}

		g.drawImage(image, xImage, yImage, null);

	}

	/**
	 * 
	 */
	public final void recalculerImage() {

		imageAJour = false;
		repaint();

	}

	/**
	 * 
	 * @param largeur
	 * @param hauteur
	 */
	public final void creerImage(int largeur, int hauteur) {

		this.largeur = largeur;
		this.hauteur = hauteur;

		image = new BufferedImage(largeur, hauteur, BufferedImage.TYPE_INT_ARGB);

		graphique = image.createGraphics();

		graphique.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				anticrenelage ? RenderingHints.VALUE_ANTIALIAS_ON
						: RenderingHints.VALUE_ANTIALIAS_OFF);

	}

	/**
	 * 
	 */
	public abstract void dessiner();

	/**
	 * 
	 */
	public final void reprendreRafraichissementAutomatique() {
		rafraichirAutomatiquement(rps);
	}

	/**
	 * 
	 * @param rps
	 *            nombre de rafraichissements par seconde
	 */
	public final void rafraichirAutomatiquement(int rps) {

		this.rps = rps;

		interrompreRafraichissementAutomatique();

		rafraichissement = new Rafrachissement(this);

		TIMER_RAFRAICHISSEMENT.schedule(rafraichissement, 0,
				Chronometre.MILLISECONDES_PAR_SECONDE / rps);

	}

	/**
	 * 
	 */
	public final void interrompreRafraichissementAutomatique() {

		if (rafraichissement != null) {
			rafraichissement.cancel();
		}

	}

	/**
	 * @return the rps
	 */
	public final int getRps() {
		return rps;
	}

	/**
	 * 
	 * @return
	 */
	public final BufferedImage getImage() {
		return image;
	}

	/**
	 * 
	 * @return
	 */
	public final Graphics2D getGraphique() {
		return graphique;
	}

	/**
	 * @return the imageAJour
	 */
	public final boolean isImageAJour() {
		return imageAJour;
	}

	/**
	 * @param imageAJour
	 *            the imageAJour to set
	 */
	public final void setImageAJour(boolean imageAJour) {
		this.imageAJour = imageAJour;
	}

}