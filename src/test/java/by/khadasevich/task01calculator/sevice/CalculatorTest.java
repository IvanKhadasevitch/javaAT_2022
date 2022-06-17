package by.khadasevich.task01calculator.sevice;

import by.khadasevich.task01calculator.service.Calculator;
import by.khadasevich.task01calculator.service.OperationName;
import by.khadasevich.task01calculator.vto.Result;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.offset;

@Execution(ExecutionMode.CONCURRENT)
public class CalculatorTest {
    private final Calculator calculator = Calculator.getInstance();

    @ParameterizedTest
    @CsvSource(value = {"1;2;3", "1.3;2.4;3.7", "0;2.4;2.4"}, delimiter = ';')
    @DisplayName("Test simple addition of two double values")
    public void testSimpleAddition(double argumentOne, double argumentTwo,
                                   double result) {
        Result actualResult = calculator.calculate(argumentOne, argumentTwo,
                OperationName.PLUS);
        SoftAssertions soft = new SoftAssertions();
        soft.assertThat(result).as("Result of addition two double not correct")
                .isEqualTo(actualResult.getValue());
        soft.assertThat(actualResult.getMessage())
                .as("Result message doesn't have operation title")
                .contains(OperationName.PLUS.getTitle());
        soft.assertAll();
    }

    @Test
    @DisplayName("Add two max double, expected result out of double range.")
    public void testAdditionTwoMaxDouble_resultOutOfDoubleRange() {
        Result actualResult = calculator.calculate(Double.MAX_VALUE,
                Double.MAX_VALUE, OperationName.PLUS);
        SoftAssertions soft =  new SoftAssertions();
        soft.assertThat(actualResult.getValue())
                .as("Sum of two max double isn't out of double range.")
                .isInfinite();
        soft.assertThat(actualResult.getMessage())
                .as("Result message doesn't have: 'out of double range'")
                .contains("out of double range");
        soft.assertAll();
    }

    @ParameterizedTest
    @CsvSource(value = {"2;1;1", "2.4;1.3;1.1", "0;2.4;-2.4"}, delimiter = ';')
    @DisplayName("Test simple subtraction of two double values")
    public void testSimpleSubtraction(double argumentOne, double argumentTwo,
                                   double result) {
        Result actualResult = calculator.calculate(argumentOne, argumentTwo,
                OperationName.MINUS);
        SoftAssertions soft = new SoftAssertions();
        soft.assertThat(result)
                .as("Result of subtraction two double not correct")
                .isEqualTo(actualResult.getValue(), offset(0.01));
        soft.assertThat(actualResult.getMessage())
                .as("Result message doesn't have operation title")
                .contains(OperationName.MINUS.getTitle());
        soft.assertAll();
    }

    @Test
    @DisplayName("-Double.MAX_VALUE - Double.MAX_VALUE," +
            " expected result out of double range.")
    public void testSubtractionTwoMaxDouble_resultOutOfDoubleRange() {
        Result actualResult = calculator.calculate(-Double.MAX_VALUE,
                Double.MAX_VALUE, OperationName.MINUS);
        SoftAssertions soft =  new SoftAssertions();
        soft.assertThat(actualResult.getValue())
                .as("-Double.MAX_VALUE - Double.MAX_VALUE" +
                        " isn't out of double range.")
                .isInfinite();
        soft.assertThat(actualResult.getMessage())
                .as("Result message doesn't have: 'out of double range'")
                .contains("out of double range");
        soft.assertAll();
    }

    @ParameterizedTest
    @CsvSource(value = {"2;1;2", "2.4;1.3;3.12", "0;2.4;0"}, delimiter = ';')
    @DisplayName("Test simple multiplication of two double values")
    public void testSimpleMultiplication(double argumentOne, double argumentTwo,
                                      double result) {
        Result actualResult = calculator.calculate(argumentOne, argumentTwo,
                OperationName.MULTIPLY);
        SoftAssertions soft = new SoftAssertions();
        soft.assertThat(result)
                .as("Result of multiplication two double not correct")
                .isEqualTo(actualResult.getValue(), offset(0.001));
        soft.assertThat(actualResult.getMessage())
                .as("Result message doesn't have operation title")
                .contains(OperationName.MULTIPLY.getTitle());
        soft.assertAll();
    }

