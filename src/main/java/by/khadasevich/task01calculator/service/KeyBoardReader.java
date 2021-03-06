package by.khadasevich.task01calculator.service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.NoSuchElementException;

/**
 * Encapsulate user's work with keyboard.
 */
public final class KeyBoardReader implements ReadDoubleOfKeyBoard,
        ReadOperationOfKeyBoard {
    /**
     * Singleton instance of KeyBoardReader.
     */
    public static final KeyBoardReader INSTANCE = new KeyBoardReader();
    /**
     * Message when invalid value was entered.
     */
    private static final String INVALID_VALUE = "Invalid value. Try again.";
    private KeyBoardReader() { }
    /**
     * Get KeyBoardReader as singleton.
     * @return instance of KeyBoardReader.
     */
    public static KeyBoardReader getInstance() {
        return INSTANCE;
    }
    /**
     * Read double value entered by user.
     * @param message that user see before entering
     * @return double value entered by user
     */
    @Override
    public double readDouble(final String message) {
        double result = 0;
        System.setOut(new java.io.PrintStream(System.out, true,
                StandardCharsets.UTF_8));
        System.out.print(message);
        boolean isValuableInput = false;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                result = scanner.nextDouble();
                if (Double.valueOf(result).isInfinite()) {
                    System.out.println(INVALID_VALUE);
                } else {
                    isValuableInput = true;
                }
            } catch (NoSuchElementException exp) {
                System.out.println(INVALID_VALUE);
            }
        } while (!isValuableInput);
        return result;
    }

    /**
     * Read operation by user entered hot key.
     * @param message that user see before entering
     * @return operation name corresponded to entered by user hot key.
     */
    @Override
    public OperationName readOperationOfKeyBoard(final String message) {
        // take and analise entered hot key
        String hotKeysView = OperationName.getHotKeysView();
        System.setOut(new PrintStream(System.out, true,
                StandardCharsets.UTF_8));
        System.out.println(message + hotKeysView);
        boolean isValuableInput = false;
        OperationName result = null;
        char hotKey;
        do {
            try {
                InputStreamReader isr = new InputStreamReader(System.in,
                        StandardCharsets.UTF_8);
                hotKey = (char) isr.read();
                result = OperationName.getOperationByHotKey(hotKey);
                if (result == null) {
                    System.out.println(INVALID_VALUE);
                } else {
                    isValuableInput = true;
                }
            } catch (NoSuchElementException | IOException exp) {
                System.out.println(INVALID_VALUE);
            }
        } while (!isValuableInput);
        return result;
    }
}
