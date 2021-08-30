package com.github.achaaab.graphe.presentation.courbe;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.github.achaaab.graphe.Graphe;
import com.github.achaaab.graphe.courbe.Courbe;
import com.github.achaaab.utilitaire.swing.PanneauVariable;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class PanneauCourbes extends PanneauVariable {

	private static final Dimension DIMENSION_DEFAUT = new Dimension(512, 320);

	private final Graphe graphe;

	private JComboBox<Courbe> presentationCourbes;
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
	}

	/**
	 * 
	 */
	private void creerComposants() {

		presentationCourbes = new JComboBox<>();
		presentationCourbes.setRenderer(RenduListeCourbes.getInstance());

		panneauCourbeAscenseurs = new JScrollPane();
		panneauCourbeAscenseurs.setPreferredSize(DIMENSION_DEFAUT);

		panneauBoutons = new JPanel();
		ajouter = new JButton("Ajouter");
		supprimer = new JButton("Supprimer");
	}

	/**
	 * 
	 */
	private void ajouterComposants() {

		add(presentationCourbes, BorderLayout.NORTH);

		add(panneauCourbeAscenseurs, BorderLayout.CENTER);

		panneauBoutons.add(ajouter);
		panneauBoutons.add(supprimer);
		add(panneauBoutons, BorderLayout.SOUTH);
	}

	/**
	 * 
	 */
	private void ajouterEcouteurs() {

		/*
		 * lors de la selection d'une courbe dans la combo box, on supprime du
		 * conteneur le panneau de la courbe precedemment selectionnee, et on
		 * ajoute le nouveau
		 */

		presentationCourbes.addActionListener(evenement -> actualiserPanneauCourbe());

		ajouter.addActionListener(evenement -> {

			PresentationNouvelleCourbe presentationNouvelleCourbe = new PresentationNouvelleCourbe(
					PanneauCourbes.this);

			presentationNouvelleCourbe.setVisible(true);

			Courbe courbe = presentationNouvelleCourbe.getCourbe();

			if (courbe != null) {

				graphe.ajouterCourbe(courbe);
				presentationCourbes.setSelectedItem(courbe);
				graphe.actualiserGraphe();
			}
		});

		supprimer.addActionListener(evenement -> {

			Courbe courbe = (Courbe) presentationCourbes.getSelectedItem();

			if (courbe != null) {
				graphe.supprimerCourbe(courbe);
			}
		});
	}

	/**
	 * 
	 */
	public final void initialiserListeCourbes() {

		List<Courbe> listeCourbes = graphe.getCourbes();
		int nombreCourbes = listeCourbes.size();
		Courbe[] courbes = new Courbe[nombreCourbes];
		listeCourbes.toArray(courbes);

		var modeleCourbes = new DefaultComboBoxModel<>(courbes);

		presentationCourbes.setModel(modeleCourbes);

		actualiserPanneauCourbe();
	}

	/**
	 * 
	 * @param courbe
	 */
	public void ajouterCourbe(Courbe courbe) {
		presentationCourbes.addItem(courbe);
	}

	/**
	 * 
	 * @param courbe
	 */
	public void supprimerCourbe(Courbe courbe) {
		presentationCourbes.removeItem(courbe);
	}

	/**
	 * 
	 */
	public void actualiserPanneauCourbe() {

		Courbe courbeSelectionnee = (Courbe) presentationCourbes.getSelectedItem();

		if (panneauCourbeAscenseurs != null) {
			remove(panneauCourbeAscenseurs);
		}

		if (courbeSelectionnee != null) {

			PanneauCourbe panneauCourbe = courbeSelectionnee.getPresentation();
			panneauCourbe.setGraphe(graphe);

			panneauCourbeAscenseurs = new JScrollPane(panneauCourbe);
			panneauCourbeAscenseurs.setPreferredSize(DIMENSION_DEFAUT);

			add(panneauCourbeAscenseurs, BorderLayout.CENTER);
		}

		revalidate();
		repaint();
	}

	/**
	 * 
	 */
	public void redessinerListeCourbes() {
		presentationCourbes.repaint();
	}
}