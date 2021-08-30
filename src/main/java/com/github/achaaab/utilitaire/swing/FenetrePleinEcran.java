package com.github.achaaab.utilitaire.swing;

import java.awt.Component;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class FenetrePleinEcran extends JFrame {

	/**
	 * 
	 */
	public FenetrePleinEcran(Component composant) {

		setUndecorated(true);

		GraphicsDevice ecranPrincipal = GraphicsEnvironment
				.getLocalGraphicsEnvironment().getDefaultScreenDevice();

		add(composant);

		ecranPrincipal.setFullScreenWindow(this);

	}

}