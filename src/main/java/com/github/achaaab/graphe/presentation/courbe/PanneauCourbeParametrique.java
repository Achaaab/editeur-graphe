package com.github.achaaab.graphe.presentation.courbe;

import com.github.achaaab.graphe.courbe.CourbeParametrique;
import com.github.achaaab.graphe.equation.EquationParametrique;
import com.github.achaaab.graphe.presentation.equation.PanneauEquationParametrique;

import static com.github.achaaab.utilitaire.swing.SwingUtilitaire.scale;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class PanneauCourbeParametrique extends PanneauCourbe {

	/**
	 * @param courbeParametrique
	 * @since 0.0.0
	 */
	public PanneauCourbeParametrique(CourbeParametrique courbeParametrique) {

		super(courbeParametrique);

		var equation = courbeParametrique.getEquation();
		panneauEquation = new PanneauEquationParametrique(equation);
		ajouterComposants();

		scale(this);
	}
}