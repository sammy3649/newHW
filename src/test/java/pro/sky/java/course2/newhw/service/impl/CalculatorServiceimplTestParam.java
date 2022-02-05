package pro.sky.java.course2.newhw.service.impl;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pro.sky.java.course2.newhw.constants.CalculatorServiceConstantsTest.*;

public class CalculatorServiceimplTestParam {
    private final CalculatorServiceimpl out = new CalculatorServiceimpl();

    public static Stream<Arguments> prepareNumsForSum() {
        return Stream.of(Arguments.of(NUMBER_NUM1, NUMBER_NUM2, NUMBER_NUM_SUM1),
                Arguments.of(NUMBER_NUM1, NUMBER_NUM_ZERO, NUMBER_NUM_SUM2),
                Arguments.of(NUMBER_NUM1, NUMBER_NUM3, NUMBER_NUM_SUM3)
        );
    }

    @ParameterizedTest
    @MethodSource("prepareNumsForSum")
    public void testSum(int num1, int num2, int expected) {
        int result = out.sum(num1, num2);
        assertEquals(expected, result);
    }

    public static Stream<Arguments> prepareNumsForSubtraction() {
        return Stream.of(Arguments.of(NUMBER_NUM1, NUMBER_NUM2, NUMBER_NUM_SUBTRACTION1),
                Arguments.of(NUMBER_NUM1, NUMBER_NUM_ZERO, NUMBER_NUM_SUBTRACTION2),
                Arguments.of(NUMBER_NUM1, NUMBER_NUM3, NUMBER_NUM_SUBTRACTION3)
        );
    }
    @ParameterizedTest
    @MethodSource("prepareNumsForSubtraction")
    public void testSubtraction(int num1, int num2, int expected) {
        int result = out.subtraction(num1, num2);
        assertEquals(expected, result);
    }
    public static Stream<Arguments> prepareNumsForMultiplication() {
        return Stream.of(Arguments.of(NUMBER_NUM1, NUMBER_NUM2, NUMBER_NUM_MULTIPLICATION1),
                Arguments.of(NUMBER_NUM1, NUMBER_NUM_ZERO, NUMBER_NUM_MULTIPLICATION2),
                Arguments.of(NUMBER_NUM1, NUMBER_NUM3, NUMBER_NUM_MULTIPLICATION3)
        );
    }
    @ParameterizedTest
    @MethodSource("prepareNumsForMultiplication")
    public void testMultiplication(int num1, int num2, int expected) {
        int result = out.multiplication(num1, num2);
        assertEquals(expected, result);
    }
    public static Stream<Arguments> prepareNumsForDivide() {
        return Stream.of(Arguments.of(NUMBER_NUM1, NUMBER_NUM2, NUMBER_NUM_DIVIDE1),
                Arguments.of(NUMBER_NUM1, NUMBER_NUM_ZERO, NUMBER_NUM_DIVIDE2),
                Arguments.of(NUMBER_NUM1, NUMBER_NUM3, NUMBER_NUM_DIVIDE3)
        );
    }
    @ParameterizedTest
    @MethodSource("prepareNumsForDivide")
    public void testDivide(int num1, int num2, int expected) {
        int result = out.divide(num1, num2);
        assertEquals(expected, result);
    }
}