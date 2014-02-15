package gfx;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Animation {

	private int count = 0;
	private int index = 0;
	private int speed;
	private int frames;

	private BufferedImage currentImage;
	private BufferedImage anime[];

	public Animation(int speed, BufferedImage anime[]) {
		this.speed = speed;
		this.anime = anime;
		this.frames = anime.length; 
	}

	public void runAnimation() {
		index++;
		if (index > speed) {
			index = 0;
			nextFrame();
		}
	}

	public void nextFrame() {
		for (int k = 0; k < frames; k++) 
			if (count == k)
				currentImage = anime[k];
			count++;
			if (count > frames)
				count = 0;
	}

	public void drawAnimation(Graphics g, float x, float y) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawImage(currentImage, (int) x, (int) y, null);
	}
}
