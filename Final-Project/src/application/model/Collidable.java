package application.model;

/**
 * 
 * @author Cary Inzerello
 *
 */

public abstract class Collidable {
	
	private Position posit;
	
	/**
	 * @return the pos
	 */
	public Position getPos() {
		return posit;
	}
	/**
	 * @param pos the pos to set
	 */
	public void setPos(Position pos) {
		this.posit = pos;
	}
	/**
	 * @return the x
	 */
	public int getX() {
		return this.posit.getY();
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.posit.setX(x);
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return this.posit.getY();
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.posit.setY(y);
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
