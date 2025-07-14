import com.example.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testFindByName() {
        User user = new User();
        user.setId(101L);
        user.setName("Alice");
        userRepository.save(user);

        List<User> users = userRepository.findByName("Alice");
        assertFalse(users.isEmpty());
        assertEquals("Alice", users.get(0).getName());
    }
}
