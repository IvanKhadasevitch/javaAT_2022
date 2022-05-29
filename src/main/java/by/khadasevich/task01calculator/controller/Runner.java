package by.khadasevich.task01calculator.controller;

public final class Runner {

    private Runner() {
        throw new IllegalStateException("Utility class");
    }
    /**
     * Program runner.
     * @param args arguments from command line.
     */
    public static void main(final String[] args) {
        // execute command
        Controller controller = new Controller();
        controller.executeCommand();
    }
}
