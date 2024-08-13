package designpatterns.behavioural.chainofresponsibility.ticket;

public class HighLevelSupportHandler extends SupportHandler {

    @Override
    public void handleRequest(SupportTicket supportTicket) {
        if (supportTicket.getLevel() == SupportLevel.HIGH) {
            System.out.println("HighLevelSupportHandler: Handling high-level support ticket.");
        }
        else {
            if (supportHandler != null) {
                supportHandler.handleRequest(supportTicket);
            }
        }
    }
}
