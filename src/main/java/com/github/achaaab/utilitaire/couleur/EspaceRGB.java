package com.github.achaaab.utilitaire.couleur;

import java.awt.Color;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class EspaceRGB extends EspaceColorimetrique {

	public static EspaceRGB INSTANCE = new EspaceRGB();

	/**
	 * @since 0.0.0
	 */
	private EspaceRGB() {
		super("RGB", "Rouge", "Vert", "Bleu");
	}

	@Override
	public Color getCouleur(int composante0, int composante1, int composante2) {
		return new Color(composante0, composante1, composante2);
	}

	@Override
	public int[] getComposantes(Color couleur) {
		return new int[] { couleur.getRed(), couleur.getGreen(), couleur.getBlue() };
	}
}