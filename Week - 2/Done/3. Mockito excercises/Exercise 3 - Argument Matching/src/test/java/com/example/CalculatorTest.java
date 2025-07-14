package com.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    public void testArgumentMatching() {
        Calculator mockCalc = mock(Calculator.class);
        when(mockCalc.add(anyInt(), eq(5))).thenReturn(10);

        int result = mockCalc.add(3, 5);

        assertEquals(10, result);
        verify(mockCalc).add(anyInt(), eq(5));
    }
}
