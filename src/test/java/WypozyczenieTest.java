import org.example.Model.Plyta;
import org.example.Model.Wypozyczenie;
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
public class WypozyczenieTest implements TestExecutionExceptionHandler {
    Dane dane;
    @BeforeEach
    public void setUp() throws ParseException {
        dane = new Dane();
        dane.changeRezerwacjaStatus();
    }

    @Test
    @ExtendWith(RezerwacjaTest.class)
    public void testSetStatusZrealizowane() {
        Wypozyczenie wypozyczenie;
        for (int i = 0; i < dane.wypozyczenia.length; i++) {
            wypozyczenie = dane.wypozyczenia[i];
            Wypozyczenie.Status staryStatus = wypozyczenie.getStatus();
            wypozyczenie.setStatus(Wypozyczenie.Status.Zrealizowane);
            if (staryStatus == Wypozyczenie.Status.Aktywne) {
                assertEquals(wypozyczenie.getStatus(), Wypozyczenie.Status.Zrealizowane);
                assertEquals(wypozyczenie.getPlyta().getStatus(), Plyta.Status.Dostepna);
            }
            if (staryStatus == Wypozyczenie.Status.Anulowane) {
                assertEquals(wypozyczenie.getStatus(), Wypozyczenie.Status.Anulowane);
            }
            if (staryStatus == Wypozyczenie.Status.Zrealizowane) {
                assertEquals(wypozyczenie.getStatus(), Wypozyczenie.Status.Zrealizowane);

            }

        }

    }

    @Test
    @ExtendWith(RezerwacjaTest.class)
    public void testSetStatusAnulowane() {
        Wypozyczenie wypozyczenie;
        for (int i = 0; i < dane.wypozyczenia.length; i++) {
            wypozyczenie = dane.wypozyczenia[i];
            Wypozyczenie.Status staryStatus = wypozyczenie.getStatus();
            wypozyczenie.setStatus(Wypozyczenie.Status.Anulowane);
            if (staryStatus == Wypozyczenie.Status.Aktywne) {
                assertEquals(wypozyczenie.getStatus(), Wypozyczenie.Status.Anulowane);
                assertEquals(wypozyczenie.getPlyta().getStatus(), Plyta.Status.Dostepna);
            }
            if (staryStatus == Wypozyczenie.Status.Anulowane) {
                assertEquals(wypozyczenie.getStatus(), Wypozyczenie.Status.Anulowane);
            }
            if (staryStatus == Wypozyczenie.Status.Zrealizowane) {
                assertEquals(wypozyczenie.getStatus(), Wypozyczenie.Status.Zrealizowane);

            }

        }

    }




    @Override
    public void handleTestExecutionException(ExtensionContext extensionContext, Throwable throwable) throws Throwable {
        if (throwable instanceof IllegalFormatCodePointException) { }
        else throw throwable;
    }
}
