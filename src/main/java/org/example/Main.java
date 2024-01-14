package org.example;

import java.util.*;
import org.example.Model.*;

public class Main {

	private static List<Plyta> plyty = new ArrayList<>();
	public static List<Rachunek> rachunki = new ArrayList<>();
	private static List<User> uzytkownicy = new ArrayList<>();
	public static List<Rezerwacja> rezerwacje = new ArrayList<>();
	public static List<Wypozyczenie> wypozyczenia = new ArrayList<>();
	public static User zalogowanyUzytkownik;
	public static Rachunek rachunek;

	public static void main(String[] args) {
		// TODO - implement Main.main

		while (true) {
			logowanie();
		}


	}

	/**
	 * 
	 * @param plyta
	 */
	public static void zmienStatusPlyty(Plyta plyta) {
		// TODO - implement Main.zmienStatusPlyty
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param plyta
	 */
	public static Rezerwacja utworzRezerwacje(Plyta plyta) {
		// TODO - implement Main.utworzRezerwacje
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param rezerwacja
	 * @param plyta
	 * @param klient
	 */
	public static void dodajWypozyczenie(Rezerwacja rezerwacja, Plyta plyta, User klient) {
		Wypozyczenie wypozyczenie = null;
		if (rezerwacja != null) {
			wypozyczenie = new Wypozyczenie(rezerwacja);

			rezerwacja.setStatus(Rezerwacja.Status.Zrealizowana);
		}
		else {
			Plyta.Status status = plyta.getStatus();
			if (status == Plyta.Status.Dostepna) {
				plyta.setStatus(Plyta.Status.Wypozyczona);
				wypozyczenie = new Wypozyczenie(plyta, klient);

			}

		}
		if (wypozyczenie != null) {
			wypozyczenia.add(wypozyczenie);
			dodajDoRachunku(wypozyczenie);
		}

	}

	/**
	 * 
	 * @param wypozyczenie
	 */
	public static void usunWypozyczenie(Wypozyczenie wypozyczenie) {
		// TODO - implement Main.usunWypozyczenie
		throw new UnsupportedOperationException();
	}

	public static Rachunek utworzRachunek() {
		// TODO - implement Main.utworzRachunek
		throw new UnsupportedOperationException();
	}

	public static void wyswietlKatalog() {
		// TODO - implement Main.wyswietlKatalog
		throw new UnsupportedOperationException();
	}

	public static void wyswietlWypozyczenia() {
		// TODO - implement Main.wyswietlWypozyczenia
		throw new UnsupportedOperationException();
	}

	public static void wyswietlRezerwacje() {
		// TODO - implement Main.wyswietlRezerwacje
		throw new UnsupportedOperationException();
	}

	public static void wyswietlRachunki() {
		// TODO - implement Main.wyswietlRachunki
		throw new UnsupportedOperationException();
	}

	public static void dodajFilm() {
		// TODO - implement Main.dodajFilm
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param plyta
	 */
	public static void usunFilm(Plyta plyta) {
		if (zalogowanyUzytkownik.getCzyPracownik()) {
			if (plyta.getStatus() == Plyta.Status.Dostepna) {
				plyta.setStatus(Plyta.Status.Niedostepna);
			}
		}
	}

	public static void logowanie() {
		System.out.println("Czy masz juz konto? true - tak, false - nie");
		Scanner s = new Scanner(System.in);
		boolean czyZarejestrowany = Boolean.parseBoolean(s.nextLine());

		int nieudaneProby = 0;

		if (czyZarejestrowany == false) {
			rejestracja();
		}

		System.out.println("Logowanie:");
		do {
			System.out.println("Podaj nick");
			String nick = s.nextLine();

			System.out.println("Podaj haslo");
			String haslo = s.nextLine();

			zalogowanyUzytkownik = walidacjaLogowania(nick, haslo);
			nieudaneProby++;

		} while (zalogowanyUzytkownik == null && nieudaneProby < 4);
    }

	public static void rejestracja() {
		System.out.println("Rozpoczeto rejestracje");
		Scanner s = new Scanner(System.in);
		String nick;
		boolean czyZajetyNick;

		do {
			System.out.println("Podaj nick");
			nick = s.nextLine();
			czyZajetyNick = walidacjaRejestracji(nick);

		} while (czyZajetyNick == true);

		System.out.println("Podaj haslo");
		String haslo = s.nextLine();

		System.out.println("Podaj imie");
		String imie = s.nextLine();

		System.out.println("Podaj nazwisko");
		String nazwisko = s.nextLine();

		System.out.println("Podaj adres");
		String adres = s.nextLine();

		System.out.println("Podaj email");
		String email = s.nextLine();

		User nowyKlient = new User(imie, nazwisko, nick, adres, haslo, email, false);

		uzytkownicy.add(nowyKlient);
	}

	/**
	 * 
	 * @param wypozyczenie
	 */
	public static void dodajDoRachunku(Wypozyczenie wypozyczenie) {
		if (rachunek == null) {
			rachunek = new Rachunek();
			rachunki.add(rachunek);
		}
		rachunek.dodajDoRachunku(wypozyczenie);

	}

	/**
	 *
	 */
	public static void platnosc() {
		// TODO - implement Main.platnosc
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nick
	 * @param haslo
	 */
	public static User walidacjaLogowania(String nick, String haslo) {
		for (User uzytkownik : uzytkownicy) {
			String tempNick = uzytkownik.getNick();
			String tempHaslo = uzytkownik.getHaslo();

			if (tempNick.equals(nick) && tempHaslo.equals(haslo)) {
					return uzytkownik;
				}
		}
		return null;
	}

	/**
	 * 
	 * @param nick
	 */
	public static boolean walidacjaRejestracji(String nick) {
		for (User uzytkownik : uzytkownicy) {
			String tempNick = uzytkownik.getNick();
			if (tempNick.equals(nick)) {
				System.out.println("nick zajety!");
				return true;
			}
		}
			return false;
	}

	public static void wyswietlMenuPracownika() {
		// TODO - implement Main.wyswietlMenuPracownika
		throw new UnsupportedOperationException();
	}

	public static void wyswietlMenuKlienta() {
		// TODO - implement Main.wyswietlMenuKlienta
		throw new UnsupportedOperationException();
	}

}