package org.example.Model;

public class User {

	private String imie;
	private String nazwisko;
	private String nick;

	public User(String imie, String nazwisko, String nick, String adres, String haslo, String email, boolean czyPracownik) {
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.nick = nick;
		this.adres = adres;
		this.haslo = haslo;
		this.email = email;
		this.czyPracownik = czyPracownik;
	}

	private String adres;
	private String haslo;
	private String email;
	private boolean czyPracownik;


	public String getImie() {
		return this.imie;
	}


	public String getNick() {
		return this.nick;
	}
	/**
	 * 
	 * @param imie
	 */
	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return this.nazwisko;
	}

	/**
	 * 
	 * @param nazwisko
	 */
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getAdres() {
		return this.adres;
	}

	/**
	 * 
	 * @param adres
	 */
	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getEmail() {
		return this.email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public String getHaslo() {
		return this.haslo;
	}

	/**
	 * 
	 * @param haslo
	 */
	public void setHaslo(String haslo) {
		this.haslo = haslo;
	}

	public boolean getCzyPracownik() {
		return this.czyPracownik;
	}

	/**
	 * 
	 * @param czyPracownik
	 */
	public void setCzyPracownik(boolean czyPracownik) {
		this.czyPracownik = czyPracownik;
	}

}