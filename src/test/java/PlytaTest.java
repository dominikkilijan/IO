import org.example.Model.Plyta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

import java.text.ParseException;
import java.util.IllegalFormatCodePointException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("Entity")
@Tag("Control")
@Tag("Status")
public class PlytaTest implements TestExecutionExceptionHandler {
    Dane dane;
    @BeforeEach
    public void setUp() throws ParseException {
        dane = new Dane();
        dane.changePlytaStatus();
    }
    @Test
    @ExtendWith(PlytaTest.class)
    public void testZarezerwuj() {
        Plyta plyta;
        for (int i = 0; i < dane.plyty.length; i++) {
            plyta = dane.plyty[i];
            Plyta.Status staryStatus = plyta.getStatus();
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

        }

    }
    @Test
    @ExtendWith(PlytaTest.class)
    public void testAnulujWypozycznie() {
        Plyta plyta;
        for (int i = 0; i < dane.plyty.length; i++) {
            plyta = dane.plyty[i];
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

        }
    }

    @Override
    public void handleTestExecutionException(ExtensionContext extensionContext, Throwable throwable) throws Throwable {
        if (throwable instanceof IllegalFormatCodePointException) { }
        else throw throwable;
    }
}
