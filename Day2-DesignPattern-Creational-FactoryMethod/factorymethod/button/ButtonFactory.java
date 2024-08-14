package designpatterns.creational.factorymethod.button;

import java.util.function.Supplier;

public enum ButtonFactory {
    WINDOWS(WindowsButton::new),
    MAC(MacButton::new);

    private final Supplier<Button> constructor;

    ButtonFactory(Supplier<Button> constructor) {
        this.constructor = constructor;
    }

    public Button createButton() {
        return constructor.get();
    }
}
