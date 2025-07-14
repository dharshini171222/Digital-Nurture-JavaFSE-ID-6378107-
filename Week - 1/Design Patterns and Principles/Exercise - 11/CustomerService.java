public class CustomerService {
    private CustomerRepository repository;

    // Constructor-based Dependency Injection
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void displayCustomer(String id) {
        Customer customer = repository.findCustomerById(id);
        if (customer != null) {
            System.out.println("Customer Found: " + customer.getName() + " (ID: " + customer.getId() + ")");
        } else {
            System.out.println("Customer not found with ID: " + id);
        }
    }
}
