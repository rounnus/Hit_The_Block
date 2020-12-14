package hittheblock.game.gamegraphics;

import hittheblock.constants.ComponentConstants;
import hittheblock.constants.ComponentDimensions;
import hittheblock.game.actions.GameGraphicsActions;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.shape.Circle;
import javafx.util.Duration;


public class Ball implements GameGraphicsActions.BallActions {
    private double ballPositionX;
    private double ballPositionY;
    private Bar gameBar;
    private Circle ballShape;
    private double dx ;
    private double dy;

    public Ball(Bar gameBar) {
        // Initialize components.
        this.gameBar = gameBar;
        this.ballPositionX = 300; // the position on X.
        this.ballPositionY = 100; // the position on Y.
        this.dx = 2;
        this.dy = 2;
        this.ballShape = new Circle();
    }
    /*
        ########## Getters ############
    */
    public double getBallPositionX() {
        return ballPositionX;
    }

    public double getBallPositionY() {
        return ballPositionY;
    }

    public Circle getBallShape() {
        return ballShape;
    }

    private void wallCollitionX() {
        /*
            If the ball hits the right or left wall,
            then the ball changes direction
        */
        ballShape.setCenterX(ballShape.getCenterX() + dx); // We change the position of the ball according to the speed
        if (ballShape.getCenterX() <= ComponentDimensions.WINDOW_MINIMUM_X_Y.size + ComponentDimensions.BALL_RADIUS.size || ballShape.getCenterX() >= ComponentDimensions.WINDOW_WEIGHT.size - ComponentDimensions.BALL_RADIUS.size) {
            // If it hits the wall then we change the direction
            dx = -dx;
        }
    }
    private void wallCollitionY() {
        /*
            If the ball hits the top wall,
            then it will change direction
        */
        ballShape.setCenterY(ballShape.getCenterY() + dy); // We change the position of the ball according to the speed
        if (ballShape.getCenterY() <= ComponentDimensions.WINDOW_MINIMUM_X_Y.size + ComponentDimensions.BALL_RADIUS.size) {
            // If it hits the wall then we change the direction
            dy = -dy;
        }
    }

    private void collitionOnBar() {
        // We receive information about the location of the bar.
        double currentBarPositionX = gameBar.getBarPositionX();
        double barPositionY = ComponentConstants.BAR_POSITION_ON_Y.constant;
        // If the ball crosses the bar, then the game is over.
        if (ballShape.getCenterY() > barPositionY) {
            System.exit(1);
        }

        // If the ball is in the bar area.
        if (ballShape.getCenterX() >= currentBarPositionX && ballShape.getCenterX() <= currentBarPositionX+100) {
            // If it touches the bar.
            if (ballShape.getCenterY() + dy >= barPositionY-ComponentDimensions.BALL_RADIUS.size) {
                ballShape.setCenterY(barPositionY-ComponentDimensions.BALL_RADIUS.size);
                dy = -dy; // change direction.
            }
        }
    }
    /*
        ########## Actions ############
    */
    @Override
    public void startMoving() {
        /*
            In this method we perform the function
            of moving the ball.
        */
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), t -> {
            wallCollitionX();
            wallCollitionY();
            collitionOnBar();

        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}
