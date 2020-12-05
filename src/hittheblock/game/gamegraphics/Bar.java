package hittheblock.game.gamegraphics;

import hittheblock.constants.BarConstants;
import hittheblock.constants.WindowConstants;
import hittheblock.game.actions.GameGraphicsActions;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

public class Bar implements GameGraphicsActions.BarActions {
    private double barPositionX;
    private Rectangle barShape;

    public Bar() {
        this.barPositionX = 455;
        this.barShape = new Rectangle();
    }

    public double getBarPositionX() {
        return barPositionX;
    }

    public Rectangle getBar() {
        return barShape;
    }

    private boolean isOnRightEnd() {
        if (barPositionX >= WindowConstants.WINDOW_BOUNDARY_X - barShape.getWidth()) {
            return true;
        }
        return false;
    }
    private boolean isOnLeftEnd() {
        if (barPositionX <= WindowConstants.WINDOW_MINIMUM_X_Y) {
            return true;
        }
        return false;
    }

    @Override
    public void moveToRight() {
        barPositionX += BarConstants.BAR_SPEED;
        barShape.setX(barPositionX);
    }

    @Override
    public void moveToLeft() {
        barPositionX -= BarConstants.BAR_SPEED;
        barShape.setX(barPositionX);
    }
    @Override
    public EventHandler<KeyEvent> moveBarOnKeyPressed() {
        return new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode() == KeyCode.LEFT) {
                    if (!isOnLeftEnd()) {
                        moveToLeft();
                    }
                }
                if (keyEvent.getCode() == KeyCode.RIGHT) {
                    if (!isOnRightEnd()) {
                        moveToRight();
                    }
                }
            }
        };
    }

}
