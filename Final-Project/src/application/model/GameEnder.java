package application.model;

import java.io.IOException;
import java.util.ArrayList;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author Kyle Horsman
 *
 */
public class GameEnder {

	private Stage stage;
	private Snake snake;
	private String name;
	
	// Constuctor
	public GameEnder(Stage stage, Snake snake, String name){
		this.stage = stage;
		this.snake = snake;
		this.name = name;
	}
	
	/**
	 * Ends game and loads ScoreController
	 */
	public void endGame(){
		HighScore score = new HighScore(snake.getLength(), name);
		//score.saveToFile();
		
		//testing
		System.out.println(snake.getLength() + " " + name);
		//
		
		try {
			Pane root = FXMLLoader.load(getClass().getResource("/application/view/Score.fxml"));
			stage.setScene(new Scene(root));
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
