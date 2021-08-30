package com.github.achaaab.graphe.presentation.courbe;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.github.achaaab.graphe.courbe.Courbe;
import com.github.achaaab.graphe.courbe.TypeCourbe;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class PresentationNouvelleCourbe extends JDialog {

	/**
	 * UID genere le 24/06/2010
	 */
	private static final long serialVersionUID = -8476276040725610552L;

	private static final String TITRE = "Nouvelle courbe";

	private ButtonGroup typesCourbe;

	private TypeCourbe typeCourbeSelectionne;

	private JLabel explication;

	private BoutonTypeCourbe boutonCourbeCartesienne;
	private BoutonTypeCourbe boutonCourbePolaire;
	private BoutonTypeCourbe boutonCourbeParametrique;

	private JButton creer;
	private JButton annuler;

	private boolean validation;

	/**
	 * 
	 */
	public PresentationNouvelleCourbe(Component composantParent) {

		super(JOptionPane.getFrameForComponent(composantParent), TITRE, true);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		validation = false;

		setLayout(new GridBagLayout());

		creerComposants();
		ajouterComposants();
		ajouterEcouteurs();

		pack();
		setLocationRelativeTo(composantParent);

	}

	/**
	 * 
	 */
	private final void creerComposants() {

		explication = new JLabel("Choisissez le type de courbe :");
		explication.setFont(new Font("Dialog", Font.BOLD, 12));

		explication.setForeground(Color.BLUE);

		typesCourbe = new ButtonGroup();

		boutonCourbeCartesienne = new BoutonTypeCourbe(this,
				TypeCourbe.CARTESIENNE);

		boutonCourbeCartesienne.setSelected(true);
		typeCourbeSelectionne = TypeCourbe.CARTESIENNE;

		boutonCourbePolaire = new BoutonTypeCourbe(this, TypeCourbe.POLAIRE);

		boutonCourbeParametrique = new BoutonTypeCourbe(this,
				TypeCourbe.PARAMETRIQUE);

		creer = new JButton("Créer");
		annuler = new JButton("Annuler");

	}

	/**
	 * 
	 */
	private final void ajouterComposants() {

		GridBagConstraints contraintes = new GridBagConstraints();
		contraintes.anchor = GridBagConstraints.LINE_START;
		Insets espacement = contraintes.insets;

		espacement.left = 5;
		espacement.bottom = 10;
		espacement.top = 10;
		espacement.right = 20;

		contraintes.gridx = 0;
		contraintes.gridy = 0;
		contraintes.gridwidth = 2;
		contraintes.gridheight = 1;
		add(explication, contraintes);

		espacement.left = 20;
		espacement.bottom = 5;
		espacement.top = 5;
		espacement.right = 5;

		contraintes.gridx = 0;
		contraintes.gridy = 1;
		contraintes.gridwidth = 2;
		contraintes.gridheight = 1;
		add(boutonCourbeCartesienne, contraintes);

		contraintes.gridx = 0;
		contraintes.gridy = 2;
		contraintes.gridwidth = 2;
		contraintes.gridheight = 1;
		add(boutonCourbePolaire, contraintes);

		contraintes.gridx = 0;
		contraintes.gridy = 3;
		contraintes.gridwidth = 2;
		contraintes.gridheight = 1;
		add(boutonCourbeParametrique, contraintes);

		espacement.top = 20;
		
		contraintes.gridx = 0;
		contraintes.gridy = 4;
		contraintes.gridwidth = 1;
		contraintes.gridheight = 1;
		add(creer, contraintes);

		contraintes.gridx = 1;
		contraintes.gridy = 4;
		contraintes.gridwidth = 1;
		contraintes.gridheight = 1;
		add(annuler, contraintes);

		typesCourbe.add(boutonCourbeCartesienne);
		typesCourbe.add(boutonCourbePolaire);
		typesCourbe.add(boutonCourbeParametrique);

	}

	/**
	 * 
	 */
	private final void ajouterEcouteurs() {

		creer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evenement) {

				validation = true;
				dispose();

			}

		});

		annuler.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evenement) {
				dispose();
			}

		});

	}

	/**
	 * @param typeCourbeSelectionne
	 *            the typeCourbeSelectionne to set
	 */
	public final void setTypeCourbeSelectionne(TypeCourbe typeCourbeSelectionne) {
		this.typeCourbeSelectionne = typeCourbeSelectionne;
	}

	/**
	 * 
	 * @return
	 */
	public final Courbe getCourbe() {

		Courbe courbe;

		if (validation) {
			courbe = typeCourbeSelectionne.getCourbeDefaut();
		} else {
			courbe = null;
		}

		return courbe;

	}

}