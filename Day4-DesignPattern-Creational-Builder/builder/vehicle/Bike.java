package designpatterns.creational.builder.vehicle;

public class Bike extends Vehicle {
    private boolean hasCarrier;

    public boolean hasCarrier() { return hasCarrier; }

    protected void setCarrier(boolean hasCarrier) { this.hasCarrier = hasCarrier; }
}
