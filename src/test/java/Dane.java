import org.example.Model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Dane {
    public Plyta plyty[] = {
            new Plyta("Szklana pułapka", Plyta.Gatunek.Akcja, "John McTiernan", 20.50f),
            new Plyta("Terminator", Plyta.Gatunek.Akcja, "James Cameron", 20.50f),
            new Plyta("Egzorcysta", Plyta.Gatunek.Horror, "William Friedkin", 24.50f),
            new Plyta("Coś", Plyta.Gatunek.Horror, "John Carpenter", 24.50f),
            new Plyta("Blues brothers", Plyta.Gatunek.Komedia, "John Landis", 27.50f),
            new Plyta("Święty Graal", Plyta.Gatunek.Komedia, "Terry Gilliam", 27.50f)
    };

    public Dane() throws ParseException {
    }

    public void changePlytaStatus() {
        for (int i = 0; i < plyty.length; i++) {
            if (i % 3 == 1) {
                plyty[i].setStatus(Plyta.Status.Wypozyczona);
            }
            if (i % 3 == 2) {
                plyty[i].setStatus(Plyta.Status.Zarezerwowana);
            }
        }
    }
    public User uzytkownicy[] = {
            new User("Jan", "Kowalski", "janko123", "Wroclaw", "haslo123", "janko@gmial.com", false),
            new User("Mariusz", "Nowak", "marny321", "Wroclaw", "haslo321", "mnowak@gmial.com", false),
            new User("Michał", "Kowalski", "michal.kowal", "Wroclaw", "h45lo", "kowal.michal@gmial.com", true),

    };
    private String pattern = "yyyy-mm-dd hh:mm:ss";
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    public Rezerwacja rezerwacje[] = {
            new Rezerwacja(plyty[2], simpleDateFormat.parse("2024-01-14 17:30:32"), uzytkownicy[1]),
            new Rezerwacja(plyty[5], simpleDateFormat.parse("2024-01-14 17:31:52"), uzytkownicy[1]),
            new Rezerwacja(plyty[4], simpleDateFormat.parse("2023-12-18 20:42:27"), uzytkownicy[2]),
            new Rezerwacja(plyty[1], simpleDateFormat.parse("2024-01-10 12:30:02"), uzytkownicy[1])
    };

    public void changeRezerwacjaStatus() {
        for (int i = 0; i < rezerwacje.length; i++) {
            rezerwacje[i].getPlyta().zarezerwuj();
            if (i % 3 == 1) {
                rezerwacje[i].setStatus(Rezerwacja.Status.Anulowana);
                rezerwacje[i].getPlyta().anulujRezerwacje();
            }
            if (i % 3 == 2) {
                rezerwacje[i].setStatus(Rezerwacja.Status.Zrealizowana);
                rezerwacje[i].getPlyta().wypozycz();
            }
        }
    }
    public Wypozyczenie wypozyczenia[] = {
            new Wypozyczenie(plyty[0], uzytkownicy[1]),
            new Wypozyczenie(plyty[3], uzytkownicy[1]),
            new Wypozyczenie(plyty[4], uzytkownicy[2])
    };

    public void changeWypozyczenieStatus() {
        for (int i = 0; i < wypozyczenia.length; i++) {
            wypozyczenia[i].getPlyta().wypozycz();
            if (i % 3 == 1) {
                wypozyczenia[i].setStatus(Wypozyczenie.Status.Anulowane);
                wypozyczenia[i].getPlyta().anulujWypozyczenie();
            }
            if (i % 3 == 2) {
                wypozyczenia[i].setStatus(Wypozyczenie.Status.Zrealizowane);
                wypozyczenia[i].getPlyta().anulujWypozyczenie();
            }
        }
    }
}
