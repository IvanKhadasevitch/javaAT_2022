package by.khadasevich.task01calculator.service;

public interface ReadOperationOfKeyBoard {
    /**
     * Read operation by user entered hot key.
     * @param message that user see before entering
     * @return operation name corresponded to entered by user hot key
     */
    OperationName readOperationOfKeyBoard(String message);
}
