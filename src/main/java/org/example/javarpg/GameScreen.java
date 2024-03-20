package org.example.javarpg;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class GameScreen extends Screen {
    private boolean walking = false;

    @Override
    public void update(Application application, KeyboardState keyboardState, GameState gameState, long currentFrame) {
        if (keyboardState.isKeyEscape()) {
            application.setCurrentScreen(new TitleScreen());
        }
        if (keyboardState.isKeyDown()) {
            gameState.getSprite().setDirection(CharacterSprite.DIRECTION_DOWN);
            walking = true;
        } else if (keyboardState.isKeyLeft()) {
            gameState.getSprite().setDirection(CharacterSprite.DIRECTION_LEFT);
            walking = true;
        } else if (keyboardState.isKeyRight()) {
            gameState.getSprite().setDirection(CharacterSprite.DIRECTION_RIGHT);
            walking = true;
        } else if (keyboardState.isKeyUp()) {
            gameState.getSprite().setDirection(CharacterSprite.DIRECTION_UP);
            walking = true;
        } else {
            walking = false;
        }
    }

    @Override
    public void draw(Application application, GraphicsContext ctx, GameState gameState, long currentFrame) {
        ctx.setFill(Color.DARKGREEN);
        ctx.fillRect(0, 0, 704, 704);

        Image tiles = new Image("file:src/main/resources/tiles.png");

        for (int x = 0; x < 11; x++) {
            for (int y = 0; y < 11; y++) {
                ctx.drawImage(tiles, 16, 0, 16, 16, x * 64, y * 64, 64, 64);
            }
        }


        int step = walking ? (int) (currentFrame / 10 % 4) : 1;

        CharacterSprite sprite = gameState.getSprite();
        sprite.draw(step, ctx, 320, 320);

    }
}
