package com.github.achaaab.utilitaire.swing;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Timer;

import static com.github.achaaab.utilitaire.Chronometre.MILLISECONDES_PAR_SECONDE;
import static java.awt.RenderingHints.KEY_ANTIALIASING;
import static java.awt.RenderingHints.VALUE_ANTIALIAS_OFF;
import static java.awt.RenderingHints.VALUE_ANTIALIAS_ON;
import static java.awt.image.BufferedImage.TYPE_INT_ARGB;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public abstract class PanneauTampon extends JPanel {

	private static final Timer TIMER_RAFRAICHISSEMENT = new Timer();

	private final boolean anticrenelage;

	protected int xImage;
	protected int yImage;
	protected boolean imageAJour;

	protected BufferedImage image;
	protected Graphics2D graphique;

	protected int largeur;
	protected int hauteur;

	private Rafrachissement rafraichissement;
	private int rps;

	/**
	 * @since 0.0.0
	 */
	public PanneauTampon() {
		this(true);
	}

	/**
	 * @param anticrenelage
	 * @since 0.0.0
	 */
	public PanneauTampon(boolean anticrenelage) {

		this.anticrenelage = anticrenelage;

		xImage = 0;
		yImage = 0;

		imageAJour = false;
	}

	@Override
	public void paint(Graphics graphics) {

		var largeurPanneau = getWidth();
		var hauteurPanneau = getHeight();

		if (image == null || largeurPanneau != largeur || hauteurPanneau != hauteur) {

			creerImage(largeurPanneau, hauteurPanneau);
			imageAJour = false;
		}

		if (imageAJour) {

			graphics.setColor(getBackground());
			graphics.fillRect(0, 0, largeurPanneau, hauteurPanneau);

		} else {

			graphique.setColor(getBackground());
			graphique.fillRect(0, 0, largeurPanneau, hauteurPanneau);

			dessiner();

			imageAJour = true;
		}

		graphics.drawImage(image, xImage, yImage, null);
	}

	/**
	 * @since 0.0.0
	 */
	public void recalculerImage() {

		imageAJour = false;
		repaint();
	}

	/**
	 * @param largeur
	 * @param hauteur
	 * @since 0.0.0
	 */
	public void creerImage(int largeur, int hauteur) {

		this.largeur = largeur;
		this.hauteur = hauteur;

		image = new BufferedImage(largeur, hauteur, TYPE_INT_ARGB);
		graphique = image.createGraphics();
		graphique.setRenderingHint(KEY_ANTIALIASING, anticrenelage ? VALUE_ANTIALIAS_ON : VALUE_ANTIALIAS_OFF);
	}

	/**
	 * @since 0.0.0
	 */
	public abstract void dessiner();

	/**
	 * @since 0.0.0
	 */
	public void reprendreRafraichissementAutomatique() {
		rafraichirAutomatiquement(rps);
	}

	/**
	 * @param rps nombre de rafraichissements par seconde
	 * @since 0.0.0
	 */
	public void rafraichirAutomatiquement(int rps) {

		this.rps = rps;

		interrompreRafraichissementAutomatique();
		rafraichissement = new Rafrachissement(this);
		TIMER_RAFRAICHISSEMENT.schedule(rafraichissement, 0, MILLISECONDES_PAR_SECONDE / rps);
	}

	/**
	 * @since 0.0.0
	 */
	public void interrompreRafraichissementAutomatique() {

		if (rafraichissement != null) {
			rafraichissement.cancel();
		}
	}

	/**
	 * @return
	 * @since 0.0.0
	 */
	public int getRps() {
		return rps;
	}

	/**
	 * @return
	 * @since 0.0.0
	 */
	public BufferedImage getImage() {
		return image;
	}

	/**
	 * @return
	 * @since 0.0.0
	 */
	public Graphics2D getGraphique() {
		return graphique;
	}

	/**
	 * @param imageAJour
	 * @since 0.0.0
	 */
	public void setImageAJour(boolean imageAJour) {
		this.imageAJour = imageAJour;
	}
}