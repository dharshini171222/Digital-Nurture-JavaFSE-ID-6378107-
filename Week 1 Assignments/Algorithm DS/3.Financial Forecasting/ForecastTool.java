import java.util.Scanner;

public class ForecastTool {

    public double Recursive(double presentValue, double rate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return Recursive(presentValue * (1 + rate), rate, years - 1);
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter present value (₹): ");
        double pv = sc.nextDouble();

        System.out.print("Enter annual growth rate (e.g., 0.08 for 8%): ");
        double rate = sc.nextDouble();

        System.out.print("Enter number of years: ");
        int years = sc.nextInt();

        double futureRecursive = Recursive(pv, rate, years);
        System.out.printf("Recursive Prediction: ₹%.2f%n", futureRecursive);

        sc.close();
    }

    public static void main(String[] args) {
        new ForecastTool().run();
    }
}
