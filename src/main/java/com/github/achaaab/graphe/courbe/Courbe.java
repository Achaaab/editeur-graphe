package com.github.achaaab.graphe.courbe;

import com.github.achaaab.graphe.equation.Equation;
import com.github.achaaab.graphe.presentation.courbe.PanneauCourbe;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;

/**
 * interface définissant une courbe
 *
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public interface Courbe<E extends Equation> {

	/**
	 * @param forme
	 * @param x0
	 * @param y0
	 * @param x1
	 * @param y1
	 * @since 0.0.0
	 */
	static void ajouterSegment(GeneralPath forme, double x0, double y0, double x1, double y1) {
		forme.append(new Line2D.Double(x0, y0, x1, y1), false);
	}

	/**
	 * @return curve type
	 * @since 0.0.0
	 */
	String getType();

	/**
	 * @return équation de la courbe
	 * @since 0.0.0
	 */
	E getEquation();

	/**
	 * @return couleur de la courbe
	 * @since 0.0.0
	 */
	Color getCouleur();

	/**
	 * @param couleur couleur de la courbe
	 * @since 0.0.0
	 */
	void setCouleur(Color couleur);

	/**
	 * @return forme de la courbe
	 * @since 0.0.0
	 */
	Shape getForme();

	/**
	 * @return minimum du domaine de définition de la courbe
	 * @since 0.0.0
	 */
	double getMin();

	/**
	 * @param min minimum du domaine de définition de la courbe
	 * @since 0.0.0
	 */
	void setMin(double min);

	/**
	 * @return maximum du domaine de définition de la courbe
	 * @since 0.0.0
	 */
	double getMax();

	/**
	 * @param max maximum du domaine de définition de la courbe
	 * @since 0.0.0
	 */
	void setMax(double max);

	/**
	 * @return pas de dessin de la courbe (différence entre 2 valeurs consécutives du domaine de définition)
	 * @since 0.0.0
	 */
	double getPas();

	/**
	 * @param pas pas de dessin de la courbe (différence entre 2 valeurs consécutives du domaine de définition)
	 * @since 0.0.0
	 */
	void setPas(double pas);

	/**
	 * @param interpolee true si la courbe est interpolée (un segment est tracé d'un point de la courbe au suivant),
	 * false sinon
	 * @since 0.0.0
	 */
	void setInterpolee(boolean interpolee);

	/**
	 * @return {@code true} si la courbe est interpolée (un segment est tracé d'un point de la courbe au suivant),
	 * {@©ode false} sinon
	 * @since 0.0.0
	 */
	boolean isInterpolee();

	/**
	 * @return nom de la courbe
	 * @since 0.0.0
	 */
	String getNom();

	/**
	 * @param nom nom de la courbe
	 * @since 0.0.0
	 */
	void setNom(String nom);

	/**
	 * @return présentation de la courbe (panneau de paramétrage)
	 * @since 0.0.0
	 */
	PanneauCourbe getPresentation();
}