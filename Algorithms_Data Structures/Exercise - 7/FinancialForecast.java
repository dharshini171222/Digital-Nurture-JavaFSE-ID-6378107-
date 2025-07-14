public class FinancialForecast {

    // Recursive method to calculate future value
    public static double calculateFutureValue(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        return (1 + growthRate) * calculateFutureValue(currentValue, growthRate, years - 1);
    }

    // Optimized version using memoization (for larger inputs)
    public static double calculateFutureValueMemo(double currentValue, double growthRate, int years, Double[] memo) {
        if (years == 0) return currentValue;

        if (memo[years] != null) return memo[years];

        memo[years] = (1 + growthRate) * calculateFutureValueMemo(currentValue, growthRate, years - 1, memo);
        return memo[years];
    }
}
