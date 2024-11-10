package main;

import gui.GetraenkControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		new GetraenkControl(primaryStage);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
//--module-path "<Pfad_zum_JavaFX_SDK>\lib" --add-modules javafx.controls,javafx.fxml
