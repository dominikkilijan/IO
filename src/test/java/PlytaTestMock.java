import mockit.*;
import org.example.Model.Plyta;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlytaTestMock {

    @Injectable
    Plyta plyta2;

    @Injectable
    String tytul, rezyser;

    @Injectable
    Plyta.Gatunek gatunek;

    @Injectable
    float cena;

    @Tested
    private Plyta plyta = new Plyta(tytul, gatunek, rezyser, cena);

    @Test
    public void testZarezerwuj() {
        //plyta = new Plyta(tytul, gatunek, rezyser, cena);

        Plyta.Status staryStatus = plyta.getStatus();

//        new Expectations(plyta) {{
//            plyta.getStatus();
//            result = Plyta.Status.Zarezerwowana;
//        }};

        plyta.zarezerwuj();

        if (staryStatus == Plyta.Status.Dostepna) {
            assertEquals(plyta.getStatus(), Plyta.Status.Zarezerwowana);
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

        new VerificationsInOrder() {
            {
                plyta.getStatus(); maxTimes = 2;
                plyta.zarezerwuj(); maxTimes = 1;
            }};
    }

    @Test
    public void testanulujWypozyczenie() {

        Plyta.Status staryStatus = plyta.getStatus();

        plyta.anulujWypozyczenie();
        if (staryStatus == Plyta.Status.Wypozyczona) {
            assertEquals(plyta.getStatus(), Plyta.Status.Dostepna);
        }
        if (staryStatus == Plyta.Status.Dostepna) {
            assertEquals(plyta.getStatus(), Plyta.Status.Dostepna);
        }
        if (staryStatus == Plyta.Status.Zarezerwowana) {
            assertEquals(plyta.getStatus(), Plyta.Status.Zarezerwowana);
        }
        if (staryStatus == Plyta.Status.Niedostepna) {
            assertEquals(plyta.getStatus(), Plyta.Status.Niedostepna);
        }

        new VerificationsInOrder() {
            {
                plyta.getStatus(); maxTimes = 2;
                plyta.anulujWypozyczenie(); maxTimes = 1;
            }};
    }
}