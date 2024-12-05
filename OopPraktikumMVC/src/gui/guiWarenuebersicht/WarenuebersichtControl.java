package gui.guiWarenuebersicht;

import business.GetraenkModel;
import javafx.stage.Stage;

public class WarenuebersichtControl {
	private WarenuebersichtView warenuebersichtView;
	private GetraenkModel getraenkeModel;

	public WarenuebersichtControl(Stage primaryStage) {
		// objekt aufruf
		this.getraenkeModel = GetraenkModel.getInstantz();
		this.warenuebersichtView = new WarenuebersichtView(this, primaryStage, getraenkeModel);
	}
}
