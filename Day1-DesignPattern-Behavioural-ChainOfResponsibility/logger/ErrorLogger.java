package designpatterns.behavioural.chainofresponsibility.logger;

public class ErrorLogger extends Logger {

    @Override
    public boolean canHandle(Severity severity) {
        return severity == Severity.ERROR;
    }

    @Override
    public void write(String message) {
        System.out.println("ERROR: " + message);
    }
}
