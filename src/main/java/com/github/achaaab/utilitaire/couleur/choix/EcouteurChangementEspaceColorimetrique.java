package com.github.achaaab.utilitaire.couleur.choix;

import com.github.achaaab.utilitaire.couleur.EspaceColorimetrique;

import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class EcouteurChangementEspaceColorimetrique implements ActionListener {

	private final ChoixCouleur choixCouleur;
	private final JComboBox<EspaceColorimetrique> combo;

	/**
	 * @param choixCouleur
	 * @param combo
	 * @since 0.0.0
	 */
	public EcouteurChangementEspaceColorimetrique(ChoixCouleur choixCouleur, JComboBox<EspaceColorimetrique> combo) {

		this.choixCouleur = choixCouleur;
		this.combo = combo;

		combo.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent evenement) {

		var espaceColorimetrique = (EspaceColorimetrique) combo.getSelectedItem();
		choixCouleur.setEspaceColorimetrique(espaceColorimetrique);
	}
}