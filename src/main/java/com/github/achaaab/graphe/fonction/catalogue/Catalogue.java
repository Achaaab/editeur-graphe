package com.github.achaaab.graphe.fonction.catalogue;

import com.github.achaaab.graphe.fonction.Fonction;
import com.github.achaaab.utilitaire.introspection.ExceptionIntrospection;

import java.util.List;

import static com.github.achaaab.utilitaire.StringUtilitaire.premiereLettreMajuscule;
import static com.github.achaaab.utilitaire.introspection.IntrospectionUtilitaire.creerInstance;
import static java.lang.Class.forName;
import static java.util.Arrays.fill;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class Catalogue {

	private static final String PACKAGE_NAME = Catalogue.class.getPackage().getName();

	/**
	 * @param name
	 * @param subFunctions
	 * @return
	 * @throws ClassNotFoundException
	 * @throws ExceptionIntrospection
	 * @since 0.0.0
	 */
	public static Fonction getFunction(String name, List<Fonction> subFunctions)
			throws ClassNotFoundException, ExceptionIntrospection {

		var className = PACKAGE_NAME + '.' + premiereLettreMajuscule(name);
		var functionClass = forName(className);

		var arity = subFunctions.size();
		var parameters = subFunctions.toArray(new Fonction[0]);

		var parameterTypes = new Class<?>[arity];
		fill(parameterTypes, Fonction.class);

		return (Fonction) creerInstance(functionClass, parameterTypes, parameters);
	}
}
