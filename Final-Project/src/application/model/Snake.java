package application.model;

/**
 * 
 * @author Cary Inzerello
 *
 */
public class Snake extends Collidable{
	
	private int length;
	private int direction;	//0 = not moving, 1 = up, 2 = right, 3 = down, 4 = left
	
	/**
	 * Constructor
	 */
	public Snake() {
		super();
		this.length = 0;
		this.direction = 0;
	}
	
	/**
	 * Gets the snake's length
	 * @return int : snake's length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Sets the snake's length
	 * @param length int : snake's length
	 */
	public void setLength(int length) {
		this.length = length;
	}
	/**
	 * Gets the snake's direction
	 * @return int : snake's direction
	 */
	public int getDirection() {
		return direction;
	}

	/**
	 * Gets the snake's direction
	 * @param direction int : snake's direction
	 */
	public void setDirection(int direction) {
		this.direction = direction;
	}

	/**
	 * Reacts to the snake colliding with anything. If it's a pellet, the length increases. Else it triggers the lose state. 
	 * @param c Collidable : The object the snake collided with.
	 */
	@Override
	void collideResponse(Collidable c) {
		if(c.getClass().equals(new Pellet().getClass())) 
				this.length++;
		else {
			//you lose 
		}
	}
	
	

}
