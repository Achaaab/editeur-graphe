package com.github.achaaab.graphe.equation;

import com.github.achaaab.graphe.fonction.Fonction;

/**
 * equation du type y = f(x)
 * 
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class EquationCartesienne implements Equation {

	private Fonction f;

	/**
	 * @param f
	 */
	public EquationCartesienne(Fonction f) {
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
	 * @param x
	 * @return
	 */
	public final double getY(double x) {
		return f.evaluer(x);
	}
}