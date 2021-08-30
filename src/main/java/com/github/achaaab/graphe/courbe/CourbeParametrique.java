package com.github.achaaab.graphe.courbe;

import java.awt.Shape;
import java.awt.geom.GeneralPath;

import com.github.achaaab.graphe.equation.Equation;
import com.github.achaaab.graphe.equation.EquationParametrique;
import com.github.achaaab.graphe.presentation.courbe.PanneauCourbeParametrique;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class CourbeParametrique extends CourbeAbstraite {

	private EquationParametrique equation;

	/**
	 * 
	 * @param nom
	 * @param equation
	 */
	public CourbeParametrique(String nom, EquationParametrique equation) {

		super(nom);

		this.equation = equation;

		presentation = new PanneauCourbeParametrique(this);

	}

	@Override
	public Shape getForme() {

		GeneralPath forme = new GeneralPath();

		double t;

		for (t = min; t + pas < max; t += pas) {

			if (interpolee) {
				ajouterSegment(forme, t, t + pas);
			} else {
				ajouterPoint(forme, t);
			}

		}

		if (interpolee) {
			ajouterSegment(forme, t, max);
		} else {
			ajouterPoint(forme, max);
		}

		return forme;

	}

	/**
	 * 
	 * @param forme
	 * @param t
	 */
	private void ajouterPoint(GeneralPath forme, double t) {

		double x = equation.getX(t);
		double y = equation.getY(t);

		ajouterSegment(forme, x, y, x, y);

	}

	/**
	 * 
	 * @param forme
	 * @param t0
	 * @param t1
	 */
	private void ajouterSegment(GeneralPath forme, double t0, double t1) {

		double x0 = equation.getX(t0);
		double y0 = equation.getY(t0);

		double x1 = equation.getX(t1);
		double y1 = equation.getY(t1);

		ajouterSegment(forme, x0, y0, x1, y1);

	}

	@Override
	public Equation getEquation() {
		return equation;
	}

	/**
	 * 
	 * @return l'equation parametrique de la courbe
	 */
	public EquationParametrique getEquationParametrique() {
		return equation;
	}

	@Override
	public TypeCourbe getType() {
		return TypeCourbe.PARAMETRIQUE;
	}

}