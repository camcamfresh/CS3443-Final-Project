package application.model;

import java.util.ArrayList;

/**
 * @author Cary Inzerello
 */
public class Snake extends Collidable{
	
	private int length;
	private int direction;	//0 = not moving, 1 = up, 2 = right, 3 = down, 4 = left
	private ArrayList<Position> path = new ArrayList<Position>();
	
	/**
	 * @apiNote Constructor; sets length to 1 & direction to 0 (not moving)
	 */
	public Snake() {
		super();
		this.length = 1;
		this.direction = 0;
	}
	
	/**
	 * @apiNote Gets the snake's length
	 * @return int : snake's length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @apiNote Sets the snake's length
	 * @param length int : snake's length
	 */
	public void setLength(int length) {
		this.length = length;
	}
	/**
	 * @apiNote Gets the snake's direction
	 * @return int : snake's direction
	 */
	public int getDirection() {
		return direction;
	}

	/**
	 * @apiNote Gets the snake's direction
	 * @param direction int : snake's direction
	 */
	public void setDirection(int direction) {
		this.direction = direction;
	}

	/**
	 * @apiNote Reacts to the snake colliding with anything. If it's a pellet, the length increases. Else it triggers the lose state. 
	 * @param c Collidable : The object the snake collided with.
	 */
	@Override
	public void collideResponse(Collidable c) {
		if(c.getClass().equals(new Pellet().getClass())) 
				this.length++;
		else {
			//you lose 
		}
	}
	/**
	 * @apiNote Adds current position to the path and deletes the last one when it is past the length
	 */
	public void updatePath() {
		path.add(new Position(getX(), getY()));
		if(path.size()>this.length)
			path.remove(0);
	}	
	
	/**
	 * @return the path
	 */
	public ArrayList<Position> getPath() {
		return path;
	}

}
