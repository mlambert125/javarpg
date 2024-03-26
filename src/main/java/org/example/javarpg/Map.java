package org.example.javarpg;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Map {
    public static final int TILE_GRASS = 0;
    public static final int TILE_PATH_TOP_LEFT = 1;
    public static final int TILE_PATH_TOP = 2;
    public static final int TILE_PATH_TOP_RIGHT = 3;
    public static final int TILE_GRASS2 = 4;
    public static final int TILE_PATH_LEFT = 5;
    public static final int TILE_PATH_FULL = 6;
    public static final int TILE_PATH_RIGHT = 7;
    public static final int TILE_TREE = 8;
    public static final int TILE_PATH_BOTTOM_LEFT = 9;
    public static final int TILE_PATH_BOTTOM = 10;
    public static final int TILE_PATH_BOTTOM_RIGHT = 11;
    public static final int TILE_ROCK = 12;
    public static final int TILE_PATH_END_TOP = 13;
    public static final int TILE_PATH_CROSS = 14;
    public static final int TILE_PATH_LEFT_TO_TOP = 15;
    public static final int TILE_STUMPS = 16;
    public static final int TILE_PATH_UP_TO_DOWN = 17;
    public static final int TILE_PATH_DOWN_TO_RIGHT = 18;
    public static final int TILE_PATH_DOWN_TO_LEFT = 19;
    public static final int TILE_FLOWERS = 20;
    public static final int TILE_TOP_TO_RIGHT = 21;
    public static final int TILE_LEFT_TO_RIGHT = 22;
    public static final int TILE_END_RIGHT = 23;
    public static final int TILE_FENCE_CORNER_TOP_LEFT = 24;
    public static final int TILE_FENCE_HORIZONTAL = 25;
    public static final int TILE_BUSH_CORNER_TOP_LEFT = 26;
    public static final int TILE_BUSH_HORIZONTAL = 27;
    public static final int TILE_FENCE_VERTICAL = 28;
    public static final int TILE_GRASS3 = 29;
    public static final int TILE_BUSH_VERTICAL = 30;
    public static final int TILE_GRASS4 = 31;
    public Image imageTiles;

    public int[][] tiles = {
            { 12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12 },
            { 12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12 },
            { 12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12 },
            { 12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12 },
            { 12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12 },
            { 12,12,12,12,12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,12,12,12,12,12 },
            { 12,12,12,12,12, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,12,12,12,12,12 },
            { 12,12,12,12,12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,12,12,12,12,12 },
            { 12,12,12,12,12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,12,12,12,12,12 },
            { 12,12,12,12,12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,12,12,12,12,12 },
            { 12,12,12,12,12, 0, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0,12,12,12,12,12 },
            { 12,12,12,12,12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,12,12,12,12,12 },
            { 12,12,12,12,12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,12,12,12,12,12 },
            { 12,12,12,12,12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0,12,12,12,12,12 },
            { 12,12,12,12,12, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,12,12,12,12,12 },
            { 12,12,12,12,12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,12,12,12,12,12 },
            { 12,12,12,12,12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0,12,12,12,12,12 },
            { 12,12,12,12,12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,12,12,12,12,12 },
            { 12,12,12,12,12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,12,12,12,12,12 },
            { 12,12,12,12,12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,12,12,12,12,12 },
            { 12,12,12,12,12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0,12,12,12,12,12 },
            { 12,12,12,12,12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,12,12,12,12,12 },
            { 12,12,12,12,12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0,12,12,12,12,12 },
            { 12,12,12,12,12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,12,12,12,12,12 },
            { 12,12,12,12,12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0,12,12,12,12,12 },
            { 12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12 },
            { 12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12 },
            { 12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12 },
            { 12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12 },
            { 12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12 },
    };

    public Map() {
        imageTiles = new Image("file:src/main/resources/tiles.png");
    }

    public void draw(GraphicsContext ctx, float characterX, float characterY) {
        int mapOffsetX = (int)characterX - 5;
        int mapOffsetY = (int)characterY - 5;

        int subOffsetX = (int)((characterX - (int)characterX) * 64);
        int subOffsetY = (int)((characterY - (int)characterY) * 64);

        int screenX = 0;
        int screenY = 0;

        for (int x = mapOffsetX; x <= mapOffsetX + 11; x++) {
            for (int y = mapOffsetY; y <= mapOffsetY + 11; y++) {
                if (x < 0 || y < 0 || x >= tiles[0].length || y >= tiles.length) {
                    screenY += 64;
                    continue;
                }

                int tile = tiles[y][x];
                int sheetOffsetX = (tile % 4) * 64;
                int sheetOffsetY = (tile / 4) * 64;

                ctx.drawImage(imageTiles, sheetOffsetX, sheetOffsetY, 64, 64, screenX - subOffsetX, screenY - subOffsetY, 64, 64);
                screenY += 64;
            }
            screenX += 64;
            screenY = 0;
        }
    }

    public boolean isTileWalkable(int x, int y) {
        if (x < 0 || y < 0 || x >= tiles[0].length || y >= tiles.length) {
            return false;
        }
        int tile = tiles[y][x];
        return tile != TILE_TREE && tile != TILE_ROCK;
    }
}
