package com.github.achaaab.utilitaire.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class LabelComposant extends JPanel {

	private JLabel label;
	private Component composant;

	/**
	 * 
	 * @param label
	 * @param composant
	 */
	public LabelComposant(String label, Component composant) {

		setLayout(new BorderLayout());

		this.label = new JLabel(label);
		this.composant = composant;

		add(this.label, BorderLayout.WEST);
		add(composant, BorderLayout.CENTER);

	}

	/**
	 * 
	 * @param label
	 */
	public void setLabel(String label) {
		this.label.setText(label);
	}

	/**
	 * 
	 * @param foreground
	 */
	public void setForegroundLabel(Color foreground) {
		label.setForeground(foreground);
	}

	/**
	 * 
	 * @param foreground
	 */
	public void setForegroundComposant(Color foreground) {
		composant.setForeground(foreground);
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