import com.example.model.User;
import com.example.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceExceptionTest {

    @Test
    void testMissingUserThrowsException() {
        UserRepository repo = mock(UserRepository.class);
        when(repo.findById(999L)).thenReturn(Optional.empty());

        UserService service = new UserService();
        service.setUserRepository(repo); // setter for test

        assertNull(service.getUserById(999L));
    }
}
