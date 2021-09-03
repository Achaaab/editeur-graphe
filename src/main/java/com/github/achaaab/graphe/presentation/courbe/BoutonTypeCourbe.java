package com.github.achaaab.graphe.presentation.courbe;

import com.github.achaaab.graphe.courbe.Courbe;

import javax.swing.JRadioButton;
import java.util.function.Supplier;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class BoutonTypeCourbe extends JRadioButton {

	private final PresentationNouvelleCourbe presentationNouvelleCourbe;
	private final Supplier<Courbe<?>> curveSupplier;

	/**
	 * @param presentationNouvelleCourbe
	 * @param type
	 * @param curveSupplier
	 * @since 0.0.0
	 */
	public BoutonTypeCourbe(PresentationNouvelleCourbe presentationNouvelleCourbe, String type,
			Supplier<Courbe<?>> curveSupplier) {

		super(type);

		this.presentationNouvelleCourbe = presentationNouvelleCourbe;
		this.curveSupplier = curveSupplier;

		addActionListener(evenement -> selectionner());
	}

	/**
	 * @since 0.0.0
	 */
	private void selectionner() {
		presentationNouvelleCourbe.setCurveSupplier(curveSupplier);
	}
}