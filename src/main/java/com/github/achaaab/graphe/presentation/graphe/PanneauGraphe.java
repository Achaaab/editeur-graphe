package com.github.achaaab.graphe.presentation.graphe;

import com.github.achaaab.graphe.Graphe;
import com.github.achaaab.utilitaire.swing.PanneauTampon;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;

import static com.github.achaaab.utilitaire.GestionnaireException.traiter;
import static java.awt.Color.DARK_GRAY;
import static java.awt.Color.WHITE;
import static java.awt.Cursor.CROSSHAIR_CURSOR;
import static java.awt.Cursor.getPredefinedCursor;
import static java.awt.geom.AffineTransform.getScaleInstance;
import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class PanneauGraphe extends PanneauTampon {

	private static final int LARGEUR_MINIMUM = 400;
	private static final int LARGEUR_IDEALE = 400;

	private static final int HAUTEUR_MINIMUM = 300;
	private static final int HAUTEUR_IDEALE = 300;

	private static final Dimension DIMENSION_MINIMUM = new Dimension(LARGEUR_MINIMUM, HAUTEUR_MINIMUM);
	private static final Dimension DIMENSION_IDEALE = new Dimension(LARGEUR_IDEALE, HAUTEUR_IDEALE);

	private final PanneauCoordonnees panneauCoordonnees;
	private final Graphe graphe;

	/**
	 * @param graphe
	 * @param panneauCoordonnees
	 * @since 0.0.0
	 */
	public PanneauGraphe(Graphe graphe, PanneauCoordonnees panneauCoordonnees) {

		super(false);

		this.graphe = graphe;
		this.panneauCoordonnees = panneauCoordonnees;

		setBackground(WHITE);
		setCursor(getPredefinedCursor(CROSSHAIR_CURSOR));

		setPreferredSize(DIMENSION_IDEALE);
		setMinimumSize(DIMENSION_MINIMUM);

		new EcouteurGraphe(this);
	}

	@Override
	public void dessiner() {

		// dessin des axes

		var axeX = getAxeX();
		var axeY = getAxeY();

		graphique.setColor(DARK_GRAY);

		graphique.draw(axeX);
		graphique.draw(axeY);

		// dessin des courbes

		var transformationAffine = getTransformationAffine();

		var courbes = graphe.getCourbes();

		for (var courbe : courbes) {

			var color = courbe.getCouleur();
			var shape = courbe.getForme();

			shape = transformationAffine.createTransformedShape(shape);

			graphique.setColor(color);
			graphique.draw(shape);
		}
	}

	/**
	 * @return transformation affine permettant d'adapter les coordonnées du graphe aux coordonnées de l'écran
	 * @since 0.0.0
	 */
	private AffineTransform getTransformationAffine() {

		var xMin = graphe.getXMin();
		var xMax = graphe.getXMax();
		var yMin = graphe.getYMin();
		var yMax = graphe.getYMax();

		// transformation affine du graphe

		var transformationAffine = getScaleInstance(
				largeur / (xMax - xMin),
				hauteur / (yMin - yMax));

		transformationAffine.translate(-xMin, -yMax);

		return transformationAffine;
	}

	/**
	 * @return
	 * @since 0.0.0
	 */
	private Shape getAxeX() {

		// paramètres de l'axe

		var xMin = graphe.getXMin();
		var xMax = graphe.getXMax();
		var graduationX = graphe.getGraduationX();

		// forme de l'axe

		var axeX = new GeneralPath();

		// transormation affine pour passer des coordonnées du graphe aux coordonnées de l'écran

		var transformationAffine = getTransformationAffine();

		// ligne de l'axe

		var minAxeGraphe = new Point2D.Double(xMin, 0);
		var maxAxeGraphe = new Point2D.Double(xMax, 0);

		var minAxeEcran = new Point2D.Double();
		var maxAxeEcran = new Point2D.Double();

		transformationAffine.transform(minAxeGraphe, minAxeEcran);
		transformationAffine.transform(maxAxeGraphe, maxAxeEcran);

		axeX.append(new Line2D.Double(minAxeEcran, maxAxeEcran), false);

		// graduations positives

		for (var x = graduationX; x <= xMax; x += graduationX) {

			var pointGraduationGraphe = new Point2D.Double(x, 0);
			var pointGraduationEcran = new Point2D.Double();

			transformationAffine.transform(pointGraduationGraphe, pointGraduationEcran);

			var graduation = new Line2D.Double(
					pointGraduationEcran.getX(), pointGraduationEcran.getY(),
					pointGraduationEcran.getX(), pointGraduationEcran.getY() - 3);

			axeX.append(graduation, false);
		}

		// graduations négatives

		for (var x = -graduationX; x >= xMin; x -= graduationX) {

			var pointGraduationGraphe = new Point2D.Double(x, 0);
			var pointGraduationEcran = new Point2D.Double();

			transformationAffine.transform(pointGraduationGraphe, pointGraduationEcran);

			var graduation = new Line2D.Double(
					pointGraduationEcran.getX(), pointGraduationEcran.getY(),
					pointGraduationEcran.getX(), pointGraduationEcran.getY() - 3);

			axeX.append(graduation, false);
		}

		return axeX;
	}

	/**
	 * @return
	 * @since 0.0.0
	 */
	private Shape getAxeY() {

		// paramètres de l'axe

		var yMin = graphe.getYMin();
		var yMax = graphe.getYMax();
		var graduationY = graphe.getGraduationY();

		// forme de l'axe

		var axeY = new GeneralPath();

		// transormation affine pour passer des coordonnées du graphe aux coordonnées de l'écran

		var transformationAffine = getTransformationAffine();

		// ligne de l'axe

		var minAxeGraphe = new Point2D.Double(0, yMin);
		var maxAxeGraphe = new Point2D.Double(0, yMax);

		var minAxeEcran = new Point2D.Double();
		var maxAxeEcran = new Point2D.Double();

		transformationAffine.transform(minAxeGraphe, minAxeEcran);
		transformationAffine.transform(maxAxeGraphe, maxAxeEcran);

		axeY.append(new Line2D.Double(minAxeEcran, maxAxeEcran), false);

		// graduations positives

		for (var y = graduationY; y <= yMax; y += graduationY) {

			var pointGraduationGraphe = new Point2D.Double(0, y);
			var pointGraduationEcran = new Point2D.Double();

			transformationAffine.transform(pointGraduationGraphe, pointGraduationEcran);

			var graduation = new Line2D.Double(
					pointGraduationEcran.getX(), pointGraduationEcran.getY(),
					pointGraduationEcran.getX() + 3, pointGraduationEcran.getY());

			axeY.append(graduation, false);
		}

		// graduations négatives

		for (var y = -graduationY; y >= yMin; y -= graduationY) {

			var pointGraduationGraphe = new Point2D.Double(0, y);
			var pointGraduationEcran = new Point2D.Double();

			transformationAffine.transform(pointGraduationGraphe, pointGraduationEcran);

			var graduation = new Line2D.Double(
					pointGraduationEcran.getX(), pointGraduationEcran.getY(),
					pointGraduationEcran.getX() + 3, pointGraduationEcran.getY());

			axeY.append(graduation, false);
		}

		return axeY;
	}

	/**
	 * @param x0
	 * @param y0
	 * @param x1
	 * @param y1
	 * @since 0.0.0
	 */
	public void grossir(int x0, int y0, int x1, int y1) {

		var transformationAffine = getTransformationAffine();

		var coinCadre0 = new Point2D.Double(x0, y0);
		var coinCadre1 = new Point2D.Double(x1, y1);

		var coinGraphe0 = new Point2D.Double();
		var coinGraphe1 = new Point2D.Double();

		try {

			transformationAffine.inverseTransform(coinCadre0, coinGraphe0);
			transformationAffine.inverseTransform(coinCadre1, coinGraphe1);

			var xMin = min(coinGraphe0.getX(), coinGraphe1.getX());
			var yMin = min(coinGraphe0.getY(), coinGraphe1.getY());
			var xMax = max(coinGraphe0.getX(), coinGraphe1.getX());
			var yMax = max(coinGraphe0.getY(), coinGraphe1.getY());

			graphe.setXMin(xMin);
			graphe.setYMin(yMin);

			graphe.setXMax(xMax);
			graphe.setYMax(yMax);

			graphe.actualiserFenetre();

		} catch (NoninvertibleTransformException erreur) {

			traiter(erreur);
		}

		recalculerImage();
	}

	/**
	 * @param xEcran
	 * @param yEcran
	 * @since 0.0.0
	 */
	public void actualiserCoordonneesCurseur(int xEcran, int yEcran) {

		var curseurEcran = new Point2D.Double(xEcran, yEcran);
		var curseurGraphe = new Point2D.Double();

		var transformationAffine = getTransformationAffine();

		try {

			transformationAffine.inverseTransform(curseurEcran, curseurGraphe);

			panneauCoordonnees.setX(curseurGraphe.getX());
			panneauCoordonnees.setY(curseurGraphe.getY());

		} catch (NoninvertibleTransformException erreur) {

			traiter(erreur);
		}
	}
}