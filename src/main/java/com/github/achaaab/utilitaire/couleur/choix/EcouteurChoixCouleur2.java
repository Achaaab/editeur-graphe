package com.github.achaaab.utilitaire.couleur.choix;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public record EcouteurChoixCouleur2(
		ChoixCouleur choixCouleur,
		PanneauComposantes panneauComposantes)
		implements MouseListener, MouseMotionListener {

	/**
	 * @param evenement
	 * @since 0.0.0
	 */
	private void actualiserChoixCouleur(MouseEvent evenement) {

		int composante0 = evenement.getX();
		int composante1 = evenement.getY();

		choixCouleur.setComposantes01(composante0, composante1);
		panneauComposantes.setComposantes01(composante0, composante1);
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