package com.github.achaaab.utilitaire.couleur.choix;

import java.awt.Color;
import java.awt.Component;
import java.util.LinkedList;
import java.util.Vector;

import javax.swing.JDialog;

import com.github.achaaab.utilitaire.couleur.EspaceColorimetrique;
import com.github.achaaab.utilitaire.couleur.EspaceHSV;
import com.github.achaaab.utilitaire.couleur.EspaceRGB;
import com.github.achaaab.utilitaire.mathematiques.MathematiquesUtilitaire;

import static java.awt.Color.WHITE;
import static javax.swing.JOptionPane.getFrameForComponent;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class ChoixCouleur {

	public static final Vector<EspaceColorimetrique> ESPACES_COLOMETRIQUES;
	private static final int NOMBRE_ECHANTILLONS = 24;

	static {

		ESPACES_COLOMETRIQUES = new Vector<>();

		ESPACES_COLOMETRIQUES.add(EspaceRGB.INSTANCE);
		ESPACES_COLOMETRIQUES.add(EspaceHSV.INSTANCE);
	}

	private final PanneauChoixCouleur presentation;

	private int[] composantes;
	private EspaceColorimetrique espaceColorimetrique;
	private JDialog dialogue;
	private boolean validation;
	private LinkedList<Color> echantillons;

	/**
	 * @since 0.0.0
	 */
	public ChoixCouleur() {

		espaceColorimetrique = EspaceHSV.INSTANCE;
		composantes = new int[3];

		initialiserEchantillons();

		presentation = new PanneauChoixCouleur(this);
	}

	/**
	 * @since 0.0.0
	 */
	private void initialiserEchantillons() {

		echantillons = new LinkedList<>();

		for (var indexEchantillon = 0; indexEchantillon < NOMBRE_ECHANTILLONS; indexEchantillon++) {
			echantillons.offer(WHITE);
		}
	}

	/**
	 * @since 0.0.0
	 */
	public void memoriserEchantillon() {

		echantillons.poll();
		echantillons.offer(getCouleur());

		presentation.redessinerPanneauEchantillons();
	}

	/**
	 * @return
	 * @throws InterruptedException
	 */
	public Color ouvrirDialogue(Component composant, Color couleurInitiale) throws InterruptedException {

		setCouleur(couleurInitiale);
		validation = false;

		var fenetreMere = getFrameForComponent(composant);
		dialogue = new JDialog(fenetreMere, "Choix d'une couleur", true);
		dialogue.setContentPane(presentation);
		dialogue.pack();
		dialogue.setLocationRelativeTo(composant);
		dialogue.setVisible(true);

		return validation ? getCouleur() : couleurInitiale;
	}

	/**
	 * @since 0.0.0
	 */
	public synchronized void valider() {

		validation = true;
		memoriserEchantillon();
		dialogue.dispose();
	}

	/**
	 * 
	 */
	public void annuler() {
		dialogue.dispose();
	}

	/**
	 * 
	 * @param composante0
	 * @param composante1
	 */
	public final void setComposantes01(int composante0, int composante1) {

		composantes[0] = MathematiquesUtilitaire.borner(composante0, 0, 255);
		composantes[1] = MathematiquesUtilitaire.borner(composante1, 0, 255);

		presentation.redessinerCurseur2();
		presentation.redessinerPanneauChoixCouleur1();
		presentation.redessinerPanneauApercuCouleur();

	}

	/**
	 * 
	 * @param composante2
	 */
	public final void setComposante2(int composante2) {

		composantes[2] = MathematiquesUtilitaire.borner(composante2, 0, 255);

		presentation.redessinerCurseur1();
		presentation.redessinerPanneauChoixCouleur2();
		presentation.redessinerPanneauApercuCouleur();

	}

	/**
	 * 
	 * @param indexComposante
	 * @param valeurComposante
	 */
	public final void setComposante(int indexComposante, int valeurComposante) {

		switch (indexComposante) {

		case 0:
			setComposantes01(valeurComposante, composantes[1]);
			break;

		case 1:
			setComposantes01(composantes[0], valeurComposante);
			break;

		case 2:
			setComposante2(valeurComposante);
			break;

		default:
			break;

		}

	}

	/**
	 * @return the composante0
	 */
	public final int getComposante0() {
		return composantes[0];
	}

	/**
	 * @return the composante1
	 */
	public final int getComposante1() {
		return composantes[1];
	}

	/**
	 * @return the composante2
	 */
	public final int getComposante2() {
		return composantes[2];
	}

	/**
	 * 
	 * @param indexComposante
	 * @return
	 */
	public final int getComposante(int indexComposante) {
		return composantes[indexComposante];
	}

	/**
	 * 
	 * @return
	 */
	public final Color getCouleur() {
		return espaceColorimetrique.getCouleur(composantes);
	}

	/**
	 * 
	 * @param couleur
	 */
	public final void setCouleur(Color couleur) {

		composantes = espaceColorimetrique.getComposantes(couleur);

		presentation.redessiner();

	}

	/**
	 * 
	 * @param composante2
	 * @return
	 */
	public final Color getCouleur(int composante2) {

		return espaceColorimetrique.getCouleur(composantes[0], composantes[1],
				composante2);

	}

	/**
	 * 
	 * @param composante0
	 * @param composante1
	 * @return
	 */
	public final Color getCouleur(int composante0, int composante1) {

		return espaceColorimetrique.getCouleur(composante0, composante1,
				composantes[2]);

	}

	/**
	 * @return the espaceColorimetrique
	 */
	public final EspaceColorimetrique getEspaceColorimetrique() {
		return espaceColorimetrique;
	}

	/**
	 * @param espaceColorimetrique
	 *            the espaceColorimetrique to set
	 */
	public final void setEspaceColorimetrique(
			EspaceColorimetrique espaceColorimetrique) {

		Color couleur = getCouleur();
		this.espaceColorimetrique = espaceColorimetrique;
		setCouleur(couleur);

		presentation.actualiserEspaceColorimetrique(espaceColorimetrique);

		presentation.redessiner();

		dialogue.pack();

	}

	/**
	 * @return the echantillons
	 */
	public LinkedList<Color> getEchantillons() {
		return echantillons;
	}

}