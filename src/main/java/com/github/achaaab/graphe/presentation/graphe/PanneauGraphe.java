package com.github.achaaab.graphe.presentation.graphe;

import com.github.achaaab.graphe.Graphe;
import com.github.achaaab.graphe.courbe.Courbe;
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
import java.util.List;

import static com.github.achaaab.utilitaire.GestionnaireException.traiter;
import static java.awt.geom.AffineTransform.getScaleInstance;

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
	 */
	public PanneauGraphe(Graphe graphe, PanneauCoordonnees panneauCoordonnees) {

		super(false);

		this.graphe = graphe;
		this.panneauCoordonnees = panneauCoordonnees;

		setBackground(Color.WHITE);
		setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));

		setPreferredSize(DIMENSION_IDEALE);
		setMinimumSize(DIMENSION_MINIMUM);

		new EcouteurGraphe(this);

	}

	@Override
	public void dessiner() {

		/*
		 * dessin des axes
		 */

		Shape axeX = getAxeX();
		Shape axeY = getAxeY();

		graphique.setColor(Color.DARK_GRAY);

		graphique.draw(axeX);
		graphique.draw(axeY);

		/*
		 * dessin des courbes
		 */

		var transformationAffine = getTransformationAffine();

		List<Courbe> courbes = graphe.getCourbes();
		Shape formeCourbe;

		for (Courbe courbe : courbes) {

			graphique.setColor(courbe.getCouleur());
			formeCourbe = courbe.getForme();
			formeCourbe = transformationAffine.createTransformedShape(formeCourbe);
			graphique.draw(formeCourbe);
		}
	}

	/**
	 * @return la transformation affine permettant d'adapter les coordonnees du
	 * graphe aux coordonnees de l'ecran
	 */
	private AffineTransform getTransformationAffine() {

		var xMin = graphe.getXMin();
		var xMax = graphe.getXMax();
		var yMin = graphe.getYMin();
		var yMax = graphe.getYMax();

		/*
		 * transformation affine du graphe
		 */

		var transformationAffine = getScaleInstance(
				largeur / (xMax - xMin),
				hauteur / (yMin - yMax));

		transformationAffine.translate(-xMin, -yMax);

		return transformationAffine;
	}

	/**
	 * @return
	 */
	private Shape getAxeX() {

		/*
		 * parametres de l'axe
		 */

		double xMin = graphe.getXMin();
		double xMax = graphe.getXMax();
		double graduationX = graphe.getGraduationX();

		/*
		 * forme de l'axe
		 */

		GeneralPath axeX = new GeneralPath();

		/*
		 * transormation affine pour passer des coordonnees du graphe aux
		 * coordonnees de l'ecran
		 */

		AffineTransform transformationAffine = getTransformationAffine();

		/*
		 * ligne de l'axe
		 */

		Point2D minAxeGraphe = new Point2D.Double(xMin, 0);
		Point2D maxAxeGraphe = new Point2D.Double(xMax, 0);

		Point2D minAxeEcran = new Point2D.Double();
		Point2D maxAxeEcran = new Point2D.Double();

		transformationAffine.transform(minAxeGraphe, minAxeEcran);
		transformationAffine.transform(maxAxeGraphe, maxAxeEcran);

		axeX.append(new Line2D.Double(minAxeEcran, maxAxeEcran), false);

		/*
		 * graduations de l'axe
		 */

		Point2D pointGraduationGraphe;
		Point2D pointGraduationEcran;

		Line2D graduation;

		double x;

		/*
		 * graduations positives
		 */

		for (x = graduationX; x <= xMax; x += graduationX) {

			pointGraduationGraphe = new Point2D.Double(x, 0);
			pointGraduationEcran = new Point2D.Double();

			transformationAffine.transform(pointGraduationGraphe,
					pointGraduationEcran);

			graduation = new Line2D.Double(pointGraduationEcran.getX(),
					pointGraduationEcran.getY(), pointGraduationEcran.getX(),
					pointGraduationEcran.getY() - 3);

			axeX.append(graduation, false);
		}

		/*
		 * graduations negatives
		 */

		for (x = -graduationX; x >= xMin; x -= graduationX) {

			pointGraduationGraphe = new Point2D.Double(x, 0);
			pointGraduationEcran = new Point2D.Double();

			transformationAffine.transform(pointGraduationGraphe,
					pointGraduationEcran);

			graduation = new Line2D.Double(pointGraduationEcran.getX(),
					pointGraduationEcran.getY(), pointGraduationEcran.getX(),
					pointGraduationEcran.getY() - 3);

			axeX.append(graduation, false);
		}

		return axeX;
	}

	/**
	 * @return
	 */
	private Shape getAxeY() {

		/*
		 * parametres de l'axe
		 */

		double yMin = graphe.getYMin();
		double yMax = graphe.getYMax();
		double graduationY = graphe.getGraduationY();

		/*
		 * forme de l'axe
		 */

		GeneralPath axeY = new GeneralPath();

		/*
		 * transormation affine pour passer des coordonnees du graphe aux
		 * coordonnees de l'ecran
		 */

		AffineTransform transformationAffine = getTransformationAffine();

		/*
		 * ligne de l'axe
		 */

		Point2D minAxeGraphe = new Point2D.Double(0, yMin);
		Point2D maxAxeGraphe = new Point2D.Double(0, yMax);

		Point2D minAxeEcran = new Point2D.Double();
		Point2D maxAxeEcran = new Point2D.Double();

		transformationAffine.transform(minAxeGraphe, minAxeEcran);
		transformationAffine.transform(maxAxeGraphe, maxAxeEcran);

		axeY.append(new Line2D.Double(minAxeEcran, maxAxeEcran), false);

		/*
		 * graduations de l'axe
		 */

		Point2D pointGraduationGraphe;
		Point2D pointGraduationEcran;

		Line2D graduation;

		double y;

		/*
		 * graduations positives
		 */

		for (y = graduationY; y <= yMax; y += graduationY) {

			pointGraduationGraphe = new Point2D.Double(0, y);
			pointGraduationEcran = new Point2D.Double();

			transformationAffine.transform(pointGraduationGraphe,
					pointGraduationEcran);

			graduation = new Line2D.Double(pointGraduationEcran.getX(),
					pointGraduationEcran.getY(),
					pointGraduationEcran.getX() + 3, pointGraduationEcran
					.getY());

			axeY.append(graduation, false);
		}

		/*
		 * graduations negatives
		 */

		for (y = -graduationY; y >= yMin; y -= graduationY) {

			pointGraduationGraphe = new Point2D.Double(0, y);
			pointGraduationEcran = new Point2D.Double();

			transformationAffine.transform(pointGraduationGraphe,
					pointGraduationEcran);

			graduation = new Line2D.Double(pointGraduationEcran.getX(),
					pointGraduationEcran.getY(),
					pointGraduationEcran.getX() + 3, pointGraduationEcran
					.getY());

			axeY.append(graduation, false);
		}

		return axeY;
	}

	/**
	 * @param x0
	 * @param y0
	 * @param x1
	 * @param y1
	 */
	public void grossir(int x0, int y0, int x1, int y1) {

		AffineTransform transformationAffine = getTransformationAffine();

		Point2D coinCadre0 = new Point2D.Double(x0, y0);
		Point2D coinCadre1 = new Point2D.Double(x1, y1);

		Point2D coinGraphe0 = new Point2D.Double();
		Point2D coinGraphe1 = new Point2D.Double();

		try {

			transformationAffine.inverseTransform(coinCadre0, coinGraphe0);
			transformationAffine.inverseTransform(coinCadre1, coinGraphe1);

			double xMin = Math.min(coinGraphe0.getX(), coinGraphe1.getX());
			double yMin = Math.min(coinGraphe0.getY(), coinGraphe1.getY());
			double xMax = Math.max(coinGraphe0.getX(), coinGraphe1.getX());
			double yMax = Math.max(coinGraphe0.getY(), coinGraphe1.getY());

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
	 */
	public final void actualiserCoordonneesCurseur(int xEcran, int yEcran) {

		Point2D curseurEcran = new Point2D.Double(xEcran, yEcran);
		Point2D curseurGraphe = new Point2D.Double();

		AffineTransform transformationAffine = getTransformationAffine();

		try {

			transformationAffine.inverseTransform(curseurEcran, curseurGraphe);

			panneauCoordonnees.setX(curseurGraphe.getX());
			panneauCoordonnees.setY(curseurGraphe.getY());

		} catch (NoninvertibleTransformException erreur) {

			traiter(erreur);
		}
	}
}