package by.khadasevich.task01calculator.controller.command;

import by.khadasevich.task01calculator.service.*;
import by.khadasevich.task01calculator.vto.Result;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class CalculationCommand implements Command {
    /**
     * Message for user as enter double value.
     */
    private static final String ENTER_DOUBLE =
            "Enter double number(for example:2,4):";
    /**
     * Message for user as enter calculation operation.
     */
    private static final String ENTER_OPERATION_HOT_KEY =
            "Enter hot key of operation: ";
    /**
     * Execute arithmetic calculation with two double numbers.
     */
    @Override
    public void execute() {
        // take income parameters
        ReadDoubleOfKeyBoard doubleReader = KeyBoardReader.getInstance();
        ReadOperationOfKeyBoard operationReader = KeyBoardReader.getInstance();
        double firstArgument = doubleReader.readDouble(ENTER_DOUBLE);
        OperationName operation = operationReader.
                readOperationOfKeyBoard(ENTER_OPERATION_HOT_KEY);
        double secondArgument = doubleReader.readDouble(ENTER_DOUBLE);
        // do calculation
        Calculation calculator = Calculator.getInstance();
        Result result = calculator.calculate(firstArgument, secondArgument,
                operation);
        // present result
        System.setOut(new PrintStream(System.out, true,
                StandardCharsets.UTF_8));
        System.out.println(result);
    }
}
