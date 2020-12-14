package hittheblock.game.gamegraphics;

import javafx.scene.shape.Rectangle;

public class Block {
    private static double prevPositionX;
    private static double prevPositionY;
    private double nextBlockPositionX;
    private double nextBlockPositionY;
    private static final double offsetX = 90;
    private static final double offsetY = 90;
    private Rectangle blockShape;


    public Block() {
        // initialize.
        this.blockShape = new Rectangle();
    }

    public static void makeNewRow() {
        // Makes a new row.
        prevPositionX = prevPositionX + offsetX;
    }

    public static void makeNewColumn() {
        // Makes a new column.
        prevPositionY = prevPositionY + offsetY;
    }

    public static void setStartingPositionX(double startX) {
        // Initialize the position of X.
        prevPositionX = startX;
    }
    
    public static void setStartingPositionY(double startY) {
        // Initialize or change the position of y.
        prevPositionY = startY;
    }

    public Double getNextPositionX() {
        // get's the Y position of the next block
        return prevPositionX;
    }

    public Double getNextPositionY() {
        // get's the X position of the next block.
        return prevPositionY;
    }

    public Rectangle getBlockShape() {
        // get's the block graph.
        return blockShape;
    }

    public void dest() {
        blockShape.setVisible(false);
    }
}
