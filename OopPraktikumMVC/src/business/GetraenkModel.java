package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import csvImport.ConcreteReaderCreator;
import csvImport.ReaderCreator;
import csvImport.ReaderProduct;

public class GetraenkModel {

	private static Getraenk getraenk;

	public void schreibeGetraenkInCsvDatei() throws IOException {

		BufferedWriter aus = new BufferedWriter(new FileWriter("GetraenkAusgabe.csv", false));
		aus.write(getraenk.gibGetraenkZurueck(';'));
		aus.close();
	}

	public void leseAusDatei(String typ) throws IOException {

		ReaderCreator creator = new ConcreteReaderCreator();
		ReaderProduct readerProduct = creator.factoryMethod(typ);

		String[] zeile = readerProduct.leseAusDatei();
		readerProduct.schliesseDatei();
		this.getraenk = new Getraenk(zeile[0], Float.parseFloat(zeile[1]), Float.parseFloat(zeile[2]), zeile[3],
				zeile[4].split("_"));

	}

	public static Getraenk getGetraenk() {
		return getraenk;
	}

	public static void setGetraenk(Getraenk getraenk) {
		GetraenkModel.getraenk = getraenk;
	}

}
