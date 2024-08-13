package designpatterns.behavioural.chainofresponsibility.logger;

public class ChainOfResponsibilityMain {

    public static void main(String[] args) {
        Logger infoLogger = new InfoLogger();
        Logger warningLogger = new WarningLogger();
        Logger errorLogger = new ErrorLogger();

        infoLogger.setNextLogger(warningLogger);
        warningLogger.setNextLogger(errorLogger);

        LogEvent event1 = new LogEvent("This is an information message.", Severity.INFO);
        LogEvent event2 = new LogEvent("This is a warning message.", Severity.WARNING);
        LogEvent event3 = new LogEvent("This is an error message.", Severity.ERROR);

        infoLogger.logMessage(event1);
        infoLogger.logMessage(event2);
        infoLogger.logMessage(event3);
    }
}
