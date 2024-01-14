import mockit.Expectations;
import mockit.VerificationsInOrder;
import org.example.Main;
import org.example.Model.Plyta;
import org.example.Model.Rezerwacja;
import org.example.Model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.text.ParseException;
import java.util.IllegalFormatCodePointException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

//@Tag("")
public class MainTest implements TestExecutionExceptionHandler {
    static Dane dane;
    static Main main;
    @BeforeAll
    public static void setUpClass() throws ParseException {
        dane = new Dane();
    }

    static Stream<Object[]> parametersProvider() {
        return Stream.of(
                new Object[]{dane.rezerwacje[1], null, null},
                new Object[]{null, dane.plyty[1], dane.uzytkownicy[2]},
                new Object[]{dane.rezerwacje[2], dane.plyty[1], dane.uzytkownicy[2]},
                new Object[]{dane.rezerwacje[1], null, dane.uzytkownicy[2]}
        );
    }
    @Tag("Dodawanie")
    @ParameterizedTest()
    @MethodSource("parametersProvider")
    @ExtendWith(MainTest.class)
    public void testdodajWypozyczenie(Rezerwacja rezerwacja, Plyta plyta, User user) {
        int liczbaWypozyczen = main.wypozyczenia.size();
        main.dodajWypozyczenie(rezerwacja, plyta, user);
        assertEquals(liczbaWypozyczen + 1, main.wypozyczenia.size());

        if (rezerwacja != null) {
            assertEquals(rezerwacja.getStatus(), Rezerwacja.Status.Zrealizowana);
            assertEquals(rezerwacja.getPlyta().getStatus(), Plyta.Status.Wypozyczona);
            if (rezerwacja.getPlyta() != plyta) {
                assertNotEquals(main.wypozyczenia.get(liczbaWypozyczen).getPlyta(), plyta);
            }
            if (rezerwacja.getRezerwujacy() != user) {
                assertNotEquals(main.wypozyczenia.get(liczbaWypozyczen).getWypozyczajacy(), user);
            }
        }
        else {
            assertEquals(plyta.getStatus(), Plyta.Status.Wypozyczona);
        }

    }

    @Tag("Dodawanie")
    @Test
    @ExtendWith(MainTest.class)
    public void testdodajDoRachunku() {
        for (int i = 0; i < dane.wypozyczenia.length; i++) {
            int liczbaRachunkow = main.rachunki.size();
            if (main.rachunek == null) {
                main.dodajDoRachunku(dane.wypozyczenia[i]);
                assertNotNull(main.rachunek);
            }
            else {
                main.dodajDoRachunku(dane.wypozyczenia[i]);
                assertEquals(liczbaRachunkow, main.rachunki.size());
            }
            assertNotEquals(main.rachunek.getWypozyczenia().indexOf(dane.wypozyczenia[i]), -1);
        }
    }

    @Tag("Usuwanie")
    @Test
    @ExtendWith(MainTest.class)
    public void testusunFilm() {
        dane.changePlytaStatus();

        Plyta plyta;

        for (int j = 0; j < dane.uzytkownicy.length; j++) {
            main.zalogowanyUzytkownik = dane.uzytkownicy[j];
            for (int i = 0; i < dane.plyty.length; i++) {
                plyta = dane.plyty[i];
                Plyta.Status staryStatus = plyta.getStatus();

                main.usunFilm(plyta);
                if (staryStatus == Plyta.Status.Dostepna) {
                    if (main.zalogowanyUzytkownik.getCzyPracownik()) {
                        assertEquals(plyta.getStatus(), Plyta.Status.Niedostepna);
                    }
                    else {
                        assertEquals(plyta.getStatus(), Plyta.Status.Dostepna);
                    }
                }
                if (staryStatus == Plyta.Status.Wypozyczona) {
                    assertEquals(plyta.getStatus(), Plyta.Status.Wypozyczona);
                }
                if (staryStatus == Plyta.Status.Zarezerwowana) {
                    assertEquals(plyta.getStatus(), Plyta.Status.Zarezerwowana);
                }
                if (staryStatus == Plyta.Status.Niedostepna) {
                    assertEquals(plyta.getStatus(), Plyta.Status.Niedostepna);
                }
            }
        }
    }




    @Override
    public void handleTestExecutionException(ExtensionContext extensionContext, Throwable throwable) throws Throwable {
        if (throwable instanceof IllegalFormatCodePointException) { }
        else throw throwable;
    }
}
