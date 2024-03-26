package org.example.javarpg;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

public class Map {
    public static final int TILE_SIZE = 64;
    public static final int VIEWPORT_WIDTH_IN_TILES = 11;
    public static final int VIEWPORT_HEIGHT_IN_TILES = 11;
    public static final int SPRITE_SHEET_WIDTH_IN_TILES = 4;
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

    private final Image fullMapImage;

    public Map() {
        imageTiles = new Image("file:src/main/resources/tiles.png");
        int mapHeight = tiles.length;
        int mapWidth = tiles[0].length;
        Canvas canvas = new Canvas(TILE_SIZE * mapWidth, TILE_SIZE * mapHeight);
        GraphicsContext ctx = canvas.getGraphicsContext2D();


        for (int x = 0; x < mapWidth; x++) {
            for (int y = 0; y < mapHeight; y++) {
                int tile = tiles[y][x];
                int sheetOffsetX = (tile % SPRITE_SHEET_WIDTH_IN_TILES) * TILE_SIZE;
                int sheetOffsetY = (tile / SPRITE_SHEET_WIDTH_IN_TILES) * TILE_SIZE;
                ctx.drawImage(imageTiles, sheetOffsetX, sheetOffsetY, TILE_SIZE, TILE_SIZE, x * TILE_SIZE, y * TILE_SIZE,  TILE_SIZE, TILE_SIZE);
            }
        }
        fullMapImage = canvas.snapshot(new SnapshotParameters(), null);
    }

    public void draw(GraphicsContext ctx, float characterX, float characterY) {
        int screenOffsetX = (int) ((characterX - (VIEWPORT_WIDTH_IN_TILES / 2)) * TILE_SIZE);
        int screenOffsetY = (int) ((characterY - (VIEWPORT_HEIGHT_IN_TILES / 2)) * TILE_SIZE);
        ctx.drawImage(
                fullMapImage,

                // Image source coordinates
                screenOffsetX,
                screenOffsetY,
                VIEWPORT_WIDTH_IN_TILES * TILE_SIZE,
                VIEWPORT_HEIGHT_IN_TILES * TILE_SIZE,

                // Canvas destination coordinates
                0,
                0,
                VIEWPORT_WIDTH_IN_TILES * TILE_SIZE,
                VIEWPORT_HEIGHT_IN_TILES * TILE_SIZE
        );
    }

    public boolean isTileWalkable(int x, int y) {
        if (x < 0 || y < 0 || x >= tiles[0].length || y >= tiles.length) {
            return false;
        }
        int tile = tiles[y][x];
        return tile != TILE_TREE && tile != TILE_ROCK;
    }
}
