package designpatterns.creational.factorymethod.button;

public class MacButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Mac Button");
    }

    @Override
    public void onClick() {
        System.out.println("Mac Button Clicked!");
    }
}
