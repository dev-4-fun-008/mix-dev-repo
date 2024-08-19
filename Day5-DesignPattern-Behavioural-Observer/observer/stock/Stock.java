package designpatterns.behavioural.observer.stock;

import java.util.HashSet;
import java.util.Set;

public class Stock implements Subject<PriceChangeEvent> {
    private final Set<Observer<PriceChangeEvent>> observers = new HashSet<>();
    private final String symbol;
    private double price;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    @Override
    public void addObserver(Observer<PriceChangeEvent> observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer<PriceChangeEvent> observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        PriceChangeEvent event = new PriceChangeEvent(symbol, price);
        for (Observer<PriceChangeEvent> observer : observers) {
            observer.update(event);
        }
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers(); // Notify observers when price changes
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }
}
