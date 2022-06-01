package by.khadasevich.task01calculator.controller.command;

import by.khadasevich.task01calculator.service.*;
import by.khadasevich.task01calculator.vto.Result;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class CalculationCommand implements Command {
    /**
     * Execute arithmetic calculation with two double numbers.
     */
    @Override
    public void execute() {
        // take income parameters
        ReadDoubleOfKeyBoard doubleReader = KeyBoardReader.getInstance();
        ReadOperationOfKeyBoard operationReader = KeyBoardReader.getInstance();
        double firstArgument = doubleReader.readDouble("Enter double number:");
        OperationName operation = operationReader.
                readOperationOfKeyBoard("Enter hot key of operation: ");
        double secondArgument = doubleReader.readDouble("Enter double number:");
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
