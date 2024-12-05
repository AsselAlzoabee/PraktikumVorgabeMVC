package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import csvImport.ConcreteReaderCreator;
import csvImport.ReaderCreator;
import csvImport.ReaderProduct;
import ownUtil.Observer;

public class GetraenkModel implements ownUtil.Observable {

	private static Getraenk getraenk;
	// pr static instance
	private static GetraenkModel instanz;

	private Vector<Observer> observers = new Vector<Observer>();

	// private constructure
	private GetraenkModel() {
		// TODO Auto-generated constructor stub
	}

	// objekt herstellung von der methode bei aufruf oder weiter leitung
	public static GetraenkModel getInstantz() {
		if (instanz == null) {
			return instanz = new GetraenkModel();

		} else {
			return instanz;
		}
	}

	public void schreibeGetraenkInCsvDatei() throws IOException {

		BufferedWriter aus = new BufferedWriter(new FileWriter("GetraenkAusgabe.csv", false));
		aus.write(getraenk.gibGetraenkZurueck(';'));
		aus.close();

		// observers alamieren nachem was geschrieben wurde
		notifyObservers();
	}

	public void leseAusDatei(String typ) throws IOException {

		ReaderCreator creator = new ConcreteReaderCreator();
		ReaderProduct readerProduct = creator.factoryMethod(typ);

		String[] zeile = readerProduct.leseAusDatei();
		readerProduct.schliesseDatei();
		this.getraenk = new Getraenk(zeile[0], Float.parseFloat(zeile[1]), Float.parseFloat(zeile[2]), zeile[3],
				zeile[4].split("_"));

		// observers alamieren nachem was gelesen wurde
		notifyObservers();

	}

	public static Getraenk getGetraenk() {
		return getraenk;
	}

	public static void setGetraenk(Getraenk getraenk) {
		GetraenkModel.getraenk = getraenk;
	}

	@Override
	public void addObserver(Observer obs) {

		this.observers.addElement(obs);
	}

	@Override
	public void removeObserver(Observer obs) {
		this.observers.removeElement(obs);
	}

	@Override
	public void notifyObservers() {
		// unsicher
		for (int i = 0; i < this.observers.size(); i++) {
			this.observers.elementAt(i).update();
		}

	}

}
