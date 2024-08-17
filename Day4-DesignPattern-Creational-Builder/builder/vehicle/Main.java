package designpatterns.creational.builder.vehicle;

public class Main {

    public static void main(String[] args) {
        Car car = new CarBuilder()
                .withEngine("V8")
                .withWheels(4)
                .withAirbags(true)
                .build();

        Bike bike = new BikeBuilder()
                .withEngine("500cc")
                .withWheels(2)
                .withCarrier(true)
                .build();

        System.out.println("Car: " + car.getEngine() + ", Airbags: " + car.hasAirbags());
        System.out.println("Bike: " + bike.getEngine() + ", Carrier: " + bike.hasCarrier());
    }
}
