import org.junit.platform.suite.api.*;

@Suite
@IncludeTags("Status")
//@SelectPackages()
@SelectClasses({MainTest.class, PlytaTest.class, RezerwacjaTest.class, WypozyczenieTest.class})
public class TestSuiteStatus {

}