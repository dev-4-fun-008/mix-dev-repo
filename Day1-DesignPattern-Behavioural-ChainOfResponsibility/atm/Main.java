package designpatterns.behavioural.chainofresponsibility.atm;

public class Main {

    public static void main(String[] args) {
        ATMDispenseChain atmDispenser = new ATMDispenseChain.Builder()
                .addChain(new Dollar100Dispenser())
                .addChain(new Dollar50Dispenser())
                .addChain(new Dollar20Dispenser())
                .addChain(new Dollar10Dispenser())
                .build();

        atmDispenser.getChain().dispense(new Currency(2430));
    }
}
