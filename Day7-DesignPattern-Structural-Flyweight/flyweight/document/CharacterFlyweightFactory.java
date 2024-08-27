package designpatterns.structural.flyweight.document;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class CharacterFlyweightFactory {
    private final Map<String, CharacterFlyweight> flyweightPool = new HashMap<>();

    public CharacterFlyweight getFlyweight(String font, int fontSize, String color, String style) {
        String key = font + fontSize + color + style;
        return flyweightPool.computeIfAbsent(key, k -> new ConcreteCharacterFlyweight(font, fontSize, color, style));
    }
}
