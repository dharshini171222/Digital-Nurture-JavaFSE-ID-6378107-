import com.example.model.User;
import com.example.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testSaveAndFetchUser() {
        User user = new User();
        user.setId(100L);
        user.setName("Integration");

        userRepository.save(user);

        User fetched = userRepository.findById(100L).orElse(null);
        assertNotNull(fetched);
        assertEquals("Integration", fetched.getName());
    }
}
