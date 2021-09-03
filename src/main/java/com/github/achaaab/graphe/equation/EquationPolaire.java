package com.github.achaaab.graphe.equation;

import com.github.achaaab.graphe.fonction.Constante;
import com.github.achaaab.graphe.fonction.Fonction;

/**
 * equation du type {@code rho = f(theta)}
 *
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class EquationPolaire implements Equation {

	public static final String TYPE = "Polaire";

	private Fonction f;

	/**
	 * @since 0.0.0
	 */
	public EquationPolaire() {
		this(new Constante(0));
	}

	/**
	 * @param f
	 * @since 0.0.0
	 */
	public EquationPolaire(Fonction f) {
		this.f = f;
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
	 * @param theta
	 * @return
	 * @since 0.0.0
	 */
	public double getRho(double theta) {
		return f.evaluer(theta);
	}
}