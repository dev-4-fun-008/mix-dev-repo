package designpatterns.behavioural.observer.stock;

import java.util.Set;

public class Main {

    public static void main(String[] args) {

        // Create notification system
        Notification emailNotification1 = new EmailNotification("investor1@example.com");
        Notification emailNotification2 = new EmailNotification("investor2@example.com");

        // Create investors with preferences and notifications
        Investor investor1 = new Investor("Alice", Set.of("AAPL"), emailNotification1);
        Investor investor2 = new Investor("Bob", Set.of("GOOGL"), emailNotification2);

        // Create stock exchange
        StockExchange stockExchange = new StockExchange(Set.of(investor1, investor2));

        // Create stocks
        Stock appleStock = new Stock("AAPL", 150.00);
        Stock googleStock = new Stock("GOOGL", 2800.00);

        // Add stocks to stock exchange
        stockExchange.addStock(appleStock);
        stockExchange.addStock(googleStock);

        // Update stock prices
        stockExchange.updateStockPrice("AAPL", 155.00);
        stockExchange.updateStockPrice("GOOGL", 2850.00);

        // Updating price of a non-preferred stock (no notifications sent)
        stockExchange.updateStockPrice("AAPL", 160.00);

    }
}
