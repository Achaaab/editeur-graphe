package com.github.achaaab.graphe.presentation.courbe;

import com.github.achaaab.graphe.courbe.CourbeCartesienne;
import com.github.achaaab.graphe.equation.EquationCartesienne;
import com.github.achaaab.graphe.presentation.equation.PanneauEquationCartesienne;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class PanneauCourbeCartesienne extends PanneauCourbe {

	/**
	 * @param courbeCartesienne
	 */
	public PanneauCourbeCartesienne(CourbeCartesienne courbeCartesienne) {

		super(courbeCartesienne);

		var equationCartesienne = courbeCartesienne.getEquationCartesienne();
		panneauEquation = new PanneauEquationCartesienne(equationCartesienne);
		ajouterComposants();
	}
}