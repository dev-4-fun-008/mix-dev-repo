package designpatterns.behavioural.chainofresponsibility.ticket;

public class LowLevelSupportHandler extends SupportHandler {

    @Override
    public void handleRequest(SupportTicket supportTicket) {
        if (supportTicket.getLevel() == SupportLevel.LOW) {
            System.out.println("LowLevelSupportHandler: Handling low-level support ticket.");
        }
        else {
            if (supportHandler != null) {
                supportHandler.handleRequest(supportTicket);
            }
        }
    }
}
