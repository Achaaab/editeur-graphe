package com.github.achaaab.graphe.presentation.graphe;

import com.github.achaaab.utilitaire.swing.LabelComposant;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;

import static java.awt.Color.DARK_GRAY;
import static javax.swing.BorderFactory.createEmptyBorder;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class PanneauCoordonnees extends JPanel {

	private JLabel x;
	private JLabel y;

	/**
	 * @since 0.0.0
	 */
	public PanneauCoordonnees() {

		setBorder(createEmptyBorder(5, 5, 5, 5));

		setLayout(new GridLayout(1, 2));

		x = new JLabel();
		y = new JLabel();

		var panneauX = new LabelComposant("x = ", x);
		var panneauY = new LabelComposant("y = ", y);

		panneauX.setForeground(DARK_GRAY);
		panneauY.setForeground(DARK_GRAY);

		add(panneauX);
		add(panneauY);
	}

	/**
	 * @param x
	 * @since 0.0.0
	 */
	public void setX(double x) {
		this.x.setText(Double.toString(x));
	}

	/**
	 * @param y
	 * @since 0.0.0
	 */
	public void setY(double y) {
		this.y.setText(Double.toString(y));
	}
}