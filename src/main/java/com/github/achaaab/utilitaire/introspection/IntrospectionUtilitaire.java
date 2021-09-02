package com.github.achaaab.utilitaire.introspection;

import java.lang.reflect.InvocationTargetException;

import static java.text.MessageFormat.format;

/**
 * classe utilitaire pour l'introspection
 *
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class IntrospectionUtilitaire {

	/**
	 * format du message d'erreur si une erreur survient durant l'instanciation d'une classe
	 */
	private static final String MESSAGE_ERREUR_INSTANCIATION = "Une erreur est survenue "
			+ "durant l''instanciation de la classe {0} (constructeur appelé : {1}, paramètres : {2}).";

	/**
	 * constructeur privé pour empêcher l'instanciation de cette classe utilitaire
	 *
	 * @since 0.0.0
	 */
	private IntrospectionUtilitaire() {

	}

	/**
	 * @param classe classe dont on souhaite créer une instance
	 * @param typesParametres types des paramètres du constructeur à appeler
	 * @param valeursParametres valeurs des paramètres du constructeur à appeler
	 * @param <T> type de la classe et donc de l'instance à créer
	 * @return nouvelle instance de la classe donnee créée via le constructeur sans paramètre
	 * @throws ExceptionIntrospection exception durant la tentative d'instanciation
	 * @since 0.0.0
	 */
	public static <T> T creerInstance(Class<T> classe, Class<?>[] typesParametres, Object[] valeursParametres)
			throws ExceptionIntrospection {

		try {

			var constructeur = classe.getConstructor(typesParametres);
			return constructeur.newInstance(valeursParametres);

		} catch (SecurityException | IllegalArgumentException | NoSuchMethodException | InstantiationException |
				IllegalAccessException | InvocationTargetException cause) {

			var nomConstructeur = classe.getSimpleName();
			var nomClasse = classe.getName();
			var detailConstructeur = getNomMethode(nomConstructeur, typesParametres);
			var detailParametres = getParametresEffectifs(valeursParametres);
			var parametresMessage = new Object[] { nomClasse, detailConstructeur, detailParametres };
			var message = format(MESSAGE_ERREUR_INSTANCIATION, parametresMessage);

			throw new ExceptionIntrospection(message, cause);
		}
	}

	/**
	 * @param parametres tableau d'objets
	 * @return chaîne de caractères représentant le type des paramètres
	 * @since 0.0.0
	 */
	private static String getParametresEffectifs(Object[] parametres) {

		var parametresEffectifs = new StringBuilder();

		parametresEffectifs.append("(");

		var nombreParametres = parametres.length;

		for (var indexParametre = 0; indexParametre < nombreParametres; indexParametre++) {

			var parametre = parametres[indexParametre];
			var typeParametre = parametre.getClass();
			var typeParametreCourt = typeParametre.getSimpleName();

			if (indexParametre > 0) {
				parametresEffectifs.append(", ");
			}

			parametresEffectifs.append(typeParametreCourt);
		}

		parametresEffectifs.append(")");

		return parametresEffectifs.toString();
	}

	/**
	 * @param nomMethode nom de la méthode sans parenthèses ni arguments
	 * @param typesArguments types des arguments
	 * @return nom de la méthode complet, dans un souci de clarté, le type des arguments n'inclut pas le package
	 * @since 0.0.0
	 */
	private static String getNomMethode(String nomMethode, Class<?>[] typesArguments) {

		var nomComplet = new StringBuilder();

		nomComplet.append(nomMethode);
		nomComplet.append("(");

		int nombreArguments = typesArguments.length;
		Class<?> typeArgument;
		String nomClasseSansPackage;

		// on parcourt les types d'argument

		for (int indexArgument = 0; indexArgument < nombreArguments; indexArgument++) {

			typeArgument = typesArguments[indexArgument];
			nomClasseSansPackage = typeArgument.getSimpleName();

			if (indexArgument > 0) {
				nomComplet.append(", ");
			}

			nomComplet.append(nomClasseSansPackage);

		}

		nomComplet.append(")");

		return nomComplet.toString();
	}
}