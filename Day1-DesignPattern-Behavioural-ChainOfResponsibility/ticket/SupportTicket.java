package designpatterns.behavioural.chainofresponsibility.ticket;

public class SupportTicket {
    private final SupportLevel level;

    public SupportTicket(SupportLevel level) {
        this.level = level;
    }

    public SupportLevel getLevel() {
        return level;
    }
}
