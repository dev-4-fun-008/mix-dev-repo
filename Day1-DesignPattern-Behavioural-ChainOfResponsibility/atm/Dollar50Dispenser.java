package designpatterns.behavioural.chainofresponsibility.atm;

public class Dollar50Dispenser implements DispenseChain {

    private DispenseChain nextChain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void dispense(Currency currency) {
        if (currency.getAmount() >= 50) {
            int num = currency.getAmount() / 50;
            int remainder = currency.getAmount() % 50;

            System.out.println("Dispensing " + num + " $50 note");
            if (remainder != 0 && nextChain != null) {
                this.nextChain.dispense(new Currency(remainder));
            }
        }
        else {
            nextChain.dispense(currency);
        }
    }
}
