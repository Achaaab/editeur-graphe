package com.github.achaaab.utilitaire;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.nanoTime;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class Chronometre {

	public static final int MILLISECONDES_PAR_SECONDE = 1000;
	public static final int MICROSECONDES_PAR_SECONDE = MILLISECONDES_PAR_SECONDE * 1000;
	public static final int NANOSECONDES_PAR_SECONDE = MICROSECONDES_PAR_SECONDE * 1000;

	private final Map<String, Long> temps;

	/**
	 * @since 0.0.0
	 */
	public Chronometre() {
		temps = new HashMap<>();
	}

	/**
	 * @param cle
	 * @since 0.0.0
	 */
	public void start(String cle) {
		temps.put(cle, nanoTime());
	}

	/**
	 * @param cle
	 * @return
	 * @since 0.0.0
	 */
	public float tick(String cle) {

		var t1 = temps.get(cle);
		var t2 = nanoTime();
		var t = (float) (t2 - t1);

		return t / NANOSECONDES_PAR_SECONDE;
	}

	/**
	 * @param cle
	 * @return
	 * @since 0.0.0
	 */
	public float stop(String cle) {

		var secondes = tick(cle);
		temps.remove(cle);
		return secondes;
	}
}