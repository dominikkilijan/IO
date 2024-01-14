package org.example.Model;

import java.util.*;

public class Rachunek {

	private int id;
	private List<Wypozyczenie> wypozyczenia = new ArrayList<>();
	private int wartosc;
	private boolean czyZaplacone;

	public Rachunek() {

	}

//	public List getWypozyczenia() {
//
//	}
	public List<Wypozyczenie> getWypozyczenia() {
		return wypozyczenia;
	}

	/**
	 * 
	 * @param wypozyczenia
	 */
	public void setWypozyczenia(List wypozyczenia) {
		// TODO - implement Rachunek.setWypozyczenia
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param wypozyczenie
	 */
	public void dodajDoRachunku(Wypozyczenie wypozyczenie) {
		wypozyczenia.add(wypozyczenie);
	}

	public boolean getCzyZaplacone() {
		return this.czyZaplacone;
	}

	/**
	 * 
	 * @param czyZaplacone
	 */
	public void setCzyZaplacone(boolean czyZaplacone) {
		this.czyZaplacone = czyZaplacone;
	}

}