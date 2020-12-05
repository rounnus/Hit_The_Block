package hittheblock.game.gamegraphics;

import hittheblock.constants.BallConstants;
import hittheblock.constants.BarConstants;
import hittheblock.constants.WindowConstants;
import hittheblock.game.actions.GameGraphicsActions;
import javafx.animation.KeyFrame;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
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
        ballShape.setCenterX(ballShape.getCenterX() + dx);
        if (ballShape.getCenterX() <= WindowConstants.WINDOW_MINIMUM_X_Y + BallConstants.BALL_RADIUS || ballShape.getCenterX() >= WindowConstants.WINDOW_BOUNDARY_X - BallConstants.BALL_RADIUS) {
            dx = -dx;
        }
    }
    private void wallCollitionY() {
        ballShape.setCenterY(ballShape.getCenterY() + dy);
        if (ballShape.getCenterY() <= WindowConstants.WINDOW_MINIMUM_X_Y + BallConstants.BALL_RADIUS) {
            dy = -dy;
        }
    }

    private void collitionOnBar() {
        // We get the information about where the bar is in a moment.
        double currentBarPositionX = gameBar.getBarPositionX();
        double barPositionY = BarConstants.BAR_POSITION_ON_Y;
        // If the ball crosses the bar, then the game is over.
        if (ballShape.getCenterY() > barPositionY) {
            System.exit(1);
        }
        System.out.println("BALL POSITION: "+ballShape.getCenterX());
        System.out.println("BAR POSITION: "+currentBarPositionX);

        // If the ball is in the bar area.
        if (ballShape.getCenterX() >= currentBarPositionX && ballShape.getCenterX() <= currentBarPositionX+100) {
            // If it touches the bar.
            System.out.println("IM ON THE BAR");
            if (ballShape.getCenterY() + dy >= barPositionY-BallConstants.BALL_RADIUS) {
                ballShape.setCenterY(barPositionY-BallConstants.BALL_RADIUS);
                dy = -dy; // We change direction.
            }
        }
    }
    /*
        ########## Actions ############
    */
    @Override
    public void startMoving() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                wallCollitionX();
                wallCollitionY();
                collitionOnBar();
            }
        }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }


}
