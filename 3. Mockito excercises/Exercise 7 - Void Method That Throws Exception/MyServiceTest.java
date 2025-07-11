import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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

        mockApi.getData();
        mockLogger.log("done");

        InOrder inOrder = inOrder(mockApi, mockLogger);
        inOrder.verify(mockApi).getData();
        inOrder.verify(mockLogger).log("done");
    }

    @Test
    public void testVoidMethodThrowsException() {
        Logger mockLogger = mock(Logger.class);

        doThrow(new RuntimeException("Boom")).when(mockLogger).log("fail");

        assertThrows(RuntimeException.class, () -> {
            mockLogger.log("fail");
        });

        verify(mockLogger).log("fail");
    }

}
