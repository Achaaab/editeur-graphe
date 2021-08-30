package com.github.achaaab.graphe.presentation.courbe;

import com.github.achaaab.graphe.courbe.CourbePolaire;
import com.github.achaaab.graphe.equation.EquationPolaire;
import com.github.achaaab.graphe.presentation.equation.PanneauEquationPolaire;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class PanneauCourbePolaire extends PanneauCourbe {

	/**
	 * UID genere le 24/06/2010
	 */
	private static final long serialVersionUID = -4445314944420280690L;

	/**
	 * 
	 * @param courbePolaire
	 */
	public PanneauCourbePolaire(CourbePolaire courbePolaire) {

		super(courbePolaire);

		EquationPolaire equationPolaire = courbePolaire.getEquationPolaire();

		panneauEquation = new PanneauEquationPolaire(equationPolaire);

		ajouterComposants();

	}

}