package designpatterns.creational.builder.vehicle;

public class BikeBuilder extends VehicleBuilder<Bike, BikeBuilder> {

    public BikeBuilder() {
        super(new Bike());
    }

    @SuppressWarnings("unchecked")
    public BikeBuilder withCarrier(boolean hasCarrier) {
        vehicle.setCarrier(hasCarrier);
        return this;
    }
}
