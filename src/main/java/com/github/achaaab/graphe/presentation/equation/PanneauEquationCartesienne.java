package com.github.achaaab.graphe.presentation.equation;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.github.achaaab.graphe.equation.EquationCartesienne;
import com.github.achaaab.graphe.fonction.Fonction;
import com.github.achaaab.graphe.fonction.fabrique.FabriqueFonction;
import com.github.achaaab.graphe.grammaire.ErreurSyntaxe;

import static com.github.achaaab.utilitaire.GestionnaireException.traiter;
import static java.awt.GridBagConstraints.BOTH;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class PanneauEquationCartesienne extends PanneauEquation {

	private final EquationCartesienne equationCartesienne;

	private JLabel labelF;
	private JTextField champF;

	/**
	 * @param equationCartesienne
	 * @since 0.0.0
	 */
	public PanneauEquationCartesienne(EquationCartesienne equationCartesienne) {

		this.equationCartesienne = equationCartesienne;

		setLayout(new GridBagLayout());

		creerComposants();
		ajouterComposants();
		ajouterEcouteurs();
	}

	/**
	 * @since 0.0.0
	 */
	private void creerComposants() {

		labelF = new JLabel("y = f(x) = ");

		var f = equationCartesienne.getF();

		champF = new JTextField(50);
		champF.setText(f.toString());
	}

	/**
	 * @øince 0.0.0
	 */
	private void ajouterComposants() {

		var contraintes = new GridBagConstraints();
		contraintes.insets = new Insets(2, 2, 2, 2);
		
		contraintes.gridx = 0;
		contraintes.gridy = 0;
		contraintes.gridwidth = 1;
		contraintes.gridheight = 1;
		add(labelF, contraintes);

		contraintes.fill = BOTH;

		contraintes.gridx = 1;
		contraintes.gridy = 0;
		contraintes.gridwidth = 1;
		contraintes.gridheight = 1;
		add(champF, contraintes);
	}

	/**
	 * @since 0.0.0
	 */
	private void ajouterEcouteurs() {

		champF.addActionListener(evenement -> {

			try {

				var texteF = champF.getText();

				var f = FabriqueFonction.INSTANCE.creerFonction(texteF);

				equationCartesienne.setF(f);
				graphe.actualiserGraphe();

			} catch (ErreurSyntaxe erreurSyntaxe) {

				traiter(erreurSyntaxe);
			}
		});
	}
}