    @Test
    @DisplayName("Multiply Double.MAX_VALUE on ten," +
            " expected result out of double range.")
    public void testMultiplyMaxDoubleOnTen_resultOutOfDoubleRange() {
        Result actualResult = calculator.calculate(Double.MAX_VALUE,10,
                OperationName.MULTIPLY);
        SoftAssertions soft =  new SoftAssertions();
        soft.assertThat(actualResult.getValue())
                .as("Multiply Double.MAX_VALUE on ten" +
                        " isn't out of double range.")
                .isInfinite();
        soft.assertThat(actualResult.getMessage())
                .as("Result message doesn't have: 'out of double range'")
                .contains("out of double range");
        soft.assertAll();
    }

    @ParameterizedTest
    @CsvSource(value = {"3;2;1.5", "2.4;0.6;4", "3;0.5;6"}, delimiter = ';')
    @DisplayName("Test simple division of two double values")
    public void testSimpleDivision(double argumentOne, double argumentTwo,
                                         double result) {
        Result actualResult = calculator.calculate(argumentOne, argumentTwo,
                OperationName.DIVIDE);
        SoftAssertions soft = new SoftAssertions();
        soft.assertThat(result)
                .as("Result of division two double not correct")
                .isEqualTo(actualResult.getValue(), offset(0.001));
        soft.assertThat(actualResult.getMessage())
                .as("Result message doesn't have operation title")
                .contains(OperationName.DIVIDE.getTitle());
        soft.assertAll();
    }

    @ParameterizedTest
    @CsvSource(value = {"3;0", "-2.4;0"}, delimiter = ';')
    @DisplayName("Divide constant on nul," +
            " expected result out of double range - Infinity.")
    public void testDivideConstantOnNul_resultOutOfDoubleRangeInfinity(
            double argumentOne, double argumentTwo) {
        Result actualResult = calculator.calculate(argumentOne,argumentTwo,
                OperationName.DIVIDE);
        SoftAssertions soft =  new SoftAssertions();
        soft.assertThat(actualResult.getValue())
                .as("Divide constant on nul" +
                        " isn't out of double range.")
                .isInfinite();
        soft.assertThat(actualResult.getMessage())
                .as("Result message doesn't have: 'out of double range'")
                .contains("out of double range");
        soft.assertAll();
    }

    @Test
    @DisplayName("Divide zero on zero," +
            " expected result out of double range - NaN.")
    public void testDivideZeroOnZero_resultOutOfDoubleRangeNaN() {
        Result actualResult = calculator.calculate(0,0,
                OperationName.DIVIDE);
        SoftAssertions soft =  new SoftAssertions();
        soft.assertThat(actualResult.getValue())
                .as("Divide zero on zero" +
                        " isn't out of double range - NaN.")
                .isNaN();
        soft.assertThat(actualResult.getMessage())
                .as("Result message doesn't have: 'out of double range'")
                .contains("out of double range");
        soft.assertAll();
    }

    @Test
    @DisplayName("Test calculation when operation is null," +
            " expected result out of double range - NaN.")
    public void testCalculationAsOperationIsNull_resultOutOfDoubleRangeNaN() {
        Result actualResult = calculator.calculate(1,1,
                null);
        SoftAssertions soft =  new SoftAssertions();
        soft.assertThat(actualResult.getValue())
                .as("Result of calculation when operation is null" +
                        " isn't out of double range - NaN.")
                .isNaN();
        soft.assertThat(actualResult.getMessage())
                .as("Result message doesn't have: 'operation not defined'")
                .contains("operation not defined");
        soft.assertAll();
    }
}
