package com.github.achaaab.utilitaire.couleur.choix;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class EcouteurChoixCouleur1 implements MouseListener,
		MouseMotionListener {

	private ChoixCouleur choixCouleur;

	private PanneauComposantes panneauComposantes;

	/**
	 * 
	 * @param choixCouleur
	 * @param panneauComposantes
	 */
	public EcouteurChoixCouleur1(ChoixCouleur choixCouleur,
			PanneauComposantes panneauComposantes) {

		this.choixCouleur = choixCouleur;
		this.panneauComposantes = panneauComposantes;

	}

	/**
	 * 
	 * @param evenement
	 */
	private void actualiserChoixCouleur(MouseEvent evenement) {

		int composante2 = evenement.getY();

		choixCouleur.setComposante2(composante2);
		panneauComposantes.setComposante2(composante2);

	}

	@Override
	public void mousePressed(MouseEvent evenement) {
		actualiserChoixCouleur(evenement);
	}

	@Override
	public void mouseDragged(MouseEvent evenement) {
		actualiserChoixCouleur(evenement);
	}

	@Override
	public void mouseClicked(MouseEvent evenement) {

	}

	@Override
	public void mouseEntered(MouseEvent evenement) {

	}

	@Override
	public void mouseExited(MouseEvent evenement) {

	}

	@Override
	public void mouseReleased(MouseEvent evenement) {

	}

	@Override
	public void mouseMoved(MouseEvent evenement) {

	}

}