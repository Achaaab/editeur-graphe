package com.github.achaaab.graphe.equation;

import com.github.achaaab.graphe.fonction.Constante;
import com.github.achaaab.graphe.fonction.Fonction;

/**
 * equation du type {@code x = f(t), y = g(t)}
 *
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class EquationParametrique implements Equation {

	public static final String TYPE = "Paramétrique";

	private Fonction f;
	private Fonction g;

	/**
	 * @since 0.0.0
	 */
	public EquationParametrique() {
		this(new Constante(0), new Constante(0));
	}

	/**
	 * @param f
	 * @param g
	 * @since 0.0.0
	 */
	public EquationParametrique(Fonction f, Fonction g) {

		this.f = f;
		this.g = g;
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
	 * @return
	 * @since 0.0.0
	 */
	public Fonction getG() {
		return g;
	}

	/**
	 * @param
	 * @since 0.0.0
	 */
	public void setG(Fonction g) {
		this.g = g;
	}

	/**
	 * @param t
	 * @return
	 * @since 0.0.0
	 */
	public double getX(double t) {
		return f.evaluer(t);
	}

	/**
	 * @param t
	 * @return
	 * @since 0.0.0
	 */
	public double getY(double t) {
		return g.evaluer(t);
	}
}