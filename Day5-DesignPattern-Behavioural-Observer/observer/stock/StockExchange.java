package designpatterns.behavioural.observer.stock;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StockExchange {
    private final Map<String, Stock> stocks = new HashMap<>();
    private final Set<Observer<PriceChangeEvent>> observers;

    public StockExchange(Set<Observer<PriceChangeEvent>> observers) {
        this.observers = observers;
    }

    public void addStock(Stock stock) {
        stocks.put(stock.getSymbol(), stock);
        stock.addObserver(this::notifyObservers);
    }

    public Stock getStock(String symbol) {
        return stocks.get(symbol);
    }

    private void notifyObservers(PriceChangeEvent event) {
        for (Observer<PriceChangeEvent> observer : observers) {
            observer.update(event);
        }
    }

    public void updateStockPrice(String symbol, double newPrice) {
        Stock stock = stocks.get(symbol);
        if (stock != null) {
            stock.setPrice(newPrice);
        }
    }
}
