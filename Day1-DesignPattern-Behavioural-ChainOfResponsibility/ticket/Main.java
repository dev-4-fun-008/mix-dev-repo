package designpatterns.behavioural.chainofresponsibility.ticket;

public class Main {

    public static void main(String[] args) {
        SupportHandler lowLevelSH = new LowLevelSupportHandler();
        SupportHandler mediumLevelSH = new MediumLevelSupportHandler();
        SupportHandler highLevelSH = new HighLevelSupportHandler();

        lowLevelSH.setNextHandler(mediumLevelSH);
        mediumLevelSH.setNextHandler(highLevelSH);

        SupportTicket lowTicket = new SupportTicket(SupportLevel.LOW);
        SupportTicket mediumTicket = new SupportTicket(SupportLevel.MEDIUM);
        SupportTicket highTicket = new SupportTicket(SupportLevel.HIGH);

        lowLevelSH.handleRequest(lowTicket);
        lowLevelSH.handleRequest(mediumTicket);
        lowLevelSH.handleRequest(highTicket);
    }
}
