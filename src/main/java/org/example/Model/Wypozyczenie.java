package org.example.Model;

import java.util.Date;

public class Wypozyczenie {

	private int id;
	private Date data;

	public Plyta getPlyta() {
		return plyta;
	}

	private Plyta plyta;

	private Status status;

	private User wypozyczajacy;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status nowyStatus) {
		if (status == Wypozyczenie.Status.Aktywne && nowyStatus == Wypozyczenie.Status.Zrealizowane) {
			status = Wypozyczenie.Status.Zrealizowane;
			plyta.anulujWypozyczenie();
		}
		if (status == Wypozyczenie.Status.Aktywne && nowyStatus == Wypozyczenie.Status.Anulowane) {
			status = Wypozyczenie.Status.Anulowane;
			plyta.anulujWypozyczenie();
		}
	}




	public User getWypozyczajacy() {
		return wypozyczajacy;
	}

	/**
	 * 
	 * @param rezerwacja
	 */
	public Wypozyczenie(Rezerwacja rezerwacja) {
		plyta = rezerwacja.getPlyta();
		wypozyczajacy = rezerwacja.getRezerwujacy();
	}

	/**
	 * 
	 * @param plyta
	 * @param wypozyczajacy
	 */
	public Wypozyczenie(Plyta plyta, User wypozyczajacy) {
		this.plyta = plyta;
		this.wypozyczajacy = wypozyczajacy;
		status = Status.Aktywne;
	}


	public enum Status {
		Aktywne,
		Anulowane,
		Zrealizowane
	}
}