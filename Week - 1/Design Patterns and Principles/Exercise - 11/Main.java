public class Main {
    public static void main(String[] args) {
        // Create repository instance
        CustomerRepository repository = new CustomerRepositoryImpl();

        // Inject repository into service
        CustomerService service = new CustomerService(repository);

        // Use the service
        service.displayCustomer("C101");
        service.displayCustomer("C999");
    }
}
