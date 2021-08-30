package com.github.achaaab.graphe.courbe;

import com.github.achaaab.graphe.presentation.courbe.PanneauCourbe;

import java.awt.Color;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;

/**
 * classe abstraite definissant une courbe quelconque
 *
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public abstract class CourbeAbstraite implements Courbe {

	protected String nom;
	protected double min;
	protected double max;
	protected double pas;
	protected boolean interpolee;
	protected Color couleur;

	protected PanneauCourbe presentation;

	/**
	 * @param nom
	 */
	public CourbeAbstraite(String nom) {
		this(nom, Color.BLACK);
	}

	/**
	 * @param nom
	 * @param couleur
	 */
	public CourbeAbstraite(String nom, Color couleur) {

		this.nom = nom;
		this.couleur = couleur;

		min = -10;
		max = 10;
		pas = 0.1;
		interpolee = true;
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

	/**
	 * @return the min
	 */
	public final double getMin() {
		return min;
	}

	/**
	 * @param min the min to set
	 */
	public final void setMin(double min) {
		this.min = min;
	}

	/**
	 * @return the max
	 */
	public final double getMax() {
		return max;
	}

	@Override
	public final void setMax(double max) {
		this.max = max;
	}

	@Override
	public final double getPas() {
		return pas;
	}

	@Override
	public final void setPas(double pas) {
		this.pas = pas;
	}

	@Override
	public final boolean isInterpolee() {
		return interpolee;
	}

	@Override
	public final void setInterpolee(boolean interpolee) {
		this.interpolee = interpolee;
	}

	@Override
	public final String getNom() {
		return nom;
	}

	@Override
	public final void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public final String toString() {
		return nom;
	}

	@Override
	public final PanneauCourbe getPresentation() {
		return presentation;
	}

	/**
	 * @param forme
	 * @param x0
	 * @param y0
	 * @param x1
	 * @param y1
	 */
	protected static void ajouterSegment(GeneralPath forme, double x0,
										 double y0, double x1, double y1) {

		forme.append(new Line2D.Double(x0, y0, x1, y1), false);
	}
}