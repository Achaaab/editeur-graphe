package com.github.achaaab.graphe.courbe;

import java.awt.Shape;
import java.awt.geom.GeneralPath;

import com.github.achaaab.graphe.equation.Equation;
import com.github.achaaab.graphe.equation.EquationPolaire;
import com.github.achaaab.graphe.presentation.courbe.PanneauCourbePolaire;

/**
 * courbe definie par une equation polaire
 * 
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class CourbePolaire extends CourbeAbstraite {

	private EquationPolaire equation;

	/**
	 * 
	 * @param nom
	 * @param equation
	 */
	public CourbePolaire(String nom, EquationPolaire equation) {

		super(nom);

		min = 0;
		max = 2 * Math.PI;
		pas = Math.PI / 500;

		this.equation = equation;

		presentation = new PanneauCourbePolaire(this);

	}

	@Override
	public Shape getForme() {

		GeneralPath forme = new GeneralPath();

		double theta;

		for (theta = min; theta + pas < max; theta += pas) {

			if (interpolee) {
				ajouterSegment(forme, theta, theta + pas);
			} else {
				ajouterPoint(forme, theta);
			}

		}

		if (interpolee) {
			ajouterSegment(forme, theta, max);
		} else {
			ajouterPoint(forme, max);
		}

		return forme;

	}

	/**
	 * 
	 * @param forme
	 * @param theta
	 */
	private void ajouterPoint(GeneralPath forme, double theta) {

		double rho = equation.getRho(theta);

		double x = rho * Math.cos(theta);
		double y = rho * Math.sin(theta);

		ajouterSegment(forme, x, y, x, y);

	}

	/**
	 * 
	 * @param forme
	 * @param theta0
	 * @param theta1
	 */
	private void ajouterSegment(GeneralPath forme, double theta0, double theta1) {

		double rho0 = equation.getRho(theta0);
		double x0 = rho0 * Math.cos(theta0);
		double y0 = rho0 * Math.sin(theta0);

		double rho1 = equation.getRho(theta1);
		double x1 = rho1 * Math.cos(theta1);
		double y1 = rho1 * Math.sin(theta1);

		ajouterSegment(forme, x0, y0, x1, y1);

	}

	@Override
	public Equation getEquation() {
		return equation;
	}

	/**
	 * 
	 * @return l'equation polaire de la courbe
	 */
	public EquationPolaire getEquationPolaire() {
		return equation;
	}

	@Override
	public TypeCourbe getType() {
		return TypeCourbe.POLAIRE;
	}

}