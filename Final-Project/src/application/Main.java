package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	/**
	 * @apiNote launches application
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * @param sets stage to Main.fxml
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/application/view/Main.fxml"));
		primaryStage.setScene(new Scene(root, 800, 600));
		primaryStage.setResizable(false);
		primaryStage.setTitle("Snake Game");
		primaryStage.show();	
	}

}
