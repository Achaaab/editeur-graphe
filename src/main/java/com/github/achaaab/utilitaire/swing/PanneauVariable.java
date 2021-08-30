package com.github.achaaab.utilitaire.swing;

import java.awt.Container;
import java.awt.Window;

import javax.swing.JPanel;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class PanneauVariable extends JPanel {

	/**
	 * 
	 */
	public void pack() {

		Container parent = getParent();

		while (parent != null && !(parent instanceof Window)) {
			parent = parent.getParent();
		}

		if (parent != null) {

			Window fenetre = (Window) parent;
			fenetre.pack();

		}

	}

}