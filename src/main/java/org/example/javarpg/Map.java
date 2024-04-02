package org.example.javarpg;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

public abstract class Map {
    public static final int TILE_SIZE = 64;
    public static final int VIEWPORT_WIDTH_IN_TILES = 11;
    public static final int VIEWPORT_HEIGHT_IN_TILES = 11;
    public static final int SPRITE_SHEET_WIDTH_IN_TILES = 4;
    protected final Image fullMapImage;
    protected Image imageTiles;

    public Map() {
        imageTiles = new Image(getTileSetPath());
        int[][] tiles = getTiles();
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

    protected int getStartX() {
        return 15;
    }

    protected int getStartY() {
        return 15;
    }

    protected int getStartDirection() {
        return CharacterSprite.DIRECTION_DOWN;
    }

    protected abstract int[][] getTiles();

    protected abstract String getTileSetPath();

    public abstract boolean isTileWalkable(int x, int y);

    public Map getNewMap(int x, int y) {
        return null;
    }
}
