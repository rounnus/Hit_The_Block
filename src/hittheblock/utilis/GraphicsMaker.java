package hittheblock.utilis;

import hittheblock.constants.BallConstants;
import hittheblock.constants.BarConstants;
import hittheblock.constants.BlockConstants;
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
    private Rectangle prevBlock;
    private Block tmp;

    public GraphicsMaker(Ball ball, Bar bar, Block block) {
        // Initialize.
        this.ball = ball;
        this.bar = bar;
        this.block = block;
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
        graphBall.setRadius(BallConstants.BALL_RADIUS);
        graphBall.setFill(BallConstants.BALL_COLOR);
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
        barGraph.setY(BarConstants.BAR_POSITION_ON_Y);
        barGraph.setWidth(BarConstants.BAR_WEIGHT);
        barGraph.setHeight(BarConstants.BAR_HEIGHT);
        barGraph.setFill(BarConstants.BAR_COLOR);
        // add bar to the group of contents as a new node.
        group.getChildren().add(barGraph);
    }

    // make rows and collumns for blocks
    // TODO: 12/6/20  

    public void start() {
        ball.startMoving();
    }

}

