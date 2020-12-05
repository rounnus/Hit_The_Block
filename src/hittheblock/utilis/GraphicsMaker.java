package hittheblock.utilis;

import hittheblock.constants.BallConstants;
import hittheblock.constants.BarConstants;
import hittheblock.constants.BlockConstants;
import hittheblock.constants.WindowConstants;
import hittheblock.game.gamegraphics.*;
import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;


public class GraphicsMaker {
    private Ball ball;
    private Bar bar;
    private Block block;

    public GraphicsMaker(Ball ball, Bar bar, Block block) {
        // Initialize.
        this.ball = ball;
        this.bar = bar;
        this.block = block;
    }
    public void makeBall(Group group) {
        // Here we make the ball.
        Circle graphBall = ball.getBallShape();
        // set circle attributes.
        graphBall.setCenterX(ball.getBallPositionX());
        graphBall.setCenterY(ball.getBallPositionY());
        graphBall.setRadius(BallConstants.BALL_RADIUS);
        graphBall.setFill(BallConstants.BALL_COLOR);
        // add ball to the group of contents as a new node.
        group.getChildren().add(graphBall);
    }

    public void makeBar(Group group) {
        Rectangle barGraph = bar.getBar();
        barGraph.setX(bar.getBarPositionX());
        barGraph.setY(BarConstants.BAR_POSITION_ON_Y);
        barGraph.setWidth(BarConstants.BAR_WEIGHT);
        barGraph.setHeight(BarConstants.BAR_HEIGHT);
        barGraph.setFill(BarConstants.BAR_COLOR);

        group.getChildren().add(barGraph);
    }

    public void makeBlock(Group group) {
        Block tmp = null;
        Rectangle prevBlock = null;
        for (int number=0; number < WindowConstants.NUMBER_OF_BLOCKS; number++) {
            tmp = new Block();
            if (number > 0) {
                tmp.nextPositionXY(prevBlock.getX(), prevBlock.getY(), false);
            }
            tmp.getBlockShape().setX(tmp.getNextBlockPositionX());
            tmp.getBlockShape().setY(tmp.getNextBlockPositionY());
            tmp.getBlockShape().setWidth(BlockConstants.BLOCK_WEIGHT);
            tmp.getBlockShape().setHeight(BlockConstants.BLOCK_HEIGHT);
            tmp.getBlockShape().setFill(BarConstants.BAR_COLOR);
            group.getChildren().add(tmp.getBlockShape());
            prevBlock = tmp.getBlockShape();
        }
    }

    public void start() {
        ball.startMoving();
    }

}

