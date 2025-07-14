public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Pay using Credit Card
        PaymentStrategy creditCard = new CreditCardPayment("1234-5678-9012-3456", "Alice");
        context.setPaymentStrategy(creditCard);
        context.makePayment(250.00);

        // Pay using PayPal
        PaymentStrategy paypal = new PayPalPayment("alice@example.com");
        context.setPaymentStrategy(paypal);
        context.makePayment(150.00);

        // Without setting strategy
        context.setPaymentStrategy(null);
        context.makePayment(100.00);
    }
}
