package com.github.achaaab.graphe;

import java.util.ArrayList;
import java.util.List;

import com.github.achaaab.graphe.courbe.Courbe;
import com.github.achaaab.graphe.presentation.graphe.PresentationGraphe;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class Graphe {

	private double xMin, xMax, yMin, yMax;

	private double graduationX, graduationY;

	private List<Courbe> courbes;

	private PresentationGraphe presentation;

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

		courbes = new ArrayList<Courbe>();
		presentation = new PresentationGraphe(this);

	}

	/**
	 * 
	 * @param courbe
	 */
	public final void ajouterCourbe(Courbe courbe) {

		courbes.add(courbe);

		presentation.ajouterCourbe(courbe);
		actualiserGraphe();

	}

	/**
	 * 
	 * @param courbe
	 */
	public final void supprimerCourbe(Courbe courbe) {

		courbes.remove(courbe);

		presentation.supprimerCourbe(courbe);
		actualiserGraphe();

	}
	
	/**
	 * 
	 */
	public final void actualiserListeCourbes() {
		presentation.actualiserListeCourbes();
	}

	/**
	 * @return the courbes
	 */
	public final List<Courbe> getCourbes() {
		return courbes;
	}

	/**
	 * @return the xMin
	 */
	public final double getXMin() {
		return xMin;
	}

	/**
	 * @param xMin
	 *            the xMin to set
	 */
	public final void setXMin(double xMin) {
		this.xMin = xMin;
	}

	/**
	 * @return the xMax
	 */
	public final double getXMax() {
		return xMax;
	}

	/**
	 * @param xMax
	 *            the xMax to set
	 */
	public final void setXMax(double xMax) {
		this.xMax = xMax;
	}

	/**
	 * @return the yMin
	 */
	public final double getYMin() {
		return yMin;
	}

	/**
	 * @param yMin
	 *            the yMin to set
	 */
	public final void setYMin(double yMin) {
		this.yMin = yMin;
	}

	/**
	 * @return the yMax
	 */
	public final double getYMax() {
		return yMax;
	}

	/**
	 * @param yMax
	 *            the yMax to set
	 */
	public final void setYMax(double yMax) {
		this.yMax = yMax;
	}

	/**
	 * @return the graduationX
	 */
	public final double getGraduationX() {
		return graduationX;
	}

	/**
	 * @param graduationX
	 *            the graduationX to set
	 */
	public final void setGraduationX(double graduationX) {
		this.graduationX = graduationX;
	}

	/**
	 * @return the graduationY
	 */
	public final double getGraduationY() {
		return graduationY;
	}

	/**
	 * @param graduationY
	 *            the graduationY to set
	 */
	public final void setGraduationY(double graduationY) {
		this.graduationY = graduationY;
	}

	/**
	 * 
	 */
	public final void actualiserFenetre() {
		presentation.actualiserFenetre();
	}

	/**
	 * 
	 */
	public final void actualiserGraphe() {
		presentation.actualiserGraphe();
	}

	/**
	 * @return the presentation
	 */
	public final PresentationGraphe getPresentation() {
		return presentation;
	}

}