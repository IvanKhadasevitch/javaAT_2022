package by.khadasevich.task01calculator.service;

import by.khadasevich.task01calculator.vto.Result;

import static by.khadasevich.task01calculator.service.OperationName.*;

/**
 * Makes arithmetic calculation with actions
 * determined in OperationName.
 */
public final class Calculator implements Calculation {
    /**
     * Singleton instance of Calculator.
     */
    public static final Calculator INSTANCE = new Calculator();
    private Calculator() { }
    /**
     * Get Calculator as singleton.
     * @return instance of Calculator.
     */
    public static Calculator getInstance() {
        return INSTANCE;
    }

    /**
     * Adds up two double numbers.
     * @param firstArgument is value for addition
     * @param secondArgument is value for addition
     * @return result of addition two arguments
     */
    public Result add(final double firstArgument, final double secondArgument) {
        double additionResult = firstArgument + secondArgument;
        if (Double.valueOf(additionResult).isInfinite()
                || Double.valueOf(additionResult).isNaN()) {
            return new Result("Result of addition out of double range",
                    additionResult);
        } else {
            return formCalculationResult(firstArgument, secondArgument,
                    PLUS, additionResult);
        }
    }
    /**
     * Subtract two double numbers.
     * @param firstArgument is minuend
     * @param secondArgument is subtrahend
     * @return result of subtraction two arguments
     */
    public Result subtract(final double firstArgument,
                           final double secondArgument) {
        double subtractionResult = firstArgument - secondArgument;
        if (Double.valueOf(subtractionResult).isInfinite()
                || Double.valueOf(subtractionResult).isNaN()) {
            return new Result("Result of subtraction out of double range",
                    subtractionResult);
        } else {
            return formCalculationResult(firstArgument, secondArgument,
                    MINUS, subtractionResult);
        }
    }
    /**
     * Multiply two double numbers.
     * @param firstArgument is value for multiplication
     * @param secondArgument is value for multiplication
     * @return result of multiplication two arguments
     */
    public Result multiply(final double firstArgument,
                           final double secondArgument) {
        double multiplicationResult = firstArgument * secondArgument;
        if (Double.valueOf(multiplicationResult).isInfinite()
                || Double.valueOf(multiplicationResult).isNaN()) {
            return new Result("Result of multiplication out of double range",
                    multiplicationResult);
        } else {
            return formCalculationResult(firstArgument, secondArgument,
                    MULTIPLY, multiplicationResult);
        }
    }
    /**
     * Divide two double numbers.
     * @param firstArgument is dividend
     * @param secondArgument is divider
     * @return result of division two arguments
     */
    public Result divide(final double firstArgument,
                         final double secondArgument) {
        double divisionResult = firstArgument / secondArgument;
        if (Double.valueOf(divisionResult).isInfinite()
                || Double.valueOf(divisionResult).isNaN()) {
            return new Result("Result of division out of double range",
                    divisionResult);
        } else {
            return formCalculationResult(firstArgument, secondArgument,
                    DIVIDE, divisionResult);
        }
    }
    /**
     * Does arithmetic calculation according OperationName.
     * @param firstArgument is double value for calculation
     * @param secondArgument is double value for calculation
     * @param operation is type of operation
     * @return
     */
    @Override
    public Result calculate(final double firstArgument,
                            final double secondArgument,
                            final OperationName operation) {
        return switch (operation) {
            case PLUS -> this.add(firstArgument, secondArgument);
            case MINUS -> this.subtract(firstArgument, secondArgument);
            case MULTIPLY -> this.multiply(firstArgument, secondArgument);
            case DIVIDE -> this.divide(firstArgument, secondArgument);
        };
    }
    private Result formCalculationResult(final double firstArgument,
                                         final double secondArgument,
                                         final OperationName operation,
                                         final double result) {
        StringBuilder message = new StringBuilder();
        message.append(firstArgument)
                .append(" ")
                .append(operation.getTitle())
                .append(" ")
                .append(secondArgument)
                .append(" is:");
        return new Result(message.toString(), result);
    }
}
