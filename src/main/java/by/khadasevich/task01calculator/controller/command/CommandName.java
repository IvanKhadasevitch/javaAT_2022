package by.khadasevich.task01calculator.controller.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Describe all possible function of program.
 * It Defines displayed name of command for user,
 * and it's realisation.
 */
@Getter
@AllArgsConstructor
public enum CommandName {
    /**
     * Does arithmetic calculation with two double numbers.
     */
    CALCULATION("Calculation", new CalculationCommand()),
    /**
     * Exit of programme working.
     */
    EXIT("Exit", null);
    /**
     * Command title. It will be read by the user.
     */
    private final String title;
    /**
     * Implementation of Command.
     */
    private final Command command;

}
