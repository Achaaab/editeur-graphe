package com.github.achaaab.graphe.presentation.courbe;

import com.github.achaaab.graphe.courbe.Courbe;
import com.github.achaaab.graphe.courbe.CourbeCartesienne;
import com.github.achaaab.graphe.courbe.CourbeParametrique;
import com.github.achaaab.graphe.courbe.CourbePolaire;
import com.github.achaaab.graphe.equation.EquationCartesienne;
import com.github.achaaab.graphe.equation.EquationParametrique;
import com.github.achaaab.graphe.equation.EquationPolaire;
import com.github.achaaab.utilitaire.swing.SwingUtilitaire;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.function.Supplier;

import static com.github.achaaab.utilitaire.swing.SwingUtilitaire.scale;
import static java.awt.Color.BLUE;
import static java.awt.Font.BOLD;
import static java.awt.GridBagConstraints.LINE_START;
import static javax.swing.JOptionPane.getFrameForComponent;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class PresentationNouvelleCourbe extends JDialog {

	private static final String TITRE = "Nouvelle courbe";

	private ButtonGroup typesCourbe;
	private Supplier<Courbe<?>> curveSupplier;
	private JLabel explication;
	private BoutonTypeCourbe boutonCourbeCartesienne;
	private BoutonTypeCourbe boutonCourbePolaire;
	private BoutonTypeCourbe boutonCourbeParametrique;
	private JButton creer;
	private JButton annuler;

	private boolean validation;

	/**
	 * @since 0.0.0
	 */
	public PresentationNouvelleCourbe(Component composantParent) {

		super(getFrameForComponent(composantParent), TITRE, true);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		validation = false;

		setLayout(new GridBagLayout());

		creerComposants();
		ajouterComposants();
		ajouterEcouteurs();

		scale(this);
		setLocationRelativeTo(composantParent);
	}

	/**
	 * @since 0.0.0
	 */
	private void creerComposants() {

		explication = new JLabel("Choisissez le type de courbe :");
		explication.setFont(new Font("Dialog", BOLD, 12));

		explication.setForeground(BLUE);

		typesCourbe = new ButtonGroup();

		boutonCourbeCartesienne = new BoutonTypeCourbe(this, EquationCartesienne.TYPE, CourbeCartesienne::new);
		boutonCourbePolaire = new BoutonTypeCourbe(this, EquationPolaire.TYPE, CourbePolaire::new);
		boutonCourbeParametrique = new BoutonTypeCourbe(this, EquationParametrique.TYPE, CourbeParametrique::new);

		boutonCourbeCartesienne.setSelected(true);
		curveSupplier = CourbeCartesienne::new;

		creer = new JButton("Créer");
		annuler = new JButton("Annuler");
	}

	/**
	 * @since 0.0.0
	 */
	private void ajouterComposants() {

		var contraintes = new GridBagConstraints();
		contraintes.anchor = LINE_START;
		var espacement = contraintes.insets;

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
	 * @since 0.0.0
	 */
	private void ajouterEcouteurs() {

		creer.addActionListener(evenement -> {

			validation = true;
			dispose();
		});

		annuler.addActionListener(evenement -> dispose());
	}

	/**
	 * @param curveSupplier
	 * @since 0.0.0
	 */
	public void setCurveSupplier(Supplier<Courbe<?>> curveSupplier) {
		this.curveSupplier = curveSupplier;
	}

	/**
	 * @return
	 * @since 0.0.0
	 */
	public Courbe<?> getCourbe() {

		return validation ?
				curveSupplier.get() :
				null;
	}
}