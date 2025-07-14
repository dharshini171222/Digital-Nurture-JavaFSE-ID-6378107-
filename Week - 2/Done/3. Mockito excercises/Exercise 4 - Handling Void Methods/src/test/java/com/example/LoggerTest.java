package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class LoggerTest {
    @Test
    public void testVoidMethod() {
        Logger mockLogger = mock(Logger.class);

        doNothing().when(mockLogger).log(anyString());

        mockLogger.log("Hello World");

        verify(mockLogger).log("Hello World");
    }
}
