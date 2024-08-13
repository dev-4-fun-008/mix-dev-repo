package designpatterns.behavioural.chainofresponsibility.logger;

public abstract class Logger {

    protected Logger nextLogger;

    public void setNextLogger(Logger logger) {
        this.nextLogger = logger;
    }

    public void logMessage(LogEvent logEvent) {
        if (canHandle(logEvent.getSeverity())) {
            write(logEvent.getMessage());
        }
        if (nextLogger != null) {
            nextLogger.logMessage(logEvent);
        }
    }

    public abstract boolean canHandle(Severity severity);

    public abstract void write(String message);
}
