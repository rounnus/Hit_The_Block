package hittheblock.game.actions;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public interface GameGraphicsActions {
    interface BallActions {
        void startMoving();
    }
    interface BarActions {
        void moveToRight();
        void moveToLeft();
        EventHandler<KeyEvent> moveBarOnKeyPressed();
    }

    interface BlockActions {
        void onBallHit();
    }
}
