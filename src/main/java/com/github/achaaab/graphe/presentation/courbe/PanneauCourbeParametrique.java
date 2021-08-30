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
	 * UID genere le 24/06/2010
	 */
	private static final long serialVersionUID = -8565289176312901406L;

	/**
	 * 
	 * @param courbeParametrique
	 */
	public PanneauCourbeParametrique(CourbeParametrique courbeParametrique) {

		super(courbeParametrique);

		EquationParametrique equationParametrique = courbeParametrique
				.getEquationParametrique();

		panneauEquation = new PanneauEquationParametrique(equationParametrique);

		ajouterComposants();

	}

}