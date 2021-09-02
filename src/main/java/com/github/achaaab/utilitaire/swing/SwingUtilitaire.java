package com.github.achaaab.utilitaire.swing;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class SwingUtilitaire {

	/**
	 * @param source
	 * @return
	 * @since 0.0.0
	 */
	public static BufferedImage copier(BufferedImage source) {

		var raster = source.copyData(null);

		return new BufferedImage(source.getColorModel(), raster, source.isAlphaPremultiplied(), null);
	}
}