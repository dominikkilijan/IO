import org.junit.platform.suite.api.*;

@Suite
@IncludeTags("Usuwanie")
//@SelectPackages()
@SelectClasses({MainTest.class, PlytaTest.class, RezerwacjaTest.class, WypozyczenieTest.class})
public class TestSuiteUsuwanie {

}