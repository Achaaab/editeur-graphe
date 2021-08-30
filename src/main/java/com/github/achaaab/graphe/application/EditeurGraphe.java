package com.github.achaaab.graphe.application;

import com.github.achaaab.graphe.Graphe;
import com.github.achaaab.utilitaire.swing.FenetreApplication;

import static com.github.achaaab.utilitaire.GestionnaireException.traiter;
import static com.github.achaaab.utilitaire.apparence.LookAndFeelUtilitaire.setLookAndFeelParNom;

/**
 * lancement de l'application en mode fenêtré : édition et visualisation de courbes sur un graphe
 *
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class EditeurGraphe {

	/**
	 * @param arguments aucun
	 * @since 0.0.0
	 */
	public static void main(String... arguments) {

		try {
			setLookAndFeelParNom("Nimbus");
		} catch (Exception erreur) {
			traiter(erreur);
		}

		var graphe = new Graphe();
		var presentation = graphe.getPresentation();
		new FenetreApplication(presentation);
	}
}