package designpatterns.creational.builder.vehicle;

public class Vehicle {
    private String engine;
    private int wheels;

    // Getters
    public String getEngine() { return engine; }
    public int getWheels() { return wheels; }

    // Protected setters to be used by Builder
    protected void setEngine(String engine) { this.engine = engine; }
    protected void setWheels(int wheels) { this.wheels = wheels; }
}
