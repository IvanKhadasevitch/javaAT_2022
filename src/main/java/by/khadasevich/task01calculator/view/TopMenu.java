package by.khadasevich.task01calculator.view;

import by.khadasevich.task01calculator.controller.command.CommandName;

import java.util.NoSuchElementException;
import java.util.Scanner;

public final class TopMenu {
    // utility class, no realisation needed
    private TopMenu() { }
    /**
     * Present possible work variants.
     * @return CommandName to find and execute command.
     */
    public static CommandName getItem() {
        CommandName[] commandNames = CommandName.values();
        for (int i = 0; i < commandNames.length - 1; i++) {
            String message = commandNames[i].getTitle();
            System.out.printf("%2d.%s%n", i, message);
        }
        int item = 1;
        boolean isValuableItem = false;
        System.out.print("Enter menu Item: ");
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                item = scanner.nextInt();
                if (0 <= item && item < commandNames.length - 1) {
                    isValuableItem = true;
                } else {
                    System.out.println("Invalid menu Item");
                }
            } catch (NoSuchElementException exp) {
                System.out.println("Invalid menu Item");
            }
        } while (!isValuableItem);
        return commandNames[item];
    }
}
