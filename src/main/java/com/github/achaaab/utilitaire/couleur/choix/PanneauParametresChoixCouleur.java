package com.github.achaaab.utilitaire.couleur.choix;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.github.achaaab.utilitaire.swing.LabelComposant;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class PanneauParametresChoixCouleur extends JPanel {

	/**
	 * UID genere le 18/06/2010
	 */
	private static final long serialVersionUID = 4169063118579845523L;

	private static final String TITRE = "Param�tres";

	private static final String LIBELLE_ESPACE_COLORIMETRIQUE = "Espace colorim�trique : ";

	private ChoixCouleur choixCouleur;

	private JComboBox espaceColorimetrique;
	private LabelComposant panneauEspaceColorimetrique;

	/**
	 * @param choixCouleur
	 */
	public PanneauParametresChoixCouleur(ChoixCouleur choixCouleur) {

		this.choixCouleur = choixCouleur;

		Border bordInterne = BorderFactory.createEmptyBorder(8, 8, 8, 8);
		Border bordExterne = BorderFactory.createTitledBorder(TITRE);

		Border bord = BorderFactory.createCompoundBorder(bordExterne,
				bordInterne);

		setBorder(bord);

		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		creerComposants();
		ajouterComposants();
		ajouterEcouteurs();

	}

	/**
	 * 
	 */
	private final void creerComposants() {

		espaceColorimetrique = new JComboBox(ChoixCouleur.ESPACES_COLOMETRIQUES);

		panneauEspaceColorimetrique = new LabelComposant(
				LIBELLE_ESPACE_COLORIMETRIQUE, espaceColorimetrique);

		panneauEspaceColorimetrique.setForegroundLabel(Color.BLUE);

		espaceColorimetrique.setSelectedItem(choixCouleur
				.getEspaceColorimetrique());

	}

	/**
	 * 
	 */
	private final void ajouterComposants() {
		add(panneauEspaceColorimetrique);
	}

	/**
	 * 
	 */
	private final void ajouterEcouteurs() {

		new EcouteurChangementEspaceColorimetrique(choixCouleur,
				espaceColorimetrique);

	}

}