package org.example.javarpg;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class GameScreen extends Screen {
    private boolean walking = false;
    private Map map = new Map();
    private int characterX = 15;
    private int characterY = 15;

    private long lastPositionUpdateFrame = 0;

    @Override
    public void update(Application application, KeyboardState keyboardState, GameState gameState, long currentFrame) {
        if (keyboardState.isKeyEscape()) {
            application.setCurrentScreen(new TitleScreen());
        }
        if (keyboardState.isKeyDown()) {
            gameState.getSprite().setDirection(CharacterSprite.DIRECTION_DOWN);
            walking = true;

            if (currentFrame - lastPositionUpdateFrame > 10) {
                lastPositionUpdateFrame = currentFrame;
                characterY++;
            }
        } else if (keyboardState.isKeyLeft()) {
            gameState.getSprite().setDirection(CharacterSprite.DIRECTION_LEFT);
            walking = true;

            if (currentFrame - lastPositionUpdateFrame > 10) {
                lastPositionUpdateFrame = currentFrame;
                characterX--;
            }
        } else if (keyboardState.isKeyRight()) {
            gameState.getSprite().setDirection(CharacterSprite.DIRECTION_RIGHT);
            walking = true;

            if (currentFrame - lastPositionUpdateFrame > 10) {
                lastPositionUpdateFrame = currentFrame;
                characterX++;
            }
        } else if (keyboardState.isKeyUp()) {
            gameState.getSprite().setDirection(CharacterSprite.DIRECTION_UP);
            walking = true;

            if (currentFrame - lastPositionUpdateFrame > 10) {
                lastPositionUpdateFrame = currentFrame;
                characterY--;
            }
        } else {
            walking = false;
        }
    }

    @Override
    public void draw(Application application, GraphicsContext ctx, GameState gameState, long currentFrame) {
        ctx.setFill(Color.DARKGREEN);
        ctx.fillRect(0, 0, 704, 704);


        map.draw(ctx, characterX, characterY);


        int step = walking ? (int) (currentFrame / 10 % 4) : 1;

        CharacterSprite sprite = gameState.getSprite();
        sprite.draw(step, ctx, 320, 320);

    }
}
