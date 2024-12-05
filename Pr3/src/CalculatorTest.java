import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testAddition() {
        Calculator calculator = new Calculator();
        double result = calculator.add(10, 5);
        assertEquals(15, result, 0.001);
    }

    @Test
    public void testSubtraction() {
        Calculator calculator = new Calculator();
        double result = calculator.subtract(10, 5);
        assertEquals(5, result, 0.001);
    }

    @Test
    public void testMultiplication() {
        Calculator calculator = new Calculator();
        double result = calculator.multiply(10, 5);
        assertEquals(50, result, 0.001);
    }

    @Test
    public void testDivision() {
        Calculator calculator = new Calculator();
        double result = calculator.divide(10, 5);
        assertEquals(2, result, 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void testDivisionByZero() {
        Calculator calculator = new Calculator();
        calculator.divide(10, 0); // Should throw ArithmeticException
    }
}
