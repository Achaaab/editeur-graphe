package com.github.achaaab.graphe.presentation.courbe;

import com.github.achaaab.graphe.courbe.Courbe;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import java.awt.Component;
import java.awt.Dimension;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class RenduListeCourbes implements ListCellRenderer<Courbe<?>> {

	public static final RenduListeCourbes INSTANCE = new RenduListeCourbes();

	private static final DefaultListCellRenderer RENDU_DEFAUT = new DefaultListCellRenderer();

	/**
	 * la largeur est donnee par la liste contenant la cellule
	 */
	private static final Dimension DIMENSION_OPTIMALE = new Dimension(0, 20);

	/**
	 * constructeur privé pour appliquer le patron de conception Singleton
	 *
	 * @since 0.0.0
	 */
	private RenduListeCourbes() {

	}

	@Override
	public Component getListCellRendererComponent(
			JList<? extends Courbe<?>> courbes, Courbe<?> courbe, int indexCourbe,
			boolean courbeSelectionnee, boolean focus) {

		var cellule = (JLabel) RENDU_DEFAUT.getListCellRendererComponent(
				courbes, courbe, indexCourbe, courbeSelectionnee, focus);

		if (courbe != null) {

			cellule.setForeground(courbe.getCouleur());
			cellule.setPreferredSize(DIMENSION_OPTIMALE);
		}

		return cellule;
	}
}