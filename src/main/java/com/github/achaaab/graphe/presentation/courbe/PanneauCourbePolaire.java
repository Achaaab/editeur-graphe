package com.github.achaaab.graphe.presentation.courbe;

import com.github.achaaab.graphe.courbe.CourbePolaire;
import com.github.achaaab.graphe.equation.EquationPolaire;
import com.github.achaaab.graphe.presentation.equation.PanneauEquationPolaire;

import static com.github.achaaab.utilitaire.swing.SwingUtilitaire.scale;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class PanneauCourbePolaire extends PanneauCourbe {

	/**
	 * @param courbePolaire
	 * @since 0.0.0
	 */
	public PanneauCourbePolaire(CourbePolaire courbePolaire) {

		super(courbePolaire);

		var equation = courbePolaire.getEquation();
		panneauEquation = new PanneauEquationPolaire(equation);
		ajouterComposants();

		scale(this);
	}
}