package application.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.model.GameBoard;
import application.model.GameEnder;
import application.model.Pellet;
import application.model.Position;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * @author chase christenson and kyle horsman and cameron salazar
 *
 */


public class GameController implements EventHandler<ActionEvent>{
	private Snake s;
	private Pellet p;
	private GameBoard board;
	
	private Position snakePosit;
	private Position pelletPosit;
	
	private Timeline timeline;
	private final int GAME_WIDTH = 600;
	private final int GAME_HEIGHT = 400;
	private final int R_WIDTH = 10;
	
	@FXML
	private Button menuButton, submitButton;
	
	@FXML
	private Label nameLabel, scoreLabel, gameOverLabel;
	
	@FXML
	private TextField nameText;
	
	@FXML
	public Pane gamePane;
	
	public void init() {
		s = new Snake();
		p = new Pellet();
		board = new GameBoard();
		
		snakePosit = new Position(GAME_WIDTH/2, GAME_HEIGHT/2);
		pelletPosit = new Position(0,0);
		
		s.setPos(snakePosit);
		s.updatePath();

		//Finds spot to start pellet where snake isn't
		p.setPos(pelletPosit);
		do{
			p.move();
		}while(p.getX() == s.getX() && p.getY() == s.getY());
		
		board.addSnakeBlock(s.getX(), s.getY(), R_WIDTH);
		board.addPellet(p.getX(), p.getY(), R_WIDTH);
		
		gamePane.getChildren().addAll(board.sBlocks);
		gamePane.getChildren().add(board.pBlock);
		
	}
	
	public void start(){
		timeline = new Timeline(new KeyFrame(Duration.millis(80), event -> {
			//Move Up
			if(s.getDirection() == 1){
				if(s.getY() == 0){
					endGame();
				}
				else{ 
					s.setY(s.getY() - R_WIDTH);
					this.collisionCheck();
				}
			}
			//Move Right
			else if(s.getDirection() == 2){
				if(s.getX() == GAME_WIDTH - R_WIDTH){
					endGame();
				}
				else{
					s.setX(s.getX() + R_WIDTH);
					this.collisionCheck();
				}
			}
			//Move Down
			else if(s.getDirection() == 3){
				if(s.getY() == GAME_HEIGHT - R_WIDTH){
        				endGame();
				}
				else{
					s.setY(s.getY() + R_WIDTH);
					this.collisionCheck();
				}
			}
			//Move Left
			else if(s.getDirection() == 4){
				if(s.getX() == 0){
        				endGame();
				}
				else{
					s.setX(s.getX() - R_WIDTH);
					this.collisionCheck();
				}
			}
			
			updateScoreLabel();
		}));
		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}
	
	private void updateScoreLabel() {
		scoreLabel.setText(String.valueOf(s.getLength() * 100));		
	}
	
    	private void endGame() {
		timeline.stop();
		
		gameOverLabel.setVisible(true);
		nameLabel.setVisible(true);
		nameText.setVisible(true);
		submitButton.setVisible(true);		
	}
    
    public void collisionCheck(){
    	if(s.collideWith(p)){
    		System.out.println("Pellet Collision");
    		s.setLength(s.getLength()+1);

    		int x = s.getX();
    		int y = s.getY();
    		
    		Rectangle tempBlock = board.addSnakeBlock(x, y, R_WIDTH);
    		gamePane.getChildren().add(tempBlock);
    		
    		s.updatePath();
    		board.moveSnake(s.getPath());
    		movePellet();
    	}
    	else{
	    	ArrayList<Position> tempPath = s.getPath();
	    	for(int i = 0; i < tempPath.size(); i++){
	    		if(s.getX() == tempPath.get(i).getX() && s.getY() == tempPath.get(i).getY()){
	    			endGame();
	    		}
	    	}
	    	s.updatePath();
	    	board.moveSnake(s.getPath());
    	}
    }
    
    public void movePellet(){
    	Boolean spaceOccupied = false;
    	do{
    		p.move();
    		for(int i = 0; i < s.getLength(); i++){
    			if(p.getX() == s.getPath().get(i).getX() && p.getY() == s.getPath().get(i).getY())
    				spaceOccupied = true;
    		}
    	}while(spaceOccupied == true);
    	board.pBlock.setX(p.getX());
    	board.pBlock.setY(p.getY());
    }

    public EventHandler<KeyEvent> keyPressed = new EventHandler<KeyEvent>() {

        @Override
        public void handle(KeyEvent event) {
            // start movement according to key pressed
        	switch (event.getCode()) {
	        	case UP:
	        		if(s.getDirection() != 3)
	        			s.setDirection(1);
	            	break;
	           	case DOWN:
	           		if(s.getDirection() != 1)
	           			s.setDirection(3);
	            	break;
	            case RIGHT:
	            	if(s.getDirection() != 4)
	            		s.setDirection(2);
	            	break;
	            case LEFT:
	            	if(s.getDirection() != 2)
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
    	Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    	
		if(event.getSource() == menuButton) {
			try {
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/Main.fxml"));
				Parent root = (Parent) loader.load();
				stage.setScene(new Scene(root));
				stage.show();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		else if(event.getSource() == submitButton) {
			GameEnder finishGame = new GameEnder(stage, s, nameText.getText());
			finishGame.endGame();
		}
	}
        
	//Unused methods beloW
    
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
	
}
