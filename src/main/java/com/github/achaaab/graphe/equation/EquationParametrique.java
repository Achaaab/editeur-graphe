package com.github.achaaab.graphe.equation;

import com.github.achaaab.graphe.fonction.Fonction;

/**
 * equation du type x = f(t), y = g(t)
 *
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class EquationParametrique implements Equation {

	private Fonction f;
	private Fonction g;

	/**
	 * @param f
	 * @param g
	 */
	public EquationParametrique(Fonction f, Fonction g) {

		this.f = f;
		this.g = g;
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
	 * @return the g
	 */
	public Fonction getG() {
		return g;
	}

	/**
	 * @param g the g to set
	 */
	public void setG(Fonction g) {
		this.g = g;
	}

	/**
	 * @param t
	 * @return
	 */
	public double getX(double t) {
		return f.evaluer(t);
	}

	/**
	 * @param t
	 * @return
	 */
	public double getY(double t) {
		return g.evaluer(t);
	}
}