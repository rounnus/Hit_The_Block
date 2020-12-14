package hittheblock.userinterface;

import hittheblock.constants.ComponentColors;
import hittheblock.constants.ComponentDimensions;
import hittheblock.game.gamegraphics.Bar;
import javafx.scene.Group;
import javafx.scene.Scene;

public class UserInterface {
    private Scene scene ;
    private Bar bar;

    public UserInterface(Scene scene, Bar bar) {
        // Initialize.
        this.scene = scene;
        this.bar = bar;
    }

    public Scene configureUI(Group group) {
        // We define attributes for the scene.
        scene = new Scene(group, ComponentDimensions.WINDOW_WEIGHT.size, ComponentDimensions.WINDOW_HEIGHT.size);
        scene.setFill(ComponentColors.WINDOW_BACKGROUND.compColor);
        scene.setOnKeyPressed(bar.moveBarOnKeyPressed());
        // return the scene.
        return scene;
    }

}
