package org.example.javarpg;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class TitleScreen extends Screen {
    @Override
    public void update(Application application, KeyboardState keyboardState, GameState gameState, long currentFrame) {
        if (keyboardState.isKeySpace()) {
            application.setCurrentScreen(new GameScreen());
        }
    }

    @Override
    public void draw(Application application, GraphicsContext ctx, GameState gameState, long currentFrame) {
        ctx.clearRect(0, 0, 704, 704);
        Image title = new Image("file:src/main/resources/title.png");
        ctx.drawImage(title, 0, 0, 704, 704);
    }
}
