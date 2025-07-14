import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter current value: ");
        double currentValue = sc.nextDouble();

        System.out.print("Enter annual growth rate (e.g., 0.05 for 5%): ");
        double growthRate = sc.nextDouble();

        System.out.print("Enter number of years: ");
        int years = sc.nextInt();

        double futureValue = FinancialForecast.calculateFutureValue(currentValue, growthRate, years);
        System.out.printf("Predicted Future Value (Recursive): ₹%.2f%n", futureValue);

        // Using optimized version
        Double[] memo = new Double[years + 1];
        double optimizedFutureValue = FinancialForecast.calculateFutureValueMemo(currentValue, growthRate, years, memo);
        System.out.printf("Predicted Future Value (Memoized): ₹%.2f%n", optimizedFutureValue);
    }
}
