package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

public class PerformanceTesterTest {

    @Test
    void testPerformance() {
        PerformanceTester tester = new PerformanceTester();
        assertTimeout(Duration.ofMillis(500), () -> tester.performTask());
    }
}