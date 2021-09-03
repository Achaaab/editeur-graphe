package com.github.achaaab.graphe.presentation.graphe;

import com.github.achaaab.graphe.Graphe;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import static java.awt.GridBagConstraints.LINE_START;
import static java.lang.Double.parseDouble;
import static javax.swing.BorderFactory.createCompoundBorder;
import static javax.swing.BorderFactory.createEmptyBorder;
import static javax.swing.BorderFactory.createTitledBorder;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class PanneauFenetre extends JPanel {

	private static final String TITRE = "Fenêtre";

	private JLabel labelXMin;
	private JLabel labelXMax;
	private JLabel labelGraduationX;

	private JLabel labelYMin;
	private JLabel labelYMax;
	private JLabel labelGraduationY;

	private JTextField champXMin;
	private JTextField champXMax;
	private JTextField champGraduationX;

	private JTextField champYMin;
	private JTextField champYMax;
	private JTextField champGraduationY;

	private final Graphe graphe;

	/**
	 * @param graphe
	 * @since 0.0.0
	 */
	public PanneauFenetre(Graphe graphe) {

		this.graphe = graphe;

		var bordureExterne = createTitledBorder(TITRE);
		var bordureInterne = createEmptyBorder(5, 5, 5, 5);
		var bordure = createCompoundBorder(bordureExterne, bordureInterne);

		setBorder(bordure);

		setLayout(new GridBagLayout());

		creerComposants();
		ajouterComposants();
		ajouterEcouteurs();
	}

	/**
	 * @since 0.0.0
	 */
	private void creerComposants() {

		labelXMin = new JLabel("X.minimum");
		labelXMax = new JLabel("X.maximum");
		labelGraduationX = new JLabel("X.graduation");

		labelYMin = new JLabel("Y.minimum");
		labelYMax = new JLabel("Y.maximum");
		labelGraduationY = new JLabel("Y.graduation");

		champXMin = new JTextField(15);
		champXMax = new JTextField(15);
		champGraduationX = new JTextField(5);

		champYMin = new JTextField(15);
		champYMax = new JTextField(15);
		champGraduationY = new JTextField(5);

		actualiser();
	}

	/**
	 * @since 0.0.0
	 */
	public void actualiser() {

		var xMin = graphe.getXMin();
		var xMax = graphe.getXMax();
		var graduationX = graphe.getGraduationX();

		var yMin = graphe.getYMin();
		var yMax = graphe.getYMax();
		var graduationY = graphe.getGraduationY();

		champXMin.setText(Double.toString(xMin));
		champXMax.setText(Double.toString(xMax));
		champGraduationX.setText(Double.toString(graduationX));

		champYMin.setText(Double.toString(yMin));
		champYMax.setText(Double.toString(yMax));
		champGraduationY.setText(Double.toString(graduationY));
	}

	/**
	 * @since 0.0.0
	 */
	private void ajouterComposants() {

		var contraintes = new GridBagConstraints();
		contraintes.anchor = LINE_START;

		contraintes.gridx = 0;

		contraintes.gridy = 0;
		add(labelXMin, contraintes);

		contraintes.gridy = 1;
		add(labelXMax, contraintes);

		contraintes.gridy = 2;
		add(labelGraduationX, contraintes);

		contraintes.gridy = 3;
		add(labelYMin, contraintes);

		contraintes.gridy = 4;
		add(labelYMax, contraintes);

		contraintes.gridy = 5;
		add(labelGraduationY, contraintes);

		contraintes.gridx = 1;
		contraintes.insets = new Insets(0, 20, 0, 0);

		contraintes.gridy = 0;
		add(champXMin, contraintes);

		contraintes.gridy = 1;
		add(champXMax, contraintes);

		contraintes.gridy = 2;
		add(champGraduationX, contraintes);

		contraintes.gridy = 3;
		add(champYMin, contraintes);

		contraintes.gridy = 4;
		add(champYMax, contraintes);

		contraintes.gridy = 5;
		add(champGraduationY, contraintes);
	}

	/**
	 * @since 0.0.0
	 */
	private void ajouterEcouteurs() {

		champXMin.addActionListener(evenement -> {

			var xMin = parseDouble(champXMin.getText());
			graphe.setXMin(xMin);
			graphe.actualiserGraphe();
		});

		champXMax.addActionListener(evenement -> {

			var xMax = parseDouble(champXMax.getText());
			graphe.setXMax(xMax);
			graphe.actualiserGraphe();
		});

		champGraduationX.addActionListener(evenement -> {

			var graduationX = parseDouble(champGraduationX.getText());
			graphe.setGraduationX(graduationX);
			graphe.actualiserGraphe();
		});

		champYMin.addActionListener(evenement -> {

			var yMin = parseDouble(champYMin.getText());
			graphe.setYMin(yMin);
			graphe.actualiserGraphe();
		});

		champYMax.addActionListener(evenement -> {

			var yMax = parseDouble(champYMax.getText());
			graphe.setYMax(yMax);
			graphe.actualiserGraphe();
		});

		champGraduationY.addActionListener(evenement -> {

			var graduationY = parseDouble(champGraduationY.getText());
			graphe.setGraduationY(graduationY);
			graphe.actualiserGraphe();
		});
	}
}