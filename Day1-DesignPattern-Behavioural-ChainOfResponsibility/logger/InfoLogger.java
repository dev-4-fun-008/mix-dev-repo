package designpatterns.behavioural.chainofresponsibility.logger;

public class InfoLogger extends Logger {

    @Override
    public boolean canHandle(Severity severity) {
        return severity == Severity.INFO;
    }

    @Override
    public void write(String message) {
        System.out.println("INFO: " + message);
    }
}
