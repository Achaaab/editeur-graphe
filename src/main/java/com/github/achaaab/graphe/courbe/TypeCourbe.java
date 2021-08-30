package com.github.achaaab.graphe.courbe;

import com.github.achaaab.graphe.equation.EquationCartesienne;
import com.github.achaaab.graphe.equation.EquationParametrique;
import com.github.achaaab.graphe.equation.EquationPolaire;
import com.github.achaaab.graphe.fonction.fabrique.FabriqueFonction;
import com.github.achaaab.graphe.grammaire.ErreurSyntaxe;

/**
 * type de courbe
 *
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public enum TypeCourbe {

	CARTESIENNE("Cartésienne") {
		@Override
		public Courbe getCourbeDefaut() {

			try {

				var f = FabriqueFonction.getInstance().creerFonction("0");
				var equationCartesienne = new EquationCartesienne(f);

				return new CourbeCartesienne(NOM_COURBE_DEFAUT, equationCartesienne);

			} catch (ErreurSyntaxe erreur) {

				// la fonction par defaut est invalide syntaxiquement
				return null;
			}
		}
	},

	POLAIRE("Polaire") {
		@Override
		public Courbe getCourbeDefaut() {

			try {

				var f = FabriqueFonction.getInstance().creerFonction("0");
				var equationPolaire = new EquationPolaire(f);

				return new CourbePolaire(NOM_COURBE_DEFAUT, equationPolaire);

			} catch (ErreurSyntaxe erreur) {

				// la fonction par defaut est invalide syntaxiquement
				return null;
			}
		}
	},

	PARAMETRIQUE("Paramétrique") {
		@Override
		public Courbe getCourbeDefaut() {

			try {

				var f = FabriqueFonction.getInstance().creerFonction("0");
				var g = FabriqueFonction.getInstance().creerFonction("0");
				var equationParametrique = new EquationParametrique(f, g);

				return new CourbeParametrique(NOM_COURBE_DEFAUT, equationParametrique);

			} catch (ErreurSyntaxe erreur) {

				// la fonction par defaut est invalide syntaxiquement
				return null;
			}
		}
	};

	private static final String NOM_COURBE_DEFAUT = "courbe_defaut";

	private final String libelle;

	/**
	 * @param libelle
	 */
	TypeCourbe(String libelle) {
		this.libelle = libelle;
	}

	public abstract Courbe getCourbeDefaut();

	@Override
	public String toString() {
		return libelle;
	}
}