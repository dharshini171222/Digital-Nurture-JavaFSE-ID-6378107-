public class Main {
    public static void main(String[] args) {
        // Basic notifier
        Notifier emailOnly = new EmailNotifier();
        System.out.println("---- Email Only ----");
        emailOnly.send("System update at 10 PM");

        // Email + SMS
        Notifier emailAndSMS = new SMSNotifierDecorator(new EmailNotifier());
        System.out.println("\n---- Email + SMS ----");
        emailAndSMS.send("Server down alert!");

        // Email + SMS + Slack
        Notifier allChannels = new SlackNotifierDecorator(new SMSNotifierDecorator(new EmailNotifier()));
        System.out.println("\n---- Email + SMS + Slack ----");
        allChannels.send("Critical security patch released.");
    }
}
