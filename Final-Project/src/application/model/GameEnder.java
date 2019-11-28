package application.model;

import java.io.IOException;
import java.util.ArrayList;

import application.controller.ScoreController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * @author Kyle Horsman and Cameron Salazar
 *
 */
public class GameEnder {

	private Stage stage;
	private Snake snake;
	private String name;
	
	// Constructor
	public GameEnder(Stage stage, Snake snake, String name){
		this.stage = stage;
		this.snake = snake;
		this.name = name;
	}
	
	/**
	 * Ends game and loads ScoreController
	 */
	public void endGame(){
		new HighScore(snake.getLength()*100, name);
		HighScore.saveToFile();
		
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/Score.fxml"));
			Pane root = loader.load();
			stage.setScene(new Scene(root));
			
			ScoreController controller = loader.getController();
			controller.init();
			
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
