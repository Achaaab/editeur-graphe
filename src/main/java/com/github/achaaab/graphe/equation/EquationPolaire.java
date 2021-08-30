package com.github.achaaab.graphe.equation;

import com.github.achaaab.graphe.fonction.Fonction;

/**
 * equation du type rho = f(theta)
 *
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class EquationPolaire implements Equation {

	private Fonction f;

	/**
	 * @param f
	 */
	public EquationPolaire(Fonction f) {
		this.f = f;
	}

	/**
	 * @return the f
	 */
	public Fonction getF() {
		return f;
	}

	/**
	 * @param f the f to set
	 */
	public void setF(Fonction f) {
		this.f = f;
	}

	/**
	 * @param theta
	 * @return
	 */
	public double getRho(double theta) {
		return f.evaluer(theta);
	}
}