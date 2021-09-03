package com.github.achaaab.graphe.courbe;

import com.github.achaaab.graphe.equation.Equation;
import com.github.achaaab.graphe.presentation.courbe.PanneauCourbe;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.GeneralPath;

import static java.awt.Color.BLACK;

/**
 * classe abstraite définissant une courbe quelconque
 *
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public abstract class CourbeAbstraite<E extends Equation> implements Courbe<E> {

	protected static final String NOM_COURBE_DEFAUT = "courbe_defaut";

	protected E equation;
	protected String nom;
	protected double min;
	protected double max;
	protected double pas;
	protected boolean interpolee;
	protected Color couleur;

	protected PanneauCourbe presentation;

	/**
	 * @param nom
	 * @param equation équation de la courbe
	 * @since 0.0.0
	 */
	public CourbeAbstraite(String nom, E equation) {
		this(nom, equation, BLACK);
	}

	/**
	 * @param nom
	 * @param equation équation de la courbe
	 * @param couleur
	 * @since 0.0.0
	 */
	public CourbeAbstraite(String nom, E equation, Color couleur) {

		this.nom = nom;
		this.equation = equation;
		this.couleur = couleur;

		min = -10;
		max = 10;
		pas = 0.1;
		interpolee = true;
	}

	@Override
	public Shape getForme() {

		var forme = new GeneralPath();

		double x;

		for (x = min; x + pas < max; x += pas) {

			if (interpolee) {
				ajouterSegment(forme, x, x + pas);
			} else {
				ajouterPoint(forme, x);
			}

		}

		if (interpolee) {
			ajouterSegment(forme, x, max);
		} else {
			ajouterPoint(forme, max);
		}

		return forme;
	}

	/**
	 * @param forme
	 * @param x
	 * @since 0.0.0
	 */
	protected abstract void ajouterPoint(GeneralPath forme, double x);

	/**
	 * @param forme
	 * @param x0
	 * @param x1
	 * @since 0.0.0
	 */
	protected abstract void ajouterSegment(GeneralPath forme, double x0, double x1);

	@Override
	public String getType() {
		return equation.getType();
	}

	@Override
	public E getEquation() {
		return equation;
	}

	@Override
	public Color getCouleur() {
		return couleur;
	}

	@Override
	public void setCouleur(Color couleur) {

		this.couleur = couleur;

		presentation.actualiserCouleurCourbe();
	}

	@Override
	public double getMin() {
		return min;
	}

	@Override
	public void setMin(double min) {
		this.min = min;
	}

	@Override
	public double getMax() {
		return max;
	}

	@Override
	public void setMax(double max) {
		this.max = max;
	}

	@Override
	public double getPas() {
		return pas;
	}

	@Override
	public void setPas(double pas) {
		this.pas = pas;
	}

	@Override
	public boolean isInterpolee() {
		return interpolee;
	}

	@Override
	public void setInterpolee(boolean interpolee) {
		this.interpolee = interpolee;
	}

	@Override
	public String getNom() {
		return nom;
	}

	@Override
	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return nom;
	}

	@Override
	public PanneauCourbe getPresentation() {
		return presentation;
	}
}