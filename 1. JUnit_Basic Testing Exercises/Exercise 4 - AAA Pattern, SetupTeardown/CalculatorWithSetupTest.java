import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorWithSetupTest {

    private Calculator calc;

    // Setup before each test
    @Before
    public void setUp() {
        calc = new Calculator();
        System.out.println("Setup done");
    }

    // Teardown after each test
    @After
    public void tearDown() {
        System.out.println("Test finished");
    }

    @Test
    public void testAdd() {
        // Arrange
        int a = 10, b = 5;

        // Act
        int result = calc.add(a, b);

        // Assert
        assertEquals(15, result);
    }

    @Test
    public void testSubtract() {
        int result = calc.subtract(10, 5);
        assertEquals(5, result);
    }
}
