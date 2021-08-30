package com.github.achaaab.graphe.application;

import com.github.achaaab.graphe.Graphe;
import com.github.achaaab.utilitaire.GestionnaireException;
import com.github.achaaab.utilitaire.apparence.LookAndFeelUtilitaire;
import com.github.achaaab.utilitaire.swing.FenetreApplication;

/**
 * lancement de l'application en mode fenetre : edition et visualisation de
 * courbes sur un graphe
 * 
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class EditeurGraphe {

	/**
	 * @param arguments aucun
	 */
	public static void main(String... arguments) {

		try {
			LookAndFeelUtilitaire.setLookAndFeelParNom("Nimbus");
		} catch (Exception erreur) {
			GestionnaireException.traiter(erreur);
		}

		Graphe graphe = new Graphe();
		new FenetreApplication(graphe.getPresentation());
	}
}