package by.khadasevich.task01calculator.sevice;

import by.khadasevich.task01calculator.service.OperationName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@Execution(ExecutionMode.CONCURRENT)
public class OperationNameTest {

    @Test
    @DisplayName("All operation hot keys are unique")
    public void testAllOperationHotKeysAreUnique() {
        Set<Character> operationHotKeys = OperationName.getHotKeys();
        List<Character> operationHotKeyList = Arrays.stream(OperationName
                .values()).map(OperationName::getHotKey).toList();
        assertThat(operationHotKeyList)
                .as("Not all operation hot key are unique")
                .hasSize(operationHotKeys.size());
    }

    @Test
    @DisplayName("Screen operation hot keys presentation has all keys")
    public void testOperationHotKeysPresentationHasAllKey() {
        String hotKeysView = OperationName.getHotKeysView();
        Set<Character> operationHotKeys = OperationName.getHotKeys();
        for (Character hotKey : operationHotKeys) {
            assertThat(hotKeysView)
                    .as("Not all operation hot keys in screen presentation.")
                    .contains(String.valueOf(hotKey));
        }
    }

    @Test
    @DisplayName("Test get operation by hot key.")
    public void testGetOperationByHotKey() {
        Set<Character> operationHotKeys = OperationName.getHotKeys();
        for (Character hotKey : operationHotKeys) {
            OperationName operationNameType =
                    OperationName.getOperationByHotKey(hotKey);
            assertThat(operationNameType)
                    .as(String.format("Hot key:[%s] doesn't" +
                            " have operation type.", hotKey))
                    .isInstanceOfAny(OperationName.class);
        }
    }
}
