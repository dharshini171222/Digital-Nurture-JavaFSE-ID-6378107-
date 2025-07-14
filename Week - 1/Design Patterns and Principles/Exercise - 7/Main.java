public class Main {
    public static void main(String[] args) {
        StockMarket appleStock = new StockMarket("AAPL");

        Observer mobileClient = new MobileApp("User123");
        Observer webClient = new WebApp("User123");

        // Register observers
        appleStock.registerObserver(mobileClient);
        appleStock.registerObserver(webClient);

        // Update stock price
        appleStock.setStockPrice(170.25);
        appleStock.setStockPrice(173.10);

        // Remove one observer
        appleStock.removeObserver(webClient);
        appleStock.setStockPrice(175.50);
    }
}
