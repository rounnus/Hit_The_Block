package hittheblock.constants;

import javafx.scene.paint.Color;

public enum ComponentColors {
    BAR_COLOR(Color.BLUE),
    BLOCK_COLOR(Color.BLUE),
    BALL_COLOR(Color.BLUE),
    WINDOW_BACKGROUND(Color.BLACK);


    public final Color compColor;
    ComponentColors(Color compColor) {
        this.compColor = compColor;
    }
}
