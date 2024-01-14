import org.example.Model.Plyta;
import org.example.Model.Rezerwacja;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

import java.text.ParseException;
import java.util.IllegalFormatCodePointException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("Status")
public class RezerwacjaTest implements TestExecutionExceptionHandler {
    Dane dane;
    @BeforeEach
    public void setUp() throws ParseException {
        dane = new Dane();
        dane.changeRezerwacjaStatus();
    }

    @Test
    @ExtendWith(RezerwacjaTest.class)
    public void testSetStatusZrealizowana() {
        Rezerwacja rezerwacja;
        for (int i = 0; i < dane.rezerwacje.length; i++) {
            rezerwacja = dane.rezerwacje[i];
            Rezerwacja.Status staryStatus = rezerwacja.getStatus();
            rezerwacja.setStatus(Rezerwacja.Status.Zrealizowana);
            if (staryStatus == Rezerwacja.Status.Aktywna) {
                assertEquals(rezerwacja.getStatus(), Rezerwacja.Status.Zrealizowana);
                assertEquals(rezerwacja.getPlyta().getStatus(), Plyta.Status.Wypozyczona);
            }
            if (staryStatus == Rezerwacja.Status.Anulowana) {
                assertEquals(rezerwacja.getStatus(), Rezerwacja.Status.Anulowana);
            }
            if (staryStatus == Rezerwacja.Status.Zrealizowana) {
                assertEquals(rezerwacja.getStatus(), Rezerwacja.Status.Zrealizowana);

            }

        }

    }

    @Test
    @ExtendWith(RezerwacjaTest.class)
    public void testSetStatusAnulowana() {
        Rezerwacja rezerwacja;
        for (int i = 0; i < dane.rezerwacje.length; i++) {
            rezerwacja = dane.rezerwacje[i];
            Rezerwacja.Status staryStatus = rezerwacja.getStatus();
            rezerwacja.setStatus(Rezerwacja.Status.Anulowana);
            if (staryStatus == Rezerwacja.Status.Aktywna) {
                assertEquals(rezerwacja.getStatus(), Rezerwacja.Status.Anulowana);
                assertEquals(rezerwacja.getPlyta().getStatus(), Plyta.Status.Dostepna);
            }
            if (staryStatus == Rezerwacja.Status.Anulowana) {
                assertEquals(rezerwacja.getStatus(), Rezerwacja.Status.Anulowana);
            }
            if (staryStatus == Rezerwacja.Status.Zrealizowana) {
                assertEquals(rezerwacja.getStatus(), Rezerwacja.Status.Zrealizowana);
            }

        }

    }

    @Override
    public void handleTestExecutionException(ExtensionContext extensionContext, Throwable throwable) throws Throwable {
        if (throwable instanceof IllegalFormatCodePointException) { }
        else throw throwable;
    }

}
