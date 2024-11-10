package gui;

import java.io.IOException;

import business.Getraenk;
import business.GetraenkModel;
import javafx.stage.Stage;

public class GetraenkControl {

	public static GetraenkView getraenkView;
	public static GetraenkModel getraenkModel;

	public GetraenkControl(Stage primaryStage) {
		this.getraenkModel = new GetraenkModel();
		this.getraenkView = new GetraenkView(this, getraenkModel, primaryStage);
	}

	public void leseAusDatei(String typ) {
		try {
			this.getraenkModel.leseAusDatei(typ);
		} catch (IOException exc) {
			this.getraenkView.zeigeFehlermeldungsfensterAn("IOException beim Lesen!");
		} catch (Exception exc) {
			this.getraenkView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Lesen!" + exc.getMessage());
			// exc.printStackTrace(); // Detaillierte Ausgabe des Fehlers in der Konsole
		}
	}

	public void schreibeGetraenkInCsvDatei() {
		try {
			this.getraenkModel.schreibeGetraenkInCsvDatei();
			this.getraenkView.zeigeInformationsfensterAn("Die Tee wurden gespeichert!");
		} catch (IOException exc) {
			this.getraenkView.zeigeFehlermeldungsfensterAn("IOException beim Speichern!");
		} catch (Exception exc) {
			this.getraenkView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
		}
	}

	public void nehmeGetraenkAuf() {
		try {

			getraenkModel.setGetraenk(new Getraenk(this.getraenkView.getTxtArtikelnummer().getText(),
					Float.parseFloat(this.getraenkView.getTxtEinkaufspreis().getText()),
					Float.parseFloat(this.getraenkView.getTxtVerkaufspreis().getText()),
					this.getraenkView.getTxtMitAlkohol().getText(),
					this.getraenkView.getTxtBehaeltnis().getText().split(";")));
			this.getraenkView.zeigeInformationsfensterAn("Der Getraenk wurde aufgenommen!");
		} catch (Exception exc) {
			getraenkView.zeigeFehlermeldungsfensterAn(exc.getMessage());
		}
	}

}
