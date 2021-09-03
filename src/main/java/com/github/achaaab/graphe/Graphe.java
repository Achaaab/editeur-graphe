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

	private final List<Courbe<?>> courbes;
	private final PresentationGraphe presentation;

	/**
	 * @since 0.0.0
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
	 * @since 0.0.0
	 */
	public void ajouterCourbe(Courbe<?> courbe) {

		courbes.add(courbe);

		presentation.ajouterCourbe(courbe);
		actualiserGraphe();
	}

	/**
	 * @param courbe
	 * @since 0.0.0
	 */
	public void supprimerCourbe(Courbe<?> courbe) {

		courbes.remove(courbe);

		presentation.supprimerCourbe(courbe);
		actualiserGraphe();
	}

	/**
	 * @since 0.0.0
	 */
	public void actualiserListeCourbes() {
		presentation.actualiserListeCourbes();
	}

	/**
	 * @return
	 * @since 0.0.0
	 */
	public List<Courbe<?>> getCourbes() {
		return courbes;
	}

	/**
	 * @return
	 * @since 0.0.0
	 */
	public double getXMin() {
		return xMin;
	}

	/**
	 * @param xMin
	 * @since 0.0.0
	 */
	public void setXMin(double xMin) {
		this.xMin = xMin;
	}

	/**
	 * @return
	 * @since 0.0.0
	 */
	public double getXMax() {
		return xMax;
	}

	/**
	 * @param xMax
	 * @since 0.0.0
	 */
	public void setXMax(double xMax) {
		this.xMax = xMax;
	}

	/**
	 * @return
	 * @since 0.0.0
	 */
	public double getYMin() {
		return yMin;
	}

	/**
	 * @param yMin
	 * @since 0.0.0
	 */
	public void setYMin(double yMin) {
		this.yMin = yMin;
	}

	/**
	 * @return
	 * @since 0.0.0
	 */
	public double getYMax() {
		return yMax;
	}

	/**
	 * @param yMax
	 * @since 0.0.0
	 */
	public void setYMax(double yMax) {
		this.yMax = yMax;
	}

	/**
	 * @return
	 * @since 0.0.0
	 */
	public double getGraduationX() {
		return graduationX;
	}

	/**
	 * @param graduationX
	 * @since 0.0.0
	 */
	public void setGraduationX(double graduationX) {
		this.graduationX = graduationX;
	}

	/**
	 * @return
	 * @since 0.0.0
	 */
	public double getGraduationY() {
		return graduationY;
	}

	/**
	 * @param graduationY
	 * @since 0.0.0
	 */
	public void setGraduationY(double graduationY) {
		this.graduationY = graduationY;
	}

	/**
	 * @since 0.0.0
	 */
	public void actualiserFenetre() {
		presentation.actualiserFenetre();
	}

	/**
	 * @since 0.0.0
	 */
	public void actualiserGraphe() {
		presentation.actualiserGraphe();
	}

	/**
	 * @return
	 * @since 0.0.0
	 */
	public PresentationGraphe getPresentation() {
		return presentation;
	}
}