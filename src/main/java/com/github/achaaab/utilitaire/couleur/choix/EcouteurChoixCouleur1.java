package com.github.achaaab.utilitaire.couleur.choix;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public record EcouteurChoixCouleur1(
		ChoixCouleur choixCouleur,
		PanneauComposantes panneauComposantes)
		implements MouseListener, MouseMotionListener {

	/**
	 * @param evenement
	 * @since 0.0.0
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