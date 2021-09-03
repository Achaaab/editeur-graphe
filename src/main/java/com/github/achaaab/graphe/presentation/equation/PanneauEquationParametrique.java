package com.github.achaaab.graphe.presentation.equation;

import com.github.achaaab.graphe.equation.EquationParametrique;
import com.github.achaaab.graphe.fonction.fabrique.FabriqueFonction;
import com.github.achaaab.graphe.grammaire.ErreurSyntaxe;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import static com.github.achaaab.utilitaire.GestionnaireException.traiter;
import static java.awt.GridBagConstraints.BOTH;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class PanneauEquationParametrique extends PanneauEquation {

	private final EquationParametrique equationParametrique;

	private JLabel labelF;
	private JTextField champF;

	private JLabel labelG;
	private JTextField champG;

	/**
	 * @param equationParametrique
	 * @since 0.0.0
	 */
	public PanneauEquationParametrique(EquationParametrique equationParametrique) {

		this.equationParametrique = equationParametrique;

		setLayout(new GridBagLayout());

		creerComposants();
		ajouterComposants();
		ajouterEcouteurs();
	}

	/**
	 * @since 0.0.0
	 */
	private void creerComposants() {

		labelF = new JLabel("x = f(t) = ");
		labelG = new JLabel("y = g(t) = ");

		var f = equationParametrique.getF();
		var g = equationParametrique.getG();

		champF = new JTextField(50);
		champF.setText(f.toString());

		champG = new JTextField(50);
		champG.setText(g.toString());
	}

	/**
	 * @since 0.0.0
	 */
	private void ajouterComposants() {

		var contraintes = new GridBagConstraints();
		contraintes.insets = new Insets(2, 2, 2, 2);

		contraintes.gridx = 0;
		contraintes.gridy = 0;
		contraintes.gridwidth = 1;
		contraintes.gridheight = 1;
		add(labelF, contraintes);

		contraintes.gridx = 0;
		contraintes.gridy = 1;
		contraintes.gridwidth = 1;
		contraintes.gridheight = 1;
		add(labelG, contraintes);

		contraintes.fill = BOTH;

		contraintes.gridx = 1;
		contraintes.gridy = 0;
		contraintes.gridwidth = 1;
		contraintes.gridheight = 1;
		add(champF, contraintes);

		contraintes.gridx = 1;
		contraintes.gridy = 1;
		contraintes.gridwidth = 1;
		contraintes.gridheight = 1;
		add(champG, contraintes);
	}

	/**
	 * @since 0.0.0
	 */
	private void ajouterEcouteurs() {

		champF.addActionListener(evenement -> {

			try {

				var texteF = champF.getText();
				var f = FabriqueFonction.INSTANCE.creerFonction(texteF);

				equationParametrique.setF(f);
				graphe.actualiserGraphe();

			} catch (ErreurSyntaxe erreurSyntaxe) {

				traiter(erreurSyntaxe);
			}
		});

		champG.addActionListener(evenement -> {

			try {

				var texteG = champG.getText();
				var g = FabriqueFonction.INSTANCE.creerFonction(texteG);

				equationParametrique.setG(g);
				graphe.actualiserGraphe();

			} catch (ErreurSyntaxe erreurSyntaxe) {

				traiter(erreurSyntaxe);
			}
		});
	}
}