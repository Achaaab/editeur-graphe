package com.github.achaaab.utilitaire.couleur;

import java.awt.Color;

import static java.awt.Color.RGBtoHSB;
import static java.awt.Color.getHSBColor;
import static java.lang.Math.round;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class EspaceHSV extends EspaceColorimetrique {

	public static final EspaceHSV INSTANCE = new EspaceHSV();

	/**
	 * @since 0.0.0
	 */
	private EspaceHSV() {
		super("HSV", "Teinte", "Saturation", "Valeur");
	}

	@Override
	public Color getCouleur(int composante0, int composante1, int composante2) {

		var teinte = composante0 / 255f;
		var saturation = composante1 / 255f;
		var valeur = composante2 / 255f;

		return getHSBColor(teinte, saturation, valeur);
	}

	@Override
	public int[] getComposantes(Color couleur) {

		var hsv = new float[3];

		var r = couleur.getRed();
		var g = couleur.getGreen();
		var b = couleur.getBlue();

		RGBtoHSB(r, g, b, hsv);

		var h = hsv[0];
		var s = hsv[1];
		var v = hsv[2];

		var teinte = round(255 * h);
		var saturation = round(255 * s);
		var valeur = round(255 * v);

		return new int[] { teinte, saturation, valeur };
	}
}