package org.example.Model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Rezerwacja {

	private int id;
	private Date data;
	private User rezerwujacy;
	private Plyta plyta;
	private Status status;

	public User getRezerwujacy() {
		return rezerwujacy;
	}

	public Plyta getPlyta() {
		return plyta;
	}

	public void setStatus(Status nowyStatus) {
		if (status == Status.Aktywna && nowyStatus == Status.Zrealizowana) {
			status = Status.Zrealizowana;
			plyta.wypozycz();
		}
		if (status == Status.Aktywna && nowyStatus == Status.Anulowana) {
			status = Status.Anulowana;
			plyta.anulujRezerwacje();
		}
	}

	public Status getStatus() {
		return status;
	}



	public enum Status {
		Aktywna,
		Anulowana,
		Zrealizowana
	}

	/**
	 * 
	 * @param plyta
	 * @param data
	 * @param rezerwujacy
	 */
	public Rezerwacja(Plyta plyta, Date data, User rezerwujacy) {
		this.plyta = plyta;
		this.data = data;
		this.rezerwujacy = rezerwujacy;
		status = Status.Aktywna;
	}

}
