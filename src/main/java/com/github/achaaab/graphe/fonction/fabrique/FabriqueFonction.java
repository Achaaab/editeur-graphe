package com.github.achaaab.graphe.fonction.fabrique;

import com.github.achaaab.graphe.fonction.Addition;
import com.github.achaaab.graphe.fonction.Constante;
import com.github.achaaab.graphe.fonction.Division;
import com.github.achaaab.graphe.fonction.Fonction;
import com.github.achaaab.graphe.fonction.Identite;
import com.github.achaaab.graphe.fonction.Multiplication;
import com.github.achaaab.graphe.fonction.Opposition;
import com.github.achaaab.graphe.fonction.Soustraction;
import com.github.achaaab.graphe.fonction.catalogue.Sin;
import com.github.achaaab.graphe.grammaire.CompilateurFonction;
import com.github.achaaab.graphe.grammaire.ErreurSyntaxe;
import com.github.achaaab.graphe.grammaire.ParseException;

import java.io.StringReader;
import java.util.List;

import static com.github.achaaab.graphe.fonction.catalogue.Catalogue.getFunction;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class FabriqueFonction {

	public static final FabriqueFonction INSTANCE = new FabriqueFonction();

	private static final Package PACKAGE_CATALOGUE = Sin.class.getPackage();

	/**
	 * @since 0.0.0
	 */
	private FabriqueFonction() {

	}

	/**
	 * @param gauche
	 * @param droite
	 * @return
	 * @since 0.0.0
	 */
	public Fonction creerAddition(Fonction gauche, Fonction droite) {
		return new Addition(gauche, droite);
	}

	/**
	 * @param gauche
	 * @param droite
	 * @return
	 * @since 0.0.0
	 */
	public Fonction creerSoustraction(Fonction gauche, Fonction droite) {
		return new Soustraction(gauche, droite);
	}

	/**
	 * @param gauche
	 * @param droite
	 * @return
	 * @since 0.0.0
	 */
	public Fonction creerMultiplication(Fonction gauche, Fonction droite) {
		return new Multiplication(gauche, droite);
	}

	/**
	 * @param gauche
	 * @param droite
	 * @return
	 * @since 0.0.0
	 */
	public Fonction creerDivision(Fonction gauche, Fonction droite) {
		return new Division(gauche, droite);
	}

	/**
	 * @param valeur
	 * @return
	 * @since 0.0.0
	 */
	public Fonction creerConstante(double valeur) {
		return new Constante(valeur);
	}

	/**
	 * @param nomVariable
	 * @return
	 * @since 0.0.0
	 */
	public Fonction creerIdentite(String nomVariable) {
		return new Identite(nomVariable);
	}

	/**
	 * @param sousFonction
	 * @return
	 * @since 0.0.0
	 */
	public Fonction creerOpposition(Fonction sousFonction) {
		return new Opposition(sousFonction);
	}

	/**
	 * @param nom
	 * @param sousFonctions
	 * @since 0.0.0
	 */
	public Fonction creerFonction(String nom, List<Fonction> sousFonctions) {

		try {
			return getFunction(nom, sousFonctions);
		} catch (Exception cause) {
			throw new RuntimeException(cause);
		}
	}

	/**
	 * Compile une fonction à partir de son texte, renvoie les erreurs de syntaxe.
	 *
	 * @param texteFonction texte de la fonction
	 * @return fonction compilée
	 * @throws ErreurSyntaxe en cas d'erreur de syntaxe (symboles manquants ou inatendus)
	 * @since 0.0.0
	 */
	public Fonction creerFonction(String texteFonction) throws ErreurSyntaxe {

		var compilateur = new CompilateurFonction(new StringReader(texteFonction));

		try {
			return compilateur.compilerFonction();
		} catch (ParseException cause) {
			throw new ErreurSyntaxe(cause);
		}
	}
}