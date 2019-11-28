package application.model;

import java.util.ArrayList;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * @author chase christenson
 *
 */
public class GameBoard {

	public ArrayList<Rectangle> sBlocks;
	public Rectangle pBlock;
	
	public GameBoard(){
		sBlocks = new ArrayList<Rectangle>();
		pBlock = new Rectangle();
	}
	
	public Rectangle addSnakeBlock(int x, int y, int width){
		Rectangle block = new Rectangle(x, y, width, width);
		block.setFill(Color.BLACK);
		this.sBlocks.add(block);
		return block;
	}
	
	public Rectangle addPellet(int x, int y, int width){
		this.pBlock = new Rectangle(x, y, width, width);
		this.pBlock.setFill(Color.RED);
		return this.pBlock;
	}
	
	public void moveSnake(ArrayList<Position> path){
		if(this.sBlocks.size() == path.size()){
			for(int i = 0; i < sBlocks.size(); i++){
				sBlocks.get(i).setX(path.get(i).getX());
				sBlocks.get(i).setY(path.get(i).getY());
			}
		}else{
			System.out.println("Not moving Snake");
		}
	}
	
	
	
	
}
