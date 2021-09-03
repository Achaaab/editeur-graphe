package com.github.achaaab.graphe.presentation.courbe;

import com.github.achaaab.graphe.courbe.CourbeCartesienne;
import com.github.achaaab.graphe.equation.EquationCartesienne;
import com.github.achaaab.graphe.presentation.equation.PanneauEquationCartesienne;
import com.github.achaaab.utilitaire.swing.SwingUtilitaire;

import static com.github.achaaab.utilitaire.swing.SwingUtilitaire.scale;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class PanneauCourbeCartesienne extends PanneauCourbe {

	/**
	 * @param courbeCartesienne
	 * @since 0.0.0
	 */
	public PanneauCourbeCartesienne(CourbeCartesienne courbeCartesienne) {

		super(courbeCartesienne);

		var equation = courbeCartesienne.getEquation();
		panneauEquation = new PanneauEquationCartesienne(equation);
		ajouterComposants();

		scale(this);
	}
}