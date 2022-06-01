package by.khadasevich.task01calculator.service;

import by.khadasevich.task01calculator.vto.Result;

public interface Calculation {
    /**
     * Does arithmetic calculation according OperationName,
     * with two double arguments.
     * @param firstArgument is double value for calculation
     * @param secondArgument is double value for calculation
     * @param operation is type of operation
     * @return result of calculation
     */
    Result calculate(double firstArgument, double secondArgument,
                     OperationName operation);
}
