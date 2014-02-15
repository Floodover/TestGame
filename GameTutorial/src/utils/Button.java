package utils;

import input.MouseInput;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

@SuppressWarnings("serial")
public class Button extends Rectangle {

	private String text;

	public Button(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public Button setText(String text) {
		this.text = text;
		return this;
	}

	public void drawButton(Graphics g, int offset) {
		Graphics2D g2 = (Graphics2D) g; // added to test out Graphics2D
		int xx = x + offset;
		int yy = y + 38;

		if (MouseInput.MOUSE.intersects(this)) {
			g2.setColor(Color.ORANGE);
		} else
			g2.setColor(Color.RED);

		g2.drawRect(x, y, width, height);
		g2.drawString(text, xx, yy);

		if (MouseInput.pressed && MouseInput.MOUSE.intersects(this)) {
			g2.setColor(Color.BLUE);
			g2.drawString(text, xx, yy);
		}

	}
}
