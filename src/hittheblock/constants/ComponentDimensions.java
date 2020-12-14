package hittheblock.constants;

public enum ComponentDimensions {
    // bar
    BAR_HEIGHT(15),
    BAR_WEIGHT(100),
    // Block
    BLOCK_HEIGHT(50),
    BLOCK_WEIGHT(50),
    // Ball
    BALL_RADIUS(10),
    // window
    WINDOW_HEIGHT(700),
    WINDOW_WEIGHT(1050),
    WINDOW_MINIMUM_X_Y(0);

    public final double size;
    ComponentDimensions(double size) {
        this.size = size;
    }


}
