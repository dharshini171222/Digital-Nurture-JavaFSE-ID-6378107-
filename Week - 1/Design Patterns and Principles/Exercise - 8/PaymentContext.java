public class PaymentContext {
    private PaymentStrategy strategy;

    // Inject strategy via constructor or setter
    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void makePayment(double amount) {
        if (strategy == null) {
            System.out.println("No payment method selected.");
        } else {
            strategy.pay(amount);
        }
    }
}
