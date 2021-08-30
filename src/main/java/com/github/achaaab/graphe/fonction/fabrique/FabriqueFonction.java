package com.github.achaaab.graphe.fonction.fabrique;

import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

import com.github.achaaab.graphe.fonction.Addition;
import com.github.achaaab.graphe.fonction.Constante;
import com.github.achaaab.graphe.fonction.Division;
import com.github.achaaab.graphe.fonction.Fonction;
import com.github.achaaab.graphe.fonction.Identite;
import com.github.achaaab.graphe.fonction.Multiplication;
import com.github.achaaab.graphe.fonction.Opposition;
import com.github.achaaab.graphe.fonction.Soustraction;
import com.github.achaaab.graphe.grammaire.CompilateurFonction;
import com.github.achaaab.graphe.grammaire.ErreurSyntaxe;
import com.github.achaaab.graphe.grammaire.ParseException;
import com.github.achaaab.utilitaire.StringUtilitaire;
import com.github.achaaab.utilitaire.introspection.ExceptionIntrospection;
import com.github.achaaab.utilitaire.introspection.IntrospectionUtilitaire;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class FabriqueFonction {

	private static final String PACKAGE_FONCTIONS = "com.github.achaaab.graphe.fonction.dictionnaire";

	private static FabriqueFonction instance;

	/**
	 * 
	 * @return
	 */
	public static synchronized FabriqueFonction getInstance() {

		if (instance == null) {
			instance = new FabriqueFonction();
		}

		return instance;

	}

	/**
	 * 
	 */
	private FabriqueFonction() {

	}

	/**
	 * 
	 * @param sousFonction0
	 * @param sousFonction1
	 * @return
	 */
	public Fonction creerAddition(Fonction sousFonction0, Fonction sousFonction1) {
		return new Addition(sousFonction0, sousFonction1);
	}

	/**
	 * 
	 * @param sousFonction0
	 * @param sousFonction1
	 * @return
	 */
	public Fonction creerSoustraction(Fonction sousFonction0, Fonction sousFonction1) {
		return new Soustraction(sousFonction0, sousFonction1);
	}

	/**
	 * 
	 * @param sousFonction0
	 * @param sousFonction1
	 * @return
	 */
	public Fonction creerMultiplication(Fonction sousFonction0,
			Fonction sousFonction1) {
		return new Multiplication(sousFonction0, sousFonction1);
	}

	/**
	 * 
	 * @param sousFonction0
	 * @param sousFonction1
	 * @return
	 */
	public Fonction creerDivision(Fonction sousFonction0, Fonction sousFonction1) {
		return new Division(sousFonction0, sousFonction1);
	}

	/**
	 * 
	 * @param valeur
	 * @return
	 */
	public Fonction creerConstante(double valeur) {
		return new Constante(valeur);
	}

	/**
	 * 
	 * @param nomVariable
	 * @return
	 */
	public Fonction creerIdentite(String nomVariable) {
		return new Identite(nomVariable);
	}

	/**
	 * 
	 * @param sousFonction
	 * @return
	 */
	public Fonction creerOpposition(Fonction sousFonction) {
		return new Opposition(sousFonction);
	}

	/**
	 * 
	 * @param nomFonction
	 * @param sousFonctions
	 * @throws ClassNotFoundException
	 * @throws ExceptionIntrospection
	 */
	public Fonction creerFonction(String nomFonction,
			List<Fonction> sousFonctions) {

		Fonction fonction;

		try {

			String nomClasse = StringUtilitaire
					.premiereLettreMajuscule(nomFonction);
			Class<?> classe = Class
					.forName(PACKAGE_FONCTIONS + '.' + nomClasse);

			int arite = sousFonctions.size();
			Fonction[] tableauSousFonctions = new Fonction[arite];
			sousFonctions.toArray(tableauSousFonctions);
			Class<?>[] typesParametres = new Class<?>[arite];
			Arrays.fill(typesParametres, Fonction.class);

			fonction = (Fonction) IntrospectionUtilitaire.creerInstance(classe,
					typesParametres, tableauSousFonctions);

		} catch (Exception cause) {

			RuntimeException exception = new RuntimeException(cause);
			throw exception;

		}

		return fonction;

	}

	/**
	 * compile une fonction a partir de son texte, renvoit les erreurs de
	 * syntaxe
	 * 
	 * @param texteFonction
	 *            texte de la fonction
	 * @return la fonction compilee
	 * @throws ErreurSyntaxe
	 *             en cas d'erreur de syntaxe (symboles manquants ou inatendus)
	 */
	public Fonction creerFonction(String texteFonction) throws ErreurSyntaxe {

		CompilateurFonction compilateur = new CompilateurFonction(
				new StringReader(texteFonction));

		Fonction fonction;

		try {
			fonction = compilateur.compilerFonction();
		} catch (ParseException cause) {
			throw new ErreurSyntaxe(cause);
		}

		return fonction;

	}

}