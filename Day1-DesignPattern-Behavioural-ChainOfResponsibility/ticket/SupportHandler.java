package designpatterns.behavioural.chainofresponsibility.ticket;

public abstract class SupportHandler {

    protected SupportHandler supportHandler;

    public void setNextHandler(SupportHandler supportHandler) {
        this.supportHandler = supportHandler;
    }

    public abstract void handleRequest(SupportTicket supportTicket);
}
