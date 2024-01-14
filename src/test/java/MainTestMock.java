import mockit.*;
import org.example.Main;
import org.example.Model.Plyta;
import org.example.Model.Rezerwacja;
import org.example.Model.User;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.example.Model.Wypozyczenie;
import org.example.Model.Rachunek;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

public class MainTestMock {
    @Tested
    private Main main;

    @Injectable
    private Rezerwacja rezerwacja;

    @Injectable
    private Plyta plyta;

    @Injectable
    private User user;

    @Injectable
    Wypozyczenie wypozyczenie1, wypozyczenie2, wypozyczenie3;

    @Injectable
    Plyta plyta1, plyta2, plyta3;

    @Injectable
    User user1, user2, user3;

    @Injectable
    private Rachunek rachunek;

    @Test
    public void testdodajWypozyczenie() {
        int liczbaWypozyczen = main.wypozyczenia.size();

        new Expectations() {{
            rezerwacja.getStatus();
            result = Rezerwacja.Status.Zrealizowana;
            plyta.getStatus();
            result = Plyta.Status.Wypozyczona;
            rezerwacja.getPlyta();
            result = plyta;
            rezerwacja.getRezerwujacy();
            result = user;
        }};

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
        } else {
            assertEquals(plyta.getStatus(), Plyta.Status.Wypozyczona);
        }
        new VerificationsInOrder() {
            {
                rezerwacja.getStatus();
                maxTimes = 1;
                plyta.getStatus();
                maxTimes = 1;
                rezerwacja.getPlyta();
                maxTimes = 1;
                rezerwacja.getRezerwujacy();
                maxTimes = 1;
            }
        };
    }


    @Test
    public void testdodajDoRachunku() {
        final Wypozyczenie wypozyczenia[] = {wypozyczenie1, wypozyczenie2, wypozyczenie3};
        for (int i = 0; i < wypozyczenia.length; i++) {
            int j = i;
            int liczbaRachunkow = main.rachunki.size();
            if (main.rachunek == null) {
                new Expectations() {{
                    main.dodajDoRachunku(wypozyczenia[j]);
                    assertNotNull(main.rachunek);
                }};
            }
            else {
                new Expectations() {{
                    main.dodajDoRachunku(wypozyczenia[j]);
                    assertEquals(liczbaRachunkow, main.rachunki.size());
                }};
            }
            assertNotEquals(main.rachunek.getWypozyczenia().indexOf(wypozyczenia[i]), -1);
        }
    }
}