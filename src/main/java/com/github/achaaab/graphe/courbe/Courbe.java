package com.github.achaaab.graphe.courbe;

import com.github.achaaab.graphe.equation.Equation;
import com.github.achaaab.graphe.presentation.courbe.PanneauCourbe;

import java.awt.Color;
import java.awt.Shape;

/**
 * interface définissant une courbe
 *
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public interface Courbe {

	/**
	 * @return équation de la courbe
	 * @since 0.0.0
	 */
	Equation getEquation();

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
	 * @return true si la courbe est interpolée (un segment est tracé d'un point de la courbe au suivant),
	 * false sinon
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
	 * @return type de la courbe
	 * @since 0.0.0
	 */
	TypeCourbe getType();

	/**
	 * @return présentation de la courbe (panneau de paramétrage)
	 * @since 0.0.0
	 */
	PanneauCourbe getPresentation();
}