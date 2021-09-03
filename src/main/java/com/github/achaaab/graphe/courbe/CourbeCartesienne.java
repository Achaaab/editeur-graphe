package com.github.achaaab.graphe.courbe;

import com.github.achaaab.graphe.equation.EquationCartesienne;
import com.github.achaaab.graphe.presentation.courbe.PanneauCourbeCartesienne;

import java.awt.geom.GeneralPath;

/**
 * courbe definie par une equation cartesienne
 *
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class CourbeCartesienne extends CourbeAbstraite<EquationCartesienne> {

	/**
	 * @since 0.0.0
	 */
	public CourbeCartesienne() {
		this(NOM_COURBE_DEFAUT, new EquationCartesienne());
	}

	/**
	 * @param nom
	 * @param equation
	 * @since 0.0.0
	 */
	public CourbeCartesienne(String nom, EquationCartesienne equation) {

		super(nom, equation);

		this.equation = equation;

		presentation = new PanneauCourbeCartesienne(this);
	}

	@Override
	protected void ajouterPoint(GeneralPath forme, double x) {

		var y = equation.getY(x);

		Courbe.ajouterSegment(forme, x, y, x, y);
	}

	@Override
	protected void ajouterSegment(GeneralPath forme, double x0, double x1) {

		var y0 = equation.getY(x0);
		var y1 = equation.getY(x1);

		Courbe.ajouterSegment(forme, x0, y0, x1, y1);
	}
}