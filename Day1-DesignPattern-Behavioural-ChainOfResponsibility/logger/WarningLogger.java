package designpatterns.behavioural.chainofresponsibility.logger;

public class WarningLogger extends Logger {

    @Override
    public boolean canHandle(Severity severity) {
        return severity == Severity.WARNING;
    }

    @Override
    public void write(String message) {
        System.out.println("WARNING: " + message);
    }
}
