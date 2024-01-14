package org.example.Model;

public class Plyta {

	private int id;
	private String tytul;
	private Gatunek gatunek;
	private String rezyser;
	private float cena;
	private Status status;

	/**
	 * 
	 * @param tytul
	 * @param gatunek
	 * @param rezyser
	 * @param cena
	 */
	public Plyta(String tytul, Gatunek gatunek, String rezyser, float cena) {
		this.tytul = tytul;
		this.gatunek = gatunek;
		this.rezyser = rezyser;
		this.cena = cena;
		status = Status.Dostepna;
	}

	public Status getStatus() {
		return this.status;
	}

	/**
	 * 
	 * @param status
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	public void zmienCene(float kwota) {
		if (status == Status.Dostepna)
		cena = kwota;
	}

	public void anulujRezerwacje() {
		if (status == Status.Zarezerwowana)
			status = Status.Dostepna;
	}
	public void anulujWypozyczenie() {
		if (status == Status.Wypozyczona)
			status = Status.Dostepna;
	}
	public void wypozycz() {
		if (status == Status.Dostepna || status == Status.Zarezerwowana)
			status = Status.Wypozyczona;
	}
	public void zarezerwuj() {
		if (status == Status.Dostepna)
			status = Status.Zarezerwowana;
	}

	public enum Gatunek {
		Horror,
		Komedia,
		Akcja,
		literal
	}
	public enum Status {
		Dostepna,
		Zarezerwowana,
		Wypozyczona,
		Niedostepna
	}

}