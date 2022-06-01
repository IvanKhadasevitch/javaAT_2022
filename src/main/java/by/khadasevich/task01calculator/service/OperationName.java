package by.khadasevich.task01calculator.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Describe all possible operation of Calculation.
 * It Defines displayed name of calculation for user,
 * and it's hot keys.
 */
@Getter
@AllArgsConstructor
public enum OperationName {
    /**
     * Plus operation means addition.
     */
    PLUS("plus", '+'),
    /**
     * Minus operation means subtraction.
     */
    MINUS("minus", '-'),
    /**
     * Multiply operation means multiplication.
     */
    MULTIPLY("multiply", '*'),
    /**
     * Divide operation means division.
     */
    DIVIDE("divide", '/');
    /**
     * Operation title. It will be read by the user.
     */
    private final String title;
    /**
     * Kot key for operation. User will choose it.
     */
    private final char hotKey;
}
