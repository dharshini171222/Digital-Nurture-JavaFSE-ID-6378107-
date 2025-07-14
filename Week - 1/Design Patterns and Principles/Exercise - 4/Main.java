public class Main {
    public static void main(String[] args) {
        // Using PayPal via Adapter
        PayPalGateway payPal = new PayPalGateway();
        PaymentProcessor paypalProcessor = new PayPalAdapter(payPal);
        paypalProcessor.processPayment(120.00);

        // Using Stripe via Adapter
        StripeGateway stripe = new StripeGateway();
        PaymentProcessor stripeProcessor = new StripeAdapter(stripe);
        stripeProcessor.processPayment(85.50);
    }
}
