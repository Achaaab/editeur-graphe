package com.github.achaaab.graphe.presentation.courbe;

import com.github.achaaab.graphe.courbe.CourbeParametrique;
import com.github.achaaab.graphe.equation.EquationParametrique;
import com.github.achaaab.graphe.presentation.equation.PanneauEquationParametrique;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class PanneauCourbeParametrique extends PanneauCourbe {

	/**
	 * @param courbeParametrique
	 */
	public PanneauCourbeParametrique(CourbeParametrique courbeParametrique) {

		super(courbeParametrique);

		EquationParametrique equationParametrique = courbeParametrique.getEquationParametrique();
		panneauEquation = new PanneauEquationParametrique(equationParametrique);
		ajouterComposants();
	}
}