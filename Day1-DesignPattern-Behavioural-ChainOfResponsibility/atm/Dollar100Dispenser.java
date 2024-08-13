package designpatterns.behavioural.chainofresponsibility.atm;

public class Dollar100Dispenser implements DispenseChain {

    private DispenseChain nextChain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void dispense(Currency currency) {
        if (currency.getAmount() >= 100) {
            int num = currency.getAmount() / 100;
            int remainder = currency.getAmount() % 100;

            System.out.println("Dispensing " + num + " $100 note");
            if (remainder != 0 && nextChain != null) {
                this.nextChain.dispense(new Currency(remainder));
            }
        }
        else {
            nextChain.dispense(currency);
        }
    }
}
