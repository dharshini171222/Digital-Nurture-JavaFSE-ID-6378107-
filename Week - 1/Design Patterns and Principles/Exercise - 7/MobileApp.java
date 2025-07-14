public class MobileApp implements Observer {
    private String appId;

    public MobileApp(String appId) {
        this.appId = appId;
    }

    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("[" + appId + " - MobileApp] " + stockName + " new price: $" + stockPrice);
    }
}
