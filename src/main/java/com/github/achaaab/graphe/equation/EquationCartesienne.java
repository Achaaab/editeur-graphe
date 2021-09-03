package com.github.achaaab.graphe.equation;

import com.github.achaaab.graphe.fonction.Constante;
import com.github.achaaab.graphe.fonction.Fonction;

/**
 * équation du type {@code y = f(x)}
 *
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class EquationCartesienne implements Equation {

	public static final String TYPE = "Cartésienne";

	private Fonction f;

	/**
	 * @since 0.0.0
	 */
	public EquationCartesienne() {
		this(new Constante(0));
	}

	/**
	 * @param fonction
	 * @since 0.0.0
	 */
	public EquationCartesienne(Fonction fonction) {
		this.f = fonction;
	}

	@Override
	public String getType() {
		return TYPE;
	}

	/**
	 * @return
	 * @since 0.0.0
	 */
	public Fonction getF() {
		return f;
	}

	/**
	 * @param f
	 * @since 0.0.0
	 */
	public void setF(Fonction f) {
		this.f = f;
	}

	/**
	 * @param x
	 * @return
	 * @since 0.0.0
	 */
	public double getY(double x) {
		return f.evaluer(x);
	}
}