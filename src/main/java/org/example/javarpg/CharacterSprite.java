package org.example.javarpg;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class CharacterSprite {
    public static CharacterSprite MAN_BLUE = new CharacterSprite(0, 0);
    public static CharacterSprite WOMAN_PURPLE = new CharacterSprite(96, 0);
    public static CharacterSprite KID_BROWN = new CharacterSprite(192, 0);
    public static CharacterSprite MAN_RED = new CharacterSprite(288, 0);
    public static CharacterSprite WOMAN_BLACK = new CharacterSprite(0, 128);
    public static CharacterSprite KID_BLACK = new CharacterSprite(96, 128);
    public static CharacterSprite WOMAN_WHITE = new CharacterSprite(192, 128);
    public static CharacterSprite MAN_BROWN = new CharacterSprite(288, 128);
    public static final int DIRECTION_DOWN = 0;
    public static final int DIRECTION_LEFT = 1;
    public static final int DIRECTION_RIGHT = 2;
    public static final int DIRECTION_UP = 3;

    private int sheetOffsetX;
    private int sheetOffsetY;
    private Image image;

    private int direction = 0;

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public CharacterSprite(int sheetOffsetX, int sheetOffsetY) {
        this.sheetOffsetX = sheetOffsetX;
        this.sheetOffsetY = sheetOffsetY;
        this.image = new Image("file:src/main/resources/characters.png");
    }

    public void draw(int step, GraphicsContext ctx, int x, int y) {
        if (direction == DIRECTION_DOWN) {
            if (step == 0) {
                drawDownOne(ctx, 320, 320);
            } else if (step == 1) {
                drawDownTwo(ctx, 320, 320);
            } else if (step == 2) {
                drawDownThree(ctx, 320, 320);
            } else {
                drawDownTwo(ctx, 320, 320);
            }
        } else if (direction == DIRECTION_LEFT) {
            if (step == 0) {
                drawLeftOne(ctx, 320, 320);
            } else if (step == 1) {
                drawLeftTwo(ctx, 320, 320);
            } else if (step == 2) {
                drawLeftThree(ctx, 320, 320);
            } else {
                drawLeftTwo(ctx, 320, 320);
            }
        } else if (direction == DIRECTION_RIGHT) {
            if (step == 0) {
                drawRightOne(ctx, 320, 320);
            } else if (step == 1) {
                drawRightTwo(ctx, 320, 320);
            } else if (step == 2) {
                drawRightThree(ctx, 320, 320);
            } else {
                drawRightTwo(ctx, 320, 320);
            }
        } else if (direction== DIRECTION_UP) {
            if (step == 0) {
                drawUpOne(ctx, 320, 320);
            } else if (step == 1) {
                drawUpTwo(ctx, 320, 320);
            } else if (step == 2) {
                drawUpThree(ctx, 320, 320);
            } else {
                drawUpTwo(ctx, 320, 320);
            }
        }
    }

    public void drawDownOne(GraphicsContext ctx, int x, int y) {
        ctx.drawImage(image, sheetOffsetX, sheetOffsetY, 32, 32, x, y, 64, 64);
    }

    public void drawDownTwo(GraphicsContext ctx, int x, int y) {
        ctx.drawImage(image, sheetOffsetX + 32, sheetOffsetY, 32, 32, x, y, 64, 64);
    }

    public void drawDownThree(GraphicsContext ctx, int x, int y) {
        ctx.drawImage(image, sheetOffsetX + 64, sheetOffsetY, 32, 32, x, y, 64, 64);
    }

    public void drawLeftOne(GraphicsContext ctx, int x, int y) {
        ctx.drawImage(image, sheetOffsetX, sheetOffsetY + 32, 32, 32, x, y, 64, 64);
    }

    public void drawLeftTwo(GraphicsContext ctx, int x, int y) {
        ctx.drawImage(image, sheetOffsetX + 32, sheetOffsetY + 32, 32, 32, x, y, 64, 64);
    }

    public void drawLeftThree(GraphicsContext ctx, int x, int y) {
        ctx.drawImage(image, sheetOffsetX + 64, sheetOffsetY + 32, 32, 32, x, y, 64, 64);
    }

    public void drawRightOne(GraphicsContext ctx, int x, int y) {
        ctx.drawImage(image, sheetOffsetX, sheetOffsetY + 64, 32, 32, x, y, 64, 64);
    }

    public void drawRightTwo(GraphicsContext ctx, int x, int y) {
        ctx.drawImage(image, sheetOffsetX + 32, sheetOffsetY + 64, 32, 32, x, y, 64, 64);
    }

    public void drawRightThree(GraphicsContext ctx, int x, int y) {
        ctx.drawImage(image, sheetOffsetX + 64, sheetOffsetY + 64, 32, 32, x, y, 64, 64);
    }

    public void drawUpOne(GraphicsContext ctx, int x, int y) {
        ctx.drawImage(image, sheetOffsetX, sheetOffsetY + 96, 32, 32, x, y, 64, 64);
    }

    public void drawUpTwo(GraphicsContext ctx, int x, int y) {
        ctx.drawImage(image, sheetOffsetX + 32, sheetOffsetY + 96, 32, 32, x, y, 64, 64);
    }

    public void drawUpThree(GraphicsContext ctx, int x, int y) {
        ctx.drawImage(image, sheetOffsetX + 64, sheetOffsetY + 96, 32, 32, x, y, 64, 64);
    }
}
