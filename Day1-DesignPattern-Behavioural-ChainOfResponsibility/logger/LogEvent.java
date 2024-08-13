package designpatterns.behavioural.chainofresponsibility.logger;

public class LogEvent {
    private final String message;
    private final Severity severity;

    public LogEvent(String message, Severity severity) {
        this.message = message;
        this.severity = severity;
    }

    public String getMessage() {
        return message;
    }

    public Severity getSeverity() {
        return severity;
    }
}
