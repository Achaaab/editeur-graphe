package com.github.achaaab.graphe.courbe;

import com.github.achaaab.graphe.equation.Equation;
import com.github.achaaab.graphe.equation.EquationCartesienne;
import com.github.achaaab.graphe.presentation.courbe.PanneauCourbeCartesienne;

import java.awt.Shape;
import java.awt.geom.GeneralPath;

/**
 * courbe definie par une equation cartesienne
 *
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class CourbeCartesienne extends CourbeAbstraite {

	private EquationCartesienne equation;

	/**
	 * @param nom
	 * @param equation
	 */
	public CourbeCartesienne(String nom, EquationCartesienne equation) {

		super(nom);

		this.equation = equation;

		presentation = new PanneauCourbeCartesienne(this);

	}

	@Override
	public Shape getForme() {

		GeneralPath forme = new GeneralPath();

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
	 */
	private void ajouterPoint(GeneralPath forme, double x) {

		double y = equation.getY(x);

		ajouterSegment(forme, x, y, x, y);

	}

	/**
	 * @param forme
	 * @param x0
	 * @param x1
	 */
	private void ajouterSegment(GeneralPath forme, double x0, double x1) {

		double y0 = equation.getY(x0);
		double y1 = equation.getY(x1);

		ajouterSegment(forme, x0, y0, x1, y1);

	}

	@Override
	public Equation getEquation() {
		return equation;
	}

	/**
	 * @return l'equation cartesienne de la courbe
	 */
	public EquationCartesienne getEquationCartesienne() {
		return equation;
	}

	@Override
	public TypeCourbe getType() {
		return TypeCourbe.CARTESIENNE;
	}
}