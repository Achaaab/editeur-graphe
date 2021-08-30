package com.github.achaaab.utilitaire.multithreading;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public interface Tache<TypeTachePartielle extends TachePartielle> {

	/**
	 * 
	 * @return la partie suivante de la tache, null si la tache est terminee
	 */
	public abstract TypeTachePartielle getTachePartielle();

}