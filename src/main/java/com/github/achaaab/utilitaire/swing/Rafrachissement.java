package com.github.achaaab.utilitaire.swing;

import java.util.TimerTask;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class Rafrachissement extends TimerTask {

	private final PanneauTampon panneau;

	/**
	 * @param panneau
	 * @since 0.0.0
	 */
	public Rafrachissement(PanneauTampon panneau) {
		this.panneau = panneau;
	}

	@Override
	public void run() {

		panneau.setImageAJour(false);
		panneau.repaint();
	}
}