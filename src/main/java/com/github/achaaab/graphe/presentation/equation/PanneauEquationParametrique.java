package com.github.achaaab.graphe.presentation.equation;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.github.achaaab.graphe.equation.EquationParametrique;
import com.github.achaaab.graphe.fonction.Fonction;
import com.github.achaaab.graphe.fonction.fabrique.FabriqueFonction;
import com.github.achaaab.graphe.grammaire.ErreurSyntaxe;
import com.github.achaaab.utilitaire.GestionnaireException;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class PanneauEquationParametrique extends PanneauEquation {

	/**
	 * UID genere le 24/06/2010
	 */
	private static final long serialVersionUID = 4114829001282179153L;

	private JLabel labelF;
	private JTextField champF;

	private JLabel labelG;
	private JTextField champG;

	private EquationParametrique equationParametrique;

	/**
	 * 
	 * @param equationParametrique
	 */
	public PanneauEquationParametrique(EquationParametrique equationParametrique) {

		this.equationParametrique = equationParametrique;

		setLayout(new GridBagLayout());

		creerComposants();
		ajouterComposants();
		ajouterEcouteurs();

	}

	/**
	 * 
	 */
	private final void creerComposants() {

		labelF = new JLabel("x = f(t) = ");
		labelG = new JLabel("y = g(t) = ");

		Fonction f = equationParametrique.getF();
		Fonction g = equationParametrique.getG();

		champF = new JTextField(50);
		champF.setText(f.getTexte());

		champG = new JTextField(50);
		champG.setText(g.getTexte());

	}

	/**
	 * 
	 */
	private final void ajouterComposants() {

		GridBagConstraints contraintes = new GridBagConstraints();
		contraintes.insets = new Insets(2, 2, 2, 2);
		
		contraintes.gridx = 0;
		contraintes.gridy = 0;
		contraintes.gridwidth = 1;
		contraintes.gridheight = 1;
		add(labelF, contraintes);

		contraintes.gridx = 1;
		contraintes.gridy = 0;
		contraintes.gridwidth = 1;
		contraintes.gridheight = 1;
		add(champF, contraintes);

		contraintes.gridx = 0;
		contraintes.gridy = 1;
		contraintes.gridwidth = 1;
		contraintes.gridheight = 1;
		add(labelG, contraintes);

		contraintes.gridx = 1;
		contraintes.gridy = 1;
		contraintes.gridwidth = 1;
		contraintes.gridheight = 1;
		add(champG, contraintes);

	}

	/**
	 * 
	 */
	private final void ajouterEcouteurs() {

		champF.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evenement) {

				try {

					String texteF = champF.getText();

					Fonction f = FabriqueFonction.getInstance().creerFonction(
							texteF);

					equationParametrique.setF(f);
					graphe.actualiserGraphe();

				} catch (ErreurSyntaxe erreurSyntaxe) {

					GestionnaireException.traiter(erreurSyntaxe);

				}

			}

		});

		champG.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evenement) {

				try {

					String texteG = champG.getText();

					Fonction g = FabriqueFonction.getInstance().creerFonction(
							texteG);

					equationParametrique.setG(g);
					graphe.actualiserGraphe();

				} catch (ErreurSyntaxe erreurSyntaxe) {

					GestionnaireException.traiter(erreurSyntaxe);

				}

			}

		});

	}

}