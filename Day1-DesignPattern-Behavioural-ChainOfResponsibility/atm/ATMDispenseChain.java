package designpatterns.behavioural.chainofresponsibility.atm;

public class ATMDispenseChain {

    private final DispenseChain chain;

    public ATMDispenseChain(DispenseChain chain) {
        this.chain = chain;
    }

    public DispenseChain getChain() {
        return chain;
    }

    public static class Builder {
        private DispenseChain head;
        private DispenseChain tail;

        public Builder addChain(DispenseChain handler) {
            if (head == null) {
                head = handler;
            }
            else {
                tail.setNextChain(handler);
            }
            tail = handler;
            return this;
        }

        public ATMDispenseChain build() {
            return new ATMDispenseChain(head);
        }
    }
}
