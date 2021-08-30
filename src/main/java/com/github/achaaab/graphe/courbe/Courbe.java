package com.github.achaaab.graphe.courbe;

import com.github.achaaab.graphe.equation.Equation;
import com.github.achaaab.graphe.presentation.courbe.PanneauCourbe;

import java.awt.Color;
import java.awt.Shape;

/**
 * interface definissant une courbe
 *
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public interface Courbe {

	/**
	 * @return l'equation de la courbe
	 */
	Equation getEquation();

	/**
	 * @return la couleur de la courbe
	 */
	Color getCouleur();

	/**
	 * @param couleur la couleur de la courbe
	 */
	void setCouleur(Color couleur);

	/**
	 * @return la forme de la courbe
	 */
	Shape getForme();

	/**
	 * @return le minimum du domaine de definition de la courbe
	 */
	double getMin();

	/**
	 * @param min le minimum du domaine de definition de la courbe
	 */
	void setMin(double min);

	/**
	 * @return le maximum du domaine de definition de la courbe
	 */
	double getMax();

	/**
	 * @param max le maximum du domaine de definition de la courbe
	 */
	void setMax(double max);

	/**
	 * @return le pas de dessin de la courbe (l'ecart entre 2 valeurs prises
	 * dans le domaine de definition)
	 */
	double getPas();

	/**
	 * @param pas le pas de dessin de la courbe (l'ecart entre 2 valeurs prises
	 * dans le domaine de definition)
	 */
	void setPas(double pas);

	/**
	 * @param interpolee true si la courbe est interpolee (un segment est tracé d'un
	 * point de la courbe au suivant), false sinon
	 */
	void setInterpolee(boolean interpolee);

	/**
	 * @return true si la courbe est interpolee (un segment est tracé d'un
	 * point de la courbe au suivant), false sinon
	 */
	boolean isInterpolee();

	/**
	 * @return le nom de la courbe
	 */
	String getNom();

	/**
	 * @param nom le nom de la courbe
	 */
	void setNom(String nom);

	/**
	 * @return le type de la courbe
	 */
	TypeCourbe getType();

	/**
	 * @return la presentation de la courbe (panneau de parametrage)
	 */
	PanneauCourbe getPresentation();
}