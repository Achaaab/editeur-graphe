package com.github.achaaab.utilitaire.multithreading;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class ExecuteurTache extends Thread {

	private Tache<?> tache;

	/**
	 * 
	 * @param tache
	 */
	public ExecuteurTache(Tache<?> tache) {
		this.tache = tache;
	}

	@Override
	public void run() {

		TachePartielle tachePartielle;

		while ((tachePartielle = tache.getTachePartielle()) != null) {
			tachePartielle.executer();
		}

	}

}