package application.model;

/**
 * 
 * @author Cary Inzerello
 *
 */

public abstract class Collidable {
	
	private int x;
	private int y;
	
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * Checks to see if this object collided with c.
	 * @param c Collidable : the object to check collision with
	 * @return true if the objects have collided, false if not.
	 */
	public boolean collideWith(Collidable c) {
		if(c.getX() == this.getX() && c.getY() == this .getY())
			return true;
		return false;
	}
	/**
	 * Abstract: Should respond to the collision of the 2 objects
	 * @param c Collidable : the object to check collided with
	 */
	abstract void collideResponse(Collidable c); 

}
