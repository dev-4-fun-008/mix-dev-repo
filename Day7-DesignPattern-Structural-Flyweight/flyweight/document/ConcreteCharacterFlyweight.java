package designpatterns.structural.flyweight.document;

public class ConcreteCharacterFlyweight implements CharacterFlyweight {
    private final String font;
    private final int fontSize;
    private final String color;
    private final String style;

    public ConcreteCharacterFlyweight(String font, int fontSize, String color, String style) {
        this.font = font;
        this.fontSize = fontSize;
        this.color = color;
        this.style = style;
    }

    @Override
    public void render(CharacterExtrinsicState extrinsicState) {
        System.out.println("Rendering character at position (" + extrinsicState.getPositionX() + ", " + extrinsicState.getPositionY() + 
            ") with font: " + font + ", size: " + fontSize + ", color: " + color + ", style: " + style);
    }
}
