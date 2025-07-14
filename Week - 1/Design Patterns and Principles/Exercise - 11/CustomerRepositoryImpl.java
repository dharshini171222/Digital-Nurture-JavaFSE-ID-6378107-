import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {
    private Map<String, Customer> customerDB = new HashMap<>();

    public CustomerRepositoryImpl() {
        customerDB.put("C101", new Customer("C101", "Alice"));
        customerDB.put("C102", new Customer("C102", "Bob"));
    }

    @Override
    public Customer findCustomerById(String id) {
        return customerDB.get(id);
    }
}
