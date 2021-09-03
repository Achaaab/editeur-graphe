package com.github.achaaab.graphe.presentation.equation;

import com.github.achaaab.graphe.Graphe;

import javax.swing.JPanel;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public abstract class PanneauEquation extends JPanel {

	protected Graphe graphe;

	/**
	 * @param graphe
	 * @since 0.0.0
	 */
	public void setGraphe(Graphe graphe) {
		this.graphe = graphe;
	}
}