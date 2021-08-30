package com.github.achaaab.graphe.presentation.courbe;

import com.github.achaaab.graphe.courbe.Courbe;
import com.github.achaaab.graphe.courbe.TypeCourbe;

import javax.swing.JRadioButton;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class BoutonTypeCourbe extends JRadioButton {

	private TypeCourbe typeCourbe;

	private PresentationNouvelleCourbe presentationNouvelleCourbe;

	/**
	 * @param presentationNouvelleCourbe
	 * @param typeCourbe
	 */
	public BoutonTypeCourbe(
			PresentationNouvelleCourbe presentationNouvelleCourbe,
			TypeCourbe typeCourbe) {

		super(typeCourbe.toString());

		this.presentationNouvelleCourbe = presentationNouvelleCourbe;
		this.typeCourbe = typeCourbe;

		addActionListener(evenement -> selectionner());
	}

	/**
	 *
	 */
	private void selectionner() {
		presentationNouvelleCourbe.setTypeCourbeSelectionne(typeCourbe);
	}

	/**
	 * @return
	 */
	public Courbe getCourbe() {
		return typeCourbe.getCourbeDefaut();
	}
}