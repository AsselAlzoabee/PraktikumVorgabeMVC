package gui.guiWarenuebersicht;

import business.GetraenkModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class WarenuebersichtView implements ownUtil.Observer {

	private WarenuebersichtControl warenuebersichtControl;
	private GetraenkModel getraenkeModel;
	// ---Anfang Attribute der grafischen Oberflaeche---
	private Pane pane = new Pane();
	private Label lblAnzeigeGetraenke = new Label("Anzeige Getränke");
	private TextArea txtAnzeigeGetraenke = new TextArea();
	private Button btnAnzeigeGetraenke = new Button("Anzeige");
	// -------Ende Attribute der grafischen Oberflaeche-------

	public WarenuebersichtView(WarenuebersichtControl WarenuebersichtControl, Stage primaryStage,
			GetraenkModel getraenkeModel) {
		Scene scene = new Scene(this.pane, 560, 340);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Anzeige der Warenübersicht");
		primaryStage.show();
		this.warenuebersichtControl = warenuebersichtControl;
		this.getraenkeModel = getraenkeModel;
		this.initKomponenten();
		this.initListener();

		// observer zufügen um alamiert zuwerden
		this.getraenkeModel.addObserver(this);
	}

	private void initKomponenten() {
		// Label
		Font font = new Font("Arial", 20);
		lblAnzeigeGetraenke.setLayoutX(310);
		lblAnzeigeGetraenke.setLayoutY(40);
		lblAnzeigeGetraenke.setFont(font);
		lblAnzeigeGetraenke.setStyle("-fx-font-weight: bold;");
		pane.getChildren().add(lblAnzeigeGetraenke);
		// Textbereich
		txtAnzeigeGetraenke.setEditable(false);
		txtAnzeigeGetraenke.setLayoutX(310);
		txtAnzeigeGetraenke.setLayoutY(90);
		txtAnzeigeGetraenke.setPrefWidth(220);
		txtAnzeigeGetraenke.setPrefHeight(185);
		pane.getChildren().add(txtAnzeigeGetraenke);
		// Button
		btnAnzeigeGetraenke.setLayoutX(310);
		btnAnzeigeGetraenke.setLayoutY(290);
		pane.getChildren().add(btnAnzeigeGetraenke);
	}

	private void initListener() {
		btnAnzeigeGetraenke.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				update();
			}
		});
	}

//	private void zeigeGetraenkeAn() {
//		if (getraenkeModel.getGetraenk() != null) {
//			txtAnzeigeGetraenke.setText(getraenkeModel.getGetraenk().gibGetraenkZurueck(' '));
//		} else {
//			zeigeInformationsfensterAn("Bisher wurde kein Getränk aufgenommen!");
//		}
//	}

	private void zeigeInformationsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.INFORMATION, "Information", meldung).zeigeMeldungsfensterAn();
	}

	@Override
	public void update() {

		if (getraenkeModel.getGetraenk() != null) {
			txtAnzeigeGetraenke.setText(getraenkeModel.getGetraenk().gibGetraenkZurueck(' '));
		} else {
			zeigeInformationsfensterAn("Bisher wurde kein Getränk aufgenommen!");
		}
	}

}
