package by.khadasevich.task01calculator.vto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Object to transfer result of calculation.
 */
@Getter @AllArgsConstructor
@ToString @EqualsAndHashCode
public class Result {
    /**
     * Message about calculation.
     */
    private String message;
    /**
     * Value of calculation.
     */
    private double value;
}
