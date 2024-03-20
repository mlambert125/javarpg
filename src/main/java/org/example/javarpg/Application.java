package org.example.javarpg;

import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The main application class for the Java RPG
 *
 * This class sets up the game loop and key listeners
 */
public class Application extends javafx.application.Application {
    // ----------------------------------------------
    // CONSTANTS
    // ----------------------------------------------
    /**
     * The number of frames per second
     */
    private final static int FRAMES_PER_SECOND = 60;



    // ----------------------------------------------
    // GRAPHICS CONTEXT
    // ----------------------------------------------
    /**
     * The graphics context to draw to
     */
    private GraphicsContext ctx;



    // ----------------------------------------------
    // KEYBOARD STATE
    // ----------------------------------------------
    /**
     * Whether the up key is currently pressed
     */
    private boolean keyUp = false;

    /**
     * Whether the down key is currently pressed
     */
    private boolean keyDown = false;

    /**
     * Whether the left key is currently pressed
     */
    private boolean keyLeft = false;

    /**
     * Whether the right key is currently pressed
     */
    private boolean keyRight = false;

    /**
     * Whether the space key is currently pressed
     */
    private boolean keySpace = false;



    // ----------------------------------------------
    // GAME STATE
    // ----------------------------------------------
    /**
     * The current game state
     */
    private final GameState gameState = new GameState();

    /**
     * The current keyboard state
     */
    private final KeyboardState keyboardState = new KeyboardState();

    /**
     * The currently active screen
     */
    private Screen currentScreen = new TitleScreen();



    // ----------------------------------------------
    // GETTERS/SETTERS
    // ----------------------------------------------
    /**
     * Set the current screen
     *
     * @param screen the new screen
     */
    public void setCurrentScreen(Screen screen) {
        currentScreen = screen;
    }



    // ----------------------------------------------
    // GAME BOILERPLATE
    // ----------------------------------------------
    /**
     * Main method to start the application
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch();
    }

    /**
     * Start the application, set up the game loop and key listeners
     *
     * Don't worry much about this method, it's just setting up the game loop and key listeners
     * and won't need any modification from this point forward
     *
     * @param stage JavaFX stage
     * @throws IOException if the stage cannot be created
     */
    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Java RPG!!!");
        stage.setResizable(false);
        Pane root = new Pane();
        Canvas canvas = new Canvas(704, 704);

        // give canvas black background
        root.setStyle("-fx-background-color: black");

        canvas.setFocusTraversable(true);
        canvas.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()) {
                    case UP:
                        keyboardState.setKeyUp(true);
                        break;
                    case DOWN:
                        keyboardState.setKeyDown(true);
                        break;
                    case LEFT:
                        keyboardState.setKeyLeft(true);
                        break;
                    case RIGHT:
                        keyboardState.setKeyRight(true);
                        break;
                    case SPACE:
                        keyboardState.setKeySpace(true);
                        break;
                    case ESCAPE:
                        keyboardState.setKeyEscape(true);
                        break;
                }
            }
        });

        canvas.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                switch (keyEvent.getCode()) {
                    case UP:
                        keyboardState.setKeyUp(false);
                        break;
                    case DOWN:
                        keyboardState.setKeyDown(false);
                        break;
                    case LEFT:
                        keyboardState.setKeyLeft(false);
                        break;
                    case RIGHT:
                        keyboardState.setKeyRight(false);
                        break;
                    case SPACE:
                        keyboardState.setKeySpace(false);
                        break;
                    case ESCAPE:
                        keyboardState.setKeyEscape(false);
                        break;
                }
            }
        });
        ctx = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        stage.setScene(new Scene(root));
        new AnimationTimer() {
            private long lastUpdate = System.nanoTime();
            private long currentFrame = 0;

            public void handle(long presentNanoTime) {
                if (presentNanoTime - lastUpdate > (1000000000 / FRAMES_PER_SECOND)) {
                    currentFrame++;
                    update(currentFrame);
                    draw(currentFrame);
                    lastUpdate = presentNanoTime;
                }
            }
        }.start();
        stage.show();
    }

    /**
     * Update the game state
     *
     * @param currentFrame the current frame number
     */
    public void update(long currentFrame) {
        currentScreen.update(this, keyboardState, gameState, currentFrame);
    }

    /**
     * Draw the game state
     *
     * @param currentFrame the current frame number
     */
    public void draw(long currentFrame) {
        currentScreen.draw(this, ctx, gameState, currentFrame);
    }
}