package com.github.achaaab.graphe.presentation.equation;

import javax.swing.JPanel;

import com.github.achaaab.graphe.Graphe;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class PanneauEquation extends JPanel {

	protected Graphe graphe;

	/**
	 * @param graphe
	 *            the graphe to set
	 */
	public void setGraphe(Graphe graphe) {
		this.graphe = graphe;
	}
}