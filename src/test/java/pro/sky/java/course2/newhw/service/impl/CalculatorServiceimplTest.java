package pro.sky.java.course2.newhw.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.newhw.service.CalculatorService;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.course2.newhw.constants.CalculatorServiceConstantsTest.*;

class CalculatorServiceimplTest {
    private final CalculatorServiceimpl out = new CalculatorServiceimpl();

        @Test
        public void testSum() {
            int result = out.sum(NUMBER_NUM1,NUMBER_NUM2);
            assertEquals(NUMBER_NUM_SUM1, result);
        }

        @Test
        public void testSumWithZero() {
            int result = out.sum(NUMBER_NUM1,NUMBER_NUM_ZERO);
            assertEquals(NUMBER_NUM_SUM2, result);
        }

        @Test
        public void testSubtraction() {
            int result = out.subtraction(NUMBER_NUM1,NUMBER_NUM2);
            assertEquals(NUMBER_NUM_SUBTRACTION1, result);
        }

        @Test
        public void testSubtractionWithZero() {
            int result = out.subtraction(NUMBER_NUM1,NUMBER_NUM_ZERO);
            assertEquals(NUMBER_NUM_SUBTRACTION2, result);
        }

        @Test
        public void testMultiplication() {
            int result = out.multiplication(NUMBER_NUM1,NUMBER_NUM2);
            assertEquals(NUMBER_NUM_MULTIPLICATION1, result);
        }

        @Test
        public void testMultiplicationWithZero() {
            int result = out.multiplication(NUMBER_NUM1,NUMBER_NUM_ZERO);
            assertEquals(NUMBER_NUM_MULTIPLICATION2, result);
        }

        @Test
        public void testDivide() {
            int result = out.divide(NUMBER_NUM1,NUMBER_NUM2);
            assertEquals(NUMBER_NUM_DIVIDE1, result);
        }

        @Test
        public void testDivideWithZero() {
            int result = out.divide(NUMBER_NUM_ZERO,NUMBER_NUM1);
            assertEquals(NUMBER_NUM_DIVIDE2, result);
        }

        @Test
        public void testDivideOnZero() {
            assertThrows(IllegalArgumentException.class, () -> out.divide(NUMBER_NUM1,NUMBER_NUM_ZERO));
        }
    }