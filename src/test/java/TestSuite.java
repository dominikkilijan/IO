import org.junit.platform.suite.api.*;

@Suite
//@SelectPackages("Test")
@SelectClasses({MainTest.class, PlytaTest.class, RezerwacjaTest.class, WypozyczenieTest.class})
public class TestSuite {

}
