package com.github.achaaab.graphe.presentation.courbe;

import com.github.achaaab.graphe.Graphe;
import com.github.achaaab.graphe.courbe.Courbe;
import com.github.achaaab.utilitaire.swing.PanneauVariable;
import com.github.achaaab.utilitaire.swing.SwingUtilitaire;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Dimension;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class PanneauCourbes extends PanneauVariable {

	private static final Dimension DIMENSION_DEFAUT = new Dimension(512, 320);

	private final Graphe graphe;

	private JComboBox<Courbe<?>> presentationCourbes;
	private JScrollPane panneauCourbeAscenseurs;

	private JPanel panneauBoutons;
	private JButton ajouter;
	private JButton supprimer;

	/**
	 * @param graphe
	 * @since 0.0.0
	 */
	public PanneauCourbes(Graphe graphe) {

		this.graphe = graphe;

		setLayout(new BorderLayout());

		creerComposants();
		ajouterComposants();
		ajouterEcouteurs();

		initialiserListeCourbes();
	}

	/**
	 * @since 0.0.0
	 */
	private void creerComposants() {

		presentationCourbes = new JComboBox<>();
		presentationCourbes.setRenderer(RenduListeCourbes.INSTANCE);

		panneauCourbeAscenseurs = new JScrollPane();
		panneauCourbeAscenseurs.setPreferredSize(DIMENSION_DEFAUT);

		panneauBoutons = new JPanel();
		ajouter = new JButton("Ajouter");
		supprimer = new JButton("Supprimer");
	}

	/**
	 * @since 0.0.0
	 */
	private void ajouterComposants() {

		add(presentationCourbes, NORTH);
		add(panneauCourbeAscenseurs, CENTER);

		panneauBoutons.add(ajouter);
		panneauBoutons.add(supprimer);
		add(panneauBoutons, SOUTH);
	}

	/**
	 * @since 0.0.0
	 */
	private void ajouterEcouteurs() {

		/*
		 * Lors de la sélection d'une courbe dans la liste,
		 * on supprime du conteneur le panneau de la courbe précédemment sélectionnée
		 * et on ajoute le nouveau.
		 */

		presentationCourbes.addActionListener(evenement -> actualiserPanneauCourbe());

		ajouter.addActionListener(evenement -> {

			var presentationNouvelleCourbe = new PresentationNouvelleCourbe(PanneauCourbes.this);

			presentationNouvelleCourbe.setVisible(true);

			var courbe = presentationNouvelleCourbe.getCourbe();

			if (courbe != null) {

				graphe.ajouterCourbe(courbe);
				presentationCourbes.setSelectedItem(courbe);
				graphe.actualiserGraphe();
			}
		});

		supprimer.addActionListener(evenement -> {

			var courbe = presentationCourbes.getItemAt(presentationCourbes.getSelectedIndex());

			if (courbe != null) {
				graphe.supprimerCourbe(courbe);
			}
		});
	}

	/**
	 * @since 0.0.0
	 */
	public void initialiserListeCourbes() {

		var listeCourbes = graphe.getCourbes();
		var courbes = listeCourbes.toArray(new Courbe[0]);

		var modeleCourbes = new DefaultComboBoxModel<Courbe<?>>(courbes);

		presentationCourbes.setModel(modeleCourbes);

		actualiserPanneauCourbe();
	}

	/**
	 * @param courbe
	 * @since 0.0.0
	 */
	public void ajouterCourbe(Courbe<?> courbe) {
		presentationCourbes.addItem(courbe);
	}

	/**
	 * @param courbe
	 * @since 0.0.0
	 */
	public void supprimerCourbe(Courbe<?> courbe) {
		presentationCourbes.removeItem(courbe);
	}

	/**
	 * @since 0.0.0
	 */
	public void actualiserPanneauCourbe() {

		var courbeSelectionnee = presentationCourbes.getItemAt(presentationCourbes.getSelectedIndex());

		if (panneauCourbeAscenseurs != null) {
			remove(panneauCourbeAscenseurs);
		}

		if (courbeSelectionnee != null) {

			var panneauCourbe = courbeSelectionnee.getPresentation();
			panneauCourbe.setGraphe(graphe);

			panneauCourbeAscenseurs = new JScrollPane(panneauCourbe);
			panneauCourbeAscenseurs.setPreferredSize(DIMENSION_DEFAUT);

			add(panneauCourbeAscenseurs, CENTER);
		}

		revalidate();
		repaint();
	}

	/**
	 * @since 0.0.0
	 */
	public void redessinerListeCourbes() {
		presentationCourbes.repaint();
	}
}