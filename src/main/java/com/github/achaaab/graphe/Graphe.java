package com.github.achaaab.graphe;

import com.github.achaaab.graphe.courbe.Courbe;
import com.github.achaaab.graphe.presentation.graphe.PresentationGraphe;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class Graphe {

	private double xMin, xMax, yMin, yMax;

	private double graduationX, graduationY;

	private final List<Courbe> courbes;

	private final PresentationGraphe presentation;

	/**
	 *
	 */
	public Graphe() {

		xMin = -10;
		xMax = 10;
		yMin = -5;
		yMax = 5;

		graduationX = 1;
		graduationY = 1;

		courbes = new ArrayList<>();
		presentation = new PresentationGraphe(this);
	}

	/**
	 * @param courbe
	 */
	public void ajouterCourbe(Courbe courbe) {

		courbes.add(courbe);

		presentation.ajouterCourbe(courbe);
		actualiserGraphe();
	}

	/**
	 * @param courbe
	 */
	public void supprimerCourbe(Courbe courbe) {

		courbes.remove(courbe);

		presentation.supprimerCourbe(courbe);
		actualiserGraphe();
	}

	/**
	 *
	 */
	public void actualiserListeCourbes() {
		presentation.actualiserListeCourbes();
	}

	/**
	 * @return the courbes
	 */
	public List<Courbe> getCourbes() {
		return courbes;
	}

	/**
	 * @return the xMin
	 */
	public double getXMin() {
		return xMin;
	}

	/**
	 * @param xMin the xMin to set
	 */
	public void setXMin(double xMin) {
		this.xMin = xMin;
	}

	/**
	 * @return the xMax
	 */
	public double getXMax() {
		return xMax;
	}

	/**
	 * @param xMax the xMax to set
	 */
	public void setXMax(double xMax) {
		this.xMax = xMax;
	}

	/**
	 * @return the yMin
	 */
	public double getYMin() {
		return yMin;
	}

	/**
	 * @param yMin the yMin to set
	 */
	public void setYMin(double yMin) {
		this.yMin = yMin;
	}

	/**
	 * @return the yMax
	 */
	public double getYMax() {
		return yMax;
	}

	/**
	 * @param yMax the yMax to set
	 */
	public void setYMax(double yMax) {
		this.yMax = yMax;
	}

	/**
	 * @return the graduationX
	 */
	public double getGraduationX() {
		return graduationX;
	}

	/**
	 * @param graduationX the graduationX to set
	 */
	public void setGraduationX(double graduationX) {
		this.graduationX = graduationX;
	}

	/**
	 * @return the graduationY
	 */
	public double getGraduationY() {
		return graduationY;
	}

	/**
	 * @param graduationY the graduationY to set
	 */
	public void setGraduationY(double graduationY) {
		this.graduationY = graduationY;
	}

	/**
	 *
	 */
	public void actualiserFenetre() {
		presentation.actualiserFenetre();
	}

	/**
	 *
	 */
	public void actualiserGraphe() {
		presentation.actualiserGraphe();
	}

	/**
	 * @return the presentation
	 */
	public PresentationGraphe getPresentation() {
		return presentation;
	}
}