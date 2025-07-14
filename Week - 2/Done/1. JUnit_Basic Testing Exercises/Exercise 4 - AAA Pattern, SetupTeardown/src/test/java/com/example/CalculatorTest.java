package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class CalculatorTest {

    // Setup before each test
    @BeforeAll
    public static void setUp() {
        System.out.println("Setup done");
    }

    // Teardown after each test
    @AfterAll
    public static void tearDown() {
        System.out.println("Test finished");
    }

    @Test
    public void testAdd() {
        Calculator calc = new Calculator();
        assertEquals(15, calc.add(10, 5));
    }

    @Test
    public void testSubtract() {
        Calculator calc = new Calculator();
        assertEquals(5, calc.subtract(10, 5));
    }
}
