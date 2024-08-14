package designpatterns.creational.factorymethod.button;

public class Main {

    public static void main(String[] args) {

        Button windowsButton = ButtonFactory.WINDOWS.createButton();
        windowsButton.render();
        windowsButton.onClick();

        Button macButton = ButtonFactory.MAC.createButton();
        macButton.render();
        macButton.onClick();

    }
}
