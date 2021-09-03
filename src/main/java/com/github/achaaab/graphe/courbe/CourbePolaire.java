package com.github.achaaab.graphe.courbe;

import com.github.achaaab.graphe.equation.EquationPolaire;
import com.github.achaaab.graphe.presentation.courbe.PanneauCourbePolaire;

import java.awt.geom.GeneralPath;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 * courbe définie par une équation polaire
 *
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class CourbePolaire extends CourbeAbstraite<EquationPolaire> {

	/**
	 * @since 0.0.0
	 */
	public CourbePolaire() {
		this(NOM_COURBE_DEFAUT, new EquationPolaire());
	}

	/**
	 * @param nom
	 * @param equation
	 * @since 0.0.0
	 */
	public CourbePolaire(String nom, EquationPolaire equation) {

		super(nom, equation);

		min = 0;
		max = 2 * PI;
		pas = PI / 500;

		presentation = new PanneauCourbePolaire(this);
	}

	@Override
	protected void ajouterPoint(GeneralPath forme, double theta) {

		var rho = equation.getRho(theta);

		var x = rho * cos(theta);
		var y = rho * sin(theta);

		Courbe.ajouterSegment(forme, x, y, x, y);
	}

	@Override
	protected void ajouterSegment(GeneralPath forme, double theta0, double theta1) {

		var rho0 = equation.getRho(theta0);
		var x0 = rho0 * cos(theta0);
		var y0 = rho0 * sin(theta0);

		var rho1 = equation.getRho(theta1);
		var x1 = rho1 * cos(theta1);
		var y1 = rho1 * sin(theta1);

		Courbe.ajouterSegment(forme, x0, y0, x1, y1);
	}
}