package com.github.achaaab.utilitaire.couleur.choix;

import com.github.achaaab.utilitaire.couleur.EspaceColorimetrique;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import static javax.swing.BorderFactory.createTitledBorder;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class PanneauChoixCouleur extends JPanel {

	private final ChoixCouleur choixCouleur;

	private JPanel panneauChoixCouleur2Encadre;
	private JPanel panneauChoixCouleur1Encadre;
	private JPanel panneauApercuCouleurEncadre;

	private TitledBorder bordPanneauChoixCouleur2;
	private TitledBorder bordPanneauChoixCouleur1;

	private PanneauChoixCouleur2 panneauChoixCouleur2;
	private PanneauChoixCouleur1 panneauChoixCouleur1;
	private PanneauApercuCouleur panneauApercuCouleur;
	private PanneauParametresChoixCouleur panneauParametres;
	private PanneauComposantes panneauComposantes;
	private PanneauValidationCouleur panneauValidation;
	private PanneauEchantillons panneauEchantillons;

	/**
	 * @param choixCouleur
	 * @since 0.0.0
	 */
	public PanneauChoixCouleur(ChoixCouleur choixCouleur) {

		this.choixCouleur = choixCouleur;

		setLayout(new GridBagLayout());

		creerComposants();
		ajouterComposants();
	}

	/**
	 * @since 0.0.0
	 */
	private void creerComposants() {

		panneauComposantes = new PanneauComposantes(choixCouleur);
		panneauChoixCouleur2 = new PanneauChoixCouleur2(choixCouleur, panneauComposantes);
		panneauChoixCouleur1 = new PanneauChoixCouleur1(choixCouleur, panneauComposantes);
		panneauEchantillons = new PanneauEchantillons(choixCouleur);
		panneauApercuCouleur = new PanneauApercuCouleur(choixCouleur);
		panneauParametres = new PanneauParametresChoixCouleur(choixCouleur);
		panneauValidation = new PanneauValidationCouleur(choixCouleur);

		var espaceColorimetrique = choixCouleur.getEspaceColorimetrique();

		var titreChoixCouleur2 = getTitreChoixCouleur2(espaceColorimetrique);
		var titreChoixCouleur1 = getTitreChoixCouleur1(espaceColorimetrique);

		bordPanneauChoixCouleur2 = createTitledBorder(titreChoixCouleur2);
		bordPanneauChoixCouleur1 = createTitledBorder(titreChoixCouleur1);

		panneauChoixCouleur2Encadre = new JPanel();
		panneauChoixCouleur1Encadre = new JPanel();
		panneauApercuCouleurEncadre = new JPanel();

		panneauChoixCouleur2Encadre.setBorder(bordPanneauChoixCouleur2);
		panneauChoixCouleur1Encadre.setBorder(bordPanneauChoixCouleur1);
		panneauApercuCouleurEncadre.setBorder(createTitledBorder("Aperçu"));
	}

	/**
	 * @since 0.0.0
	 */
	private void ajouterComposants() {

		panneauChoixCouleur2Encadre.add(panneauChoixCouleur2);
		panneauChoixCouleur1Encadre.add(panneauChoixCouleur1);
		panneauApercuCouleurEncadre.add(panneauApercuCouleur);

		var contraintes = new GridBagConstraints();

		contraintes.gridx = 0;
		contraintes.gridy = 0;
		contraintes.gridwidth = 2;
		contraintes.gridheight = 1;
		add(panneauParametres, contraintes);

		contraintes.gridx = 0;
		contraintes.gridy = 1;
		contraintes.gridwidth = 1;
		contraintes.gridheight = 3;
		add(panneauChoixCouleur2Encadre, contraintes);

		contraintes.gridx = 1;
		contraintes.gridy = 1;
		contraintes.gridwidth = 1;
		contraintes.gridheight = 3;
		add(panneauChoixCouleur1Encadre, contraintes);

		contraintes.gridx = 2;
		contraintes.gridy = 0;
		contraintes.gridwidth = 2;
		contraintes.gridheight = 2;
		add(panneauComposantes, contraintes);

		contraintes.gridx = 2;
		contraintes.gridy = 2;
		contraintes.gridwidth = 1;
		contraintes.gridheight = 1;
		add(panneauApercuCouleurEncadre, contraintes);

		contraintes.gridx = 3;
		contraintes.gridy = 2;
		contraintes.gridwidth = 1;
		contraintes.gridheight = 1;
		add(panneauEchantillons, contraintes);

		contraintes.gridx = 2;
		contraintes.gridy = 3;
		contraintes.gridwidth = 2;
		contraintes.gridheight = 1;
		add(panneauValidation, contraintes);
	}

	/**
	 * @param espaceColorimetrique
	 * @return
	 * @since 0.0.0
	 */
	private static String getTitreChoixCouleur2(EspaceColorimetrique espaceColorimetrique) {

		var nomComposante0 = espaceColorimetrique.getNomComposante0();
		var nomComposante1 = espaceColorimetrique.getNomComposante1();

		return nomComposante0 + ", " + nomComposante1;
	}

	/**
	 * @param espaceColorimetrique
	 * @return
	 * @since 0.0.0
	 */
	private static String getTitreChoixCouleur1(EspaceColorimetrique espaceColorimetrique) {
		return espaceColorimetrique.getNomComposante2();
	}

	/**
	 * @since 0.0.0
	 */
	public void redessiner() {

		redessinerPanneauChoixCouleur2();
		redessinerPanneauChoixCouleur1();
		redessinerPanneauApercuCouleur();

		panneauComposantes.actualiserComposantes();
	}

	/**
	 * @since 0.0.0
	 */
	public void redessinerCurseur1() {
		panneauChoixCouleur1.redessinerCurseur();
	}

	/**
	 * @since 0.0.0
	 */
	public void redessinerPanneauChoixCouleur2() {

		panneauChoixCouleur2.setImageAJour(false);
		panneauChoixCouleur2Encadre.repaint();
	}

	/**
	 * @since 0.0.0
	 */
	public void redessinerCurseur2() {
		panneauChoixCouleur2.redessinerCurseur();
	}

	/**
	 * @since 0.0.0
	 */
	public void redessinerPanneauChoixCouleur1() {

		panneauChoixCouleur1.setImageAJour(false);
		panneauChoixCouleur1Encadre.repaint();
	}

	/**
	 * @since 0.0.0
	 */
	public void redessinerPanneauApercuCouleur() {
		panneauApercuCouleur.repaint();
	}

	/**
	 * @since 0.0.0
	 */
	public void redessinerPanneauEchantillons() {
		panneauEchantillons.repaint();
	}

	/**
	 * @param espaceColorimetrique
	 * @since 0.0.0
	 */
	public void actualiserEspaceColorimetrique(EspaceColorimetrique espaceColorimetrique) {

		var titreChoixCouleur2 = getTitreChoixCouleur2(espaceColorimetrique);
		var titreChoixCouleur1 = getTitreChoixCouleur1(espaceColorimetrique);

		bordPanneauChoixCouleur2.setTitle(titreChoixCouleur2);
		bordPanneauChoixCouleur1.setTitle(titreChoixCouleur1);

		panneauComposantes.actualiserEspaceColorimetrique(espaceColorimetrique);
	}
}