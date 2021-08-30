package com.github.achaaab.graphe.presentation.graphe;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.github.achaaab.utilitaire.swing.LabelComposant;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class PanneauCoordonnees extends JPanel {

	/**
	 * UID genere le 17/06/2010
	 */
	private static final long serialVersionUID = 4278541600064327067L;

	private JLabel x;
	private JLabel y;

	/**
	 * 
	 */
	public PanneauCoordonnees() {

		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		setLayout(new GridLayout(1, 2));

		x = new JLabel();
		y = new JLabel();

		LabelComposant panneauX = new LabelComposant("x = ", x);
		LabelComposant panneauY = new LabelComposant("y = ", y);

		panneauX.setForeground(Color.DARK_GRAY);
		panneauY.setForeground(Color.DARK_GRAY);

		add(panneauX);
		add(panneauY);

	}

	/**
	 * 
	 * @param x
	 */
	public void setX(double x) {
		this.x.setText(Double.toString(x));
	}

	/**
	 * 
	 * @param y
	 */
	public void setY(double y) {
		this.y.setText(Double.toString(y));
	}

}