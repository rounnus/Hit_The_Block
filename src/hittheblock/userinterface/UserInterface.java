package hittheblock.userinterface;

import hittheblock.constants.WindowConstants;
import hittheblock.game.gamegraphics.Bar;
import javafx.scene.Group;
import javafx.scene.Scene;

public class UserInterface {
    private Scene scene;
    private Bar bar;

    public UserInterface(Scene scene, Bar bar) {
        // Initialize.
        this.scene = scene;
        this.bar = bar;
    }

    public Scene configureUI(Group group) {
        // We define attributes for the scene.
        scene = new Scene(group, WindowConstants.WINDOW_BOUNDARY_X, WindowConstants.WINDOW_BOUNDARY_Y);
        scene.setFill(WindowConstants.WINDOW_BACKGROUND);
        scene.setOnKeyPressed(bar.moveBarOnKeyPressed());
        // return the scene.
        return scene;
    }

}
