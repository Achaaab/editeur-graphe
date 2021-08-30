package com.github.achaaab.graphe.presentation.graphe;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.github.achaaab.graphe.Graphe;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class PanneauFenetre extends JPanel {

	/**
	 * UID genere le 22/06/2010
	 */
	private static final long serialVersionUID = 5738050152988523053L;

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

	private Graphe graphe;

	/**
	 * @param graphe
	 */
	public PanneauFenetre(Graphe graphe) {

		this.graphe = graphe;

		Border bordureExterne = BorderFactory.createTitledBorder(TITRE);
		Border bordureInterne = BorderFactory.createEmptyBorder(5, 5, 5, 5);

		Border bordure = BorderFactory.createCompoundBorder(bordureExterne,
				bordureInterne);

		setBorder(bordure);

		setLayout(new GridBagLayout());

		creerComposants();
		ajouterComposants();
		ajouterEcouteurs();

	}

	/**
	 * 
	 */
	private final void creerComposants() {

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
	 * 
	 */
	public final void actualiser() {

		double xMin = graphe.getXMin();
		double xMax = graphe.getXMax();
		double graduationX = graphe.getGraduationX();

		double yMin = graphe.getYMin();
		double yMax = graphe.getYMax();
		double graduationY = graphe.getGraduationY();

		champXMin.setText(Double.toString(xMin));
		champXMax.setText(Double.toString(xMax));
		champGraduationX.setText(Double.toString(graduationX));

		champYMin.setText(Double.toString(yMin));
		champYMax.setText(Double.toString(yMax));
		champGraduationY.setText(Double.toString(graduationY));

	}

	/**
	 * 
	 */
	private final void ajouterComposants() {

		GridBagConstraints contraintes = new GridBagConstraints();
		contraintes.anchor = GridBagConstraints.LINE_START;

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
	 * 
	 */
	private final void ajouterEcouteurs() {

		champXMin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evenement) {

				double xMin = Double.parseDouble(champXMin.getText());
				graphe.setXMin(xMin);
				graphe.actualiserGraphe();

			}

		});

		champXMax.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evenement) {

				double xMax = Double.parseDouble(champXMax.getText());
				graphe.setXMax(xMax);
				graphe.actualiserGraphe();

			}

		});

		champGraduationX.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evenement) {

				double graduationX = Double.parseDouble(champGraduationX
						.getText());
				graphe.setGraduationX(graduationX);
				graphe.actualiserGraphe();

			}

		});

		champYMin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evenement) {

				double yMin = Double.parseDouble(champYMin.getText());
				graphe.setYMin(yMin);
				graphe.actualiserGraphe();

			}

		});

		champYMax.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evenement) {

				double yMax = Double.parseDouble(champYMax.getText());
				graphe.setYMax(yMax);
				graphe.actualiserGraphe();

			}

		});

		champGraduationY.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evenement) {

				double graduationY = Double.parseDouble(champGraduationY
						.getText());
				graphe.setGraduationY(graduationY);
				graphe.actualiserGraphe();

			}

		});

	}

}