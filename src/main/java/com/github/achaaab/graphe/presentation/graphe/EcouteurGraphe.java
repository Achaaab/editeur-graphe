package com.github.achaaab.graphe.presentation.graphe;

import com.github.achaaab.utilitaire.swing.SwingUtilitaire;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class EcouteurGraphe implements MouseListener, MouseMotionListener {

	private static final int LONGUEUR_COINS_CADRE = 8;

	private final PanneauGraphe panneauGraphe;

	private BufferedImage imageSansCadre;
	private Graphics2D graphique;

	private int x0, y0;
	private int x1, y1;

	/**
	 * @param panneauGraphe
	 */
	public EcouteurGraphe(PanneauGraphe panneauGraphe) {

		this.panneauGraphe = panneauGraphe;

		panneauGraphe.addMouseListener(this);
		panneauGraphe.addMouseMotionListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent evenement) {

	}

	@Override
	public void mouseEntered(MouseEvent evenement) {

	}

	@Override
	public void mouseExited(MouseEvent evenement) {

	}

	@Override
	public void mousePressed(MouseEvent evenement) {

		x0 = evenement.getX();
		y0 = evenement.getY();

		x1 = x0;
		y1 = y0;

		imageSansCadre = SwingUtilitaire.copier(panneauGraphe.getImage());
		graphique = panneauGraphe.getGraphique();

		dessinerCadreGrossissement(x0, y0, x1, y1);
	}

	@Override
	public void mouseReleased(MouseEvent evenement) {

		if (x0 != x1 && y0 != y1) {

			panneauGraphe.grossir(x0, y0, x1, y1);

		} else {

			panneauGraphe.setImageAJour(false);
			panneauGraphe.repaint();
		}
	}

	@Override
	public void mouseDragged(MouseEvent evenement) {

		x1 = evenement.getX();
		y1 = evenement.getY();

		dessinerCadreGrossissement(x0, y0, x1, y1);

		panneauGraphe.actualiserCoordonneesCurseur(evenement.getX(), evenement.getY());
	}

	@Override
	public void mouseMoved(MouseEvent evenement) {
		panneauGraphe.actualiserCoordonneesCurseur(evenement.getX(), evenement.getY());
	}

	/**
	 * @param x0
	 * @param y0
	 * @param x1
	 * @param y1
	 */
	private void dessinerCadreGrossissement(int x0, int y0, int x1, int y1) {

		graphique.drawImage(imageSansCadre, 0, 0, null);

		graphique.setColor(Color.BLACK);

		int xMinCadre = min(x0, x1);
		int yMinCadre = min(y0, y1);
		int xMaxCadre = max(x0, x1);
		int yMaxCadre = max(y0, y1);

		graphique.drawLine(xMinCadre, yMinCadre, xMinCadre + LONGUEUR_COINS_CADRE, yMinCadre);
		graphique.drawLine(xMinCadre, yMinCadre, xMinCadre, yMinCadre + LONGUEUR_COINS_CADRE);
		graphique.drawLine(xMaxCadre, yMinCadre, xMaxCadre - LONGUEUR_COINS_CADRE, yMinCadre);
		graphique.drawLine(xMaxCadre, yMinCadre, xMaxCadre, yMinCadre + LONGUEUR_COINS_CADRE);
		graphique.drawLine(xMaxCadre, yMaxCadre, xMaxCadre - LONGUEUR_COINS_CADRE, yMaxCadre);
		graphique.drawLine(xMaxCadre, yMaxCadre, xMaxCadre, yMaxCadre - LONGUEUR_COINS_CADRE);
		graphique.drawLine(xMinCadre, yMaxCadre, xMinCadre + LONGUEUR_COINS_CADRE, yMaxCadre);
		graphique.drawLine(xMinCadre, yMaxCadre, xMinCadre, yMaxCadre - LONGUEUR_COINS_CADRE);

		panneauGraphe.repaint();
	}
}