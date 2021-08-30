package com.github.achaaab.utilitaire.couleur;

import java.awt.Color;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class EspaceHSV extends EspaceColorimetrique {

	private static EspaceHSV instance;

	/**
	 * 
	 * @return
	 */
	public static final synchronized EspaceHSV getInstance() {

		if (instance == null) {
			instance = new EspaceHSV();
		}

		return instance;

	}

	/**
	 * 
	 */
	private EspaceHSV() {
		super("HSV", "Teinte", "Saturation", "Valeur");
	}

	@Override
	public final Color getCouleur(int composante0, int composante1,
			int composante2) {

		float teinte = composante0 / 255f;
		float saturation = composante1 / 255f;
		float valeur = composante2 / 255f;

		return Color.getHSBColor(teinte, saturation, valeur);

	}

	@Override
	public final int[] getComposantes(Color couleur) {

		float[] hsv = new float[3];

		int r = couleur.getRed();
		int g = couleur.getGreen();
		int b = couleur.getBlue();

		Color.RGBtoHSB(r, g, b, hsv);

		float h = hsv[0];
		float s = hsv[1];
		float v = hsv[2];

		int teinte = Math.round(255 * h);
		int saturation = Math.round(255 * s);
		int valeur = Math.round(255 * v);

		return new int[] { teinte, saturation, valeur };

	}

}