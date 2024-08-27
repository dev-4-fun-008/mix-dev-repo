package designpatterns.structural.flyweight.document;

public class Client {
    public static void main(String[] args) {
        CharacterFlyweightFactory flyweightFactory = new CharacterFlyweightFactory();
        Document document = new Document(flyweightFactory);

        document.addCharacter('H', "Arial", 12, "Black", "Bold", 10, 10);
        document.addCharacter('e', "Arial", 12, "Black", "Bold", 20, 10);
        document.addCharacter('l', "Arial", 12, "Black", "Bold", 30, 10);
        document.addCharacter('l', "Arial", 12, "Black", "Bold", 40, 10);
        document.addCharacter('o', "Arial", 12, "Black", "Bold", 50, 10);
        document.addCharacter('W', "Arial", 12, "Red", "Italic", 10, 20);
        document.addCharacter('o', "Arial", 12, "Red", "Italic", 20, 20);
        document.addCharacter('r', "Arial", 12, "Red", "Italic", 30, 20);
        document.addCharacter('l', "Arial", 12, "Red", "Italic", 40, 20);
        document.addCharacter('d', "Arial", 12, "Red", "Italic", 50, 20);

        document.renderDocument();
    }
}
