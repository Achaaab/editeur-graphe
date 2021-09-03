package com.github.achaaab.graphe.courbe;

import com.github.achaaab.graphe.equation.EquationParametrique;
import com.github.achaaab.graphe.presentation.courbe.PanneauCourbeParametrique;

import java.awt.geom.GeneralPath;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class CourbeParametrique extends CourbeAbstraite<EquationParametrique> {

	/**
	 * @since 0.0.0
	 */
	public CourbeParametrique() {
		this(NOM_COURBE_DEFAUT, new EquationParametrique());
	}

	/**
	 * @param nom
	 * @param equation
	 * @since 0.0.0
	 */
	public CourbeParametrique(String nom, EquationParametrique equation) {

		super(nom, equation);

		this.equation = equation;

		presentation = new PanneauCourbeParametrique(this);
	}

	@Override
	protected void ajouterPoint(GeneralPath forme, double t) {

		var x = equation.getX(t);
		var y = equation.getY(t);

		Courbe.ajouterSegment(forme, x, y, x, y);
	}

	@Override
	protected void ajouterSegment(GeneralPath forme, double t0, double t1) {

		var x0 = equation.getX(t0);
		var y0 = equation.getY(t0);

		var x1 = equation.getX(t1);
		var y1 = equation.getY(t1);

		Courbe.ajouterSegment(forme, x0, y0, x1, y1);
	}
}