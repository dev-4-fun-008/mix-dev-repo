package designpatterns.creational.builder.vehicle;

public abstract class VehicleBuilder<T extends Vehicle, B extends VehicleBuilder<T, B>> {
    protected T vehicle;

    public VehicleBuilder(T vehicle) {
        this.vehicle = vehicle;
    }

    @SuppressWarnings("unchecked")
    public B withEngine(String engine) {
        vehicle.setEngine(engine);
        return (B) this;
    }

    @SuppressWarnings("unchecked")
    public B withWheels(int wheels) {
        vehicle.setWheels(wheels);
        return (B) this;
    }

    public T build() {
        return vehicle;
    }
}
