package designpatterns.behavioural.observer.stock;

public class EmailNotification implements Notification {
    private final String emailAddress;

    public EmailNotification(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public void send(String message) {
        // Placeholder for actual email sending logic
        System.out.println("Sending email to " + emailAddress + ": " + message);
    }
}
