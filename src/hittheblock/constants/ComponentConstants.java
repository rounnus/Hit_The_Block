package hittheblock.constants;

public enum ComponentConstants {
    // bar
    BAR_POSITION_ON_Y(675),
    BAR_SPEED(10),
    // Block
    BLOCK_NUMBER_ROWS(9),
    BLOCK_NUMBER_COLUMNS(4);


    public final double constant;
    ComponentConstants(double constant) {
        this.constant = constant;
    }
}
