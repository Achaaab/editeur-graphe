package com.github.achaaab.graphe.presentation.courbe;

import com.github.achaaab.graphe.Graphe;
import com.github.achaaab.graphe.courbe.Courbe;
import com.github.achaaab.graphe.presentation.equation.PanneauEquation;
import com.github.achaaab.utilitaire.couleur.choix.ChoixCouleur;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import static java.awt.Color.BLUE;
import static javax.swing.BorderFactory.createTitledBorder;

/**
 * panneau de parametrage d'une courbe
 *
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public abstract class PanneauCourbe extends JPanel {

	private static final String TITRE = "Propriétés de la courbe";
	private static final String TITRE_PARAMETRES_GENERAUX = "Paramètres généraux";
	private static final String TITRE_DOMAINE = "Domaine";
	private static final String TITRE_FONCTION = "Fonction";

	private static final Color COULEUR_LABELS = BLUE;

	private static final ChoixCouleur CHOIX_COULEUR_COURBE = new ChoixCouleur();

	private JPanel panneauParametresGeneraux;
	private JPanel panneauDomaine;
	private JPanel panneauFonctionEncadre;

	private JLabel labelNom;
	private JTextField champNom;

	private JLabel labelType;
	private JLabel champType;

	private JLabel labelCouleur;
	private JButton champCouleur;

	private JLabel labelMin;
	private JTextField champMin;

	private JLabel labelMax;
	private JTextField champMax;

	private JLabel labelPas;
	private JTextField champPas;

	private JLabel labelInterpolee;
	private JCheckBox champInterpolee;

	protected PanneauEquation panneauEquation;

	private Graphe graphe;
	private final Courbe courbe;

	/**
	 * @param courbe
	 */
	public PanneauCourbe(Courbe courbe) {

		this.courbe = courbe;

		var bordure = createTitledBorder(TITRE);

		setBorder(bordure);

		setLayout(new GridBagLayout());

		creerComposants();
		ajouterEcouteurs();

	}

	/**
	 *
	 */
	private void creerComposants() {

		// parametres generaux

		labelNom = new JLabel("Nom : ");
		labelNom.setForeground(COULEUR_LABELS);
		String nom = courbe.getNom();
		champNom = new JTextField(20);
		champNom.setText(nom);

		labelType = new JLabel("Type : ");
		labelType.setForeground(COULEUR_LABELS);
		String type = courbe.getType().toString();
		champType = new JLabel(type);

		labelCouleur = new JLabel("Couleur : ");
		labelCouleur.setForeground(COULEUR_LABELS);
		champCouleur = new JButton();
		Dimension tailleBouton = new Dimension(80, 20);
		champCouleur.setPreferredSize(tailleBouton);
		champCouleur.setMinimumSize(tailleBouton);

		actualiserCouleurCourbe();

		panneauParametresGeneraux = new JPanel();
		panneauParametresGeneraux.setLayout(new GridBagLayout());
		panneauParametresGeneraux.setBorder(createTitledBorder(TITRE_PARAMETRES_GENERAUX));

		/*
		 * domaine
		 */

		double min = courbe.getMin();
		labelMin = new JLabel("Minimum : ");
		labelMin.setForeground(COULEUR_LABELS);
		champMin = new JTextField(15);
		champMin.setText(Double.toString(min));

		double max = courbe.getMax();
		labelMax = new JLabel("Maximum : ");
		labelMax.setForeground(COULEUR_LABELS);
		champMax = new JTextField(15);
		champMax.setText(Double.toString(max));

		double pas = courbe.getPas();
		labelPas = new JLabel("Pas : ");
		labelPas.setForeground(COULEUR_LABELS);
		champPas = new JTextField(10);
		champPas.setText(Double.toString(pas));

		boolean interpolee = courbe.isInterpolee();
		labelInterpolee = new JLabel("Interpolation : ");
		labelInterpolee.setForeground(COULEUR_LABELS);
		champInterpolee = new JCheckBox();
		champInterpolee.setSelected(interpolee);

		panneauDomaine = new JPanel();
		panneauDomaine.setLayout(new GridBagLayout());
		panneauDomaine.setBorder(createTitledBorder(TITRE_DOMAINE));

		/*
		 * fonction
		 */

		panneauFonctionEncadre = new JPanel();
		panneauFonctionEncadre.setLayout(new BorderLayout());
		Border bordurePanneauFonction = createTitledBorder(TITRE_FONCTION);
		panneauFonctionEncadre.setBorder(bordurePanneauFonction);
	}

	/**
	 *
	 */
	protected void ajouterComposants() {

		GridBagConstraints contraintes = new GridBagConstraints();

		contraintes.anchor = GridBagConstraints.LINE_START;
		contraintes.insets = new Insets(2, 2, 2, 2);

		/*
		 * parametres generaux
		 */

		contraintes.gridx = 0;
		contraintes.gridy = 0;
		contraintes.gridwidth = 1;
		contraintes.gridheight = 1;
		panneauParametresGeneraux.add(labelNom, contraintes);

		contraintes.gridx = 1;
		contraintes.gridy = 0;
		contraintes.gridwidth = 1;
		contraintes.gridheight = 1;
		panneauParametresGeneraux.add(champNom, contraintes);

		contraintes.gridx = 0;
		contraintes.gridy = 1;
		contraintes.gridwidth = 1;
		contraintes.gridheight = 1;
		panneauParametresGeneraux.add(labelType, contraintes);

		contraintes.gridx = 1;
		contraintes.gridy = 1;
		contraintes.gridwidth = 1;
		contraintes.gridheight = 1;
		panneauParametresGeneraux.add(champType, contraintes);

		contraintes.gridx = 0;
		contraintes.gridy = 2;
		contraintes.gridwidth = 1;
		contraintes.gridheight = 1;
		panneauParametresGeneraux.add(labelCouleur, contraintes);

		contraintes.gridx = 1;
		contraintes.gridy = 2;
		contraintes.gridwidth = 1;
		contraintes.gridheight = 1;
		panneauParametresGeneraux.add(champCouleur, contraintes);

		/*
		 * domaine
		 */

		contraintes.gridx = 0;
		contraintes.gridy = 0;
		contraintes.gridwidth = 1;
		contraintes.gridheight = 1;
		panneauDomaine.add(labelMin, contraintes);

		contraintes.gridx = 1;
		contraintes.gridy = 0;
		contraintes.gridwidth = 1;
		contraintes.gridheight = 1;
		panneauDomaine.add(champMin, contraintes);

		contraintes.gridx = 0;
		contraintes.gridy = 1;
		contraintes.gridwidth = 1;
		contraintes.gridheight = 1;
		panneauDomaine.add(labelMax, contraintes);

		contraintes.gridx = 1;
		contraintes.gridy = 1;
		contraintes.gridwidth = 1;
		contraintes.gridheight = 1;
		panneauDomaine.add(champMax, contraintes);

		contraintes.gridx = 0;
		contraintes.gridy = 2;
		contraintes.gridwidth = 1;
		contraintes.gridheight = 1;
		panneauDomaine.add(labelPas, contraintes);

		contraintes.gridx = 1;
		contraintes.gridy = 2;
		contraintes.gridwidth = 1;
		contraintes.gridheight = 1;
		panneauDomaine.add(champPas, contraintes);

		contraintes.gridx = 0;
		contraintes.gridy = 3;
		contraintes.gridwidth = 1;
		contraintes.gridheight = 1;
		panneauDomaine.add(labelInterpolee, contraintes);

		contraintes.gridx = 1;
		contraintes.gridy = 3;
		contraintes.gridwidth = 1;
		contraintes.gridheight = 1;
		panneauDomaine.add(champInterpolee, contraintes);

		/*
		 * fonction
		 */

		panneauFonctionEncadre.add(panneauEquation, BorderLayout.CENTER);

		/*
		 * panneaux
		 */

		contraintes.gridx = 0;
		contraintes.gridy = 0;
		contraintes.gridwidth = 1;
		contraintes.gridheight = 1;
		add(panneauParametresGeneraux, contraintes);

		contraintes.gridx = 1;
		contraintes.gridy = 0;
		contraintes.gridwidth = 1;
		contraintes.gridheight = 1;
		add(panneauDomaine, contraintes);

		contraintes.gridx = 0;
		contraintes.gridy = 1;
		contraintes.gridwidth = 2;
		contraintes.gridheight = 1;
		contraintes.fill = GridBagConstraints.BOTH;
		add(panneauFonctionEncadre, contraintes);

	}

	/**
	 *
	 */
	private void ajouterEcouteurs() {

		champCouleur.addActionListener(evenement -> {

			Color couleurCourbe = courbe.getCouleur();

			try {

				couleurCourbe = CHOIX_COULEUR_COURBE.ouvrirDialogue(
						PanneauCourbe.this, couleurCourbe);

			} catch (InterruptedException erreur) {

			}

			courbe.setCouleur(couleurCourbe);
			graphe.actualiserGraphe();

		});

		champNom.addActionListener(evenement -> {

			String nom = champNom.getText();
			courbe.setNom(nom);
			graphe.actualiserListeCourbes();
		});

		champMin.addActionListener(evenement -> {

			double min = Double.parseDouble(champMin.getText());
			courbe.setMin(min);
			graphe.actualiserGraphe();
		});

		champMax.addActionListener(evenement -> {

			double max = Double.parseDouble(champMax.getText());
			courbe.setMax(max);
			graphe.actualiserGraphe();
		});

		champPas.addActionListener(evenement -> {

			double pas = Double.parseDouble(champPas.getText());
			courbe.setPas(pas);
			graphe.actualiserGraphe();
		});

		champInterpolee.addChangeListener(evenement -> {

			boolean interpolee = champInterpolee.isSelected();
			courbe.setInterpolee(interpolee);
			graphe.actualiserGraphe();
		});
	}

	/**
	 *
	 */
	public void actualiserCouleurCourbe() {

		Color couleurCourbe = courbe.getCouleur();
		champCouleur.setBackground(couleurCourbe);
	}

	/**
	 * @param graphe the graphe to set
	 */
	public void setGraphe(Graphe graphe) {

		this.graphe = graphe;

		panneauEquation.setGraphe(graphe);
	}
}