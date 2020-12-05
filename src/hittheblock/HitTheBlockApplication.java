package hittheblock;

import hittheblock.game.gamegraphics.*;
import hittheblock.userinterface.UserInterface;
import hittheblock.utilis.GraphicsMaker;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HitTheBlockApplication extends Application {
    private Group root;
    private Bar bar;
    private Ball ball;
    private Block block;
    private GraphicsMaker graphicsMaker;
    private UserInterface userInterface;
    private Scene scene;

    private void initializeItems() {
        // Initialize.
        this.root = new Group();
        this.bar = new Bar();
        this.ball = new Ball(bar);
        this.block = new Block();
        this.graphicsMaker = new GraphicsMaker(ball, bar, block);
        this.userInterface = new UserInterface(scene, bar);
        configureGraphics();
        configureScene();
    }

    private void configureGraphics() {
        graphicsMaker.makeBall(root);
        graphicsMaker.makeBar(root);
        graphicsMaker.makeBlock(root);
    }

    private void configureScene() {
        scene = userInterface.configureUI(root);
    }

    private void configureStage(Stage stage) {
        // configure window.
        stage.setTitle("Hit The Block");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        graphicsMaker.start();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        initializeItems();
        configureStage(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }


}