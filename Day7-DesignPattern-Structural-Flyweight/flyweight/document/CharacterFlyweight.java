package designpatterns.structural.flyweight.document;

@FunctionalInterface
public interface CharacterFlyweight {
    void render(CharacterExtrinsicState extrinsicState);
}
