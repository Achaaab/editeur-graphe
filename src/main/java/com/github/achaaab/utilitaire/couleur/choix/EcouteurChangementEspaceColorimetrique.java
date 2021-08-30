package com.github.achaaab.utilitaire.couleur.choix;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import com.github.achaaab.utilitaire.couleur.EspaceColorimetrique;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class EcouteurChangementEspaceColorimetrique implements ActionListener {

	private ChoixCouleur choixCouleur;
	private JComboBox combo;

	/**
	 * @param choixCouleur
	 * @param combo
	 */
	public EcouteurChangementEspaceColorimetrique(ChoixCouleur choixCouleur,
			JComboBox combo) {

		this.choixCouleur = choixCouleur;
		this.combo = combo;

		combo.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent evenement) {

		EspaceColorimetrique espaceColorimetrique = (EspaceColorimetrique) combo
				.getSelectedItem();

		choixCouleur.setEspaceColorimetrique(espaceColorimetrique);

	}

}