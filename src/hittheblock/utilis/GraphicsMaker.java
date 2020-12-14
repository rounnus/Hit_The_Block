package hittheblock.utilis;

import hittheblock.constants.ComponentColors;
import hittheblock.constants.ComponentConstants;
import hittheblock.constants.ComponentDimensions;
import hittheblock.game.gamegraphics.*;
import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


public class GraphicsMaker {
    private final Ball ball;
    private final Bar bar;
    private Rectangle prevBlock;
    private Block tmp;

    public GraphicsMaker(Ball ball, Bar bar) {
        // Initialize.
        this.ball = ball;
        this.bar = bar;
        //this.block = block;
    }
    public void makeBall(Group group) {
        /*
            In this method we do the necessary
            functions to create a ball.
        */
        // Here we make the ball.
        Circle graphBall = ball.getBallShape();
        // set circle attributes.
        graphBall.setCenterX(ball.getBallPositionX());
        graphBall.setCenterY(ball.getBallPositionY());
        graphBall.setRadius(ComponentDimensions.BALL_RADIUS.size);
        graphBall.setFill(ComponentColors.BALL_COLOR.compColor);
        // add ball to the group of contents as a new node.
        group.getChildren().add(graphBall);
    }

    public void makeBar(Group group) {
        /*
            In this method we do all the necessary
            procedures to create a bar.
        */
        Rectangle barGraph = bar.getBar();
        barGraph.setX(bar.getBarPositionX());
        barGraph.setY(ComponentConstants.BAR_POSITION_ON_Y.constant);
        barGraph.setWidth(ComponentDimensions.BAR_WEIGHT.size);
        barGraph.setHeight(ComponentDimensions.BAR_HEIGHT.size);
        barGraph.setFill(ComponentColors.BAR_COLOR.compColor);
        // add bar to the group of contents as a new node.
        group.getChildren().add(barGraph);
    }

    public void addBlock(Group group) {
        /*
            In this method we add the new block in the group
            of objects that will appear on the screen.
        */
        Block currBlock = new Block();
        // We initialize the features of this block
        Rectangle blockGraph = currBlock.getBlockShape();
        blockGraph.setX(currBlock.getNextPositionX());
        blockGraph.setY(currBlock.getNextPositionY());
        blockGraph.setWidth(ComponentDimensions.BLOCK_WEIGHT.size);
        blockGraph.setHeight(ComponentDimensions.BLOCK_HEIGHT.size);
        blockGraph.setFill(ComponentColors.BLOCK_COLOR.compColor);
        // Add the block to the group.
        group.getChildren().add(blockGraph);
     }

    public void makeBlocks(Group group) {
        /*
            In this method we create the rows and
            columns of the blocks.
        */
        Block.setStartingPositionX(47);
        for (int row=0; row < ComponentConstants.BLOCK_NUMBER_ROWS.constant; row++) {
            // Create a new row and add the block there.
            Block.setStartingPositionY(90);
            Block.makeNewRow();
            addBlock(group);
            for (int colm=0; colm < ComponentConstants.BLOCK_NUMBER_COLUMNS.constant; colm++) {
                // Create a new column and add the block there.
                Block.makeNewColumn();
                addBlock(group);
            }
        }
    }


    public void start() {
        ball.startMoving();
    }

}

