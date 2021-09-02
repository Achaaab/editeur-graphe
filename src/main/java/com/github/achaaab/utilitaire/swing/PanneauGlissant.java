package com.github.achaaab.utilitaire.swing;

import static java.lang.Math.pow;

/**
 * Panneau ou l'on peut zoomer et dezoomer grace a la molette de la souris. On
 * peut aussi le deplacer en faisant un glisser-deposer avec la touche
 * majuscule enfoncee.
 *
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public abstract class PanneauGlissant extends PanneauTampon {

	protected float xCentrePanneau;
	protected float yCentrePanneau;
	protected int zoom;

	protected int zoomMinimum;
	protected int zoomMaximum;

	/**
	 * @param zoomMinimum
	 * @param zoomMaximum
	 * @since 0.0.0
	 */
	public PanneauGlissant(int zoomMinimum, int zoomMaximum) {

		this.zoomMinimum = zoomMinimum;
		this.zoomMaximum = zoomMaximum;

		xCentrePanneau = 0;
		yCentrePanneau = 0;
		zoom = 0;

		setFocusable(true);

		var ecouteurDeplacement = new EcouteurDeplacementPanneau(this);

		addMouseListener(ecouteurDeplacement);
		addMouseMotionListener(ecouteurDeplacement);
		addMouseWheelListener(ecouteurDeplacement);
		addKeyListener(ecouteurDeplacement);
	}

	/**
	 * @since 0.0.0
	 */
	public void validerDeplacement() {

		deplacerFenetre(-xImage, -yImage);

		xImage = 0;
		yImage = 0;
	}

	/**
	 * @param dx déplacement horizontal en pixels (vers la droite)
	 * @param dy déplacement vertical en pixels (vers le bas)
	 * @since 0.0.0
	 */
	public void deplacerFenetre(int dx, int dy) {

		var dxReel = (float) (dx / pow(2, zoom));
		var dyReel = (float) (dy / pow(2, zoom));

		xCentrePanneau += dxReel;
		yCentrePanneau += dyReel;
	}

	/**
	 * @param xImage
	 * @param yImage
	 * @since 0.0.0
	 */
	public void deplacerImage(int xImage, int yImage) {

		this.xImage = xImage;
		this.yImage = yImage;

		repaint();
	}

	/**
	 * @return
	 * @since 0.0.0
	 */
	public int getZoom() {
		return zoom;
	}

	/**
	 * @param zoom
	 * @param x
	 * @param y
	 * @since 0.0.0
	 */
	public void setZoom(int zoom, int x, int y) {

		if (zoom < zoomMinimum) {
			zoom = zoomMinimum;
		}

		if (zoom > zoomMaximum) {
			zoom = zoomMaximum;
		}

		// on recentre sur la sélection
		deplacerFenetre(x - largeur / 2, y - hauteur / 2);

		// on applique le nouveau zoom
		this.zoom = zoom;

		// on recentre sur le curseur
		deplacerFenetre(largeur / 2 - x, hauteur / 2 - y);

		repaint();
	}
}