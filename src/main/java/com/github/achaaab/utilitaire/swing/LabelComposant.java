package com.github.achaaab.utilitaire.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class LabelComposant extends JPanel {

	private final JLabel label;
	private final Component composant;

	/**
	 * @param label
	 * @param composant
	 * @since 0.0.0
	 */
	public LabelComposant(String label, Component composant) {

		setLayout(new BorderLayout());

		this.label = new JLabel(label);
		this.composant = composant;

		add(this.label, WEST);
		add(composant, CENTER);
	}

	/**
	 * @param foreground
	 * @since 0.0.0
	 */
	public void setForegroundLabel(Color foreground) {
		label.setForeground(foreground);
	}

	@Override
	public void setForeground(Color foreground) {

		if (label != null) {
			label.setForeground(foreground);
		}

		if (composant != null) {
			composant.setForeground(foreground);
		}
	}
}