package core;

import gfx.Textures;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public abstract class CoreObject {

	protected float x, y, velX, velY;
	protected int width, height, id;

	protected Textures tex;
	protected BufferedImage image;
	
	public CoreObject(float x, float y, int id, Textures tex) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.tex = tex;
	}
	
	public CoreObject(float x, float y, int id, BufferedImage image) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.image = image;
	}

	public abstract void tick();
	public void render(Graphics g) {
        /*Debugging collision*/
      Graphics2D g2 = (Graphics2D) g;
      g2.setColor(Color.red);
      g2.draw(getTopBounds());
      g2.draw(getBottomBounds());
      g2.draw(getRightBounds());
      g2.draw(getLeftBounds());
	}
	
	///////////////////////////Get bounds for collision
	public Rectangle getTopBounds() {
		return new Rectangle((int)x + 6, (int)y, width - 12, 12);
	}
	
	public Rectangle getBottomBounds() {
		return new Rectangle((int)x + 6, (int)y + (height - 6), width - 12, 6);
	}

	public Rectangle getRightBounds() {
		return new Rectangle((int)x + (width - 6), (int)y + 15, 6, height - 20);
	}
	public Rectangle getLeftBounds() {
		 return new Rectangle((int)x, (int)y + 15, 6, height - 20);
	}
	
	//////////////////////////////////////////////////////
	/**
	 * @return the x coordinate
	 */
	public float getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public float getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(float y) {
		this.y = y;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param velX
	 *            the velX to set
	 */
	public void setVelX(float velX) {
		this.velX = velX;
	}

	/**
	 * @param velY
	 *            the velY to set
	 */
	public void setVelY(float velY) {
		this.velY = velY;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
public void setSize(int width, int height) {
	this.width = width;
	this.height = height;
}
}
