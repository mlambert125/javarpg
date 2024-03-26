package org.example.javarpg;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class GameScreen extends Screen {
    private static final float SMOOTH_STEP = 0.125f;
    private Map map = new Map();
    private float characterX = 15;
    private float characterY = 15;

    @Override
    public void update(Application application, KeyboardState keyboardState, GameState gameState, long currentFrame) {
        if (keyboardState.isKeyEscape()) {
            application.setCurrentScreen(new TitleScreen());
        }

        if (characterX - (int) characterX == 0 && characterY - (int) characterY == 0) {
            // We are on a specific tile and should read keyboard input to maybe move
            if (keyboardState.isKeyDown()) {
                gameState.getSprite().setDirection(CharacterSprite.DIRECTION_DOWN);
                if (map.isTileWalkable((int)characterX, (int)characterY + 1)) {
                    characterY += SMOOTH_STEP;
                }
            } else if (keyboardState.isKeyLeft()) {
                gameState.getSprite().setDirection(CharacterSprite.DIRECTION_LEFT);
                if (map.isTileWalkable((int)characterX - 1, (int)characterY)) {
                    characterX -= SMOOTH_STEP;
                }
            } else if (keyboardState.isKeyRight()) {
                gameState.getSprite().setDirection(CharacterSprite.DIRECTION_RIGHT);
                if (map.isTileWalkable((int)characterX + 1, (int)characterY)) {
                    characterX += SMOOTH_STEP;
                }
            } else if (keyboardState.isKeyUp() ) {
                gameState.getSprite().setDirection(CharacterSprite.DIRECTION_UP);
                if (map.isTileWalkable((int)characterX, (int)characterY - 1)) {
                    characterY -= SMOOTH_STEP;
                }
            }
        } else {
            // We are in the middle of a tile and should continue moving
            if (gameState.getSprite().getDirection() == CharacterSprite.DIRECTION_DOWN) {
                characterY += SMOOTH_STEP;
            } else if (gameState.getSprite().getDirection() == CharacterSprite.DIRECTION_LEFT) {
                characterX -= SMOOTH_STEP;
            } else if (gameState.getSprite().getDirection() == CharacterSprite.DIRECTION_RIGHT) {
                characterX += SMOOTH_STEP;
            } else if (gameState.getSprite().getDirection() == CharacterSprite.DIRECTION_UP) {
                characterY -= SMOOTH_STEP;
            }
        }
    }

    @Override
    public void draw(Application application, GraphicsContext ctx, GameState gameState, long currentFrame) {
        ctx.setFill(Color.DARKGREEN);
        ctx.fillRect(0, 0, 704, 704);

        map.draw(ctx, characterX, characterY);

        int step = 0;
        float stepDiff = (characterX - (int)characterX);

        if (stepDiff == 0) {
            stepDiff = (characterY - (int)characterY);
        }

        if (stepDiff > 0 && stepDiff <= 0.25) {
            step = 1;
        } else if (stepDiff > 0.25 && stepDiff <= 0.5) {
            step = 2;
        } else if (stepDiff > 0.5 && stepDiff <= 0.75) {
            step = 3;
        }

        CharacterSprite sprite = gameState.getSprite();
        sprite.draw(step, ctx, 320, 320);

    }
}
