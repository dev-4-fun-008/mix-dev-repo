package designpatterns.creational.builder.vehicle;

public class CarBuilder extends VehicleBuilder<Car, CarBuilder> {

    public CarBuilder() {
        super(new Car());
    }

    @SuppressWarnings("unchecked")
    public CarBuilder withAirbags(boolean hasAirbags) {
        vehicle.setAirbags(hasAirbags);
        return this;
    }
}
