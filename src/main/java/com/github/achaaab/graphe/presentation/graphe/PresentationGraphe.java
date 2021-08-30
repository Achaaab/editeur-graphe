package com.github.achaaab.graphe.presentation.graphe;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import com.github.achaaab.graphe.Graphe;
import com.github.achaaab.graphe.courbe.Courbe;
import com.github.achaaab.graphe.presentation.courbe.PanneauCourbes;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class PresentationGraphe extends JSplitPane {

	/**
	 * UID genere le 17/06/2010
	 */
	private static final long serialVersionUID = -6375669030883272767L;

	private JSplitPane panneauHaut;
	private JPanel panneauGauche;

	private PanneauGraphe panneauGraphe;
	private JScrollPane panneauGrapheAscenseurs;

	private PanneauCoordonnees panneauCoordonnees;

	private PanneauFenetre panneauFenetre;
	private JScrollPane panneauFenetreAscenseurs;

	private PanneauCourbes panneauCourbes;

	private Graphe graphe;

	/**
	 * @param graphe
	 */
	public PresentationGraphe(Graphe graphe) {

		super(VERTICAL_SPLIT);

		this.graphe = graphe;

		setOneTouchExpandable(true);
		setContinuousLayout(true);

		creerComposants();
		ajouterComposants();

	}

	/**
	 * 
	 */
	private final void creerComposants() {

		panneauHaut = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		panneauHaut.setOneTouchExpandable(true);
		panneauHaut.setContinuousLayout(true);

		panneauGauche = new JPanel();
		panneauGauche.setLayout(new BorderLayout());

		panneauCoordonnees = new PanneauCoordonnees();

		panneauGraphe = new PanneauGraphe(graphe, panneauCoordonnees);
		panneauGrapheAscenseurs = new JScrollPane(panneauGraphe);

		panneauFenetre = new PanneauFenetre(graphe);
		panneauFenetreAscenseurs = new JScrollPane(panneauFenetre);

		panneauCourbes = new PanneauCourbes(graphe);

		panneauGauche.setMinimumSize(new Dimension(0, 0));
		panneauFenetre.setMinimumSize(new Dimension(0, 0));
		panneauCourbes.setMinimumSize(new Dimension(0, 0));

	}

	/**
	 * 
	 */
	private final void ajouterComposants() {

		panneauGauche.add(panneauGrapheAscenseurs, BorderLayout.CENTER);
		panneauGauche.add(panneauCoordonnees, BorderLayout.SOUTH);

		panneauHaut.setLeftComponent(panneauGauche);
		panneauHaut.setRightComponent(panneauFenetreAscenseurs);

		setLeftComponent(panneauHaut);
		setRightComponent(panneauCourbes);

	}

	/**
	 * 
	 */
	public final void actualiserFenetre() {
		panneauFenetre.actualiser();
	}

	/**
	 * 
	 */
	public final void actualiserGraphe() {
		panneauGraphe.recalculerImage();
	}

	/**
	 * 
	 * @param courbe
	 */
	public final void ajouterCourbe(Courbe courbe) {
		panneauCourbes.ajouterCourbe(courbe);
	}

	/**
	 * 
	 * @param courbe
	 */
	public final void supprimerCourbe(Courbe courbe) {
		panneauCourbes.supprimerCourbe(courbe);
	}

	/**
	 * 
	 */
	public final void actualiserListeCourbes() {
		panneauCourbes.redessinerListeCourbes();
	}

}