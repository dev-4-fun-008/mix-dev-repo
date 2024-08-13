package designpatterns.behavioural.chainofresponsibility.ticket;

public class MediumLevelSupportHandler extends SupportHandler {

    @Override
    public void handleRequest(SupportTicket supportTicket) {
        if (supportTicket.getLevel() == SupportLevel.MEDIUM) {
            System.out.println("MediumLevelSupportHandler: Handling medium-level support ticket.");
        }
        else {
            if (supportHandler != null) {
                supportHandler.handleRequest(supportTicket);
            }
        }
    }
}
