package com.github.achaaab.utilitaire.couleur.choix;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import com.github.achaaab.utilitaire.couleur.EspaceColorimetrique;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class PanneauChoixCouleur extends JPanel {

	/**
	 * UID genere le 17/06/2010
	 */
	private static final long serialVersionUID = 6273462181199802358L;

	private ChoixCouleur choixCouleur;

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
	 */
	public PanneauChoixCouleur(ChoixCouleur choixCouleur) {

		this.choixCouleur = choixCouleur;

		setLayout(new GridBagLayout());

		creerComposants();
		ajouterComposants();

	}

	/**
	 * 
	 */
	private final void creerComposants() {

		panneauComposantes = new PanneauComposantes(choixCouleur);

		panneauChoixCouleur2 = new PanneauChoixCouleur2(choixCouleur,
				panneauComposantes);

		panneauChoixCouleur1 = new PanneauChoixCouleur1(choixCouleur,
				panneauComposantes);

		panneauEchantillons = new PanneauEchantillons(choixCouleur);

		panneauApercuCouleur = new PanneauApercuCouleur(choixCouleur);
		panneauParametres = new PanneauParametresChoixCouleur(choixCouleur);
		panneauValidation = new PanneauValidationCouleur(choixCouleur);

		EspaceColorimetrique espaceColorimetrique = choixCouleur
				.getEspaceColorimetrique();

		String titreChoixCouleur2 = getTitreChoixCouleur2(espaceColorimetrique);
		String titreChoixCouleur1 = getTitreChoixCouleur1(espaceColorimetrique);

		bordPanneauChoixCouleur2 = BorderFactory
				.createTitledBorder(titreChoixCouleur2);

		bordPanneauChoixCouleur1 = BorderFactory
				.createTitledBorder(titreChoixCouleur1);

		panneauChoixCouleur2Encadre = new JPanel();
		panneauChoixCouleur1Encadre = new JPanel();
		panneauApercuCouleurEncadre = new JPanel();

		panneauChoixCouleur2Encadre.setBorder(bordPanneauChoixCouleur2);
		panneauChoixCouleur1Encadre.setBorder(bordPanneauChoixCouleur1);

		panneauApercuCouleurEncadre.setBorder(BorderFactory
				.createTitledBorder("Aper�u"));

	}

	/**
	 * 
	 */
	private final void ajouterComposants() {

		panneauChoixCouleur2Encadre.add(panneauChoixCouleur2);
		panneauChoixCouleur1Encadre.add(panneauChoixCouleur1);
		panneauApercuCouleurEncadre.add(panneauApercuCouleur);

		GridBagConstraints contraintes = new GridBagConstraints();

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
	 * 
	 * @param espaceColorimetrique
	 * @return
	 */
	private static final String getTitreChoixCouleur2(
			EspaceColorimetrique espaceColorimetrique) {

		String nomComposante0 = espaceColorimetrique.getNomComposante0();
		String nomComposante1 = espaceColorimetrique.getNomComposante1();

		return nomComposante0 + ", " + nomComposante1;

	}

	/**
	 * 
	 * @param espaceColorimetrique
	 * @return
	 */
	private static final String getTitreChoixCouleur1(
			EspaceColorimetrique espaceColorimetrique) {

		String nomComposante2 = espaceColorimetrique.getNomComposante2();

		return nomComposante2;

	}

	/**
	 * 
	 */
	public final void redessiner() {

		redessinerPanneauChoixCouleur2();
		redessinerPanneauChoixCouleur1();
		redessinerPanneauApercuCouleur();

		panneauComposantes.actualiserComposantes();

	}

	/**
	 * 
	 */
	public final void redessinerCurseur1() {
		panneauChoixCouleur1.redessinerCurseur();
	}

	/**
	 * 
	 */
	public final void redessinerPanneauChoixCouleur2() {

		panneauChoixCouleur2.setImageAJour(false);
		panneauChoixCouleur2Encadre.repaint();

	}

	/**
	 * 
	 */
	public final void redessinerCurseur2() {
		panneauChoixCouleur2.redessinerCurseur();
	}

	/**
	 * 
	 */
	public final void redessinerPanneauChoixCouleur1() {

		panneauChoixCouleur1.setImageAJour(false);
		panneauChoixCouleur1Encadre.repaint();

	}

	/**
	 * 
	 */
	public final void redessinerPanneauApercuCouleur() {
		panneauApercuCouleur.repaint();
	}

	/**
	 * 
	 */
	public final void redessinerPanneauEchantillons() {
		panneauEchantillons.repaint();
	}

	/**
	 * 
	 * @param espaceColorimetrique
	 */
	public final void actualiserEspaceColorimetrique(
			EspaceColorimetrique espaceColorimetrique) {

		String titreChoixCouleur2 = getTitreChoixCouleur2(espaceColorimetrique);
		String titreChoixCouleur1 = getTitreChoixCouleur1(espaceColorimetrique);

		bordPanneauChoixCouleur2.setTitle(titreChoixCouleur2);
		bordPanneauChoixCouleur1.setTitle(titreChoixCouleur1);

		panneauComposantes.actualiserEspaceColorimetrique(espaceColorimetrique);

	}

}