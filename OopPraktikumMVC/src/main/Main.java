package main;

import gui.guiGetraenke.GetraenkControl;
import gui.guiWarenuebersicht.WarenuebersichtControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		new GetraenkControl(primaryStage);

		Stage fensterGetraenke = new Stage();
		new WarenuebersichtControl(fensterGetraenke);
//			new WarenuebersichtControl(fensterGetraenke);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
//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
//--module-path "<Pfad_zum_JavaFX_SDK>\lib" --add-modules javafx.controls,javafx.fxml
