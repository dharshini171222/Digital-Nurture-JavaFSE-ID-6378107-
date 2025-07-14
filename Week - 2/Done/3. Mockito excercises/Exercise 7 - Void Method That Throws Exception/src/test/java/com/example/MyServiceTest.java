package com.example;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        assertEquals("Mock Data", result);
    }

    @Test
    public void testVerifyInteraction() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.fetchData();

        verify(mockApi).getData(); // Verifies method was called
    }

    @Test
    public void testMultipleReturns() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("First").thenReturn("Second");

        MyService service = new MyService(mockApi);

        assertEquals("First", service.fetchData());
        assertEquals("Second", service.fetchData());
    }

    @Test
    public void testInteractionOrder() {
        ExternalApi mockApi = mock(ExternalApi.class);

        MyService service = new MyService(mockApi);
        service.fetchData();
        service.fetchData();

        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi, times(2)).getData();
    }

    @Test
    public void testMultipleInteractionOrder() {
        ExternalApi mockApi = mock(ExternalApi.class);
        Logger mockLogger = mock(Logger.class);

        MyService service = new MyService(mockApi, mockLogger);
        service.fetchData();

        InOrder inOrder = inOrder(mockApi, mockLogger);
        inOrder.verify(mockApi).getData();
        inOrder.verify(mockLogger).log(Level.INFO, "done");
    }

@Test
    public void testVoidMethodThrowsException() {
        Logger mockLogger = mock(Logger.class);

        // Correctly mocking the method with (Level, String)
        doThrow(new RuntimeException("Boom"))
            .when(mockLogger).log(Level.SEVERE, "fail");

        assertThrows(RuntimeException.class, () -> {
            mockLogger.log(Level.SEVERE, "fail");
        });

        verify(mockLogger).log(Level.SEVERE, "fail");
    }
}
