package designpatterns.behavioural.chainofresponsibility.atm;

public interface DispenseChain {
    void setNextChain(DispenseChain nextChain);
    void dispense(Currency currency);
}
