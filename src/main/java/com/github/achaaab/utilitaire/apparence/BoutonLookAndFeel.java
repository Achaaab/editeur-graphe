package com.github.achaaab.utilitaire.apparence;

import javax.swing.JRadioButtonMenuItem;
import javax.swing.plaf.metal.MetalTheme;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class BoutonLookAndFeel extends JRadioButtonMenuItem {

	/**
	 * @param nomLookAndFeel
	 * @param classeLookAndFeel
	 * @param theme optionnel (renseigner seulement pour le Look And Feel Metal)
	 */
	public BoutonLookAndFeel(String nomLookAndFeel, String classeLookAndFeel, MetalTheme theme) {

		super(getTexte(nomLookAndFeel, theme));

		EcouteurChangementLnf ecouteur = new EcouteurChangementLnf(classeLookAndFeel, theme);

		addActionListener(ecouteur);
	}

	/**
	 * @param nomLookAndFeel
	 * @param theme
	 * @return
	 */
	private static String getTexte(String nomLookAndFeel, MetalTheme theme) {

		String texte;

		if (theme == null) {
			texte = nomLookAndFeel;
		} else {
			texte = theme.getName();
		}

		return texte;
	}
}