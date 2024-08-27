package designpatterns.structural.flyweight.document;

import java.util.ArrayList;
import java.util.List;

public class Document {
    private final List<CharacterRendering> characters = new ArrayList<>();
    private final CharacterFlyweightFactory flyweightFactory;

    public Document(CharacterFlyweightFactory flyweightFactory) {
        this.flyweightFactory = flyweightFactory;
    }

    public void addCharacter(char c, String font, int fontSize, String color, String style, int posX, int posY) {
        CharacterFlyweight flyweight = flyweightFactory.getFlyweight(font, fontSize, color, style);
        CharacterExtrinsicState extrinsicState = new CharacterExtrinsicState(posX, posY);
        characters.add(new CharacterRendering(flyweight, extrinsicState));
    }

    public void renderDocument() {
        for (CharacterRendering rendering : characters) {
            rendering.render();
        }
    }

    private static class CharacterRendering {
        private final CharacterFlyweight flyweight;
        private final CharacterExtrinsicState extrinsicState;

        public CharacterRendering(CharacterFlyweight flyweight, CharacterExtrinsicState extrinsicState) {
            this.flyweight = flyweight;
            this.extrinsicState = extrinsicState;
        }

        public void render() {
            flyweight.render(extrinsicState);
        }
    }
}
