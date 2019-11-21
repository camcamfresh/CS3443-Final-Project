package application.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.model.Pellet;
import application.model.Snake;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * @author chase christenson and kyle horsman
 *
 */


public class GameController implements EventHandler<ActionEvent>{
	
	private Snake s;
	private ArrayList<Rectangle> snakeRectangles = new ArrayList<Rectangle>();
	private int gameWidth = 600;
	private int gameHeight = 400;
	
	private int x = gameWidth/2;
	private int y = gameHeight/2;
	
	private int rWidth = 10;
	//private Boolean paused = false;
	
	@FXML
	private Button menuButton;
	public Pane gamePane;
	
	public void start(){
		Timeline timeline = new Timeline(new KeyFrame(Duration.millis(40), event -> {
			
			GameEnder end = new GameEnder((Stage) gamePane.getScene().getWindow(), s, "name");
			
			if(s.getDirection() == 1){
        		if(y == 0){
        			y = gameHeight - rWidth;
				end.endGame();
        		}
        		else{
        			y = y - rWidth;
        		}
        		snakeRectangles.get(0).setY(y);
        	}
        	else if(s.getDirection() == 2){
        		if(x == gameWidth - rWidth){
        			x = 0;
				end.endGame();
        		}
        		else{
        			x = x + rWidth;
        		}
        		snakeRectangles.get(0).setX(x);
        	}
			else if(s.getDirection() == 3){
				if(y == gameHeight - rWidth){
        			y = 0;
				end.endGame();
        		}
        		else{
        			y = y + rWidth;
        		}
        		snakeRectangles.get(0).setY(y);
			}
			else if(s.getDirection() == 4){
				if(x == 0){
        			x = gameWidth - rWidth;
				end.endGame();
        		}
        		else{
        			x = x - rWidth;
        		}
        		snakeRectangles.get(0).setX(x);
			}

		}));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}
	
	/**
	 * the logic for running the game
	 * @param s : the snake
	 * @param b	: the bounds of the playing screen
	 */
	public void startGame(Snake s, Bounds b){
		
		s.setX((int) b.getMaxX() / 2);
		s.setY((int) b.getMaxY() / 2);
		Pellet p = new Pellet();
		p.move();
		
		while(true){
			if(s.getX() >= b.getMaxX() || s.getX() <= b.getMinX()
					|| s.getY() >= b.getMaxY() || s.getY() <= b.getMinY()){
				//game over do something
				break;
			}
			if(s.collideWith(p)){
				s.collideResponse(p);
				p.collideResponse(s);
			}
		}
	}
	

	public void init() {
		//int x = gameWidth/2;
		//int y = gameHeight/2;
		
		this.s = new Snake();
		
		Rectangle snakeHead = new Rectangle(x, y, 10, 10);
		snakeHead.setFill(Color.RED);
		
		this.snakeRectangles.add(snakeHead);
		gamePane.getChildren().add(snakeHead);
	}
	
    public EventHandler<KeyEvent> keyReleased = new EventHandler<KeyEvent>() {

        @Override
        public void handle(KeyEvent event) {
        	switch (event.getCode()) {
	        	case UP:
	            		s.setDirection(1);
	            		break;
	           	case DOWN:
	            		s.setDirection(3);
	            		break;
	            	case RIGHT:
	            		s.setDirection(2);
	            		break;
	            	case LEFT:
	            		s.setDirection(4);
	            		break;
	            	case ENTER:
	            		s.setDirection(0);
	            		//paused = true;
	            		break;
			default:
				break;
        	}	
        
        }
    };

    public EventHandler<KeyEvent> keyPressed = new EventHandler<KeyEvent>() {

        @Override
        public void handle(KeyEvent event) {
            // start movement according to key pressed
        	switch (event.getCode()) {
	        	case UP:
	            		s.setDirection(1);
	            		break;
	           	case DOWN:
	            		s.setDirection(3);
	            		break;
	            	case RIGHT:
	            		s.setDirection(2);
	            		break;
	            	case LEFT:
	            		s.setDirection(4);
	            		break;
	            	case ENTER:
	            		s.setDirection(0);
	            		//paused = true;
	            		break;
			default:
				break;
        	}

        }
    };

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource() == menuButton) {
			try {
				Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/Main.fxml"));
				Parent root = (Parent) loader.load();
				stage.setScene(new Scene(root));
				stage.show();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
