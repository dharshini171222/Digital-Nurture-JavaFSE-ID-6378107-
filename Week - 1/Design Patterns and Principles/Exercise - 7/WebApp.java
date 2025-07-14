public class WebApp implements Observer {
    private String appId;

    public WebApp(String appId) {
        this.appId = appId;
    }

    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("[" + appId + " - WebApp] " + stockName + " new price: $" + stockPrice);
    }
}
