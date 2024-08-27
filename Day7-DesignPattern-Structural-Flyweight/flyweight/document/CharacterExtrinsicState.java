package designpatterns.structural.flyweight.document;

public class CharacterExtrinsicState {
    private final int positionX;
    private final int positionY;

    public CharacterExtrinsicState(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }
}
