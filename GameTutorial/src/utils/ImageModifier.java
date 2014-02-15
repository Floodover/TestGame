package utils;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class ImageModifier {

	public static BufferedImage resizeImage(BufferedImage originalImage,
			int type, float x, float y, int initialWidth, int initialHeight,
			double scale) {

		initialHeight *= scale;
		initialWidth *= scale;
		BufferedImage resizedImage = new BufferedImage(initialWidth,
				initialHeight, type);
		Graphics2D g2 = resizedImage.createGraphics();
		g2.drawImage(originalImage, (int) x, (int) y, initialWidth,
				initialHeight, null);
		return resizedImage;
	}

}
