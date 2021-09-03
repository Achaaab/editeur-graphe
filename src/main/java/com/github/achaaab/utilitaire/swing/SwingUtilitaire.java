package com.github.achaaab.utilitaire.swing;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.image.BufferedImage;

import static java.awt.Image.SCALE_SMOOTH;
import static java.util.Arrays.stream;

/**
 * @author Jonathan Guéhenneux
 * @since 0.0.0
 */
public class SwingUtilitaire {

	private static final int REFERENCE_DPI = 72;
	private static final int DPI = 96;

	/**
	 * @param source
	 * @return
	 * @since 0.0.0
	 */
	public static BufferedImage copier(BufferedImage source) {

		var raster = source.copyData(null);

		return new BufferedImage(source.getColorModel(), raster, source.isAlphaPremultiplied(), null);
	}

	/**
	 * Recursively scales component hierarchy.
	 *
	 * @param component component to scale
	 * @since 0.0.0
	 */
	public static void scale(Component component) {

		var minimumSize = component.getMinimumSize();
		var maximumSize = component.getMaximumSize();
		var preferredSize = component.getPreferredSize();
		var size = component.getSize();

		var scaledMinimumSize = scale(minimumSize);
		var scaledMaximumSize = scale(maximumSize);
		var scaledPreferredSize = scale(preferredSize);
		var scaledSize = scale(size);

		component.setMinimumSize(scaledMinimumSize);
		component.setMaximumSize(scaledMaximumSize);
		component.setPreferredSize(scaledPreferredSize);
		component.setSize(scaledSize);

		var font = component.getFont();
		var scaledFont = scale(font);
		component.setFont(scaledFont);

		if (component instanceof Container container) {

			synchronized (container.getTreeLock()) {

				var children = container.getComponents();
				stream(children).forEach(SwingUtilitaire::scale);
			}
		}

		if (component instanceof JMenu menu) {

			var popupMenu = menu.getPopupMenu();
			scale(popupMenu);
		}

		if (component instanceof AbstractButton button) {

			var icon = button.getIcon();

			if (icon instanceof ImageIcon imageIcon) {
				scale(imageIcon);
			}
		}

		if (component instanceof JComponent jComponent) {

			var border = jComponent.getBorder();

			if (border != null) {
				scale(border);
			}
		}
	}

	/**
	 * @param border border to scale
	 * @since 0.0.0
	 */
	private static void scale(Border border) {

		if (border instanceof TitledBorder titledBorder) {

			var font = titledBorder.getTitleFont();
			var scaledFont = scale(font);
			titledBorder.setTitleFont(scaledFont);

		} else if (border instanceof EmptyBorder emptyBorder) {

			var insets = emptyBorder.getBorderInsets();
			scale(insets);

		} else if (border instanceof CompoundBorder compoundBorder) {

			var insideBorder = compoundBorder.getInsideBorder();
			var outsideBorder = compoundBorder.getOutsideBorder();

			scale(insideBorder);
			scale(outsideBorder);
		}
	}

	/**
	 * @param value
	 * @return
	 * @since 0.0.0
	 */
	private static int scale(int value) {
		return value * DPI / REFERENCE_DPI;
	}

	/**
	 * @param dimension
	 * @since 0.0.0
	 */
	private static Dimension scale(Dimension dimension) {

		if (dimension != null) {

			dimension.width = scale(dimension.width);
			dimension.height = scale(dimension.height);
		}

		return dimension;
	}

	/**
	 * @param insets
	 * @since 0.0.0
	 */
	private static Insets scale(Insets insets) {

		if (insets != null) {

			insets.left = scale(insets.left);
			insets.right = scale(insets.right);
			insets.top = scale(insets.top);
			insets.bottom = scale(insets.bottom);
		}

		return insets;
	}

	/**
	 * @param font font to scale
	 * @return scaled font
	 * @since 0.0.0
	 */
	private static Font scale(Font font) {

		Font scaledFont;

		if (font == null) {

			scaledFont = null;

		} else {

			var fontSize = font.getSize();
			var scaledFontSize = scale(fontSize);
			scaledFont = font.deriveFont((float) scaledFontSize);
		}

		return scaledFont;
	}

	/**
	 * @param icon
	 * @return
	 * @since 0.0.8
	 */
	private static void scale(ImageIcon icon) {

		var width = icon.getIconWidth();
		var height = icon.getIconHeight();

		var scaledWidth = scale(width);
		var scaledHeight = scale(height);

		var image = icon.getImage();
		var scaledImage = image.getScaledInstance(scaledWidth, scaledHeight, SCALE_SMOOTH);
		icon.setImage(scaledImage);
	}
}