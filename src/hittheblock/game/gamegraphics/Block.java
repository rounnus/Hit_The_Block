package hittheblock.game.gamegraphics;

import javafx.scene.shape.Rectangle;

public class Block {
    private double nextBlockPositionX;
    private double nextBlockPositionY;
    private final double offsetX;
    private final double offsetY;
    private Rectangle blockShape;


    public Block() {
        this.blockShape = new Rectangle();
        this.offsetX = 90;
        this.offsetY = 40;
        this.nextBlockPositionX = 120;
        this.nextBlockPositionY = 200;
    }

    public void nextPositionXY(double previousNextPositionX, double previousNextPositionY, boolean changeLine) {
        if (!changeLine) {
            nextBlockPositionX = previousNextPositionX + offsetX;
        }
        else {
            nextBlockPositionY = previousNextPositionY + offsetY;
        }
    }

    public Rectangle getBlockShape() {
        return blockShape;
    }

    public double getNextBlockPositionX() {
        return nextBlockPositionX;
    }

    public double getNextBlockPositionY() {
        return nextBlockPositionY;
    }
}
