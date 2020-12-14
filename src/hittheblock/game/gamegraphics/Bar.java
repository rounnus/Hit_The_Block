package hittheblock.game.gamegraphics;

import hittheblock.constants.ComponentConstants;
import hittheblock.constants.ComponentDimensions;
import hittheblock.game.actions.GameGraphicsActions;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

public class Bar implements GameGraphicsActions.BarActions {
    private double barPositionX;
    private Rectangle barShape;

    public Bar() {
        // Initialize.
        this.barPositionX = 455;
        this.barShape = new Rectangle();
    }

    /*
        ###### Getters #######
    */
    public double getBarPositionX() {
        return barPositionX;
    }

    public Rectangle getBar() {
        return barShape;
    }

    private boolean isOnRightEnd() {
        /*
            In this method we check if the ball
            is on the right wall.
        */
        if (barPositionX >= ComponentDimensions.WINDOW_WEIGHT.size - barShape.getWidth()) {
            return true;
        }
        return false;
    }
    private boolean isOnLeftEnd() {
        /*
            In this method we check if the ball
            is on the left wall.
        */
        if (barPositionX <= ComponentDimensions.WINDOW_MINIMUM_X_Y.size) {
            return true;
        }
        return false;
    }

    @Override
    public void moveToRight() {
        // We moved to the right.
        barPositionX += ComponentConstants.BAR_SPEED.constant;
        barShape.setX(barPositionX);
    }

    @Override
    public void moveToLeft() {
        // We moved to the left.
        barPositionX -= ComponentConstants.BAR_SPEED.constant;
        barShape.setX(barPositionX);
    }
    @Override
    public EventHandler<KeyEvent> moveBarOnKeyPressed() {
        /*
            In this method we return the handler who allows
            the movement of the bar using the arrow keys.
        */
        return keyEvent -> {
            if (keyEvent.getCode() == KeyCode.LEFT) {
                if (!isOnLeftEnd()) {
                    // If the left arrow key pressed.
                    moveToLeft();
                }
            }
            if (keyEvent.getCode() == KeyCode.RIGHT) {
                    // If the right arrow key pressed.
                if (!isOnRightEnd()) {
                    moveToRight();
                }
            }
        };
    }

}
