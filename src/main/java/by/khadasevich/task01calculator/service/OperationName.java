package by.khadasevich.task01calculator.service;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

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
    /**
     * Get Set of Operation names hot keys.
     * @return Set of calculation operation names hot keys
     */
    public static Set<Character> getHotKeys() {
        Set<Character> operationHotKeys = new HashSet<>();
        for (var item : OperationName.values()) {
            operationHotKeys.add(item.getHotKey());
        }
        return operationHotKeys;
    }
    /**
     * Make string of operation hot keys to present it for user.
     * @return string of operation hot keys in format: "hotKey1; hotKey2;..."
     */
    public static String getHotKeysView() {
        StringBuilder stringBuilder = new StringBuilder();
        for (var item : OperationName.values()) {
            stringBuilder.append(item.getHotKey())
                    .append(" ")
                    .append(item.getTitle())
                    .append("; ");
        }
        return stringBuilder.toString();
    }
    /**
     * Get OperationName by its hotKey.
     * @param hotKey is calculation operation hot key.
     * @return OperationName correspondent to hot key
     * or null if hot key not exist.
     */
    public static OperationName getOperationByHotKey(final char hotKey) {
        OperationName result = null;
        if (getHotKeys().contains(hotKey)) {
            for (var item : OperationName.values()) {
                if (item.getHotKey() == hotKey) {
                    result = item;
                    break;
                }
            }
        }
        return result;
    }
}
