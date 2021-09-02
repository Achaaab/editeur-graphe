package com.github.achaaab.utilitaire.couleur.choix;

import com.github.achaaab.utilitaire.couleur.EspaceColorimetrique;
import com.github.achaaab.utilitaire.swing.LabelComposant;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import static com.github.achaaab.utilitaire.couleur.choix.ChoixCouleur.ESPACES_COLOMETRIQUES;
import static java.awt.Color.BLUE;
import static javax.swing.BorderFactory.createCompoundBorder;
import static javax.swing.BorderFactory.createEmptyBorder;
import static javax.swing.BorderFactory.createTitledBorder;
import static javax.swing.BoxLayout.PAGE_AXIS;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class PanneauParametresChoixCouleur extends JPanel {

	private static final String TITRE = "Paramètres";
	private static final String LIBELLE_ESPACE_COLORIMETRIQUE = "Espace colorimétrique : ";

	private final ChoixCouleur choixCouleur;

	private JComboBox<EspaceColorimetrique> espaceColorimetrique;
	private LabelComposant panneauEspaceColorimetrique;

	/**
	 * @param choixCouleur
	 * @since 0.0.0
	 */
	public PanneauParametresChoixCouleur(ChoixCouleur choixCouleur) {

		this.choixCouleur = choixCouleur;

		var bordInterne = createEmptyBorder(8, 8, 8, 8);
		var bordExterne = createTitledBorder(TITRE);
		var bord = createCompoundBorder(bordExterne, bordInterne);

		setBorder(bord);

		setLayout(new BoxLayout(this, PAGE_AXIS));

		creerComposants();
		ajouterComposants();
		ajouterEcouteurs();
	}

	/**
	 * @since 0.0.0
	 */
	private void creerComposants() {

		espaceColorimetrique = new JComboBox<>(ESPACES_COLOMETRIQUES);
		panneauEspaceColorimetrique = new LabelComposant(LIBELLE_ESPACE_COLORIMETRIQUE, espaceColorimetrique);
		panneauEspaceColorimetrique.setForegroundLabel(BLUE);
		espaceColorimetrique.setSelectedItem(choixCouleur.getEspaceColorimetrique());
	}

	/**
	 * @since 0.0.0
	 */
	private void ajouterComposants() {
		add(panneauEspaceColorimetrique);
	}

	/**
	 * @since 0.0.0
	 */
	private void ajouterEcouteurs() {
		new EcouteurChangementEspaceColorimetrique(choixCouleur, espaceColorimetrique);
	}
}