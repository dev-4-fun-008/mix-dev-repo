package designpatterns.behavioural.observer.stock;

import java.util.Set;

public class Investor implements Observer<PriceChangeEvent> {
    private final String name;
    private final Set<String> preferredStocks;
    private final Notification notification;

    public Investor(String name, Set<String> preferredStocks, Notification notification) {
        this.name = name;
        this.preferredStocks = preferredStocks;
        this.notification = notification;
    }

    @Override
    public void update(PriceChangeEvent event) {
        if (preferredStocks.contains(event.getDescription().split(" ")[1])) {
            notification.send("Investor " + name + " notified: " + event.getDescription());
        }
    }
}
