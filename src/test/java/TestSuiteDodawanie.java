import org.junit.platform.suite.api.*;

@Suite
@IncludeTags("Dodawanie")
//@SelectPackages()
@SelectClasses({MainTest.class, PlytaTest.class, RezerwacjaTest.class, WypozyczenieTest.class})
public class TestSuiteDodawanie {

}
