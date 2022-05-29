package by.khadasevich.task01calculator.controller;

import by.khadasevich.task01calculator.controller.command.Command;
import by.khadasevich.task01calculator.controller.command.CommandName;
import by.khadasevich.task01calculator.view.TopMenu;

/**
 * Controls logic of execution commands.
 */
public final class Controller {
    /**
     * Execute task chosen in TopMenu.
     */
    public void executeCommand() {
        Command command;
        do {
            CommandName commandName = TopMenu.getItem();
            command = commandName.getCommand();
            if (command != null) {
                command.execute();
            }
        } while (command != null);
    }
}
