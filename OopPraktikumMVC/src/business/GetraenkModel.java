package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GetraenkModel {

	private static Getraenk getraenk;

	public void schreibeGetraenkInCsvDatei() throws IOException {

		BufferedWriter aus = new BufferedWriter(new FileWriter("GetraenkAusgabe.csv", true));
		aus.write(getraenk.gibGetraenkZurueck(';'));
		aus.close();
	}

	public void leseAusDatei(String typ) throws IOException {
		if ("csv".equals(typ)) {
			BufferedReader ein = new BufferedReader(new FileReader("GetraenkAusgabe.csv"));
			String[] zeile = ein.readLine().split(";");
			this.getraenk = new Getraenk(zeile[0], Float.parseFloat(zeile[1]), Float.parseFloat(zeile[2]), zeile[3],
					zeile[4].split(";"));

			ein.close();
		}
	}

	public static Getraenk getGetraenk() {
		return getraenk;
	}

	public static void setGetraenk(Getraenk getraenk) {
		GetraenkModel.getraenk = getraenk;
	}

}
