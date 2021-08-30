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

	/**
	 * UID genere le 23/06/2010
	 */
	private static final long serialVersionUID = 7162369836022667540L;

	private static final Dimension DIMENSION_PANNEAU_COURBE = new Dimension(
			512, 320);

	private JComboBox presentationCourbes;
	private PanneauCourbe panneauCourbe;
	private JScrollPane panneauCourbeAscenseurs;

	private JPanel panneauBoutons;
	private JButton ajouter;
	private JButton supprimer;

	private Graphe graphe;

	/**
	 * @param graphe
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
	private final void creerComposants() {

		presentationCourbes = new JComboBox();
		presentationCourbes.setRenderer(RenduListeCourbes.getInstance());

		panneauCourbeAscenseurs = new JScrollPane();
		panneauCourbeAscenseurs.setPreferredSize(DIMENSION_PANNEAU_COURBE);

		panneauBoutons = new JPanel();
		ajouter = new JButton("Ajouter");
		supprimer = new JButton("Supprimer");

	}

	/**
	 * 
	 */
	private final void ajouterComposants() {

		add(presentationCourbes, BorderLayout.NORTH);

		add(panneauCourbeAscenseurs, BorderLayout.CENTER);

		panneauBoutons.add(ajouter);
		panneauBoutons.add(supprimer);
		add(panneauBoutons, BorderLayout.SOUTH);

	}

	/**
	 * 
	 */
	private final void ajouterEcouteurs() {

		/*
		 * lors de la selection d'une courbe dans la combo box, on supprime du
		 * conteneur le panneau de la courbe precedemment selectionnee, et on
		 * ajoute le nouveau
		 */

		presentationCourbes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evenement) {
				actualiserPanneauCourbe();
			}

		});

		ajouter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evenement) {

				PresentationNouvelleCourbe presentationNouvelleCourbe = new PresentationNouvelleCourbe(
						PanneauCourbes.this);

				presentationNouvelleCourbe.setVisible(true);

				Courbe courbe = presentationNouvelleCourbe.getCourbe();

				if (courbe != null) {

					graphe.ajouterCourbe(courbe);
					presentationCourbes.setSelectedItem(courbe);
					graphe.actualiserGraphe();

				}

			}

		});

		supprimer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evenement) {

				Courbe courbe = (Courbe) presentationCourbes.getSelectedItem();

				if (courbe != null) {
					graphe.supprimerCourbe(courbe);
				}

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

		ComboBoxModel modeleCourbes = new DefaultComboBoxModel(courbes);

		presentationCourbes.setModel(modeleCourbes);

		actualiserPanneauCourbe();

	}

	/**
	 * 
	 * @param courbe
	 */
	public final void ajouterCourbe(Courbe courbe) {
		presentationCourbes.addItem(courbe);
	}

	/**
	 * 
	 * @param courbe
	 */
	public final void supprimerCourbe(Courbe courbe) {
		presentationCourbes.removeItem(courbe);
	}

	/**
	 * 
	 */
	public final void actualiserPanneauCourbe() {

		Courbe courbeSelectionnee = (Courbe) presentationCourbes
				.getSelectedItem();

		if (panneauCourbeAscenseurs != null) {
			remove(panneauCourbeAscenseurs);
		}

		if (courbeSelectionnee != null) {

			panneauCourbe = courbeSelectionnee.getPresentation();
			panneauCourbe.setGraphe(graphe);

			panneauCourbeAscenseurs = new JScrollPane(panneauCourbe);
			panneauCourbeAscenseurs.setPreferredSize(DIMENSION_PANNEAU_COURBE);

			add(panneauCourbeAscenseurs, BorderLayout.CENTER);

		}

		revalidate();
		repaint();

	}

	/**
	 * 
	 */
	public final void redessinerListeCourbes() {
		presentationCourbes.repaint();
	}

}