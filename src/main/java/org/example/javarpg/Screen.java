package org.example.javarpg;

import javafx.scene.canvas.GraphicsContext;

public abstract class Screen {
    public abstract void update(Application application, KeyboardState keyboardState, GameState gameState, long currentFrame);
    public abstract void draw(Application application, GraphicsContext ctx, GameState gameState, long currentFrame);
}
