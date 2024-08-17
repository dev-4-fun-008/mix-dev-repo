package designpatterns.creational.builder.vehicle;

public class Car extends Vehicle {
    private boolean hasAirbags;

    public boolean hasAirbags() { return hasAirbags; }

    protected void setAirbags(boolean hasAirbags) { this.hasAirbags = hasAirbags; }
}
