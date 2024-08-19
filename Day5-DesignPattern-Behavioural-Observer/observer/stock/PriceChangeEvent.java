package designpatterns.behavioural.observer.stock;

public class PriceChangeEvent implements Event {
    private final String stockSymbol;
    private final double newPrice;

    public PriceChangeEvent(String stockSymbol, double newPrice) {
        this.stockSymbol = stockSymbol;
        this.newPrice = newPrice;
    }

    @Override
    public String getDescription() {
        return "Stock " + stockSymbol + " new price: $" + newPrice;
    }
}
